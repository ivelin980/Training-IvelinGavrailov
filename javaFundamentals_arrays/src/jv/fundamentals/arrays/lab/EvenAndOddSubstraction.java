package jv.fundamentals.arrays.lab;

import java.util.Scanner;

/**
 * Write a program that calculates the difference between the sum of the even
 * and the sum of the odd numbers in an array.
 * 
 * @author Ivelin Gavrailov
 * @since 15.06.2020
 *
 */
public class EvenAndOddSubstraction {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sumEven = 0;
		int sumOdd = 0;
		String[] stringNumbers = scan.nextLine().split(" ");
		int[] numbers = new int[stringNumbers.length];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(stringNumbers[i]);
			if (numbers[i] % 2 == 0) {
				sumEven += numbers[i];
			} else {
				sumOdd += numbers[i];
			}
		}
		System.out.println(sumEven - sumOdd);
		scan.close();
	}
}
