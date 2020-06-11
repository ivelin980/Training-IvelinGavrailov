package jv.fundamentals.variables.lab;

import java.util.Scanner;

/**
 * Write a program that reads 3 lines of input. On each line you get a single
 * character. Combine all the characters into one string and print it on the
 * console.
 * 
 * @author Ivelin Gavrailov
 * @since 11.06.2020
 *
 */
public class CharsToString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String output = "";
		for (int i = 1; i <= 3; i++) {
			String input = scan.nextLine();
			output += input;
		}
		System.out.println(output);
		scan.close();
	}
}
