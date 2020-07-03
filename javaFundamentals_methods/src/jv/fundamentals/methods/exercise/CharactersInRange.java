package jv.fundamentals.methods.exercise;

import java.util.Scanner;

/**
 * Write a method that receives two characters and prints on a single line all
 * the characters in between them according to ASCII.
 * 
 * @author Ivelin Gavrailov
 * @since 17.06.2020
 *
 */
public class CharactersInRange {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char firstInput = scan.nextLine().charAt(0);
		char secondInput = scan.nextLine().charAt(0);
		printCharactersInBetween(firstInput, secondInput);
		scan.close();
	}

	private static void printCharactersInBetween(char firstInput, char secondInput) {
		for (int i = Math.min(firstInput,secondInput) + 1; i < Math.max(firstInput, secondInput); i++) {
			System.out.print(String.format("%c ", i));
		}
	}
}
