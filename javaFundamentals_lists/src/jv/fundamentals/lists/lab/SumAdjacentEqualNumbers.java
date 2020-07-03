package jv.fundamentals.lists.lab;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a program to sum all adjacent equal numbers in a list of decimal
 * numbers, starting from left to right.  After two numbers are summed, the
 * obtained result could be equal to some of its neighbors and should be summed
 * as well (see the examples below).  Always sum the leftmost two equal
 * neighbors (if several couples of equal neighbors are available).
 * 
 * @author Ivelin Gavrailov
 * @since 21.06.2020
 *
 */
public class SumAdjacentEqualNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] stringArr = scan.nextLine().split(" ");
		ArrayList<Double> numbers = new ArrayList<>();
		for (String element : stringArr) {
			numbers.add(Double.parseDouble(element));
		}
		for (int i = 0; i < numbers.size() - 1; i++) {
			if (numbers.get(i).equals(numbers.get(i + 1))) {
				numbers.set(i, numbers.get(i) + numbers.get(i + 1));
				numbers.remove(i + 1);
				i = -1;
			}
		}
		System.out.println(joinElementsByDelimeter(numbers, " "));
		scan.close();
	}

	private static String joinElementsByDelimeter(ArrayList<Double> numbers, String delimeter) {
		String output = "";
		for (Double number : numbers) {
			output += (new DecimalFormat("0.#").format(number) + delimeter);
		}
		return output;
	}
}
