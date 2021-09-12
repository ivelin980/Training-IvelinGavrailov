package jv.oop.interfaces.and.abstraction.lab.border.control;

import jv.interfaces.and.abstraction.constants.Constants;

public class Citizen implements Identifiable {
	private String name;
	private int age;
	private String id;

	public Citizen(String name, int age, String id) {
		setName(name);
		setAge(age);
		setId(id);
	}

	public String getName() {
		return this.name;
	}

	private void setName(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(Constants.INVALID_NAME);
		}
		this.name = name;
	}

	public int age() {
		return this.age;
	}

	private void setAge(int age) {
		if (age <= 0) {
			throw new IllegalArgumentException(Constants.INVALID_AGE);
		}
		this.age = age;
	}

	@Override
	public String getId() {
		return this.id;
	}

	private void setId(String id) {
		if (id.isEmpty()) {
			throw new IllegalArgumentException(Constants.INVALID_ID);
		}
		this.id = id;
	}
}
