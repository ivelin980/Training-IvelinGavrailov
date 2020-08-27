package jv.advanced.sets.and.maps.exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Write a program that reads some text from the console and counts the
 * occurrences of each character in it. Print the results in alphabetical
 * (lexicographical) order.
 * 
 * @author Ivelin Gavrailov
 * @since 25.08.2020
 *
 */
public class CountSymbols {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		TreeMap<Character, Integer> characters = new TreeMap<>();
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			characters.putIfAbsent(ch, 0);
			characters.put(ch, characters.get(ch) + 1);
		}
		for (Map.Entry<Character, Integer> entry : characters.entrySet()) {
			System.out.println(String.format("%c: %d time/s", entry.getKey(), entry.getValue()));
		}
		scan.close();
	}
}
