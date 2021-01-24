package exercise.strategypattern;

public class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		setName(name);
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	private void setName(String name) {
		if(name.isEmpty() || name == null) {
			throw new IllegalArgumentException("Name cannot be empty or null");
		}
		this.name = name;
	}

	@Override
	public int hashCode() {
		return (this.name.hashCode() + Integer.hashCode(age)) * 73;
	}

	@Override
	public String toString() {
		return this.name + " " + this.age;
	}
}
