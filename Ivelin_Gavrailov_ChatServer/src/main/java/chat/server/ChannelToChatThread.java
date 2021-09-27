package chat.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

import chat.server.message.BaseChatMessage;
import chat.server.message.ServerInfoMessage;
import custom.inject.InjectLogger;
import custom.inject.InjectorCreater;
import server.constants.Constants;

public class ChannelToChatThread extends Thread {
	private Socket socket;
	private ChannelServer server;
	private ObjectOutputStream writer;
	private ObjectInputStream reader;
	private String channelName;
	private ServerData serverData;

	public ChannelToChatThread(Socket socket, ChannelServer server, ServerData serverData) {
		this.socket = socket;
		this.server = server;
		InjectorCreater.getInjector().injectMembers(this);
		this.serverData = serverData;
	}

	@InjectLogger
	Logger log;

	public String getChannelName() {
		return channelName;
	}

	public void run() {
		try {

			OutputStream os = socket.getOutputStream();
			writer = new ObjectOutputStream(os);
			InputStream is = socket.getInputStream();
			reader = new ObjectInputStream(is);

			sendMessage(new ServerInfoMessage(server.getServerName()));
			BaseChatMessage clientMessage;

			do {
				clientMessage = (BaseChatMessage) reader.readObject();
				if (clientMessage == null) {
					throw new Exception();
				}
				switch (clientMessage.getType()) {
				case MESSAGE:
					if (!clientMessage.getText().equals("bye")
							&& !clientMessage.getText().equals("[" + clientMessage.getUserName() + "]: " + "bye")) {
						server.sendMessagetoUser(clientMessage, clientMessage.getUserName());
					}
					break;
				case EXIT_ROOM:
					server.addRoomToUser(clientMessage.getUserName(), "");
					break;

				default:
					break;
				}
			} while (true);
		} catch (IOException ex) {
			log.error(Constants.LOG_EXCEPTION_MESSAGE, ex);
		} catch (Exception ex) {
			log.error(Constants.LOG_EXCEPTION_MESSAGE, ex);
		} finally {
			closeSilently(server, socket);
		}
	}

	synchronized public void sendMessage(BaseChatMessage clientMessage) {
		try {
			writer.writeObject(clientMessage);
		} catch (IOException e) {
			log.error(e);
			e.printStackTrace();
		}
	}

	public int getPort() {
		return socket.getLocalPort();
	}

	public String getIP() {
		return socket.getInetAddress().toString();
	}

	public Socket getSocket() {
		return socket;
	}

	public ChannelServer getServer() {
		return server;
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

	public ServerData getServerData() {
		return serverData;
	}

	public void closeSilently(ChannelServer server, Socket socket) {
		if (socket != null) {
			try {
				server.removeChatServer(this);
				socket.close();
				log.info(Constants.SOCKET_CLOSE_MESSAGE);
			} catch (IOException e) {
			}
		}
	}

}
