package chat.server.message;

public class ChatResponse extends BaseChatMessage {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1225375553735687968L;
	/**
	 * 
	 */
	private String userName;
	private final String text;

	public ChatResponse(String text) {
		this.text = text;
	}

	@Override
	public Command getType() {
		return Command.MESSAGE;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
