package jv.fundamentals.maps.exercise;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Write a program, which keeps information about courses. Each course has a
 * name and registered students. You will receive course name and student name,
 * until you receive the command "end". Check if such course already exists, and
 * if not, add the course. Register the user into the course. When you do
 * receive the command "end", print the courses with their names and total
 * registered users, ordered by the count of registered users in descending
 * order. For each contest print registered users ordered by name in ascending
 * order. Input • Until you receive "end", the input come in the format:
 * "{courseName} : {studentName}". • The product data is always delimited by " :
 * ". Output • Print information about each course, following the format:
 * "{courseName}: {registeredStudents}" • Print information about each student,
 * following the format: "-- {studentName}"
 * 
 * @author Ivelin Gavrailov
 * @since 08.07.2020
 *
 */
public class Courses {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedHashMap<String, ArrayList<String>> courses = new LinkedHashMap<>();
		String[] tokens = scan.nextLine().split(" : ");
		while (!"end".equalsIgnoreCase(tokens[0])) {
			String courseName = tokens[0];
			String studentName = tokens[1];
			courses.putIfAbsent(courseName, new ArrayList<>());
			courses.get(courseName).add(studentName);
			tokens = scan.nextLine().split(" : ");
		}
		courses.entrySet().stream().sorted((c1, c2) -> Integer.compare(c2.getValue().size(), c1.getValue().size()))
				.forEach(c -> System.out.println(String.format("%s: %d%n-- %s", c.getKey(), c.getValue().size(),
						String.join("\n-- ", c.getValue().stream().sorted().collect(Collectors.toList())))));
		scan.close();
	}
}
