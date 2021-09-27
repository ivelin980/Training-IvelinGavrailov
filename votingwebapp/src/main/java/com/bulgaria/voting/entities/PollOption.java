package com.bulgaria.voting.entities;

import java.util.Objects;

import org.springframework.data.annotation.Id;

public class PollOption implements Comparable<PollOption>{
	@Id
	private String id;
	
	private String optionName;
	private int optionVotes;
	
	public PollOption() {}

	public PollOption(String optionName) {
		this.optionName = optionName;
		this.optionVotes = 0;
	}
	
	public PollOption(String optionName, int optionVotes) {
		this.optionName = optionName;
		this.optionVotes = optionVotes;
	}

	public String getId() {
		return id;
	}

	public String getOptionName() {
		return optionName;
	}

	public int getOptionVotes() {
		return optionVotes;
	}

	public void setOptionVotes(int optionVotes) {
		this.optionVotes = optionVotes;
	}

	@Override
	public int compareTo(PollOption option) {	
		return Integer.compare(getOptionNumber(this.optionName), getOptionNumber(option.getOptionName()));
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		
		PollOption other = (PollOption)o;
		return this.id == other.id; 
	}
	
	@Override
    public int hashCode() {
        return Objects.hash(this.id, this.optionName, this.optionVotes);
    }
	
	private static int getOptionNumber(String optionName) {
		return Integer.parseInt(optionName.substring(0,optionName.indexOf(".")));
	}
	
	
}
