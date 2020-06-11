package jv.fundamentals.variables.lab;

import java.util.Scanner;

/**
 * Read two names and a delimiter. Print the names joined by the delimiter.
 * 
 * @author Ivelin Gavrailov
 * @since 11.06.2020
 *
 */
public class ConcatNames {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.nextLine();
		String secondName = scan.nextLine();
		String delimiter = scan.nextLine();
		System.out.println(firstName+delimiter+secondName);
		scan.close();
	}
}
