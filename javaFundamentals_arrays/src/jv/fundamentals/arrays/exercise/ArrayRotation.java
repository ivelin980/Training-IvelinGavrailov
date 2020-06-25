package jv.fundamentals.arrays.exercise;

import java.util.Scanner;

/**
 * Write a program that receives an array and number of rotations you have to
 * perform (first element goes at the end) Print the resulting array.
 * 
 * @author Ivelin Gavrailov
 * @since 16.06.2020
 *
 */
public class ArrayRotation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		int rotate = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < rotate; i++) {
			String temp = input[0];
			for (int j = 0; j < input.length - 1; j++) {
				input[j] = input[j + 1];
			}
			input[input.length - 1] = temp;
		}
		System.out.println(String.join(" ", input));
		scan.close();
	}
}
