package objects.and.classes.lab.entities;

public class Student {
	private String firstName;
	private String lastName;
	private String age;
	private String hometown;
	
	public Student(String firstName, String lastName, String age, String hometown) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.hometown = hometown;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	@Override
	public String toString() {
		return String.format("%s %s is %s years old%n", this.firstName, this.lastName, this.age);
	}
}
