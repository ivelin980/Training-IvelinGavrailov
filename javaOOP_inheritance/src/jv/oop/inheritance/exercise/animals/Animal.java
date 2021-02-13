package jv.oop.inheritance.exercise.animals;

public abstract class Animal {

	private String name;
	private int age;
	private String gender;

	public Animal(String name, int age, String gender) {
		setName(name);
		setAge(age);
		setGender(gender);
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	protected abstract String produceSound();

	private void setName(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(Constants.INVALID_INPUT_MESSAGE);
		}
		this.name = name;
	}

	private void setAge(int age) {
		if (age < 0) {
			throw new IllegalArgumentException(Constants.INVALID_INPUT_MESSAGE);
		}
		this.age = age;
	}

	private void setGender(String gender) {
		if (!"Female".equalsIgnoreCase(gender) && !"Male".equalsIgnoreCase(gender)) {
			throw new IllegalArgumentException(Constants.INVALID_INPUT_MESSAGE);
		}
		this.gender = gender;
	}

	@Override
	public String toString() {
		return String.format("%s%n%s %d %s%n%s", this.getClass().getSimpleName(), this.getName(), this.getAge(),
				this.getGender(), this.produceSound());
	}
}