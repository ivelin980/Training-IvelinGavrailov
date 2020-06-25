package jv.fundamentals.methods.lab;

import java.util.Scanner;

/**
 * Create a program that reads an integer number and multiplies the sum of all
 * its even digits by the sum of all its odd digits:
 * 
 * @author Ivelin Gavrailov
 * @since 17.07.2020
 *
 */
public class MultiplyEvensByOdds {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = Integer.parseInt(scan.nextLine());
		System.out.println(multiplyEvensByOdds(input));
		scan.close();
	}

	private static int multiplyEvensByOdds(int number) {
		int evenSum = getSumOfEvens(number);
		int oddSum = getSumOfOdds(number);
		return evenSum * oddSum;
	}

	private static int getSumOfEvens(int number) {
		int sum = 0;
		while (Math.abs(number) > 0) {
			int digit = number % 10;
			if (digit % 2 == 0) {
				sum += digit;
			}
			number /= 10;
		}
		return sum;
	}

	private static int getSumOfOdds(int number) {
		int sum = 0;
		while (Math.abs(number) > 0) {
			int digit = number % 10;
			if (digit % 2 != 0) {
				sum += digit;
			}
			number /= 10;
		}
		return sum;
	}
}
