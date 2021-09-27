package com.bulgaria.voting.entities;

public class Vote {
	private String pollId;
	private String pollOptionId;
	
	public void setPollId(String pollId) {
		this.pollId = pollId;
	}

	public void setPollOptionId(String pollOptionId) {
		this.pollOptionId = pollOptionId;
	}

	public String getPollId() {
		return pollId;
	}

	public String getPollOptionId() {
		return pollOptionId;
	}
	
	
}
