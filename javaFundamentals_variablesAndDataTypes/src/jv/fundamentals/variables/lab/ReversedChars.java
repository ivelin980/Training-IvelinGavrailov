package jv.fundamentals.variables.lab;

import java.util.Scanner;

/**
 * Write a program that takes 3 lines of characters and prints them in reversed
 * order with a space between them.
 * 
 * @author Ivelin Gavrailov
 * @since 11.06.2020
 *
 */
public class ReversedChars {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String allChars = "";
		for (int i = 1; i <= 3; i++) {
			char input = scan.nextLine().charAt(0);
			allChars += input;
		}
		for (int i = allChars.length() - 1; i >= 0; i--) {
			System.out.print(allChars.charAt(i) + " ");
		}
		scan.close();
	}
}
