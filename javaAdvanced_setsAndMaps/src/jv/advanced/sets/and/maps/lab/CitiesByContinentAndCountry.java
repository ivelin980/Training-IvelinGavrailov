package jv.advanced.sets.and.maps.lab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Write a program to read continents, countries and their cities, put them in a
 * nested map and print them in the order of first appearance.
 * 
 * @author Ivelin Gavrailov
 * @since 25.08.2020
 *
 */
public class CitiesByContinentAndCountry {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		LinkedHashMap<String, LinkedHashMap<String,ArrayList<String>>> world = new LinkedHashMap<>();
		for (int i = 0; i < n; i++) {
			String[] tokens = scan.nextLine().split("\\s+");
			String continent = tokens[0];
			String country = tokens[1];
			String city = tokens[2];
			world.putIfAbsent(continent, new LinkedHashMap<>());
			world.get(continent).putIfAbsent(country, new ArrayList<>());
			world.get(continent).get(country).add(city);	
		}
		for (Map.Entry<String, LinkedHashMap<String, ArrayList<String>>> entry : world.entrySet()) {
			System.out.println(entry.getKey()+":");
			for (Map.Entry<String, ArrayList<String>> innerEntry : entry.getValue().entrySet()) {
				System.out.println(String.format("%s -> %s", innerEntry.getKey(),String.join(", ", innerEntry.getValue())));
			}
		}
		scan.close();
	}
}
