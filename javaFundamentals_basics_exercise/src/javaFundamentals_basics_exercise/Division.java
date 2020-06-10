package javaFundamentals_basics_exercise;

import java.util.Scanner;

public class Division {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = Integer.parseInt(scan.nextLine());
		int div = 0;
		if (input % 10 == 0) {
			div = 10;
		} else if (input % 7 == 0) {
			div = 7;
		} else if (input % 6 == 0) {
			div = 6;
		} else if (input % 3 == 0) {
			div = 3;
		} else if (input % 2 == 0) {
			div = 2;
		}
		if (div != 0) {
			System.out.println(String.format("The number is divisible by %d", div));
		} else {
			System.out.println("Not divisible");
		}
		scan.close();
	}

}
