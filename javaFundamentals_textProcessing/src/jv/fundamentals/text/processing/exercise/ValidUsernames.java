package jv.fundamentals.text.processing.exercise;

import java.util.Scanner;

/**
 * Write a program that reads user names on a single line (joined by ", ") and
 * prints all valid usernames. A valid username is: • Has length between 3 and
 * 16 characters • Contains only letters, numbers, hyphens and underscores • Has
 * no redundant symbols before, after or in between.
 * 
 * @author Ivelin Gavrailov
 * @since 13.07.2020
 *
 */
public class ValidUsernames {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(", ");
		for (String word : input) {
			if (isRightSize(word) && hasAllowedChars(word)) {
				System.out.println(word);
			}
		}
		scan.close();
	}

	private static boolean isRightSize(String word) {
		return word.length() > 2 && word.length() < 17;
	}

	private static boolean hasAllowedChars(String word) {
		for (int i = 0; i < word.length(); i++) {
			if (!Character.isLetterOrDigit(word.charAt(i)) && word.charAt(i) != '_' && word.charAt(i) != '-') {
				return false;
			}
		}
		return true;
	}
}
