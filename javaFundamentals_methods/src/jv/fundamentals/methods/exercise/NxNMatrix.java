package jv.fundamentals.methods.exercise;

import java.util.Scanner;

/**
 * Write a method that receives a single integer n and prints nxn matrix with
 * that number.
 * 
 * @author Ivelin Gavrailov
 * @since 18.06.2020
 *
 */
public class NxNMatrix {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = Integer.parseInt(scan.nextLine());
		nXnMatrix(input);
		scan.close();
	}
	private static void nXnMatrix(int input) {
		for (int i = 0; i < input; i++) {
			for (int j = 0; j < input; j++) {
				System.out.print(input+" ");
			}
			System.out.println();
		}
	}
}
