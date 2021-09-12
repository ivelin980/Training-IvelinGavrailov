package com.playtech.chat.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

import org.apache.log4j.Logger;

import com.playtech.chat.server.constants.Constants;
import com.playtech.chat.server.custom.inject.InjectLogger;
import com.playtech.chat.server.custom.inject.InjectorCreater;
import com.playtech.chat.server.message.BaseChatMessage;
import com.playtech.chat.server.message.ChatRequest;
import com.playtech.chat.server.message.ChatResponse;
import com.playtech.chat.server.message.CreateRoomCommand;
import com.playtech.chat.server.message.LoginCommand;

@SuppressWarnings("unused")
public class UserThread extends Thread {
	private Socket socket;
	private ChannelServer server;
	private ObjectOutputStream writer;
	private ObjectInputStream reader;
	private String userName;
	private String password;
	private String room;
	private volatile boolean exit;

	public UserThread(Socket socket, ChannelServer channelServer) {
		this.socket = socket;
		this.server = channelServer;
		InjectorCreater.getInjector().injectMembers(this);
	}

	@InjectLogger
	Logger log;

	public String getUserName() {
		if (userName != null) {
			return userName;
		}
		return "";
	}

	public void run() {
		try {
			OutputStream os = socket.getOutputStream();
			writer = new ObjectOutputStream(os);
			InputStream is = socket.getInputStream();
			reader = new ObjectInputStream(is);
			Database database = Database.getInstance();
			String command = ((ChatRequest) reader.readObject()).getText();
			userName = ((ChatRequest) reader.readObject()).getText();
			password = ((ChatRequest) reader.readObject()).getText();
			boolean isValid = false;
			LoginCommand loginResponse = null;
			if (command.equals("login")) {
				isValid = database.isLoginSuccessful(userName, password);
				String text = isValid ? "Correct username and password." : Constants.INCORRECT_INPUT;
				loginResponse = new LoginCommand(text);
			} else if (command.equals("create_user")) {
				isValid = !database.isAlreadyInUse(userName);
				if (isValid == true) {
					database.createUser(userName, password);
				}
				String text = isValid ? "Created user!" : "Username already in use";
				loginResponse = new LoginCommand(text);
			}
			if (server.hasUser(userName) == false && isValid) {
				server.addUserThread(userName, this);
				server.sendMessagetoUser(loginResponse, userName);
				ChatRequest messageForUser = new ChatRequest(Constants.SUCCESSFULL_LOGIN);
				server.sendMessagetoUser(messageForUser, this.getUserName());
				ChatResponse serverMessage = new ChatResponse(Constants.NEW_USER_CONNECTED_MESSAGE + ": " + userName);
				serverMessage.setUserName(userName);
				log.info(serverMessage.getText());

				printUsers();
				BaseChatMessage clientMessage;
				String textOfMessage = "";
				do {
					clientMessage = (BaseChatMessage) reader.readObject();
					if (clientMessage == null) {
						throw new Exception();
					}
					textOfMessage = clientMessage.getText();
					clientMessage.setUserName(userName);
					server.sendToChatServer(clientMessage);
				} while (!textOfMessage.equalsIgnoreCase("bye"));
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			log.error(Constants.LOG_EXCEPTION_MESSAGE, ex);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error(Constants.LOG_EXCEPTION_MESSAGE, ex);
		} finally {
			this.interrupt();
			closeSilently(server, socket, this);
		}
	}

	void printUsers() {
		if (server.hasUsers()) {
			System.out.println(Constants.USERS_CONNECTED_MESSAGE + server.getUserNames());
		} else {
			System.out.println(Constants.NO_USERS_CONNECTED_MESSAGE);
		}
	}

	public void sendMessage(BaseChatMessage message) {
		try {
			writer.writeObject(message);
		} catch (IOException e) {
			log.error(e);
			e.printStackTrace();
		}
	}

	public void closeSilently(ChannelServer server2, Socket socket, UserThread user) {
		if (socket != null) {
			try {
				log.info(Constants.SOCKET_CLOSE_MESSAGE + " USERNAME: " + user.userName);
				server.removeUser(userName);
				socket.close();
			} catch (IOException e) {
			}
		}
	}

	public String getRoom() {
		if (room != null) {
			return room;
		}
		return "";
	}

	public void setRoom(String room) {
		this.room = room;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (exit ? 1231 : 1237);
		result = prime * result + ((log == null) ? 0 : log.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((reader == null) ? 0 : reader.hashCode());
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		result = prime * result + ((server == null) ? 0 : server.hashCode());
		result = prime * result + ((socket == null) ? 0 : socket.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((writer == null) ? 0 : writer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserThread other = (UserThread) obj;
		if (exit != other.exit)
			return false;
		if (log == null) {
			if (other.log != null)
				return false;
		} else if (!log.equals(other.log))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (reader == null) {
			if (other.reader != null)
				return false;
		} else if (!reader.equals(other.reader))
			return false;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		if (server == null) {
			if (other.server != null)
				return false;
		} else if (!server.equals(other.server))
			return false;
		if (socket == null) {
			if (other.socket != null)
				return false;
		} else if (!socket.equals(other.socket))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (writer == null) {
			if (other.writer != null)
				return false;
		} else if (!writer.equals(other.writer))
			return false;
		return true;
	}

}
