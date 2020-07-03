package jv.fundamentals.methods.lab;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Create a method that calculates and returns the area of a rectangle by given
 * width and length.
 * 
 * @author Ivelin Gavrailov
 * @since 17.06.2020
 *
 */
public class CalculateRectangleArea {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double width = Double.parseDouble(scan.nextLine());
		double length = Double.parseDouble(scan.nextLine());
		System.out.println(new DecimalFormat("0.##").format(getRectangleArea(width, length)));
		scan.close();
	}

	private static double getRectangleArea(double width, double length) {
		return width * length;
	}
}
