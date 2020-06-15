package jv.fundamentals.arrays.lab;

import java.util.Scanner;

/**
 * Write a program to read an array of integers and condense them by summing
 * adjacent couples of elements until a single integer is obtained. For example,
 * if we have 3 elements {2, 10, 3}, we sum the first two and the second two
 * elements and obtain {2+10, 10+3} = {12, 13}, then we sum again all adjacent
 * elements and obtain {12+13} = {25}.
 * 
 * @author Ivelin Gavrailov
 * @since 15.06.2020
 *
 */
public class CondenseArrayToNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] numbersAsString = scan.nextLine().split(" ");
		int[] numbers = new int[numbersAsString.length];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(numbersAsString[i]);
		}
		while (numbers.length > 1) {
			int[] condensed = new int[numbers.length - 1];
			for (int i = 0; i < condensed.length; i++) {
				condensed[i] = numbers[i] + numbers[i + 1];
			}
			numbers = condensed;
		}
		System.out.println(numbers[0]);
		scan.close();
	}
}
