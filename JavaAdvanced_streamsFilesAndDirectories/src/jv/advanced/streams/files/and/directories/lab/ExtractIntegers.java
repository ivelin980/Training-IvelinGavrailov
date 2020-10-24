package jv.advanced.streams.files.and.directories.lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ExtractIntegers {

	public static void main(String[] args) throws IOException {
		String path = "input.txt";
		try (FileInputStream fis = new FileInputStream(path); Scanner scan = new Scanner(fis);) {
			while (scan.hasNext()) {
				if (scan.hasNextInt()) {
					System.out.println(scan.nextInt());
				}
				scan.next();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
