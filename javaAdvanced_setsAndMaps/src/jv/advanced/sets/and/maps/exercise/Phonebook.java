package jv.advanced.sets.and.maps.exercise;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Write a program that receives some info from the console about people and
 * their phone numbers. You are free to choose the manner in which the data is
 * entered; each entry should have just one name and one number (both of them
 * strings). If you receive a name that already exists in the phonebook, simply
 * update its number. After filling this simple phonebook, upon receiving the
 * command "search", your program should be able to perform a search of a
 * contact by name and print her details in format "{name} -> {number}". In case
 * the contact isn't found, print "Contact {name} does not exist." Examples:
 * 
 * @author Ivelin Gavrailov
 * @since 25.08.2020
 *
 */
public class Phonebook {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<String, String> phonebook = new HashMap<>();
		String input = scan.nextLine();
		while (!"search".equalsIgnoreCase(input)) {
			String[] tokens = input.split("-");
			String name = tokens[0];
			String phone = tokens[1];
			phonebook.putIfAbsent(name, "");
			phonebook.put(name, phone);
			input = scan.nextLine();
		}
		input = scan.nextLine();
		while (!"stop".equalsIgnoreCase(input)) {
			if (phonebook.containsKey(input)) {
				System.out.println(input + " -> " + phonebook.get(input));
			} else {
				System.out.println(String.format("Contact %s does not exist.", input));
			}
			input = scan.nextLine();
		}
		scan.close();
	}
}
