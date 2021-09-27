package com.bulgaria.voting.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class PollOutput {
	@Id
	private String pollId;

	private String pollName;
	private String pollOwner;
	private List<PollOption> pollOptions;
	private String status;
	private List<String> voterEgns = new ArrayList<>();

	public PollOutput(String pollId,String pollName, String pollOwner, List<PollOption> pollOptions, String status, List<String> voterEgns) {
		this.pollId = pollId;
		this.pollName = pollName;
		this.pollOwner = pollOwner;
		this.pollOptions = pollOptions;
		this.status = status;
		this.voterEgns = voterEgns;
	}

	public String getPollId() {
		return pollId;
	}

	public void setPollId(String pollId) {
		this.pollId = pollId;
	}

	public String getPollName() {
		return pollName;
	}

	public void setPollName(String pollName) {
		this.pollName = pollName;
	}

	public String getPollOwner() {
		return pollOwner;
	}

	public void setPollOwner(String pollOwner) {
		this.pollOwner = pollOwner;
	}

	public List<PollOption> getPollOptions() {
		return pollOptions;
	}
	
	public List<String> getVoterEgns() {
		return voterEgns;
	}

	public void setVoterEgns(List<String> voterEgns) {
		this.voterEgns = voterEgns;
	}

	public void setPollOptions(List<PollOption> pollOptions) {
		this.pollOptions = pollOptions;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	public int getAllVotes() {
		return getVoterEgns().size();
	}
	
	@Override
	public String toString() {
		return "PollOutput [pollId=" + pollId + ", pollName=" + pollName + ", pollOwner=" + pollOwner + ", pollOptions="
				+ pollOptions + "]";
	}
	
	
}
