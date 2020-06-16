package jv.fundamentals.arrays.exercise;

import java.util.Scanner;

/**
 * Write a program, which prints all unique pairs in an array of integers whose
 * sum is equal to a given number.
 * 
 * @author Ivelin Gavrailov
 * @since 16.06.2020
 *
 */
public class MagicSum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		int[] numbers = new int[input.length];
		int magicSum = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(input[i]);
		}
		for (int i = 0; i < numbers.length; i++) {
			int currentNumber = numbers[i];
			for (int j = i + 1; j < numbers.length; j++) {
				if (currentNumber + numbers[j] == magicSum) {
					System.out.println(currentNumber + " " + numbers[j]);
				}
			}
		}
		scan.close();
	}
}
