package jv.fundamentals.variables.exercise;

import java.util.Scanner;

/**
 * You have a water tank with capacity of 255 liters. On the next n lines, you
 * will receive liters of water, which you have to pour in your tank. If the
 * capacity is not enough, print “Insufficient capacity!” and continue reading
 * the next line. On the last line, print the liters in the tank. Input The
 * input will be on two lines: • On the first line, you will receive n – the
 * number of lines, which will follow • On the next n lines – you receive
 * quantities of water, which you have to pour in the tank Output Every time you
 * do not have enough capacity in the tank to pour the given liters, print:
 * Insufficient capacity! On the last line, print only the liters in the tank.
 * Constraints • n will be in the interval [1…20] • liters will be in the
 * interval [1…1000]
 * 
 * @author Ivelin Gavrailov
 * @since 11.06.2020
 *
 */
public class WaterOverflow {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		int capacity = 255;
		int tank = 0;
		for (int i = 0; i < n; i++) {
			int quantity = Integer.parseInt(scan.nextLine());
			capacity -= quantity;
			if (capacity < 0) {
				System.out.println("Insufficient capacity!");
				capacity += quantity;
			} else {
				tank += quantity;
			}
		}
		System.out.println(tank);
		scan.close();
	}
}
