package com.playtech.chat.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Set;

import org.apache.log4j.Logger;

import com.playtech.chat.server.constants.Constants;
import com.playtech.chat.server.custom.inject.InjectLogger;
import com.playtech.chat.server.custom.inject.InjectorCreater;
import com.playtech.chat.server.message.BaseChatMessage;
import com.playtech.chat.server.message.ChatResponse;

public class ChatToChannelThread extends Thread {
	private Socket socket;
	private ChatServer chatServer;
	private ObjectOutputStream writer;
	private ObjectInputStream reader;
	private String serverName;

	public ChatToChannelThread(Socket socket, ChatServer chatServer) {
		this.socket = socket;
		this.chatServer = chatServer;
		InjectorCreater.getInjector().injectMembers(this);
	}

	@InjectLogger
	Logger log;

	public void run() {
		try {
			OutputStream os = socket.getOutputStream();
			writer = new ObjectOutputStream(os);
			InputStream is = socket.getInputStream();
			reader = new ObjectInputStream(is);

			BaseChatMessage clientMessage;

			do {
				clientMessage = (BaseChatMessage) reader.readObject();
				if (clientMessage == null) {
					throw new Exception();
				}
				switch (clientMessage.getType()) {
				case CREATE_ROOM:
					chatServer.addRoom(clientMessage.getText());
					chatServer.addUserToRoom(clientMessage.getText(), clientMessage.getUserName());
					break;
				case ENTER_ROOM: {
					chatServer.addUserToRoom(clientMessage.getText(), clientMessage.getUserName());
					ChatResponse message = new ChatResponse(clientMessage.getUserName() + " joined the room");
					message.setUserName(clientMessage.getUserName());
					chatServer.sendMessageToUsersInRoom(message);
				}
					break;
				case EXIT_ROOM: {
					ChatResponse message = new ChatResponse(clientMessage.getUserName() + " left the room");
					message.setUserName(clientMessage.getUserName());
					chatServer.sendMessageToUsersInRoom(message);
					chatServer.removeUserFromRoom(clientMessage.getUserName());
					writer.writeObject(clientMessage);
				}
					break;
				case SHOW_USERS_IN_ROOM:
					if (chatServer.getRoomsWithUsers().containsKey(clientMessage.getText())) {
						Set<String> userNames = chatServer.getRoomsWithUsers().get(clientMessage.getText());
						ChatResponse response = new ChatResponse(userNames.toString());
						response.setUserName(clientMessage.getUserName());
						writer.writeObject(response);
					}
					break;
				case SERVER_INFO:
					this.serverName = clientMessage.getText();
					break;
				default:
					chatServer.sendMessageToUsersInRoom(clientMessage);
					if (clientMessage.getText().equalsIgnoreCase("bye") || clientMessage.getText()
							.equalsIgnoreCase("[" + clientMessage.getUserName() + "]: " + "bye")) {
						chatServer.removeUserFromRoom(clientMessage.getUserName());
						writer.writeObject(clientMessage);
					}
					break;
				}
			} while (true);
		} catch (IOException ex) {
			log.error(Constants.LOG_EXCEPTION_MESSAGE, ex);
			ex.printStackTrace();
		} catch (Exception ex) {
			log.error(Constants.LOG_EXCEPTION_MESSAGE, ex);
		} finally {
			closeSilently(chatServer, socket);
		}
	}

	public void sendMessage(BaseChatMessage clientMessage) {
		try {
			writer.writeObject(clientMessage);
		} catch (IOException e) {
			log.error(e);
			e.printStackTrace();
		}
	}

	public void closeSilently(ChatServer server, Socket socket) {
		if (socket != null) {
			try {
				server.removeChannel(this);
				socket.close();
				log.info(Constants.SOCKET_CLOSE_MESSAGE);
			} catch (IOException e) {
			}
		}
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public Socket getSocket() {
		return socket;
	}

	public ChatServer getChatServer() {
		return chatServer;
	}

	public ObjectOutputStream getWriter() {
		return writer;
	}

	public ObjectInputStream getReader() {
		return reader;
	}

	public Logger getLog() {
		return log;
	}

}
