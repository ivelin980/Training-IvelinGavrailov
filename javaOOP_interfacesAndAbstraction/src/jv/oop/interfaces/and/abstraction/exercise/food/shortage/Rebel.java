package jv.oop.interfaces.and.abstraction.exercise.food.shortage;

import jv.interfaces.and.abstraction.constants.Constants;

public class Rebel implements Buyer {
	private String name;
	private int age;
	private String group;
	private int food;

	public Rebel(String name, int age, String group) {
		setName(name);
		setAge(age);
		setGroup(group);
		this.food = 0;
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
	public void buyFood() {
		this.food += 5;
	}

	public String getGroup() {
		return this.group;
	}

	private void setGroup(String group) {
		if (group.isEmpty()) {
			throw new IllegalArgumentException("Group should not be empty!");
		}
		this.group = group;
	}

	@Override
	public int getFood() {
		return this.food;
	}
}
