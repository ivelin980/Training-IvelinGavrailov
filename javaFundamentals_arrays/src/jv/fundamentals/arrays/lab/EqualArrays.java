package jv.fundamentals.arrays.lab;

import java.util.Scanner;

/**
 * Read two arrays and print on the console whether they are identical or not.
 * Arrays are identical if their elements are equal. If the arrays are identical
 * find the sum of the first one and print on the console following message:
 * "Arrays are identical. Sum: {sum}", otherwise find the first index where the
 * arrays differ and print on the console following message: "Arrays are not
 * identical. Found difference at {index} index."
 * 
 * @author Ivelin Gavrailov
 * @since 15.06.2020
 *
 */
public class EqualArrays {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] firstArrayString = scan.nextLine().split(" ");
		String[] secondArrayString = scan.nextLine().split(" ");
		int[] firstArray = new int[firstArrayString.length];
		int[] secondArray = new int[secondArrayString.length];
		boolean isIdentical = true;
		int diffIndex = 0;
		int sum = 0;
		for (int i = 0; i < firstArrayString.length; i++) {
			firstArray[i] = Integer.parseInt(firstArrayString[i]);
		}
		for (int i = 0; i < secondArrayString.length; i++) {
			secondArray[i] = Integer.parseInt(secondArrayString[i]);
		}
		for (int i = 0; i < firstArray.length; i++) {
			sum += firstArray[i];
			if (firstArray[i] != secondArray[i]) {
				isIdentical = false;
				diffIndex = i;
				break;
			}
		}
		if (isIdentical) {
			System.out.println(String.format("Arrays are identical. Sum: %d", sum));
		} else {
			System.out.println(String.format("Arrays are not identical. Found difference at %d index.", diffIndex));
		}
		scan.close();
	}
}
