package jv.fundamentals.variables.lab;

import java.util.Scanner;

/**
 * You will be given an integer that will be distance in meters. Write a program
 * that converts meters to kilometers formatted to the second decimal point.
 * 
 * @author Ivelin Gavrailov
 * @since 10.06.2020
 *
 */
public class ConvertMetersToKilometers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int meters = Integer.parseInt(scan.nextLine());
		double kilometers = 1.0 * meters / 1000;
		System.out.println(String.format("%.2f", kilometers));

		scan.close();
	}

}
