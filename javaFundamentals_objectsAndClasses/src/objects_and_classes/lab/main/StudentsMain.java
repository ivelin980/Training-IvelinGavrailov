package objects_and_classes.lab.main;

import java.util.ArrayList;
import java.util.Scanner;

import objects_and_classes.lab.entities.Student;

/**
 * Define a class Student, which holds the following information about students:
 * first name, last name, age and hometown. Read list of students until you
 * receive "end" command. After that, you will receive a city name. Print only
 * students which are from the given city, in the following format: "{firstName}
 * {lastName} is {age} years old.".
 * 
 * @author Ivelin Gavrailov
 * @since 30.06.2020
 *
 */
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
