package jv.fundamentals.arrays.exercise;

import java.util.Scanner;

/**
 * Write a program to find all the top integers in an array. A top integer is an
 * integer which is bigger than all the elements to its right.
 * 
 * @author Ivelin Gavrailov
 * @since 16.06.2020
 *
 */
public class TopIntegers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		int[] numbers = new int[input.length];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(input[i]);
		}
		for (int i = 0; i < numbers.length; i++) {
			boolean isTop = true;
			int currentNumber = numbers[i];
			for (int j = i + 1; j < numbers.length; j++) {
				if (currentNumber <= numbers[j]) {
					isTop = false;
					break;
				}
			}
			if (isTop) {
				System.out.print(currentNumber + " ");
			}
		}
		scan.close();
	}
}
