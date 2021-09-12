package com.playtech.chat.server.message;

import java.io.Serializable;
import java.util.UUID;

public abstract class BaseChatMessage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1738943619395125574L;
	/**
	 * 
	 */
	private String id;
	private long date;

	protected BaseChatMessage() {
		this.id = UUID.randomUUID().toString();
		this.date = System.currentTimeMillis();
	}

	public String getId() {
		return id;
	}

	public long getDate() {
		return date;
	}

	public abstract Command getType();

	public abstract String getText();

	public abstract String getUserName();

	public abstract void setUserName(String userName);

	@Override
	public String toString() {
		return "BaseChatMessage [ USERNAME=" + getUserName() + ", id=" + id + ", date=" + date + ", type=" + getType()
				+ ", text=" + getText() + "]";

	}

}
