package jv.fundamentals.text.processing.exercise;

import java.util.Scanner;

/**
 * Write a program that reads a string from the console and replaces any
 * sequence of the same letters with a single corresponding letter.
 * 
 * @author Ivelin Gavrailov
 * @since 14.07.2020
 *
 */
public class ReplaceRepeatingChars {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		StringBuilder result = new StringBuilder();
		char baseLetter = input.charAt(0);
		result.append(baseLetter);
		for (int i = 1; i < input.length(); i++) {
			char currentLetter = input.charAt(i);
			if (baseLetter != currentLetter) {
				result.append(currentLetter);
				baseLetter = currentLetter;
			}
		}
		System.out.println(result);
		scan.close();
	}
}
