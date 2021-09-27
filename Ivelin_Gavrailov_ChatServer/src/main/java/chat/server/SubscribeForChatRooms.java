package chat.server;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import custom.inject.InjectLogger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class SubscribeForChatRooms extends Thread {
	private Jedis jedis;
	private ChannelServer channelServer;

	@InjectLogger
	private Logger log;

	public SubscribeForChatRooms(ChannelServer channelServer) {
		this.jedis = new Jedis();
		this.channelServer = channelServer;
	}

	public void subscribeForChatRooms(String channel) {
		try {
			JedisPubSub jedisPubSub = new JedisPubSub() {

				@Override
				public void onMessage(String channel, String message) {
					Gson gson = new Gson();
					@SuppressWarnings("unchecked")
					ConcurrentHashMap<String, String> chatServerAndRoom = gson.fromJson(message,
							ConcurrentHashMap.class);

					Map.Entry<String, String> entry = chatServerAndRoom.entrySet().iterator().next();
					ServerData serverData = gson.fromJson(entry.getKey(), ServerData.class);
					String roomName = entry.getValue();

					channelServer.updateRooms(serverData, roomName);

				}
			};

			jedis.subscribe(jedisPubSub, channel);

		} catch (Exception ex) {
			System.out.println("Exception : " + ex.getMessage());
			log.error(ex);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	@Override
	public void run() {
		this.subscribeForChatRooms("NewRoom");
	}
}
