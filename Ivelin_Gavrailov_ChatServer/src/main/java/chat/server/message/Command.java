package chat.server.message;

public enum Command {
	CREATE_ROOM("CreateRoomCommand"), EXIT_ROOM("ExitRoomCommand"), ENTER_ROOM("GoToRoomCommand"),
	SHOW_ROOMS("ShowRoomsCommand"), MESSAGE("ChatRequest"), SHOW_USERS_IN_ROOM("ShowUsersInRoomCommand"),
	SERVER_INFO("ServerInfoMessage"), LOGIN("LoginCommand");

	public final String label;

	private Command(String label) {
		this.label = label;
	}

	public String toString() {
		return label;
	}
}
