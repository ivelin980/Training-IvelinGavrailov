package jv.oop.encapsulation.lab.salary.increase;

import jv.oop.encapsulation.lab.sort.by.name.and.age.Person;

public class Worker extends Person {

	private double salary;

	public Worker(String firstName, String lastName, int age, double salary) {
		super(firstName, lastName, age);
		setSalary(salary);
		}

	public double getSalary() {
		return salary;
	}

	private void setSalary(double salary) {
		validateSalary(salary);
		this.salary = salary;
	}

	private void validateSalary(double salary) {
		if (salary < 460) {
			throw new IllegalArgumentException("Salary cannot be less than 460 leva");
		}
	}

	public double increaseSalary(double bonus) {
		if (this.getAge() < 30) {
			bonus /= 2;
		}
		this.salary = this.salary * (1 + bonus / 100);
		return this.salary;
	}

	@Override
	public String toString() {
		return String.format("%s %s gets %s leva", this.getFirstName(), this.getLastName(), this.salary);
	}
}
