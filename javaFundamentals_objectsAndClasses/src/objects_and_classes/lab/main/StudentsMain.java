package objects_and_classes.lab.main;

import java.util.ArrayList;
import java.util.Scanner;

import objects_and_classes.lab.entities.Student;

public class StudentsMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		ArrayList<Student> students = new ArrayList<>();
		while (!input[0].equalsIgnoreCase("end")) {
			String firstName = input[0];
			String lastName = input[1];
			String age = input[2];
			String hometown = input[3];

			Student student = new Student();

			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setAge(age);
			student.setHometown(hometown);

			students.add(student);
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
}
