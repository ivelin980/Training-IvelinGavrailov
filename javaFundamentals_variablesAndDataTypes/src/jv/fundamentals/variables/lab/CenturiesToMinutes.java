package jv.fundamentals.variables.lab;

import java.util.Scanner;

/**
 * Write program to enter an integer number of centuries and convert it to
 * years, days, hours and minutes.
 * 
 * @author Ivelin Gavrailov
 * @since 11.06.2020
 *
 */
public class CenturiesToMinutes {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int centuries = Integer.parseInt(scan.nextLine());
		int years = centuries * 100;
		double days = Math.floor(years * 365.2422);
		double hours = days * 24;
		double minutes = hours * 60;
		System.out.print(String.format("%d centuries = %d years = %.0f days = %.0f hours = %.0f minutes", centuries,
				years, days, hours, minutes));
		scan.close();
	}
}
