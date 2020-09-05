package jv.advanced.streams.files.and.directories.lab;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * You are given a file named "input.txt". Read and print all of its contents as
 * a sequence of bytes (the binary representation of the ASCII code for each
 * character) separated by a single comma. Submit in Judge only the output of
 * the program.
 * 
 * @author Ivelin Gavrailov
 * @since 30.08.2020
 *
 */
public class ReadFile {

	public static void main(String[] args) {
		String path = "input.txt";
		try (FileInputStream fileStream = new FileInputStream(path)) {
			int oneByte = fileStream.read();
			while (oneByte != -1) {
				System.out.print(Integer.toBinaryString(oneByte)+" ");
				oneByte = fileStream.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Wrong file name");
		}
	}

}
