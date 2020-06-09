package javaFundamentals_basicSyntax;

import java.util.Scanner;

public class SumOfOddNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int input = Integer.parseInt(scan.nextLine());
		int sum = 0;
		int counter = 0;
		int number = 1;
		while (counter < input) {
			if (number % 2 != 0) {
				sum += number;
				counter++;
				System.out.println(number);
			}
			number++;
		}
		System.out.println("Sum: " + sum);
	}

}
