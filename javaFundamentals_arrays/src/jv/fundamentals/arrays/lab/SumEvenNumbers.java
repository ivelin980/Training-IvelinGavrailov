package jv.fundamentals.arrays.lab;

import java.util.Scanner;

/**
 * Read an array from the console and sum only the even numbers.
 * 
 * @author Ivelin Gavrailov
 * @since 15.06.2020
 *
 */
public class SumEvenNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] numbersAsString = scan.nextLine().split(" ");
		int[] numbers = new int[numbersAsString.length];
		int sum = 0;
		for (int i = 0; i < numbersAsString.length; i++) {
			numbers[i] = Integer.parseInt(numbersAsString[i]);
		}
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 2 == 0) {
				sum += numbers[i];
			}
		}
		System.out.println(sum);
		scan.close();
	}
}
