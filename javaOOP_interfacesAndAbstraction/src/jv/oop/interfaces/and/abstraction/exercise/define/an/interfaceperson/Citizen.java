package jv.oop.interfaces.and.abstraction.exercise.define.an.interfaceperson;

import jv.interfaces.and.abstraction.constants.Constants;

public class Citizen implements Person {
	private String name;
	private int age;

	public Citizen(String name, int age) {
		setName(name);
		setAge(age);
	}

	@Override
	public String getName() {
		return this.name;
	}

	private void setName(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(Constants.INVALID_NAME);
		}
		this.name = name;
	}

	@Override
	public int getAge() {
		return this.age;
	}

	private void setAge(int age) {
		if (age <= 0) {
			throw new IllegalArgumentException(Constants.INVALID_AGE);
		}
		this.age = age;
	}
}
