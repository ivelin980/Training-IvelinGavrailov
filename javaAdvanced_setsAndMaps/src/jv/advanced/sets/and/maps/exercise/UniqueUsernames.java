package jv.advanced.sets.and.maps.exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Write a simple program that reads from the console a sequence of usernames
 * and keeps a collection with only the unique ones. Print the collection on the
 * console in order of insertion:
 * 
 * @author Ivelin Gavrailov
 * @since 25.08.2020
 *
 */
public class UniqueUsernames {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		LinkedHashSet<String> usernames = new LinkedHashSet<>();
		for (int i = 0; i < n; i++) {
			String name = scan.nextLine();
			usernames.add(name);
		}
		for (String username : usernames) {
			System.out.println(username);
		}
		scan.close();
	}
}
