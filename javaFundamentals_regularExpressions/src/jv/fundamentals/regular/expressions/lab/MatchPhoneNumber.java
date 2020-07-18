package jv.fundamentals.regular.expressions.lab;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a regular expression to match a valid phone number from Sofia. After
 * you find all valid phones, print them on the console, separated by a comma
 * and a space “, ”. Compose the Regular Expression A valid number has the
 * following characteristics: • It starts with "+359" • Then, it is followed by
 * the area code (always 2) • After that, it’s followed by the number itself: o
 * The number consists of 7 digits (separated in two groups of 3 and 4 digits
 * respectively). • The different parts are separated by either a space or a
 * hyphen ('-').
 * 
 * @author Ivelin Gavrailov
 * @since 15.07.2020
 *
 */
public class MatchPhoneNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String regex = "\\+359([- ])2\\1[0-9]{3}\\1[0-9]{4}\\b";
		String input = scan.nextLine();

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		ArrayList<String> list = new ArrayList<>();
		while (matcher.find()) {
			list.add(matcher.group());
		}
		System.out.println(String.join(", ", list));
		scan.close();
	}
}
