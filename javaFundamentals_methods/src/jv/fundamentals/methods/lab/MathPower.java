package jv.fundamentals.methods.lab;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Create a method that calculates and returns the value of a number raised to a
 * given power.
 * 
 * @author Ivelin Gavrailov
 * @since 17.06.2020
 *
 */
public class MathPower {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double number = Double.parseDouble(scan.nextLine());
		int power = Integer.parseInt(scan.nextLine());
		System.out.println(new DecimalFormat("0.####").format(mathPower(number, power)));
		scan.close();
	}

	private static double mathPower(double number, int power) {
		double result = Math.pow(number, power);
		return result;
	}
}
