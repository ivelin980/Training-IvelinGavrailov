package com.playtech.chat.server;

import java.util.Set;

import org.apache.log4j.Logger;

import com.playtech.chat.server.custom.inject.InjectLogger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class SubscribeForChatServers extends Thread {
	private Jedis jedis;
	private JedisRead jedisRead = new JedisRead();
	private ChannelServer channelServer;

	@InjectLogger
	private Logger log;

	public SubscribeForChatServers(ChannelServer channelServer) {
		this.jedis = new Jedis();
		this.channelServer = channelServer;
	}

	public void subscribeForChatServers(String channel) {

		try {
			JedisPubSub jedisPubSub = new JedisPubSub() {

				@Override
				public void onMessage(String channel, String message) {
					Set<ServerData> serversData = jedisRead.getConnectedChatServers();
					for (ServerData serverData : serversData) {
						if (serverData.getServerName().equals(message)) {
							channelServer.connectToChatServers(serverData);
							return;
						}
					}

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
		this.subscribeForChatServers("NewChatServer");
	}
}