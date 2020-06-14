package jv.fundamentals.variables.exercise;

import java.util.Scanner;

/**
 * Find online more information about ASCII (American Standard Code for
 * Information Interchange) and write a program that prints part of the ASCII
 * table of characters at the console. On the first line of input you will
 * receive the char index you should start with and on the second line - the
 * index of the last character you should print.
 * 
 * @author Ivelin Gavrailov
 * @since 11.06.2020
 *
 */
public class PrintPartOfTheASCIITable {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int firstIndex = Integer.parseInt(scan.nextLine());
		int lastIndex = Integer.parseInt(scan.nextLine());
		for (int i = firstIndex; i <= lastIndex; i++) {
			System.out.print(String.format("%c ", i));
		}
		scan.close();
	}

}
