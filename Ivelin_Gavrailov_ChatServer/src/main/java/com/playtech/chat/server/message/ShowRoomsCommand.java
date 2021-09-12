package com.playtech.chat.server.message;

public class ShowRoomsCommand extends BaseChatMessage {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2424430831135653048L;
	/**
	 * 
	 */
	private String roomNames;
	private String userName;

	@Override
	public Command getType() {
		return Command.SHOW_ROOMS;
	}

	@Override
	public String getText() {
		return this.roomNames == null ? "No rooms in the server" : this.roomNames;
	}

	public void setRoomNames(String roomNames) {
		this.roomNames = roomNames;
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
