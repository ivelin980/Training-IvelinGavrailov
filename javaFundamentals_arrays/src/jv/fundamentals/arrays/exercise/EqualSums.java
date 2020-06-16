package jv.fundamentals.arrays.exercise;

import java.util.Scanner;

/**
 * Write a program that determines if there exists an element in the array such
 * that the sum of the elements on its left is equal to the sum of the elements
 * on its right. If there are no elements to the left / right, their sum is
 * considered to be 0. Print the index that satisfies the required condition or
 * “no” if there is no such index.
 * 
 * @author Ivelin Gavrailov
 * @since 16.06.2020
 *
 */
public class EqualSums {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		int[] numbers = new int[input.length];
		int index = 0;
		boolean isEqual = false;
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(input[i]);
		}
		for (int i = 0; i < numbers.length; i++) {
			int leftSum = 0;
			int rightSum = 0;
			for (int j = i; j < numbers.length; j++) {
				rightSum += numbers[j];
			}
			for (int j = i; j >= 0; j--) {
				leftSum += numbers[j];
			}
			if (leftSum == rightSum) {
				isEqual = true;
				index = i;
				break;
			}
		}
		if (isEqual) {
			System.out.println(index);
		} else {
			System.out.println("no");
		}
		scan.close();
	}
}
