package com.playtech.chat.server.message;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ShowUsersInRoomCommand extends BaseChatMessage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 102038995758586381L;
	/**
	 * 
	 */
	private String userName;
	private String roomName;
	private Set<String> userNamesInRoom = ConcurrentHashMap.newKeySet();

	public ShowUsersInRoomCommand(String roomName) {
		this.roomName = roomName;
	}

	@Override
	public Command getType() {
		return Command.SHOW_USERS_IN_ROOM;
	}

	@Override
	public String getText() {
		return this.roomName;
	}

	@Override
	public String getUserName() {
		return this.userName;
	}

	@Override
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<String> getUserNamesInRoom() {
		return userNamesInRoom;
	}

	public void setUserNamesInRoom(Set<String> userNames) {
		this.userNamesInRoom = userNames;
	}
}
