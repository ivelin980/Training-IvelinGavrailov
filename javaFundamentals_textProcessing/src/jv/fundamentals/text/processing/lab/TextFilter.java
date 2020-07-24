package jv.fundamentals.text.processing.lab;

import java.util.Scanner;

/**
 * Write a program that takes a text and a string of banned words. All words
 * included in the ban list should be replaced with asterisks "*", equal to the
 * word's length. The entries in the ban list will be separated by a comma and
 * space ", ". The ban list should be entered on the first input line and the
 * text on the second input line.
 * 
 * @author Ivelin Gavrailov
 * @since 13.07.2020
 *
 */
public class TextFilter {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] bannedWords = scan.nextLine().split(", ");
		String text = scan.nextLine();
		for (String word : bannedWords) {
			StringBuilder replacement = new StringBuilder();
			for (int i = 0; i < word.length(); i++) {
				replacement.append("*");
			}
			text = text.replace(word, replacement);
		}
		System.out.println(String.join(" ", text));
		scan.close();
	}
}
