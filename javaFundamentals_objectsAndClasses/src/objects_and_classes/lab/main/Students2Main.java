package objects_and_classes.lab.main;

import java.util.ArrayList;
import java.util.Scanner;

import objects_and_classes.lab.entities.Student2;

public class Students2Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		ArrayList<Student2> students = new ArrayList<>();
		while (!input[0].equalsIgnoreCase("end")) {
			String firstName = input[0];
			String lastName = input[1];
			String age = input[2];
			String hometown = input[3];
			if (isStudentExisting(students, firstName, lastName)) {
				Student2 student = getStudent(students, firstName, lastName);
				student.setAge(age);
				student.setHometown(hometown);
			} else {
				Student2 student = new Student2();

				student.setFirstName(firstName);
				student.setLastName(lastName);
				student.setAge(age);
				student.setHometown(hometown);

				students.add(student);
			}
			input = scan.nextLine().split(" ");
		}
		String searchedHometown = scan.nextLine();
		for (Student2 student : students) {
			if (searchedHometown.equals(student.getHometown())) {
				System.out.print(student);
			}
		}
		scan.close();
	}

	private static boolean isStudentExisting(ArrayList<Student2> students, String firstName, String lastName) {
		for (Student2 student : students) {
			if (firstName.equals(student.getFirstName()) && lastName.equals(student.getLastName())) {
				return true;
			}
		}
		return false;
	}

	private static Student2 getStudent(ArrayList<Student2> students, String firstName, String lastName) {
		Student2 existingStudent = null;
		for (Student2 student : students) {
			if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
				existingStudent = student;
			}
		}
		return existingStudent;
	}
}