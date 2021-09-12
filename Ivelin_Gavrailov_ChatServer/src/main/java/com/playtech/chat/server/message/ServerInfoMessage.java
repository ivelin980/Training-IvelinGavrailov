package com.playtech.chat.server.message;

public class ServerInfoMessage extends BaseChatMessage {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4762370992915952962L;
	private String serverName;

	/**
	 * 
	 */

	public ServerInfoMessage(String serverName) {
		this.serverName = serverName;
	}

	@Override
	public Command getType() {
		return Command.SERVER_INFO;
	}

	@Override
	public String getText() {
		return serverName;
	}

	@Override
	public String getUserName() {
		return null;
	}

	@Override
	public void setUserName(String userName) {
	}

}
