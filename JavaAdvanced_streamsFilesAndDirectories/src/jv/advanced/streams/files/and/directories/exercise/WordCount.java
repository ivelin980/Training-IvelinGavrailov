package jv.advanced.streams.files.and.directories.exercise;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Write a program that reads a list of words from the file words.txt (from the
 * Resources - Exercises) and finds how many times each of the words is
 * contained in another file text.txt (from the Resources – Exercises). Matching
 * should be case-insensitive. Write the results in file results.txt. Sort the
 * words by frequency in descending order.
 * 
 * @author Ivelin Gavrailov
 * @since 03.09.2020
 *
 */
public class WordCount {

	public static void main(String[] args) {
		String wordsPath = "src\\Exercises Resources\\words.txt";
		String output = "output.txt";
		String textPath = "src\\Exercises Resources\\text.txt";
		HashMap<String, Integer> words = new HashMap<>();
		try (Scanner wordsFile = new Scanner(new File(wordsPath));
				Scanner textFile = new Scanner(new File(textPath));
				PrintWriter out = new PrintWriter(output)) {
			while (wordsFile.hasNext()) {
				String word = wordsFile.next();
				words.putIfAbsent(word, 0);
			}
			while (textFile.hasNextLine()) {
				Scanner textLine = new Scanner(textFile.nextLine());
				while (textLine.hasNext()) {
					String word = textLine.next();
					if (words.containsKey(word)) {
						words.put(word, words.get(word) + 1);
					}
				}
				textLine.close();
			}
			words.entrySet().stream().sorted((w1, w2) -> w2.getValue().compareTo(w1.getValue()))
					.forEach(w -> out.write(w.getKey() + " - " + w.getValue() + "\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}