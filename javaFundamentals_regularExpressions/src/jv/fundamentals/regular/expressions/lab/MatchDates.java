package jv.fundamentals.regular.expressions.lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Ivelin Gavrailov
 * @since 16.07.2020
 *
 */
public class MatchDates {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String regex = "\\b(?<day>[0-9]{2})(?<separator>[\\.\\-\\/])(?<month>[A-Z][a-z]{2})\\k<separator>(?<year>[0-9]{4})\\b";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);

		while (matcher.find()) {
			String day = matcher.group("day");
			String month = matcher.group("month");
			String year = matcher.group("year");

			System.out.println(String.format("Day: %s, Month: %s, Year: %s", day, month, year));
		}
		scan.close();
	}
}
