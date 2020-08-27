package jv.advanced.sets.and.maps.exercise;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Ivelin Gavrailov
 * @since 25.08.2020
 *
 */
public class PeriodicTable {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		TreeSet<String> chemicalElements = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			String input = scan.nextLine();
			String[] elements = input.split("\\s+");
			for (int j = 0; j < elements.length; j++) {
				chemicalElements.add(elements[j]);
			}
		}
		for (String element : chemicalElements) {
			System.out.print(element + " ");
		}
		scan.close();
	}
}
