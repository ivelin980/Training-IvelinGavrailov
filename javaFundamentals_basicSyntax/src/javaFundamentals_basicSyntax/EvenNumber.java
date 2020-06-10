package javaFundamentals_basicSyntax;

import java.util.Scanner;

public class EvenNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = Integer.parseInt(scan.nextLine());
		while (input % 2 != 0) {
			System.out.println("Please write an even number.");
			input = Integer.parseInt(scan.nextLine());
		}
		if (input % 2 == 0) {
			input = Math.abs(input);
			System.out.println(String.format("The number is: %d", input));
		}
		scan.close();
	}
}
