package jv.fundamentals.text.processing.exercise;

import java.util.Scanner;

/**
 * You are given two lines – the first one can be a really big number (0 to
 * 1050). The second one will be a single digit number (0 to 9). You must
 * display the product of these numbers. Note: do not use the BigInteger class.
 * 
 * @author Ivelin Gavrailov
 * @since 14.07.2020
 *
 */
public class MultiplyBigNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String number = scan.nextLine();
		while (number.charAt(0) == '0') {
			number = number.substring(1);
			if (number.length() == 1) {
				break;
			}
		}
		int multiplier = Integer.parseInt(scan.nextLine());
		if (multiplier == 0) {
			System.out.println(0);
			scan.close();
			return;
		}
		StringBuilder result = new StringBuilder();
		int reminder = 0;
		for (int i = number.length() - 1; i >= 0; i--) {
			int digit = Integer.parseInt(String.valueOf(number.charAt(i)));
			int product = digit * multiplier + reminder;
			result.append(product % 10);
			reminder = product / 10;
		}
		if (reminder > 0) {
			result.append(reminder);
		}
		System.out.println(result.reverse());
		scan.close();
	}
}
