package jv.fundamentals.variables.exercise;

import java.util.Scanner;

/**
 * You will be given a single integer. Your task is to find the sum of its
 * digits.
 * 
 * @author Ivelin Gavrailov
 * @since 11.06.2020
 *
 */
public class SumDigits {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num = num / 10;
		}
		System.out.println(sum);
		scan.close();
	}
}
