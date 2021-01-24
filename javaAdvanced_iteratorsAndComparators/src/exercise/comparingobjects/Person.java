package exercise.comparingobjects;

public class Person implements Comparable<Person> {
	private String name;
	private int age;
	private String town;

	public Person(String name, int age, String town) {
		this.name = name;
		this.age = age;
		this.town = town;
	}

	@Override
	public int compareTo(Person p) {
		if (p.name.equals(this.name) && p.age == this.age && p.town.equals(this.town)) {
			return 1;
		}
		return 0;
	}
}
