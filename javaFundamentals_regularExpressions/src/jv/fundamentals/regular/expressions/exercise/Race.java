package jv.fundamentals.regular.expressions.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a program that processes information about a race. On the first line
 * you will be given a list of participants separated by ", ". On the next few
 * lines until you receive a line "end of race" you will be given some info
 * which will be some alphanumeric characters. In between them you could have
 * some extra characters which you should ignore. For example:
 * "G!32e%o7r#32g$235@!2e". The letters are the name of the person and the sum
 * of the digits is the distance he ran. So here we have George who ran 29 km.
 * Store the information about the person only if the list of racers contains
 * the name of the person. If you receive the same person more than once just
 * add the distance to his old distance. At the end print the top 3 racers
 * ordered by distance in descending in the format: "1st place: {first racer}
 * 2nd place: {second racer} 3rd place: {third racer}"
 * 
 * @author Ivelin Gavrailov
 * @since 16.07.2020
 *
 */
public class Race {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] data = scan.nextLine().split(", ");
		ArrayList<String> racers = new ArrayList<>(Arrays.asList(data));
		Pattern letterPattern = Pattern.compile("[A-Z]|[a-z]");
		Pattern digitPattern = Pattern.compile("[0-9]");
		LinkedHashMap<String, Integer> results = new LinkedHashMap<>();
		String input = scan.nextLine();
		while (!"end of race".equalsIgnoreCase(input)) {
			Matcher nameMatcher = letterPattern.matcher(input);
			StringBuilder name = new StringBuilder();
			while(nameMatcher.find()) {
				name.append(nameMatcher.group());
			}
			if(racers.contains(name.toString())) {
				results.putIfAbsent(name.toString(), 0);
			int oldKm = results.get(name.toString());
			int newKm = 0;
			Matcher digitMatcher = digitPattern.matcher(input);
			while(digitMatcher.find()) {
				newKm += Integer.parseInt(digitMatcher.group());
			}
			
			results.put(name.toString(), oldKm+newKm);
			}
			
			input = scan.nextLine();
		}
		int[] number = {1};
		results.entrySet().stream().sorted((r1,r2) -> Integer.compare(r2.getValue(), r1.getValue()))
		.limit(3).forEach(r -> {
		switch (number[0]) {
		case 1:
			System.out.println(String.format("1st place: %s", r.getKey()));
			break;
		case 2:
			System.out.println(String.format("2nd place: %s", r.getKey()));
			break;
		case 3:
			System.out.println(String.format("3rd place: %s", r.getKey()));
			break;
		default:
			break;
		}
		number[0]++;
		});
		scan.close();
	}
}
