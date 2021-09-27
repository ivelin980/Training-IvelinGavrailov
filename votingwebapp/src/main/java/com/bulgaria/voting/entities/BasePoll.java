package com.bulgaria.voting.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class BasePoll {
	@Id
	private String id;

	private String pollName;
	private String pollOwner;
	private List<String> pollOptions;
	private String status = "created";
	private List<String> voterEgns = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<String> getPollOptions() {
		return pollOptions;
	}

	public void setPollOptions(List<String> pollOptions) {
		this.pollOptions = pollOptions;
	}

	public List<String> getVoterEgns() {
		return voterEgns;
	}

	public void addVoterEgn(String voterEgn) {
		this.voterEgns.add(voterEgn);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + pollName + ", owner=" + pollOwner + ", pollOptions=" + pollOptions + "]";
	}
}
