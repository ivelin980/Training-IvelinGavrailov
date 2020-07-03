package jv.fundamentals.methods.exercise;

import java.util.Scanner;

/**
 * A palindrome is a number which reads the same backward as forward, such as
 * 323 or 1001. Write a program which reads a positive integer numbers until you
 * receive "End", for each number print whether the number is palindrome or not.
 * 
 * @author Ivelin Gavrailov
 * @since 18.06.2020
 */
public class PalindromeIntegers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		while (!"end".equalsIgnoreCase(input)) {
			if (isNumber(input)) {
				System.out.println(isPalindrome(input));
			}
			input = scan.nextLine();
		}
		scan.close();
	}

	private static boolean isPalindrome(String number) {
		String reverseString = "";
		for (int i = number.length() - 1; i >= 0; i--) {
			reverseString += number.charAt(i);
		}
		return reverseString.equals(number);
	}

	private static boolean isNumber(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
