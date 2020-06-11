package jv.fundamentals.variables.lab;

import java.util.Scanner;

/**
 * Write a program that converts British pounds to US dollars formatted to 3th
 * decimal point. 1 British Pound = 1.31 Dollars
 * 
 * @author Ivelin Gavrailov
 * @since 10.06.2020
 *
 */
public class PoundsToDollars {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double pounds = Double.parseDouble(scan.nextLine());
		double dollars = 1.31 * pounds;
		System.out.println(String.format("%.3f", dollars));
		scan.close();
	}
}
