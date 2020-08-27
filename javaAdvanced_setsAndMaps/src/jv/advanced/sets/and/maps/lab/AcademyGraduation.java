package jv.advanced.sets.and.maps.lab;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Write a program that: Read from console number of students for a track
 * Read on pair of rows: o First line is the name of student o Second line is
 * his score for different number of courses Print on console “{name} is
 * graduated with {average scores)”
 * 
 * @author Ivelin Gavrailov
 * @since 25.08.2020
 *
 */
public class AcademyGraduation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int studentsNumber = Integer.parseInt(scan.nextLine());
		TreeMap<String, Double> students = new TreeMap<>();
		for (int i = 0; i < studentsNumber; i++) {
			String name = scan.nextLine();
			double[] grades = Arrays.stream(scan.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
			students.putIfAbsent(name, 0.0);
			students.put(name, getAverageGrade(grades));
		}
		for (Map.Entry<String, Double> entry : students.entrySet()) {
			System.out.println(String.format("%s is graduated with %s", entry.getKey(),entry.getValue()));
		}
		scan.close();
	}
	private static double getAverageGrade(double[] grades) {
		double sum = 0;
		for (double grade : grades) {
			sum+=grade;
		}
		return sum/grades.length;
	}
}
