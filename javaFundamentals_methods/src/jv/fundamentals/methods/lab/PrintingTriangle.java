package jv.fundamentals.methods.lab;

import java.util.Scanner;

/**
 * Create a method for printing triangles as shown below:
 * 
 * @author Ivelin Gavrailov
 * @since 17.06.2020
 *
 */
public class PrintingTriangle {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = Integer.parseInt(scan.nextLine());
		printTriangle(input);
		scan.close();
	}

	private static void printTriangle(int number) {
		for (int i = 1; i < number; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}

			System.out.println();
		}
		for (int i = number; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}

			System.out.println();
		}
	}

}
