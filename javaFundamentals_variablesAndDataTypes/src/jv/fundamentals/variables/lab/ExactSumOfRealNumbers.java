package jv.fundamentals.variables.lab;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Write program to enter n numbers and calculate and print their exact sum
 * (without rounding).
 * 
 * @author Ivelin Gavrailov
 * @since 10.06.2020
 *
 */
public class ExactSumOfRealNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		BigDecimal sum = new BigDecimal(0);
		for (int i = 0; i < n; i++) {
			BigDecimal input = new BigDecimal(scan.nextLine());
			sum = sum.add(input);
		}
		System.out.println(sum);
		scan.close();
	}

}
