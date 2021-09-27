package chat.server.message;

public class GoToRoomCommand extends BaseChatMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8221519601255515486L;
	/**
	 * 
	 */
	private String roomName;
	private String userName;

	public GoToRoomCommand(String roomName) {
		this.roomName = roomName;
	}

	@Override
	public Command getType() {
		return Command.ENTER_ROOM;
	}

	@Override
	public String getText() {
		return this.roomName;
	}

	@Override
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
