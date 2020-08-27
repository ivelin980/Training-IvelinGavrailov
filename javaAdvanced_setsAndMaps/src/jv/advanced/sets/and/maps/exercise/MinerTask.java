package jv.advanced.sets.and.maps.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * You are given a sequence of strings, each on a new line. Every odd line on
 * the console is representing a resource (e.g. Gold, Silver, Copper, and so on)
 * , and every even – quantity. Your task is to collect the resources and print
 * them each on a new line. Print the resources and their quantities in format:
 * {resource} –> {quantity} The quantities inputs will be in the range [1 … 2
 * 000 000 000]
 * 
 * @author Ivelin Gavrailov
 * @since 26.08.2020
 *
 */
public class MinerTask {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		LinkedHashMap<String, Integer> mine = new LinkedHashMap<>();
		while (!"stop".equalsIgnoreCase(input)) {
			String resource = input;
			int quantity = Integer.parseInt(scan.nextLine());
			mine.putIfAbsent(resource, 0);
			mine.put(resource, mine.get(resource)+quantity);
			input = scan.nextLine();
		}
		for (Map.Entry<String, Integer> entry : mine.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
		scan.close();
	}
}
