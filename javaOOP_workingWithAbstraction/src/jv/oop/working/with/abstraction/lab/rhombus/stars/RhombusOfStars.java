package jv.oop.working.with.abstraction.lab.rhombus.stars;

import java.util.Scanner;

/**
 * Create a program that reads a positive integer n as input and prints on the
 * console a rhombus with size n:
 * 
 * @author Ivelin Gavrailov
 * @since 04.01.2021
 *
 */
public class RhombusOfStars {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		printRhombus(n);
		scan.close();
	}

	private static void printRhombus(int rows) {
		printTop(rows);
		printBottom(rows);
	}

	private static void printTop(int rows) {
		for (int row = 1; row <= rows; row++) {
			printString(rows - row, " ");
			printString(row, "* ");
			System.out.println();
		}
	}

	private static void printBottom(int rows) {
		for (int row = 1; row < rows; row++) {
			printString(row, " ");
			printString(rows - row, "* ");
			System.out.println();
		}
	}

	private static void printString(int rows, String str) {
		for (int i = 0; i < rows; i++) {
			System.out.print(str);
		}
	}
}
