package jv.fundamentals.regular.expressions.lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a Java Program to match full names from a list of names and print them
 * on the console. First, write a regular expression to match a valid full name,
 * according to these conditions: • A valid full name has the following
 * characteristics: o It consists of two words. o Each word starts with a
 * capital letter. o After the first letter, it only contains lowercase letters
 * afterwards. o Each of the two words should be at least two letters long. o
 * The two words are separated by a single space.
 * 
 * @author Ivelin Gavrailov
 * @since 15.07.2020
 *
 */
public class MatchFullName {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String regex = "\\b[A-Z][a-z]+ [A-Z][a-z]+\\b";
		String input = scan.nextLine();
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		
		while(matcher.find()) {
			System.out.print(matcher.group() + " ");
		}
		scan.close();
	}

}
