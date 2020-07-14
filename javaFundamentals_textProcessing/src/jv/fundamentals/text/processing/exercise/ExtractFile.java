package jv.fundamentals.text.processing.exercise;

import java.util.Scanner;

/**
 * Write a program that reads the path to a file and subtracts the file name and
 * its extension.
 * 
 * @author ExtractFile
 * @since 13.07.2020
 *
 */
public class ExtractFile {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String fileName = input.substring(input.lastIndexOf('\\') + 1, input.indexOf('.'));
		String fileExtension = input.substring(input.indexOf('.') + 1);
		System.out.print(String.format("File name: %s%nFile extension: %s", fileName, fileExtension));
		scan.close();
	}
}
