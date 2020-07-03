package jv.fundamentals.methods.lab;

import java.util.Scanner;

/**
 * Write a method that receives a string and a repeat count n (integer). The
 * method should return a new string (the old one repeated n times).
 * 
 * @author Ivelin Gavrailov
 * @since 17.06.2020
 *
 */
public class RepeatString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		int n = Integer.parseInt(scan.nextLine());
		System.out.println(multiplyString(input, n));
		scan.close();
	}

	private static String multiplyString(String input, int timesToMultiply) {
		String result = "";
		for (int i = 0; i < timesToMultiply; i++) {
			result += input;
		}
		return result;
	}
}
