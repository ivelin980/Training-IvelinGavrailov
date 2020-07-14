package jv.fundamentals.text.processing.exercise;

import java.util.Scanner;

/**
 * Write a program that returns an encrypted version of the same text. Encrypt
 * the text by shifting each character with three positions forward. For example
 * A would be replaced by D, B would become E, and so on. Print the encrypted
 * text.
 * 
 * @author Ivelin Gavrailov
 * @since 13.07.2020
 *
 */
public class CeaserCipher {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			output.append((char) (input.charAt(i) + 3));
		}
		System.out.println(output);
		scan.close();
	}
}
