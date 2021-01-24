package jv.oop.encapsulation.lab.first.and.reserve.team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jv.oop.encapsulation.lab.salary.increase.Worker;

public class Team {
	private String name;
	private List<Worker> firstTeam;
	private List<Worker> reserveTeam;

	public Team(String name) {
		setName(name);
		this.firstTeam = new ArrayList<>();
		this.reserveTeam = new ArrayList<>();
	}

	public String getName() {
		return this.name;
	}

	public void addPlayer(Worker person) {
		if (person.getAge() < 40) {
			firstTeam.add(person);
		} else {
			reserveTeam.add(person);
		}
	}

	private void setName(String name) {
		this.name = name;
	}

	public List<Worker> getFirstTeam() {
		return Collections.unmodifiableList(this.firstTeam);
	}

	public List<Worker> getReserveTeam() {
		return Collections.unmodifiableList(this.reserveTeam);
	}
}
