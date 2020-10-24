package jv.advanced.streams.files.and.directories.lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Read the file named "input.txt" that is provided for this exercise and write
 * all its content to a file while skipping any punctuation. Skip the following
 * symbols: ',', '.', '!', '?'. Submit in Judge only the output of the program.
 * 
 * @author Ivelin Gavrailov
 * @since 30.08.2020
 *
 */
public class WriteToFile {

	public static void main(String[] args) throws IOException {
		String path = "input.txt";
		String output = "output.txt";
		ArrayList<Character> punctuation = new ArrayList<>(Arrays.asList(',', '.', '!', '?'));
		try (FileInputStream fis = new FileInputStream(path); FileOutputStream fos = new FileOutputStream(output)) {
			int oneByte = fis.read();
			while (oneByte != -1) {
				if (!punctuation.contains((char) oneByte)) {
					fos.write(oneByte);
				}
				oneByte = fis.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Wrong file name.");
		}
	}

}
