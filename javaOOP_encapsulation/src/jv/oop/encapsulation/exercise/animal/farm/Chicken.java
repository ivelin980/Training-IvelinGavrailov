package jv.oop.encapsulation.exercise.animal.farm;

public class Chicken {
	private String name;
	private int age;

	public Chicken(String name, int age) {
		setName(name);
		setAge(age);
	}

	private void setAge(int age) {
		validateAge(age);
		this.age = age;
	}

	private void validateAge(int age) {
		if (age < 0 || age > 15) {
			throw new IllegalArgumentException("Age should be between 0 and 15.");
		}
	}

	private void setName(String name) {
		validateName(name);
		this.name = name;
	}

	private void validateName(String name) {
		if (name.length() < 1) {
			throw new IllegalArgumentException("Name cannot be empty.");
		}
	}

	public double productPerDay() {
		return this.calculateProductPerDay();
	}

	private double calculateProductPerDay() {
		if (this.age < 6) {
			return 2;
		} else if (this.age < 12) {
			return 1;
		}
		return 0.75;
	}
	
	@Override
	public String toString() {
		return String.format("Chicken %s (age %d) can produce %.2f eggs per day.",this.name,this.age,this.productPerDay());	
	}

}
