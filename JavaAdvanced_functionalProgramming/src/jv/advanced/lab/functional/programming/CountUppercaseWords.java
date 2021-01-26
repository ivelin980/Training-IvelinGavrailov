package jv.advanced.lab.functional.programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Write a program that reads one line of text from the console. Print the count
 * of words that start with a Uppercase letter, after that print all these words
 * in the same order, like you found them in the text. Use a Predicate<String>
 * 
 * @author Ivelin Gavrailov
 * @since 25.12.2020
 *
 */
public class CountUppercaseWords {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] arr = Arrays.stream(scan.nextLine().split("\\s+")).toArray(String[]::new);
		Predicate<String> validator = str -> Character.isUpperCase(str.charAt(0));
		System.out.println(getByPredicate(arr, validator).length);
		Arrays.stream(getByPredicate(arr, validator)).forEach(System.out::println);
		scan.close();
	}

	public static String[] getByPredicate(String[] arr, Predicate<String> predicate) {
		return Arrays.stream(arr).filter(predicate).toArray(String[]::new);
	}

}
