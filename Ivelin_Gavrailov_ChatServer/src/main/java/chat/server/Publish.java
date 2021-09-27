package chat.server;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import custom.inject.InjectLogger;
import redis.clients.jedis.Jedis;

public class Publish extends Thread {
	private Jedis jedis;

	@InjectLogger
	private Logger log;

	public Publish() {
		this.jedis = new Jedis();
	}

	public void publish(String topic, String message) {
		try {
			jedis.publish(topic, message);
		} catch (Exception ex) {
			System.out.println("Exception : " + ex.getMessage());
			log.error(ex);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	public void setJsonString(String key, ServerData serverData) {
		Gson gson = new Gson();
		String json = gson.toJson(serverData, serverData.getClass());
		jedis.sadd(key, json);
	}

	public Jedis getJedis() {
		return this.jedis;
	}

	@Override
	public void run() {
	}
}
