package jv.fundamentals.arrays.lab;

import java.util.Scanner;

/**
 * Read n numbers and print them in reverse order.
 * 
 * @author Ivelin Gavrailov
 * @since 15.06.2020
 *
 */
public class PrintNumbersInReverseOrder {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		int[] numbers = new int[n];
		for (int i = 0; i < numbers.length; i++) {
			int number = Integer.parseInt(scan.nextLine());
			numbers[i] = number;
		}
		for (int i = numbers.length - 1; i >= 0; i--) {
			System.out.print(numbers[i] + " ");
		}
		scan.close();
	}
}
