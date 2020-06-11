package jv.fundamentals.variables.lab;

import java.util.Scanner;

/**
 * A number is special when its sum of digits is 5, 7 or 11. Write a program to
 * read an integer n and for all numbers in the range 1…n to print the number
 * and if it is special or not (True / False).
 * 
 * @author Ivelin Gavrailov
 * @since 11.06.2020
 *
 */
public class SpecialNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			int num = i;
			while (num > 0) {
				sum += num % 10;
				num = num / 10;
			}
			if (sum == 5 || sum == 7 || sum == 11) {
				System.out.println(String.format("%d -> True", i));
			} else {
				System.out.println(String.format("%d -> False", i));
			}
		}
		scan.close();
	}
}
