package jv.advanced.streams.files.and.directories.lab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteEveryThirdLine {

	public static void main(String[] args) {
		String path = "input.txt";
		String output = "output.txt";
		try (BufferedReader in = new BufferedReader(new FileReader(path));
				PrintWriter out = new PrintWriter(new FileWriter(output))) {
			int lineNum = 1;
			String line = in.readLine();
			while (line != null) {
				if (lineNum % 3 == 0) {
					out.println(line);
				}
				line = in.readLine();
				lineNum++;
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Wrong file name");
		}
	}
}
