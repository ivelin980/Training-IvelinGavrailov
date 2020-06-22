package jv.fundamentals.lists.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Read a number n and n lines of products. Print a numbered list of all the
 * products ordered by name.
 * 
 * @author Ivelin Gavrailov
 * @since 22.06.2020
 *
 */
public class ListOfProducts {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		ArrayList<String> products = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			products.add(scan.nextLine());
		}
		numberedList(products);
		scan.close();
	}

	private static void numberedList(ArrayList<String> list) {
		int index = 1;
		Collections.sort(list);
		for (String element : list) {
			System.out.print(String.format("%d.%s%n", index, element));
			index++;
		}
	}
}
