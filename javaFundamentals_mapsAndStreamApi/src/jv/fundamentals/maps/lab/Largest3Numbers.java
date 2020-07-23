package jv.fundamentals.maps.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Read a list of integers and print largest 3 of them. If there are less than
 * 3, print all of them.
 * 
 * @author Ivelin Gavrailov
 * @since 06.07.2020
 *
 */
public class Largest3Numbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Integer> sorted = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt)
				.sorted((n1, n2) -> n2.compareTo(n1)).collect(Collectors.toList());
		for (int i = 0; i < 3; i++) {
			if (i < sorted.size()) {
				System.out.print(sorted.get(i) + " ");
			}
		}
		scan.close();
	}

}
