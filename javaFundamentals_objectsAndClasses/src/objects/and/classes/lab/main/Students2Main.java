package objects.and.classes.lab.main;

import java.util.ArrayList;
import java.util.Scanner;

import objects.and.classes.lab.entities.Student;

/**
 * Use the class from the previous problem. If you receive a student which
 * already exists (first name and last name should be unique) overwrite the
 * information.
 * 
 * @author Ivelin Gavrailov
 * @since 30.06.2020
 *
 */
public class Students2Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		ArrayList<Student> students = new ArrayList<>();
		while (!input[0].equalsIgnoreCase("end")) {
			String firstName = input[0];
			String lastName = input[1];
			String age = input[2];
			String hometown = input[3];
			if (isStudentExisting(students, firstName, lastName)) {
				Student student = getStudent(students, firstName, lastName);
				student.setAge(age);
				student.setHometown(hometown);
			} else {
				Student student = new Student(firstName, lastName, age, hometown);
				students.add(student);
			}
			input = scan.nextLine().split(" ");
		}
		String searchedHometown = scan.nextLine();
		for (Student student : students) {
			if (searchedHometown.equals(student.getHometown())) {
				System.out.print(student);
			}
		}
		scan.close();
	}

	private static boolean isStudentExisting(ArrayList<Student> students, String firstName, String lastName) {
		for (Student student : students) {
			if (firstName.equals(student.getFirstName()) && lastName.equals(student.getLastName())) {
				return true;
			}
		}
		return false;
	}

	private static Student getStudent(ArrayList<Student> students, String firstName, String lastName) {
		Student existingStudent = null;
		for (Student student : students) {
			if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
				existingStudent = student;
			}
		}
		return existingStudent;
	}
}