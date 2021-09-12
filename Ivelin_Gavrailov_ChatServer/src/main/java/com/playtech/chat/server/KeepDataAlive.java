package com.playtech.chat.server;

import java.time.Instant;

import redis.clients.jedis.Jedis;

public class KeepDataAlive extends Thread {
	private Jedis jedis = new Jedis();
	private String key;

	public KeepDataAlive(String key) {
		this.key = key;
	}

	@Override
	public void run() {
		jedis.expireAt(key, Instant.now().getEpochSecond()+2);
//		jedis.expire(key, 2);
	}

}
