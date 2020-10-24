package jv.advanced.streams.files.and.directories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Write a program that reads a text file (input.txt from the Resources -
 * Exercises) and prints on the console the sum of the ASCII symbols of all
 * characters inside of the file. Use BufferedReader in combination with
 * FileReader.
 * 
 * @author Ivelin Gavrailov
 * @since 03.09.2020
 *
 */
public class SumBytes {

	public static void main(String[] args) {
		String path = "src\\Exercises Resources\\input.txt";
		BigInteger sum = BigInteger.valueOf(0);
		try (BufferedReader in = new BufferedReader(new FileReader(path))) {
			String line = in.readLine();
			while (line != null) {
				for (int i = 0; i < line.length(); i++) {
					sum = sum.add(BigInteger.valueOf(line.charAt(i)));
				}
				line = in.readLine();
			}
			System.out.println(sum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
