package com.playtech.chat.server.message;

public class ExitRoomCommand extends BaseChatMessage {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1145603839045839781L;
	/**
	 * 
	 */
	private String userName;
	private String roomName;

	@Override
	public Command getType() {
		return Command.EXIT_ROOM;
	}

	@Override
	public String getText() {
		return roomName != null ? roomName : "No room set";
	}

	public void setText(String roomName) {
		this.roomName = roomName;
	}

	@Override
	public String getUserName() {
		return this.userName;
	}

	@Override
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
