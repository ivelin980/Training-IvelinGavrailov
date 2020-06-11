package jv.fundamentals.variables.lab;

import java.util.Scanner;

/**
 * You are given a working code that is a solution to Problem 9. Special
 * Numbers. However, the variables are improperly named, declared before they
 * are needed and some of them are used for multiple things. Without using your
 * previous solution, modify the code so that it is easy to read and understand.
 * 
 * @author Ivelin Gavrailov
 * @since 11.06.2020
 *
 */
public class RefactorSpecialNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		for (int i = 1; i <= n; i++) {
			int num = i;
			int sum = 0;
			while (num > 0) {
				sum += num % 10;
				num = num / 10;
			}
			if ((sum == 5) || (sum == 7) || (sum == 11)) {
				System.out.printf("%d -> True%n", i);
			} else {
				System.out.printf("%d -> False%n", i);
			}
		}
		scanner.close();
	}
}