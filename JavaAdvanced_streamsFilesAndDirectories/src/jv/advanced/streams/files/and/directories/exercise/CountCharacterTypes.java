package jv.advanced.streams.files.and.directories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 * Write a program that reads a list of words from the file (input.txt from the
 * Resources - Exercises) and finds the count of vowels, consonants and
 * punctuation marks. Assume that: • a, e, i, o, u are vowels, only lower case •
 * All others are consonants • Punctuation marks are (!,.?) • Do not count
 * whitespace. Write the results to another file – output.txt.
 * 
 * @author Ivelin Gavrailov
 * @since 03.09.2020
 *
 */
public class CountCharacterTypes {

	public static void main(String[] args) {
		String path = "src\\resources\\input.txt";
		String output = "output.txt";
		int vowelsCount = 0;
		int consonantsCount = 0;
		int punctuationCount = 0;
		try (BufferedReader in = new BufferedReader(new FileReader(path)); PrintWriter out = new PrintWriter(output)) {
			String line = in.readLine();
			while (line != null) {
				for (int i = 0; i < line.length(); i++) {
					switch (line.charAt(i)) {
					case 'e':
					case 'a':
					case 'i':
					case 'o':
					case 'u':
						vowelsCount++;
						break;
					case '!':
					case '.':
					case ',':
						punctuationCount++;
						break;
					case ' ':
						break;
					default:
						consonantsCount++;
						break;
					}
				}
				line = in.readLine();
			}
			System.out.println(String.format("Vowels: %d%nConsonants: %d%nPunctuation: %d", vowelsCount,
					consonantsCount, punctuationCount));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}