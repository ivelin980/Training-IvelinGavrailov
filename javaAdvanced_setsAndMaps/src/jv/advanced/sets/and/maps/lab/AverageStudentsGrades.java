package jv.advanced.sets.and.maps.lab;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Write a program, which reads the name of a student and their grades and adds
 * them to the student record, then prints grades along with their average grade
 * – ordered the output by the names of the students.
 * 
 * @author Ivelin Gavrailov
 * @since 24.08.2020
 *
 */
public class AverageStudentsGrades {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = Integer.parseInt(scan.nextLine());
		TreeMap<String, ArrayList<String>> student = new TreeMap<>();
		for (int i = 0; i < input; i++) {
			String[] tokens = scan.nextLine().split("\\s+");
			String name = tokens[0];
			String grade = String.valueOf(String.format("%.2f", Double.parseDouble(tokens[1])));
			student.putIfAbsent(name, new ArrayList<>());
			student.get(name).add(grade);
		}
		student.entrySet().stream().forEach(s -> System.out.println(String.format("%s -> %s (avg: %.2f)", s.getKey(),String.join(" ", s.getValue()),getAverageGrade(s.getValue()))));
		scan.close();
	}
	
	private static double getAverageGrade(ArrayList<String> grades) {
		double sum = 0;
		for (String grade : grades) {
			sum += Double.parseDouble(grade);
		}
		return sum / grades.size();
	}
}
