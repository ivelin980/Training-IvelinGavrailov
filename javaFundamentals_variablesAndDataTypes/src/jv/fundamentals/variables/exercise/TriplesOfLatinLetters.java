package jv.fundamentals.variables.exercise;

import java.util.Scanner;

/**
 * Write a program to read an integer n and print all triples of the first n
 * small Latin letters, ordered alphabetically:
 * 
 * @author Ivelin Gavrailov
 * @since 11.06.2020
 *
 */
public class TriplesOfLatinLetters {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		for (char i = 'a'; i < 'a' + n; i++) {
			for (int j = 'a'; j < 'a' + n; j++) {
				for (int k = 'a'; k < 'a' + n; k++) {
					System.out.println(String.format("%c%c%c", i, j, k));
				}

			}
		}
		scan.close();
	}
}
