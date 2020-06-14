package jv.fundamentals.variables.exercise;

import java.util.Scanner;

/**
 * Calculate how many courses will be needed to elevate n persons by using an
 * elevator with capacity of p persons. The input holds two lines: the number of
 * people n and the capacity p of the elevator.
 * 
 * @author Ivelin Gavrailov
 * @since 11.06.2020
 *
 */
public class Elevator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int people = Integer.parseInt(scan.nextLine());
		int capacity = Integer.parseInt(scan.nextLine());
		double courses = Math.ceil(people * 1.0 / capacity);
		System.out.println(String.format("%.0f", courses));
		scan.close();
	}
}
