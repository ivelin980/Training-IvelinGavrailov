package com.playtech.chat.server.message;

public class LoginCommand extends BaseChatMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6477348545019507961L;
	/**
	 * 
	 */
	private String userName;
	private String text;

	public LoginCommand(String text) {
		this.text = text;
	}

	@Override
	public Command getType() {
		return Command.LOGIN;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public String getUserName() {
		return userName;
	}

	@Override
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
