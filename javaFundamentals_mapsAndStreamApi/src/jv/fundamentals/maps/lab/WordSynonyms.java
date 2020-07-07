package jv.fundamentals.maps.lab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Write a program which keeps a map with synonyms. The key of the map will be
 * the word. The value will be a list of all the synonyms of that word. You will
 * be given a number n. On the next 2 * n lines you will be given a word and a
 * synonym each on a separate line like this: • {word} • {synonym} If you get
 * the same word for second time, just add the new synonym to the list. Print
 * the words in the following format: {word} - {synonym1, synonym2… synonymN}
 * 
 * @author Ivelin Gavrailov
 * @since 06.07.2020
 *
 */
public class WordSynonyms {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		LinkedHashMap<String, ArrayList<String>> words = new LinkedHashMap<>();
		for (int i = 1; i <= n; i++) {
			String word = scan.nextLine();
			String synonym = scan.nextLine();

			words.putIfAbsent(word, new ArrayList<>());
			words.get(word).add(synonym);
		}
		for (Map.Entry<String, ArrayList<String>> entry : words.entrySet()) {
			System.out.print(String.format("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue())));
		}
		scan.close();
	}
}
