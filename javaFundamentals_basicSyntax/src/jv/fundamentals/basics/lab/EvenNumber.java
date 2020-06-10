package jv.fundamentals.basics.lab;

import java.util.Scanner;

public class EvenNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = Integer.parseInt(scan.nextLine());
		while (input % 2 != 0) {
			System.out.println("Please write an even number.");
			input = Integer.parseInt(scan.nextLine());
		}
		input = Math.abs(input);
		System.out.println(String.format("The number is: %d", input));
		scan.close();
	}
}
