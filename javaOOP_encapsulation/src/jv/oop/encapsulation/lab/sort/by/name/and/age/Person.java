package jv.oop.encapsulation.lab.sort.by.name.and.age;

public class Person {
	private String firstName;
	private String lastName;
	private int age;

	public Person(String firstName, String lastName, int age) {
		setFirstName(firstName);
		setLastName(lastName);
		setAge(age);
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public int getAge() {
		return this.age;
	}
	
	private void setFirstName(String firstName) {
		validateName(firstName,"First name");
		this.firstName = firstName;
	}
	
	private void setLastName(String lastName) {
		validateName(lastName,"Last name");
		this.lastName = lastName;
	}

	private void setAge(int age) {
		validateAge(age);
		this.age = age;
	}
	
	public void validateAge(int age) {
		if(age<=0) {
			throw new IllegalArgumentException("Age cannot be zero or negative integer");
		}
	}
	
	public void validateName(String name,String prefix) {
		if(name.length()<3) {
			throw new IllegalArgumentException(prefix + " cannot be less than 3 symbols");
		}
	}
	
	@Override
	public String toString() {
		return String.format("%s %s is %d years old.", this.firstName, this.lastName, this.age);
	}

}
