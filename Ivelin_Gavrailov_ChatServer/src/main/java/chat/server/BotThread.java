package chat.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import chat.server.message.BaseChatMessage;
import chat.server.message.ChatRequest;
import chat.server.message.ChatResponse;
import chat.server.message.Command;
import chat.server.message.CreateRoomCommand;
import chat.server.message.ExitRoomCommand;
import chat.server.message.GoToRoomCommand;
import chat.server.message.ShowRoomsCommand;
import chat.server.message.ShowUsersInRoomCommand;

public class BotThread extends Thread {
	private Socket socket;
	private ObjectOutputStream writer;
	private String userName;

	public BotThread(Socket socket, String userName) {
		this.socket = socket;
		this.userName = userName;
	}

	@Override
	public void run() {
		try {
			OutputStream os = socket.getOutputStream();
			writer = new ObjectOutputStream(os);
			ChatRequest command = new ChatRequest("login");
			writer.writeObject(command);
			ChatRequest userName = new ChatRequest(this.userName);
			writer.writeObject(userName);
			ChatRequest password = new ChatRequest(this.userName);
			writer.writeObject(password);
			doOperations(5, randomMessage(userName.getText()));
		} catch (IOException | InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	private BaseChatMessage randomMessage(String userName) {
		JedisRead jedisRead = new JedisRead();
		Map<String, ServerData> chatRooms = jedisRead.getChatRooms();
		List<String> keysAsArray = new ArrayList<String>(chatRooms.keySet());
		Random r = new Random();
		int pick = r.nextInt(Command.values().length - 2);
		String roomName = randomString();
		if (!keysAsArray.isEmpty()) {
			roomName = keysAsArray.get(r.nextInt(keysAsArray.size()));
		}
		Command command = Command.values()[pick];
		BaseChatMessage message = null;
		switch (command) {
		case CREATE_ROOM:
			message = new CreateRoomCommand(randomString());
			break;
		case ENTER_ROOM:
			message = new GoToRoomCommand(roomName);
			break;
		case EXIT_ROOM:
			message = new ExitRoomCommand();
			break;
		case MESSAGE:
			message = new ChatRequest(randomString());
			break;
		case SHOW_ROOMS:
			message = new ShowRoomsCommand();
			break;
		case SHOW_USERS_IN_ROOM:
			message = new ShowUsersInRoomCommand(roomName);
			break;
		default:
			break;
		}
		message.setUserName(userName);
		return message;
	}

	public String randomString() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		return generatedString;
	}

	private void doOperations(int count, BaseChatMessage message) throws IOException, InterruptedException {
		int counter = 0;
		while (counter < count) {
			writer.writeObject(message);
			BotThread.sleep(1000);
			counter++;
		}
		ChatResponse lastMessage = new ChatResponse("bye");
		lastMessage.setUserName(BotThread.this.userName);
		writer.writeObject(lastMessage);
	}
}
