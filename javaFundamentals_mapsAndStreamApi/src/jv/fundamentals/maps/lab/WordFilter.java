package jv.fundamentals.maps.lab;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Read an array of strings, take only words which length is even. Print each
 * word on a new line.
 * 
 * @author Ivelin Gavrailov
 * @since 06.07.2020
 *
 */
public class WordFilter {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] words = Arrays.stream(scan.nextLine().split("\\s+")).filter(w -> w.length() % 2 == 0)
				.toArray(String[]::new);
		System.out.println(String.join("\n", words));
		scan.close();
	}

}
