package chat.server;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import redis.clients.jedis.Jedis;

public class JedisRead {
	private Jedis jedis = new Jedis();

	public Set<ServerData> getConnectedChatServers() {
		Set<ServerData> serversData = new HashSet<>();
		Set<String> members = jedis.smembers("chatServers");
		for (String member : members) {
			Gson gson = new Gson();
			ServerData serverData = gson.fromJson(member, ServerData.class);
			serversData.add(serverData);
		}
		return serversData;
	}

	public Set<ServerData> getConnectedChannelServers() {
		Set<ServerData> serversData = new HashSet<>();
		Set<String> members = jedis.smembers("channelServers");
		for (String member : members) {
			Gson gson = new Gson();
			ServerData serverData = gson.fromJson(member, ServerData.class);
			serversData.add(serverData);
		}
		return serversData;
	}

	public HashMap<String, ServerData> getChatRooms() {
		HashMap<String, ServerData> result = new HashMap<>();

		if (jedis.exists("chatRooms")) {
			String json = jedis.get("chatRooms");
			Gson gson = new Gson();
			Map<String, ServerData> chatServerAndRoom = gson.fromJson(json, new TypeToken<Map<String, ServerData>>() {
			}.getType());
			for (Map.Entry<String, ServerData> entry : chatServerAndRoom.entrySet()) {
				ServerData serverData = entry.getValue();
				String roomName = entry.getKey();

				result.put(roomName, serverData);
			}
		}
		return result;
	}
}
