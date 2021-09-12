package com.playtech.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.DecoderException;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.playtech.chat.server.constants.Constants;
import com.playtech.chat.server.custom.inject.InjectLogger;
import com.playtech.chat.server.custom.inject.InjectorCreater;
import com.playtech.chat.server.message.BaseChatMessage;
import com.playtech.chat.server.message.ChatRequest;
import com.playtech.chat.server.message.ChatResponse;
import com.playtech.chat.server.message.ExitRoomCommand;

import redis.clients.jedis.Jedis;

public class ChannelServer {
	private String serverName;
	private Map<String, UserThread> userNameToUserThread = new ConcurrentHashMap<String, UserThread>();
	private Set<UserThread> userThreads = ConcurrentHashMap.newKeySet();
	private Map<ChannelToChatThread, Set<String>> chatServersWithRooms = new ConcurrentHashMap<ChannelToChatThread, Set<String>>();
	private Set<ChannelToChatThread> channelToChatThreads = ConcurrentHashMap.newKeySet();
	private Map<String, ServerData> chatServersDataWithRooms = new ConcurrentHashMap<String, ServerData>(); // <roomName,
																											// ServerData>
	private Publish publish;
	private Jedis jedis = new Jedis();

	@InjectLogger
	private Logger log;
	private JedisRead jedisRead = new JedisRead();

	public ChannelServer(String serverName) {
		this.serverName = serverName;
		InjectorCreater.getInjector().injectMembers(this);
		this.publish = new Publish();
	}

	public void execute() throws SQLException, DecoderException {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		KeepDataAlive dataAlive = new KeepDataAlive("channelServers");
		dataAlive.start();
		int port = Database.getInstance().getServerData(serverName).getPort();
		String ip = Database.getInstance().getServerData(serverName).getIp();
		publish.setJsonString("channelServers", new ServerData(serverName, ip, port));
		executor.scheduleAtFixedRate(dataAlive, 5, 1, TimeUnit.SECONDS);
		SubscribeForChatServers subscribeForChatServers = new SubscribeForChatServers(this);
		subscribeForChatServers.start();
		SubscribeForChatRooms chatRoomsSubscribe = new SubscribeForChatRooms(this);
		chatRoomsSubscribe.start();

		try {
			jedisRead.getConnectedChatServers().stream().forEach(c -> connectToChatServers(c));
			HashMap<String, ServerData> chatRoomsWithServersData = jedisRead.getChatRooms();
			for (Map.Entry<String, ServerData> entry : chatRoomsWithServersData.entrySet()) {
				updateRooms(entry.getValue(), entry.getKey());
			}

			try (ServerSocket serverSocket = new ServerSocket(port)) {
				System.out.println(Constants.CHANNEL_SERVER_STARTED_MESSAGE + port);
				log.info(Constants.CHANNEL_SERVER_STARTED_MESSAGE + port);
				while (true) {
					Socket socket = serverSocket.accept();
					System.out.println(Constants.NEW_USER_CONNECTED_MESSAGE);
					log.info(Constants.NEW_USER_CONNECTED_MESSAGE);
					UserThread newUser = new UserThread(socket, this);
					userThreads.add(newUser);
					newUser.start();
				}
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

		ChannelServer channelServer = new ChannelServer(serverName);
		channelServer.execute();
	}

	public void connectToChatServers(ServerData c) {
		try {
			Socket chatServerSocket;
			chatServerSocket = new Socket(c.getIp(), c.getPort());
			ChannelToChatThread channelToChatThread = new ChannelToChatThread(chatServerSocket, this, c);
			channelToChatThreads.add(channelToChatThread);
			channelToChatThread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void sendMessagetoUser(BaseChatMessage message, String userName) {
		userNameToUserThread.get(userName).sendMessage(message);
	}

	void sendToChatServer(BaseChatMessage clientMessage) {
		log.debug(clientMessage);
		System.out.println(clientMessage);
		UserThread userThread = userNameToUserThread.get(clientMessage.getUserName());
		for (ChannelToChatThread channelToChatThread : channelToChatThreads) {
			chatServersWithRooms.putIfAbsent(channelToChatThread, ConcurrentHashMap.newKeySet());
		}
		switch (clientMessage.getType()) {
		case CREATE_ROOM:
			if (!chatServersDataWithRooms.containsKey(clientMessage.getText())) {
				int lessRooms = chatServersWithRooms.get(channelToChatThreads.stream().findFirst().get()).size();
				ChannelToChatThread channelToChatThreadWithLessRooms = null;
				for (ChannelToChatThread channelToChatThread : channelToChatThreads) {
					if (chatServersWithRooms.get(channelToChatThread).size() <= lessRooms) {
						lessRooms = chatServersWithRooms.get(channelToChatThread).size();
						channelToChatThreadWithLessRooms = channelToChatThread;
					}
				}
				addRoomToChatServer(channelToChatThreadWithLessRooms, clientMessage.getText());
				chatServersDataWithRooms.put(clientMessage.getText(), channelToChatThreadWithLessRooms.getServerData());
				jedis = new Jedis();
				Gson gson = new Gson();
				String json = gson.toJson(chatServersDataWithRooms, new TypeToken<Map<String, ServerData>>() {
				}.getType());
				jedis.set("chatRooms", json);
				ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
				KeepDataAlive dataAlive = new KeepDataAlive("chatRooms");
				dataAlive.start();
				executor.scheduleAtFixedRate(dataAlive, 5, 1, TimeUnit.SECONDS);
				Map<String, String> chatServerAndRoom = new HashMap<>();
				String serverDataJson = gson.toJson(channelToChatThreadWithLessRooms.getServerData());
				chatServerAndRoom.put(serverDataJson, clientMessage.getText());
				json = gson.toJson(chatServerAndRoom);
				jedis.publish("NewRoom", json);
				if (!userThread.getRoom().isEmpty()) {
					ExitRoomCommand exit = new ExitRoomCommand();
					exit.setUserName(userThread.getUserName());
					exit.setText(userThread.getRoom());
					for (ChannelToChatThread channelToChatThread : channelToChatThreads) {
						if (chatServersWithRooms.get(channelToChatThread).contains(userThread.getRoom())) {
							channelToChatThread.sendMessage(exit);
							break;
						}
					}
				}
				userThread.setRoom(clientMessage.getText());
				channelToChatThreadWithLessRooms.sendMessage(clientMessage);
			} else {
				this.sendMessagetoUser(new ChatRequest("Room " + clientMessage.getText() + " already exists!"),
						userThread.getUserName());
			}
			break;
		case SHOW_ROOMS:
			Set<String> allRooms = new HashSet<>();
			for (ChannelToChatThread channelToChatThread : channelToChatThreads) {
				allRooms.addAll(chatServersWithRooms.get(channelToChatThread));
			}
			this.sendMessagetoUser(new ChatRequest(allRooms.toString()), userThread.getUserName());
			break;
		case ENTER_ROOM:
			if (chatServersDataWithRooms.containsKey(clientMessage.getText())) {
				userThread.setRoom(clientMessage.getText());
			}
		case SHOW_USERS_IN_ROOM:
			for (ChannelToChatThread channelToChatThread : channelToChatThreads) {
				if (chatServersWithRooms.get(channelToChatThread).contains(clientMessage.getText())) {
					channelToChatThread.sendMessage(clientMessage);
				}
			}
			break;
		default:
			if (!userThread.getRoom().isEmpty()) { // || clientMessage.getText().equals("[" +
													// clientMessage.getUserName() + "]: " + "bye")) {
				for (ChannelToChatThread channelToChatThread : channelToChatThreads) {
					if (chatServersWithRooms.get(channelToChatThread).contains(userThread.getRoom())) {
						channelToChatThread.sendMessage(clientMessage);
						break;
					}
				}
			} else {
				if (!clientMessage.getText().equals("[" + clientMessage.getUserName() + "]: " + "bye")
						&& !clientMessage.getText().equals("bye")) {
					sendMessagetoUser(new ChatRequest("You should join a room to chat with other people!"),
							clientMessage.getUserName());
				}
			}
			break;
		}
	}

	public void addRoomToChatServer(ChannelToChatThread channelToChatThreadWithLessRooms, String roomName) {
		chatServersWithRooms.get(channelToChatThreadWithLessRooms).add(roomName);
	}

	public ChannelToChatThread channelToChatThreadFromServerData(ServerData serverData) {
		for (ChannelToChatThread channelToChatThread : channelToChatThreads) {
			if (channelToChatThread.getServerData().equals(serverData)) {
				return channelToChatThread;
			}
		}
		return null;
	}

	void removeUser(String userName) {
		UserThread activeUser = userNameToUserThread.get(userName);
		if (activeUser != null) {
			removeUserThread(userName);
			userThreads.remove(activeUser);
			ChatResponse message = new ChatResponse("The user " + activeUser.getUserName() + " has been disconnected");
			message.setUserName(activeUser.getUserName());
			System.out.println(message.getText());
			log.info(message.getText());
		}
	}

	Set<String> getUserNames() {
		return this.userNameToUserThread.keySet();
	}

	boolean hasUsers() {
		return !this.userNameToUserThread.keySet().isEmpty();
	}

	synchronized public void addUserThread(String userName, UserThread userThread) throws SQLException {
		userNameToUserThread.putIfAbsent(userName, userThread);
		jedis.hset("allUsers", userName, serverName);
	}

	synchronized public void removeUserThread(String userName) {
		userNameToUserThread.remove(userName);
		jedis.hdel("allUsers", userName);
	}

	public void addRoomToUser(String userName, String roomName) {
		UserThread user = userNameToUserThread.get(userName);
		user.setRoom(roomName);
	}

	public boolean hasUser(String userName) {
		return userNameToUserThread.keySet().contains(userName);
	}

	public void removeChatServer(ChannelToChatThread channelToChatThread) {
		channelToChatThreads.remove(channelToChatThread);
	}

	public void updateRooms(ServerData serverData, String roomName) {
		ChannelToChatThread channelToChatThread = channelToChatThreadFromServerData(serverData);
		chatServersWithRooms.putIfAbsent(channelToChatThread, new HashSet<>());
		chatServersWithRooms.get(channelToChatThread).add(roomName);
		Set<String> roomNames = chatServersWithRooms.get(channelToChatThread);
		roomNames.add(roomName);

		System.out.println("roomNames:" + roomNames);
	}

	public String getServerName() {
		return serverName;
	}
}
