package jv.fundamentals.methods.lab;

import java.util.Scanner;

/**
 * Create a method that prints the sign of an integer number.
 * 
 * @author Ivelin Gavrailov
 * @since 17.06.2020
 *
 */
public class SignOfInteger {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = Integer.parseInt(scan.nextLine());
		signOfInteger(number);
		scan.close();
	}

	private static void signOfInteger(int number) {
		if (number > 0) {
			System.out.print(String.format("The number %d is positive.", number));
		} else if (number < 0) {
			System.out.print(String.format("The number %d is negative.", number));
		} else {
			System.out.print(String.format("The number %d is zero.", number));
		}
	}
}
