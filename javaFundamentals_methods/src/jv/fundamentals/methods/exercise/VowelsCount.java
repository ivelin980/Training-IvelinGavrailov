package jv.fundamentals.methods.exercise;

import java.util.Scanner;

/**
 * Write a method that receives a single string and prints the count of the
 * vowels. Use appropriate name for the method.
 * 
 * @author Ivelin Gavrailov
 * @since 17.06.2020
 *
 */
public class VowelsCount {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		printVowelsCount(input);
		scan.close();
	}

	private static void printVowelsCount(String input) {
		int vowelsCount = 0;
		for (int i = 0; i < input.length(); i++) {
			switch (input.toLowerCase().charAt(i)) {
			case 'a':
			case 'e':
			case 'o':
			case 'i':
			case 'u':
				vowelsCount++;
				break;
			}
		}
		System.out.println(vowelsCount);
	}
}
