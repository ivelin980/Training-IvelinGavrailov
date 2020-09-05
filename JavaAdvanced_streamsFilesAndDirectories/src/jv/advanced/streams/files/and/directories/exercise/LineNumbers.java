package jv.advanced.streams.files.and.directories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Write a program that reads a text file (inputLineNumbers.txt from the
 * Resources - Exercises) and inserts line numbers in front of each of its
 * lines. The result should be written to another text file – output.txt.
 * 
 * @author Ivelin Gavrailov
 * @since 03.09.2020
 *
 */
public class LineNumbers {

	public static void main(String[] args) {
		String path = "src\\Exercise Resources\\inputLineNumbers.txt";
		String output = "output.txt";
		int lineCount = 1;
		try (BufferedReader in = new BufferedReader(new FileReader(path)); PrintWriter out = new PrintWriter(output)) {
			String line = in.readLine();
			while (line != null) {
				out.write(lineCount + ". ");
				for (int i = 0; i < line.length(); i++) {
					out.write(line.charAt(i));
				}
				out.write('\n');
				line = in.readLine();
				lineCount++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
