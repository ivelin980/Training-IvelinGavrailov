package jv.fundamentals.text.processing.lab;

import java.util.Scanner;

/**
 * You will be given series of strings until you receive an "end" command. Write
 * a program that reverses strings and printseach pair on separate line in
 * format "{word} = {reversed word}".
 * 
 * @author Ivelin Gavrailov
 * @since 10.07.2020
 *
 */
public class ReverseStrings {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder input = new StringBuilder();
		input.append(scan.nextLine());
		while (!"end".equalsIgnoreCase(input.toString())) {
			System.out.println(String.format("%s = %s", input.toString(), input.reverse().toString()));
			input.setLength(0);
			input.append(scan.nextLine());
		}
		scan.close();
	}
}
