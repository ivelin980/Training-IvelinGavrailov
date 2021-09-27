package com.bulgaria.voting.entities;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3834835087686176459L;
	String egn;
	String personalCode;
	String role;

	public String getEgn() {
		return egn;
	}

	public String getPersonalCode() {
		return personalCode;
	}

	public void setEgn(String egn) {
		this.egn = egn;
	}

	public void setPersonalCode(String personalCode) {
		this.personalCode = personalCode;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
