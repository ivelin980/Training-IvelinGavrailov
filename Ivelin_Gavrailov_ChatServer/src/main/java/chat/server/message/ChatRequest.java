package chat.server.message;

public class ChatRequest extends BaseChatMessage {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8565319621010136700L;
	/**
	 * 
	 */
	private final String text;
	private String userName;

	public ChatRequest(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return userName != null ? "[" + userName + "]: " + text : text;
	}

	public String getUserName() {
		return userName != null ? userName : "";
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public Command getType() {
		return Command.MESSAGE;
	}

}