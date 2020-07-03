package jv.fundamentals.methods.lab;

import java.util.Scanner;

/**
 * Write a method that receives a grade between 2.00 and 6.00 and prints the
 * corresponding grade in words:
 * 
 * @author Ivelin Gavrailov
 * @since 17.06.2020
 *
 */
public class Grades {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double grade = Double.parseDouble(scan.nextLine());
		printGradeInWords(grade);
		scan.close();
	}

	private static void printGradeInWords(double grade) {
		if (grade >= 2 && grade <= 2.99) {
			System.out.println("Fail");
		} else if (grade >= 3 && grade <= 3.49) {
			System.out.println("Poor");
		} else if (grade >= 3.50 && grade <= 4.49) {
			System.out.println("Good");
		} else if (grade >= 4.5 && grade <= 5.49) {
			System.out.println("Very good");
		} else if (grade >= 5.50 && grade <= 6.00) {
			System.out.println("Excellent");
		}
	}

}
