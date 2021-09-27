package chat.server;

import java.io.IOException;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.sql.SQLException;
import java.util.Random;

import server.constants.Constants;

public class BotClient {

	public static void main(String[] args) throws SQLException, IOException {
		BotClient client = new BotClient();
		client.connectBots(Integer.parseInt(args[0]));

	}

	private void connectBots(int numberOfBots) {
		for (int i = 0; i < numberOfBots; i++) {
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
				BotThread bot = new BotThread(socket, "bot" + i);
				bot.start();
				Thread.sleep(100);
			} catch (UnknownHostException ex) {
				System.out.println(Constants.CONNECTION_TO_SERVER_ERROR_MESSAGE + ex.getMessage());
			} catch (IOException ex) {
				System.out.println(Constants.CONNECTION_TO_SERVER_ERROR_MESSAGE + ex.getMessage());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}