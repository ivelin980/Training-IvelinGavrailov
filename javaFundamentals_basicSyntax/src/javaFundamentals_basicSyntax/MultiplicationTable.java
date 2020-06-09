package javaFundamentals_basicSyntax;

import java.util.Scanner;

public class MultiplicationTable {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = Integer.parseInt(scan.nextLine());
		int mult = 0;
		for (int i = 1; i <= 10; i++) {
			mult = i * input;
			System.out.println(String.format("%d X %d = %d", input, i, mult));
		}
	}

}
