package objects.and.classes.exercise.entities;

public class Student {
	private String firstName;
	private String secondName;
	private double grade;

	public Student(String firstName, String secondName, double grade) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.grade = grade;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		String output = String.format("%s %s: %.2f", firstName, secondName, grade);
		return output;
	}
}
