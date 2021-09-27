package chat.server;

import java.io.IOException;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.log4j.Logger;

import custom.inject.InjectLogger;
import custom.inject.InjectorCreater;
import server.constants.Constants;

public class ChatClient {
	private String userName;
	private String password;
	private AtomicBoolean atomicInitialized;

	public ChatClient() {
		atomicInitialized = new AtomicBoolean(true);
		InjectorCreater.getInjector().injectMembers(this);
	}

	@InjectLogger
	Logger log;

	public void execute() {
		try {
			String hostName = null;
			int port = 0;
			Random rand = new Random();
			JedisRead jedisRead = new JedisRead();
			int random = rand.nextInt(jedisRead.getConnectedChannelServers().size());
			int index = 0;
			for (ServerData serverData : jedisRead.getConnectedChannelServers()) {
				if (index == random) {
					hostName = serverData.getIp();
					port = serverData.getPort();
					break;
				}
				index++;
			}
			Socket socket = new Socket(hostName, port);
			System.out.println(Constants.CONNECTION_TO_SERVER_SUCCESS_MESSAGE);

			Runnable write = new WriteThread(socket, this);
			Runnable read = new ReadThread(socket, this);

			Thread writeThread = new Thread(write);
			Thread readThread = new Thread(read);
			readThread.start();
			log.debug(Constants.READTHREAD_START_MESSAGE);

			writeThread.start();
			log.debug(Constants.WRITETHREAD_START_MESSAGE);
		} catch (IOException ex) {
			log.error(Constants.LOG_EXCEPTION_MESSAGE, ex);
			System.out.println(Constants.CONNECTION_TO_SERVER_ERROR_MESSAGE + ex.getMessage());
		}
	}

	void setUserName(String username) {
		this.userName = username;
	}

	String getUserName() {
		return this.userName;
	}

	public AtomicBoolean getAtomicInitialized() {
		return atomicInitialized;
	}

	public void setAtomicInitialized(AtomicBoolean atomicInitialized) {
		this.atomicInitialized = atomicInitialized;
	}

	public static void main(String[] args) {
		ChatClient client = new ChatClient();
		client.execute();
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
