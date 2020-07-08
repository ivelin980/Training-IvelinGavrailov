package objects.and.classes.exercise.main;

import java.util.ArrayList;
import java.util.Scanner;

import objects.and.classes.exercise.entities.Student;

/**
 * Write a program that receives an n count of students and orders them by grade
 * (in descending). Each student should have First name (string), Last name
 * (string) and grade (floating-point number). Input • First line will be a
 * number n • Next n lines you will get a student info in the format "{first
 * name} {second name} {grade}" Output • Print each student in the following
 * format "{first name} {second name}: {grade}"
 * 
 * @author Ivelin Gavrailov
 * @since 01.07.2020
 *
 */
public class StudentsMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		ArrayList<Student> students = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String[] input = scan.nextLine().split(" ");
			String firstName = input[0];
			String secondName = input[1];
			double grade = Double.parseDouble(input[2]);
			Student student = new Student(firstName, secondName, grade);
			students.add(student);
		}
		students.stream().sorted((s1, s2) -> Double.compare(s2.getGrade(), s1.getGrade()))
				.forEach(s1 -> System.out.println(s1));
		scan.close();
	}
}
