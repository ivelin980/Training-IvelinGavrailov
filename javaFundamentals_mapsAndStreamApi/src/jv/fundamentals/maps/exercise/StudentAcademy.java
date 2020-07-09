package jv.fundamentals.maps.exercise;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Write a program, which keeps information about students and their grades. You
 * will receive n pair of rows. First you will receive the student's name, after
 * that you will receive his grade. Check if student already exists, and if not,
 * add him. Keep track of all grades for each student. When you finish reading
 * data, keep students with average grade higher or equal to 4.50. Order
 * filtered students by average grade in descending. Print the students and
 * their average grade in format: "{name} –> {averageGrade}" Format the average
 * grade to the 2nd decimal place.
 * 
 * @author Ivelin Gavrailov
 * @since 08.07.2020
 *
 */
public class StudentAcademy {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		LinkedHashMap<String, ArrayList<Double>> students = new LinkedHashMap<>();
		for (int i = 0; i < n; i++) {
			String name = scan.nextLine();
			double grade = Double.parseDouble(scan.nextLine());
			students.putIfAbsent(name, new ArrayList<>());
			students.get(name).add(grade);
		}
		students.entrySet().stream().filter(s -> averageGrade(s.getValue()) >= 4.5)
				.sorted((s1, s2) -> Double.compare(averageGrade(s2.getValue()), averageGrade(s1.getValue())))
				.forEach(s -> System.out.println(String.format("%s -> %.2f", s.getKey(), averageGrade(s.getValue()))));
		scan.close();
	}

	private static double averageGrade(ArrayList<Double> grades) {
		double sumOfGrades = 0.0;
		int counter = 0;
		for (Double grade : grades) {
			sumOfGrades += grade;
			counter++;
		}
		if (counter != 0) {
			return sumOfGrades / counter;
		}
		return 0;
	}
}
