package jv.fundamentals.maps.exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * You’ve beaten all the content and the last thing left to accomplish is own a
 * legendary item. However, it’s a tedious process and requires quite a bit of
 * farming. Anyway, you are not too pretentious – any legendary will do. The
 * possible items are: • Shadowmourne – requires 250 Shards; • Valanyr –
 * requires 250 Fragments; • Dragonwrath – requires 250 Motes; Shards, Fragments
 * and Motes are the key materials, all else is junk. You will be given lines of
 * input, such as 2 motes 3 ores 15 stones. Keep track of the key materials -
 * the first that reaches the 250 mark wins the race. At that point, print the
 * corresponding legendary obtained. Then, print the remaining shards,
 * fragments, motes, ordered by quantity in descending order, then by name in
 * ascending order, each on a new line. Finally, print the collected junk items,
 * in alphabetical order. Input • Each line of input is in format {quantity}
 * {material} {quantity} {material} … {quantity} {material} Output • On the
 * first line, print the obtained item in format {Legendary item} obtained! • On
 * the next three lines, print the remaining key materials in descending order
 * by quantity o If two key materials have the same quantity, print them in
 * alphabetical order • On the final several lines, print the junk items in
 * alphabetical order o All materials are printed in format {material}:
 * {quantity} o All output should be lowercase, except the first letter of the
 * legendary
 * 
 * @author Ivelin Gavrailov
 * @since 07.07.2020
 *
 */
public class LegendaryFarming {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		TreeMap<String, Integer> items = new TreeMap<>();
		{
			{
				items.put("shards", 0);
				items.put("motes", 0);
				items.put("fragments", 0);
			}
		}
		TreeMap<String, Integer> junk = new TreeMap<>();
		boolean isObtained = false;
		while (!isObtained) {
			String[] tokens = scan.nextLine().split("\\s+");
			for (int i = 0; i < tokens.length; i += 2) {
				int quantity = Integer.parseInt(tokens[i]);
				String type = tokens[i + 1].toLowerCase();
				if (items.containsKey(type)) {
					addItem(items, type, quantity);
					isObtained = hasLegendary(items, type);
					if (isObtained) {
						break;
					}
				} else {
					addItem(junk, type, quantity);
				}
			}
		}
		items.entrySet().stream().sorted((i1, i2) -> Integer.compare(i2.getValue(), i1.getValue()))
				.forEach(i -> System.out.println(String.format("%s: %d", i.getKey(), i.getValue())));
		junk.entrySet().stream().forEach(j -> System.out.println(String.format("%s: %d", j.getKey(), j.getValue())));
		scan.close();
	}

	private static void addItem(Map<String, Integer> map, String key, int value) {
		map.putIfAbsent(key, 0);
		map.put(key, map.get(key) + value);
	}

	private static boolean hasLegendary(Map<String, Integer> items, String type) {
		if (items.get(type) >= 250) {
			items.put(type, items.get(type) - 250);
			switch (type) {
			case "shards":
				System.out.println("Shadowmourne obtained!");
				return true;
			case "motes":
				System.out.println("Dragonwrath obtained!");
				return true;
			case "fragments":
				System.out.println("Valanyr obtained!");
				return true;
			}
		}
		return false;
	}
}
