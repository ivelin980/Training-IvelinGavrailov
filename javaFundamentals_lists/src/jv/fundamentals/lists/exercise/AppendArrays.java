package jv.fundamentals.lists.exercise;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a program to append several array of numbers.  arrays are separated by
 * ‘|’. Values are separated by spaces (‘ ’, one or several) Order the arrays
 * from the last to the first, and their values from left to right.
 * 
 * @author Ivelin Gavrailov
 * @since 24.06.2020
 *
 */
public class AppendArrays {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split("\\|");
		ArrayList<String> result = new ArrayList<>();
		for (int i = input.length - 1; i >= 0; i--) {
			String[] arr = input[i].trim().split("\\s+");
			for (String element : arr) {
				result.add(element);
			}
			result.remove("");
		}
		System.out.println(String.join(" ", result));
		scan.close();
	}
}
