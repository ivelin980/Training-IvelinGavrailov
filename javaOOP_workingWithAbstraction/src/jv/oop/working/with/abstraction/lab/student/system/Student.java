package jv.oop.working.with.abstraction.lab.student.system;

public class Student {
	private String name;
	private int age;
	private double grade;
	
	public Student(String name, int age, double grade) {
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public static String commentaryGrade(Student student) {
		if(student.grade>=3 && student.grade<5.5) {
			return "Average student.";
		}
		else if(student.grade>=5.5 && student.grade<6) {
			return "Excellent student.";
		}
		return null;
	}
}

