package jv.advanced.sets.and.maps.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * You are given a sequence of strings, each on a new line, unitll you receive
 * “stop” command. First string is a name of a person. On the second line you
 * receive his email. Your task is to collect their names and emails, and remove
 * emails whose domain ends with "us", "uk" or “com” (case insensitive). Print:
 * {name} – > {email}
 * 
 * @author Ivelin Gavrailov
 * @since 26.08.2020
 *
 */
public class FixEmails {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		LinkedHashMap<String, String> db = new LinkedHashMap<>();
		while (!"stop".equalsIgnoreCase(input)) {
			String name = input;
			String email = scan.nextLine();
			db.put(name, email);
			input = scan.nextLine();
		}
		for (Map.Entry<String, String> entry : db.entrySet()) {
			if (isDomainAllowed(entry.getValue())) {
				System.out.println(entry.getKey() + " -> " + entry.getValue());
			}
		}
		scan.close();
	}

	private static String getDomainOfEmail(String email) {
		return email.substring(email.indexOf('.') + 1, email.length());
	}

	private static boolean isDomainAllowed(String email) {
		String domain = getDomainOfEmail(email);
		switch (domain) {
		case "com":
			return false;
		case "uk":
			return false;
		case "us":
			return false;
		default:
			break;
		}
		return true;
	}
}
