package chat.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.log4j.Logger;

import chat.server.message.BaseChatMessage;
import chat.server.message.ChatRequest;
import chat.server.message.LoginCommand;
import custom.inject.InjectLogger;
import custom.inject.InjectorCreater;
import server.constants.Constants;

@SuppressWarnings("unused")
public class ReadThread implements Runnable {
	private ObjectInputStream reader;
	private Socket socket;
	private ChatClient client;
	private volatile boolean exit;

	@InjectLogger
	Logger log;

	public ReadThread(Socket socket, ChatClient client) throws IOException {
		this.socket = socket;
		this.client = client;
		InjectorCreater.getInjector().injectMembers(this);
		InputStream is = socket.getInputStream();
		try {
			reader = new ObjectInputStream(is);
		} catch (IOException ex) {
			log.error(ex);
			System.out.println(Constants.INPUT_ERROR_MESSAGE + ex.getMessage());
		}
	}

	public void run() {
		try {
			while (client.getAtomicInitialized().get() == true) {
				BaseChatMessage response = (BaseChatMessage) reader.readObject();
				if (response instanceof LoginCommand) {
					String text = response.getText();
					if (text.equals("Username already in use") || text.equals(Constants.INCORRECT_INPUT)) {
						client.setAtomicInitialized(new AtomicBoolean(false));
					}
				}
				System.out.println(response.getText());
				System.out.print("> ");
			}
		} catch (IOException ex) {
			log.error(ex);

		} catch (Exception ex) {
			log.error(Constants.LOG_EXCEPTION_MESSAGE, ex);

			client.getAtomicInitialized().set(false);
		} finally {

			this.stop();
			System.out.println(Constants.DISCONNECTED_FROM_SERVER_MESSAGE);
			log.debug(Constants.READTHREAD_STOP_MESSAGE);
		}
	}

	public void stop() {
		exit = true;
	}
}
