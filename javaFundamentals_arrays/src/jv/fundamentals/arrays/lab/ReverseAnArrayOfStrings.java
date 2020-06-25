package jv.fundamentals.arrays.lab;

import java.util.Scanner;

/**
 * Write a program to read an array of strings, reverse it and print its
 * elements. The input consists of a sequence of space separated strings. Print
 * the output on a single line (space separated).
 * 
 * @author Ivelin Gavrailov
 * @since 15.06.2020
 *
 */
public class ReverseAnArrayOfStrings {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] stringArr = scan.nextLine().split(" ");
		for (int i = 0; i < (stringArr.length) / 2; i++) {
			String temp = stringArr[i];
			stringArr[i] = stringArr[stringArr.length - 1 - i];
			stringArr[stringArr.length - 1 - i] = temp;
		}
		System.out.println(String.join(" ", stringArr));
		scan.close();
	}
}
