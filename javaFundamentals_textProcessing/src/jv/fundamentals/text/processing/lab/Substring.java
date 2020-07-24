package jv.fundamentals.text.processing.lab;

import java.util.Scanner;

/**
 * On the first line you will receive a string. On the second line you will
 * receive a second string. Write a program that removes all of the occurrences
 * of the first string in the second until there is no match. At the end print
 * the remaining string.
 * 
 * @author Ivelin Gavrailov
 * @since 12.07.2020
 *
 */
public class Substring {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String key = scan.nextLine();
		String input = scan.nextLine();
		while (input.contains(key)) {
			input = input.replace(key, "");
		}
		System.out.println(input);
		scan.close();
	}
}
