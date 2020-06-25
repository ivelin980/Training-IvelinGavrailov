package jv.fundamentals.methods.exercise;

import java.util.Scanner;

/**
 * You will receive a single string. Write a method that prints the middle
 * character. If the length of the string is even there are two middle
 * characters.
 * 
 * @author Ivelin Gavrailov
 * @since 18.06.2020
 *
 */
public class MiddleCharacters {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		printMiddleCharacter(input);
		scan.close();
	}

	private static void printMiddleCharacter(String input) {
		int length = input.length();
		System.out.print(input.charAt((length - 1) / 2));
		if (length % 2 == 0) {
			System.out.print(input.charAt(length / 2));
		}
	}
}
