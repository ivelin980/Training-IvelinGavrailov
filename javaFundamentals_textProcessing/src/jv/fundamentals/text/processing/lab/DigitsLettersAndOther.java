package jv.fundamentals.text.processing.lab;

import java.util.Scanner;

/**
 * Write a program that receives a single string and on the first line prints
 * all the digits, on the second – all the letters, and on the third – all the
 * other characters. There will always be at least one digit, one letter and one
 * other characters.
 * 
 * @author Ivelin Gavrailov
 * @since 13.07.2020
 *
 */
public class DigitsLettersAndOther {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		StringBuilder digits = new StringBuilder();
		StringBuilder letters = new StringBuilder();
		StringBuilder others = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char element = input.charAt(i);
			if (Character.isLetter(element)) {
				letters.append(element);
			} else if (Character.isDigit(element)) {
				digits.append(element);
			} else {
				others.append(element);
			}
		}
		System.out.print(String.format("%s%n%s%n%s", digits, letters, others));
		scan.close();
	}
}
