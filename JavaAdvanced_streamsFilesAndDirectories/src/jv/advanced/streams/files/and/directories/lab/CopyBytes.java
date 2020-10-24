package jv.advanced.streams.files.and.directories.lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Read the file provided, named "input.txt" and extracts all integers that are
 * not a part of a word in a separate file. A valid integer is surrounded with
 * white spaces. Submit in Judge only the output of the program.
 * 
 * @author Ivelin Gavrailov
 * @since 31.08.2020
 *
 */
public class CopyBytes {

	public static void main(String[] args) throws IOException {
		String path = "input.txt";
		String output = "output.txt";
		try (FileInputStream fis = new FileInputStream(path); FileOutputStream fos = new FileOutputStream(output)) {
			int oneByte = fis.read();
			while (oneByte != -1) {
				if (oneByte == ' ' || oneByte == '\n') {
					fos.write(oneByte);
				} else {
					String digits = String.valueOf(oneByte);
					for (int i = 0; i < digits.length(); i++) {
						fos.write(digits.charAt(i));
					}
				}

				oneByte = fis.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Wrong file name");
		}

	}
}
