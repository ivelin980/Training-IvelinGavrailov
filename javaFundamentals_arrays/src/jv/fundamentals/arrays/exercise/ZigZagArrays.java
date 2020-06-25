package jv.fundamentals.arrays.exercise;

import java.util.Scanner;

/**
 * Write a program which creates 2 arrays. You will be given an integer n. On
 * the next n lines you get 2 integers. Form 2 arrays as shown below.
 * 
 * @author Ivelin Gavrailov
 * @since 16.06.2020
 *
 */
public class ZigZagArrays {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		String[] firstArr = new String[n];
		String[] secondArr = new String[n];
		for (int i = 0; i < n; i++) {
			String[] row = scan.nextLine().split(" ");
			if (i % 2 == 0) {
				firstArr[i] = row[0];
				secondArr[i] = row[1];
			} else {
				firstArr[i] = row[1];
				secondArr[i] = row[0];
			}
		}
		System.out.println(String.join(" ", firstArr));
		System.out.println(String.join(" ", secondArr));
		scan.close();
	}
}
