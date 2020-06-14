package jv.fundamentals.variables.exercise;

import java.util.Scanner;

/**
 * Write a program, which calculates the volume of n beer kegs. You will receive
 * in total 3 * n lines. Each three lines will hold information for a single
 * keg. First up is the model of the keg, after that is the radius of the keg,
 * and lastly is the height of the keg. Calculate the volume using the following
 * formula: π * r^2 * h. At the end, print the model of the biggest keg. Input
 * You will receive 3 * n lines. Each group of lines will be on a new line: •
 * First – model – string. • Second –radius – floating-point number • Third –
 * height – integer number Output Print the model of the biggest keg.
 * Constraints • n will be in the interval [1…10] • The radius will be a
 * floating-point number in the interval [1…3.402823E+38] • The height will be
 * an integer in the interval [1…2147483647]
 * 
 * @author Ivelin Gavrailov
 * @since 14.06.2020
 *
 */
public class BeerKegs {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		String bestKegModel = "";
		double bestKegVolume = -1.0;
		for (int i = 0; i < n; i++) {
			String model = scan.nextLine();
			double radius = Double.parseDouble(scan.nextLine());
			int height = Integer.parseInt(scan.nextLine());
			double volume = Math.PI * Math.pow(radius, 2) * height;
			if (volume > bestKegVolume) {
				bestKegModel = model;
				bestKegVolume = volume;
			}
		}
		System.out.println(bestKegModel);
		scan.close();
	}
}
