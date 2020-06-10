package jv.fundamentals.basics.exercise;

import java.util.Scanner;

public class StrongNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		int number = 0;
		int sumOfFactorials = 0;
		for (int i = input.length() - 1; i >= 0; i--) {
			number = Integer.parseInt("" + input.charAt(i));
			int factorialOfNumber = 1;
			for (int j = number; j >= 1; j--) {
				factorialOfNumber *= j;
			}
			sumOfFactorials += factorialOfNumber;
		}
		if (sumOfFactorials == Integer.parseInt(input)) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
		scan.close();
	}

}
