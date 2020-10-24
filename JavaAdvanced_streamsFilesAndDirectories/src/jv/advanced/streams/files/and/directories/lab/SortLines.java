package jv.advanced.streams.files.and.directories.lab;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Read the file provided, named "input.txt" and sort all lines. Write text to
 * another text file. Use Path and Files Classes. Submit in Judge only the
 * output of the program.
 * 
 * @author Ivelin Gavrailov
 * @since 31.08.2020
 *
 */
public class SortLines {

	public static void main(String[] args) {
		Path path = Paths.get("input.txt");

		try (PrintWriter out = new PrintWriter("output.txt")) {
			List<String> lines = Files.readAllLines(path);
			lines.stream().sorted().forEach(l -> out.write(l + "\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
