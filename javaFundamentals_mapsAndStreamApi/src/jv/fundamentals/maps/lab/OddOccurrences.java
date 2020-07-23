package jv.fundamentals.maps.lab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Write a program that extracts from a given sequence of words all elements
 * that present in it odd number of times (case-insensitive). • Words are given
 * in a single line, space separated. • Print the result elements in lowercase,
 * in their order of appearance.
 * 
 * @author Ivelin Gavrailov
 * @since 06.07.2020
 *
 */
public class OddOccurrences {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split("\\s+");
		LinkedHashMap<String, Integer> counts = new LinkedHashMap<>();
		for (String word : input) {
			String wordInLowerCase = word.toLowerCase();
			counts.putIfAbsent(wordInLowerCase, 0);
			counts.put(wordInLowerCase, counts.get(wordInLowerCase) + 1);
		}
		ArrayList<String> odds = new ArrayList<>();

		for (Map.Entry<String, Integer> entry : counts.entrySet()) {
			if (entry.getValue() % 2 == 1) {
				odds.add(entry.getKey());
			}
		}
		System.out.println(String.join(", ", odds));
		scan.close();
	}
}
