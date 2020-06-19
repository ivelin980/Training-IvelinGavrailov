package jv.fundamentals.arrays.lab;

import java.util.Scanner;

/**
 * Enter a day number [1…7] and print the day name (in English) or "Invalid
 * day!". Use an array of strings.
 * 
 * @author Ivelin Gavrailov
 * @since 15.06.2020
 *
 */
public class DayOfWeek {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] dayNames = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
		int input = Integer.parseInt(scan.nextLine());
		if (input >= 1 && input <= 7) {
			System.out.println(dayNames[input - 1]);
		} else {
			System.out.println("Invalid day!");
		}
		scan.close();
	}
}
