package jv.oop.working.with.abstraction.lab.student.system;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * You are given a working project for a small Student System, but the code is
 * very poorly organized. Break up the code logically into smaller functional
 * units – methods and classes and don’t break the functionality. The program
 * supports the following commands: • “Create <studentName> <studentAge>
 * <studentGrade>” – creates a new student and adds them to the repository. •
 * “Show <studentName>” – prints on the console information about a student in
 * the format: “<studentName> is <studentAge> years old. <commentary>”, where
 * the commentary is based on the student’s grade. • “Exit” – closes the
 * program. Do not add any extra validation or functionality to the app!
 * 
 * @author Ivelin Gavrailov
 * @since 05.01.2020
 *
 */
public class StudentSystem {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = Arrays.stream(scan.nextLine().split("\\s+")).toArray(String[]::new);
		List<Student> students = new ArrayList<>();
		while (!"exit".equalsIgnoreCase(input[0])) {
			switch (input[0]) {
			case "Create": {
				String name = input[1];
				int age = Integer.parseInt(input[2]);
				double grade = Double.parseDouble(input[3]);
				Student student = new Student(name, age, grade);
				students.add(student);
			}
				break;
			case "Show":
				String name = input[1];
				show(students, name);
				break;
			default:
				break;
			}
			input = Arrays.stream(scan.nextLine().split("\\s+")).toArray(String[]::new);
		}
		scan.close();
	}

	public static void show(List<Student> students, String name) {
		for (Student s : students) {
			if (s.getName().equals(name)) {
				System.out.println(
						String.format("%s is %d years old. %s", s.getName(), s.getAge(), Student.commentaryGrade(s)));
			}
		}

	}
}
