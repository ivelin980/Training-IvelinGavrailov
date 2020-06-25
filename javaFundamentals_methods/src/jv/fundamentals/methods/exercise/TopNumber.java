package jv.fundamentals.methods.exercise;

import java.util.Scanner;

/**
 * A top number is an integer that holds the following properties: • Its sum of
 * digits is divisible by 8, e.g. 8, 16, 88. • Holds at least one odd digit,
 * e.g. 232, 707, 87578. Write a program to print all master numbers in the
 * range [1…n].
 * 
 * @author Ivelin Gavrailov
 * @since 18.06.2020
 *
 */
public class TopNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		printTopNumbers(n);
		scan.close();
	}

	private static void printTopNumbers(int number) {
		for (int i = 1; i <= number; i++) {
			int temp = i;
			int sumOfDigits = 0;
			while (temp > 0) {
				sumOfDigits += temp % 10;
				temp /= 10;
			}
			if (sumOfDigits % 8 == 0 && isOddDigit(i)) {
				System.out.println(i);
			}
		}
	}

	private static boolean isOddDigit(int number) {
		boolean isOddDigit = false;
		while (number > 0) {
			int digit = number % 10;
			if (digit % 2 != 0) {
				isOddDigit = true;
			}
			number /= 10;
		}
		return isOddDigit;
	}
}
