package jv.oop.interfaces.and.abstraction.exercise.multiple.implementation;

import jv.interfaces.and.abstraction.constants.Constants;

public class Citizen implements Identifiable, Birthable, Person {
	private String name;
	private int age;
	private String id;
	private String birthDate;

	public Citizen(String name, int age, String id, String birthDate) {
		setName(name);
		setAge(age);
		setId(id);
		setBirthDate(birthDate);
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

	@Override
	public String getBirthDate() {
		return this.birthDate;
	}

	private void setBirthDate(String birthDate) {
		if (birthDate.length() != 10) {
			throw new IllegalArgumentException(Constants.INVALID_BIRTHDATE);
		}
		int date = Integer.parseInt(birthDate.substring(0, 2));
		int month = Integer.parseInt(birthDate.substring(3, 5));
		int year = Integer.parseInt(birthDate.substring(6, 10));
		if (date < 0 || date > 31 || month < 0 || month > 31 || year < 0 || year > 2021) {
			throw new IllegalArgumentException(Constants.INVALID_BIRTHDATE);
		}
		this.birthDate = birthDate;
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
