package jv.fundamentals.variables.exercise;

import java.util.Scanner;

/**
 * Write a program that calculates the total amount of spice that can be
 * extracted from a source. The source has a starting yield, which indicates how
 * much spice can be mined on the first day. After it has been mined for a day,
 * the yield drops by 10, meaning on the second day it’ll produce 10 less spice
 * than on the first, on the third day 10 less than on the second, and so on
 * (see examples). A source is considered profitable only while its yield is at
 * least 100 – when less than 100 spice is expected in a day, abandon the
 * source. The mining crew consumes 26 spice every day at the end of their shift
 * and an additional 26 after the mine has been exhausted. Note that the workers
 * cannot consume more spice than there is in storage. When the operation is
 * complete, print on the console on two separate lines how many days the mine
 * has operated and the total amount of spice extracted. Input You will receive
 * a number, representing the starting yield of the source. Output Print on the
 * console on two separate lines how many days the mine has operated and the
 * total amount of spice extracted. Constraints • The starting yield will be a
 * positive integer within range [0 … 2 147 483 647]
 * 
 * @author Ivelin Gavrailov
 * @since 14.06.2020
 *
 */
public class SpiceMustFlow {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int startingYield = Integer.parseInt(scan.nextLine());
		int days = 0;
		int total = 0;
		int leftForTheDay = 0;
		if (startingYield >= 100) {
			while (startingYield >= 100) {
				days++;
				leftForTheDay = startingYield - 26;
				startingYield -= 10;
				total += leftForTheDay;
			}
			total = total - 26;
		} else if (startingYield >= 26 && startingYield < 100) {
			days = 1;
			leftForTheDay = startingYield - 26;
			total += leftForTheDay;
		}
		if (startingYield >= 0) {
			System.out.println(days);
			System.out.println(total);
		}
		scan.close();
	}
}
