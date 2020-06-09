package javaFundamentals_basics_exercise;

import java.util.Scanner;

public class PrintAndSum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int startNumber = Integer.parseInt(scan.nextLine());
		int endNumber = Integer.parseInt(scan.nextLine());
		int sum = 0;
		for (int i = startNumber; i <= endNumber; i++) {
			System.out.print(i + " ");
			sum += i;
		}
		System.out.print(String.format("%nSum: %d", sum));

	}

}
