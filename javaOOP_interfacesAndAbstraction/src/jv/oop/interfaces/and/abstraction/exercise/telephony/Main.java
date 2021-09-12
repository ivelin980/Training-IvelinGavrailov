package jv.oop.interfaces.and.abstraction.exercise.telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * You have a business - manufacturing cell phones. But you have no software
 * developers, so you call your friends and ask them to help you create a cell
 * phone software. They agree and you start working on the project. The project
 * consists of one main model - a Smartphone. Each of your smartphones should
 * have functionalities of calling other phones and browsing in the world wide
 * web. Your friends are very busy, so you decide to write the code on your own.
 * Here is the mandatory assignment: You should have a model - Smartphone and
 * two separate functionalities which your smartphone has - to call other phones
 * and to browse in the world wide web. You should end up with one class and two
 * interfaces.Input The input comes from the console. It will hold two lines: •
 * First line: phone numbers to call (String), separated by spaces. • Second
 * line: sites to visit (String), separated by spaces. Output • First call all
 * numbers in the order of input then browse all sites in order of input • The
 * functionality of calling phones is printing on the console the number which
 * are being called in the format: "Calling... <number>" • The functionality of
 * the browser should print on the console the site in format: "Browsing:
 * <site>!" (pay attention to the exclamation mark when printing URLs) • If
 * there is a number in the input of the URLs, print: "Invalid URL!" and
 * continue printing the rest of the URLs. • If there is a character different
 * from a digit in a number, print: "Invalid number!" and continue to the next
 * number. Constraints • Each site's URL should consist only of letters and
 * symbols (No digits are allowed in the URL address)
 * 
 * 
 * @author Ivelin Gavrailov
 * @since 13.02.2021
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<String> numbers = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
		List<String> urls = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
		Smartphone smartphone = new Smartphone(numbers, urls);
		System.out.print(smartphone.call());
		System.out.print(smartphone.browse());
		scan.close();
	}
}