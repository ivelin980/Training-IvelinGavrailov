package jv.fundamentals.maps.exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * You are given a sequence of strings, each on a new line. Every odd line on
 * the console is representing a resource (e.g. Gold, Silver, Copper, and so
 * on), and every even – quantity. Your task is to collect the resources and
 * print them each on a new line. Print the resources and their quantities in
 * format: {resource} –> {quantity} The quantities inputs will be in the range
 * [1 … 2 000 000 000]
 * 
 * @author Ivelin Gavrailov
 * @since 07.07.2020
 *
 */
public class MinnerTask {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();
		while (true) {
			String resource = scan.nextLine();
			if ("stop".equalsIgnoreCase(resource)) {
				break;
			}
			int quantity = Integer.parseInt(scan.nextLine());
			resources.putIfAbsent(resource, 0);
			resources.put(resource, resources.get(resource) + quantity);
		}
		resources.entrySet().stream()
				.forEach(r -> System.out.print(String.format("%s -> %d%n", r.getKey(), r.getValue())));
		scan.close();
	}
}
