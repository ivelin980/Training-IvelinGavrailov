package jv.fundamentals.maps.exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Write a program which counts all characters in a string except space (' ').
 * Print all occurrences in the following format: {char} -> {occurrences}
 * 
 * @author Ivelin Gavrailov
 * @since 07.07.2020
 *
 */
public class CountCharsInAString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		LinkedHashMap<Character, Integer> symbols = new LinkedHashMap<>();
		for (int i = 0; i < input.length(); i++) {
			char symbol = input.charAt(i);
			if (' ' == symbol) {
				continue;
			}
			symbols.putIfAbsent(symbol, 0);
			symbols.put(symbol, symbols.get(symbol) + 1);
		}
		symbols.entrySet().stream()
				.forEach(s -> System.out.print(String.format("%s -> %d%n", s.getKey(), s.getValue())));
		scan.close();
	}
}
