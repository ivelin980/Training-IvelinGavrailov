package jv.advanced.streams.files.and.directories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Write a program that reads a text file (input.txt from the Resources -
 * Exercises) and changes the casing of all letters to upper. Write the output
 * to another file (output.txt).
 * 
 * @author Ivelin Gavrailov
 * @since 03.09.2020
 *
 */
public class AllCapitals {

	public static void main(String[] args) {
		String path = "src\\resources\\input.txt";
		String output = "output.txt";
		try (BufferedReader in = new BufferedReader(new FileReader(path)); PrintWriter out = new PrintWriter(output)) {
			String line = in.readLine();
			while (line != null) {
				for (int i = 0; i < line.length(); i++) {
					out.write(Character.toTitleCase(line.charAt(i)));
				}
				out.write('\n');
				line = in.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
