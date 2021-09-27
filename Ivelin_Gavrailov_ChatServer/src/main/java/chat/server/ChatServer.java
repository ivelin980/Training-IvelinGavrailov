package chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.DecoderException;
import org.apache.log4j.Logger;

import chat.server.message.BaseChatMessage;
import chat.server.message.ChatRequest;
import chat.server.message.ChatResponse;
import custom.inject.InjectLogger;
import custom.inject.InjectorCreater;
import redis.clients.jedis.Jedis;
import server.constants.Constants;

public class ChatServer {
	private String serverName;
	private Set<ChatToChannelThread> chatToChannelThreads = ConcurrentHashMap.newKeySet();
	private Map<String, Set<String>> roomsWithUsers = new ConcurrentHashMap<String, Set<String>>();
	private Publish publish;
	private Jedis jedis = new Jedis();

	@InjectLogger
	private Logger log;

	public ChatServer(String serverName) {
		this.serverName = serverName;
		InjectorCreater.getInjector().injectMembers(this);
		this.publish = new Publish();
	}

	public void execute() throws SQLException, DecoderException {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		KeepDataAlive dataAlive = new KeepDataAlive("chatServers");
		dataAlive.start();
		publish.publish("NewChatServers", serverName);
		int port = Database.getInstance().getServerData(serverName).getPort();
		String ip = Database.getInstance().getServerData(serverName).getIp();
		publish.setJsonString("chatServers", new ServerData(serverName, ip, port));
		executor.scheduleAtFixedRate(dataAlive, 5, 1, TimeUnit.SECONDS);
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			System.out.println(Constants.CHAT_SERVER_STARTED_MESSAGE + port);
			log.info(Constants.CHAT_SERVER_STARTED_MESSAGE + port);
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println(Constants.NEW_CHANNEL_CONNECTED_MESSAGE);
				log.info(Constants.NEW_CHANNEL_CONNECTED_MESSAGE);

				ChatToChannelThread chatToChannelThread = new ChatToChannelThread(socket, this);
				chatToChannelThreads.add(chatToChannelThread);
				chatToChannelThread.start();
			}
		} catch (IOException ex) {
			log.error(Constants.LOG_EXCEPTION_MESSAGE, ex);
			System.out.println(Constants.SERVER_ERROR_MESSAGE + ex.getMessage());
		}
	}

	public static void main(String[] args) throws SQLException, DecoderException {
		if (args.length < 1) {
			System.out.println(Constants.SERVER_NO_PORT_ADDED_MESSAGE);
			System.exit(0);
		}

		String serverName = args[0];

		ChatServer server = new ChatServer(serverName);
		server.execute();
	}

	void sendToChannel(ChatRequest message, ChatToChannelThread channelThread) {
		channelThread.sendMessage(message);
	}

	void addRoom(String roomName) {
		roomsWithUsers.put(roomName, new HashSet<>());
	}

	public Map<String, Set<String>> getRoomsWithUsers() {
		return roomsWithUsers;
	}

	public void setRoomsWithUsers(Map<String, Set<String>> roomsWithUsers) {
		this.roomsWithUsers = roomsWithUsers;
	}

	public String getServerName() {
		return serverName;
	}

	public Set<ChatToChannelThread> getChannelThreads() {
		return chatToChannelThreads;
	}

	public Logger getLog() {
		return log;
	}

	void removeChannel(ChatToChannelThread activeChannel) {
		boolean removed = chatToChannelThreads.remove(activeChannel);
		if (removed) {
			log.info(Constants.CHANNEL_REMOVED_MESSAGE);
		}
	}

	public void addUserToRoom(String roomName, String userName) {
		if (roomsWithUsers.containsKey(roomName)) {
			roomsWithUsers.get(roomName).add(userName);
		}
	}

	public void removeUserFromRoom(String userName) {
		for (String roomName : roomsWithUsers.keySet()) {
			if (roomsWithUsers.get(roomName).contains(userName)) {
				roomsWithUsers.get(roomName).remove(userName);
				break;
			}
		}
	}

	public String getRoomOfUser(String userName) {
		for (String roomName : roomsWithUsers.keySet()) {
			if (roomsWithUsers.get(roomName).contains(userName)) {
				return roomName;
			}
		}
		return "";
	}

	public void sendMessageToUsersInRoom(BaseChatMessage clientMessage) throws IOException {
		String roomName = this.getRoomOfUser(clientMessage.getUserName());
		if (!this.getRoomsWithUsers().isEmpty()) {
			for (String userName : this.getRoomsWithUsers().get(roomName)) {
				if (!clientMessage.getUserName().equals(userName)) {
					ChatResponse message = new ChatResponse(clientMessage.getText());
					message.setUserName(userName);
					String serverName = jedis.hget("allUsers", userName);
					for (ChatToChannelThread chatToChannelThread : chatToChannelThreads) {
						if (chatToChannelThread.getServerName().equals(serverName)) {
							chatToChannelThread.sendMessage(message);
						}
					}
				}
			}
		}
	}
}
