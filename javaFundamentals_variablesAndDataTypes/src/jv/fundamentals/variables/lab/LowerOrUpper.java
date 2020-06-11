package jv.fundamentals.variables.lab;

import java.util.Scanner;

/**
 * Write a program that prints whether a given character is upper-case or lower
 * case.
 * 
 * @author Ivelin Gavrailov
 * @since 11.06.2020
 *
 */
public class LowerOrUpper {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char input = scan.nextLine().charAt(0);
		if (input >= 65 && input <= 90) {
			System.out.println("upper-case");
		} else if (input >= 97 && input <= 122) {
			System.out.println("lower-case");
		}

		scan.close();
	}
}
