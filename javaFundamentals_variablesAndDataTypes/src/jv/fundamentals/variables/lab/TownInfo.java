package jv.fundamentals.variables.lab;

import java.util.Scanner;

/**
 * You will be given 3 lines of input. On the first line you will be given the
 * name of the town, on the second – the population and on the third the area.
 * Use the correct data types and print the result in the following format:
 * "Town {town name} has population of {population} and area {area} square km".
 * 
 * @author Ivelin Gavrailov
 * @since 11.06.2020
 *
 */
public class TownInfo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String town = scan.nextLine();
		long population = Long.parseLong(scan.nextLine());
		int area = Integer.parseInt(scan.nextLine());
		System.out.println(String.format("Town %s has population of %d and area %d square km.", town, population, area));

		scan.close();
	}
}
