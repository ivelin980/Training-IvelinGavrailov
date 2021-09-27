package chat.server.message;

public class CreateRoomCommand extends BaseChatMessage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4616482166897266980L;
	/**
	 * 
	 */
	private String roomName;
	private String userName;

	public CreateRoomCommand(String roomName) {
		this.roomName = roomName;
	}

	@Override
	public Command getType() {
		return Command.CREATE_ROOM;
	}

	@Override
	public String getText() {
		return roomName;
	}

	@Override
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
