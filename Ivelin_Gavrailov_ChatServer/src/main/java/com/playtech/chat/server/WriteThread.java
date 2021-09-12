package com.playtech.chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.playtech.chat.server.constants.Constants;
import com.playtech.chat.server.custom.inject.InjectLogger;
import com.playtech.chat.server.custom.inject.InjectorCreater;
import com.playtech.chat.server.message.BaseChatMessage;
import com.playtech.chat.server.message.ChatRequest;
import com.playtech.chat.server.message.CreateRoomCommand;
import com.playtech.chat.server.message.ExitRoomCommand;
import com.playtech.chat.server.message.GoToRoomCommand;
import com.playtech.chat.server.message.ShowRoomsCommand;
import com.playtech.chat.server.message.ShowUsersInRoomCommand;

@SuppressWarnings("unused")
public class WriteThread implements Runnable {
	private ObjectOutputStream writer;
	private Socket socket;
	private ChatClient client;
	private volatile boolean exit;

	@InjectLogger
	Logger log;

	public WriteThread(Socket socket, ChatClient client) throws IOException {
		this.socket = socket;
		this.client = client;
		InjectorCreater.getInjector().injectMembers(this);

		OutputStream os = socket.getOutputStream();
		writer = new ObjectOutputStream(os);
	}

	public void run() {
		try {
			while (client.getAtomicInitialized().get() == true) {
				BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
				ChatRequest command;
				ChatRequest userName;
				ChatRequest password;
				System.out.print(Constants.ENTER_COMMAND);
				command = new ChatRequest(console.readLine());
				if (command.getText().equals("login") || (command.getText().equals("create_user"))) {

					System.out.print(Constants.ENTER_USERNAME_MESSAGE);
					userName = new ChatRequest(console.readLine());
					System.out.print(Constants.ENTER_PASSWORD_MESSAGE);
					password = new ChatRequest(console.readLine());

					client.setUserName(userName.getText());
					client.setPassword(password.getText());
					writer.writeObject(command);
					writer.writeObject(userName);
					writer.writeObject(password);
					BaseChatMessage message;
					do {
						System.out.print(Constants.TYPE_HERE_SYMBOL);
						String text = console.readLine();
						switch (text) {
						case "create_room":
							System.out.print(Constants.ENTER_ROOM_NAME);
							text = console.readLine();
							message = new CreateRoomCommand(text);
							break;
						case "go_to_room":
							System.out.print(Constants.ENTER_ROOM_NAME);
							text = console.readLine();
							message = new GoToRoomCommand(text);
							break;
						case "exit_room":
							message = new ExitRoomCommand();
							break;
						case "show_rooms":
							message = new ShowRoomsCommand();
							break;
						case "show_users_in_room":
							System.out.print(Constants.ENTER_ROOM_NAME);
							text = console.readLine();
							message = new ShowUsersInRoomCommand(text);
							break;
						default:
							message = new ChatRequest(text);
							break;
						}
						if (message.getText().equals("exception")) {
							throw new Exception();
						}
						if (!message.getText().equals("")) {
							writer.writeObject(message);
						}
					} while (!message.getText().equalsIgnoreCase("bye"));
					client.getAtomicInitialized().set(false);
				} else {
					System.out.println(Constants.WRONG_COMMAND);
					client.getAtomicInitialized().set(false);
				}
			}
		} catch (IOException ex) {
			log.error(Constants.LOG_EXCEPTION_MESSAGE, ex);
			System.out.println(Constants.CONNECTION_TO_SERVER_ERROR_MESSAGE + ex.getMessage());
		} catch (Exception ex) {
			log.error(Constants.LOG_EXCEPTION_MESSAGE, ex);
			ex.printStackTrace();
		} finally {
			this.stop();
			log.debug(Constants.WRITETHREAD_STOP_MESSAGE);
//			closeSilently(socket);
		}
	}

	public void stop() {
		exit = true;
	}

	public static void closeSilently(Socket socket) {
		if (socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
			}
		}
	}
}
