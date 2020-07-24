package jv.fundamentals.text.processing.lab;

import java.util.Scanner;

/**
 * Write a program that reads an array of strings. Each string is repeated n
 * times, where n is the length of the string. Print the concatenated string.
 * 
 * @author Ivelin Gavrailov
 * @since 12.07.2020
 *
 */
public class RepeatStrings {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split("\\s+");
		StringBuilder result = new StringBuilder();
		for (String word : input) {
			for (int i = 0; i < word.length(); i++) {
				result.append(word);
			}
		}
		System.out.println(String.join("", result));
		scan.close();
	}
}
