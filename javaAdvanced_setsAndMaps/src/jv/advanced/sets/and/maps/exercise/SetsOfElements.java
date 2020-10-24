package jv.advanced.sets.and.maps.exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * On the first line you are given the length of two sets n and m. On the next n
 * + m lines there are n numbers that are in the first set and m numbers that
 * are in the second one. Find all non-repeating element that appears in both of
 * them, and print them in same order at the console: Set with length n = 4: {1,
 * 3, 5, 7} Set with length m = 3: {3, 4, 5} Set that contains all repeating
 * elements -> {3, 5}
 * 
 * @author Ivelin Gavrailov
 * @since 25.08.2020
 *
 */
public class SetsOfElements {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String size = scan.nextLine();
		String[] tokens = size.split("\\s+");
		LinkedHashSet<String> firstSet = new LinkedHashSet<>();
		LinkedHashSet<String> secondSet = new LinkedHashSet<>();
		int n = Integer.parseInt(tokens[0]);
		int m = Integer.parseInt(tokens[1]);
		String digit = "";
		for (int i = 0; i < n; i++) {
			digit = scan.nextLine();
			firstSet.add(digit);
		}
		for (int i = 0; i < m; i++) {
			digit = scan.nextLine();
			secondSet.add(digit);
		}
		firstSet.retainAll(secondSet);
		for (String element : firstSet) {
			System.out.print(element + " ");
		}
		scan.close();
	}
}
