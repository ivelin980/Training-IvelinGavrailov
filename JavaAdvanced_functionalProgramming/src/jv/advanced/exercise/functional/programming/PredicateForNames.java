package jv.advanced.exercise.functional.programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Write a predicate. Its goal is to check a name for its length and to return
 * true if the names length is less or equal the passed integer. You will be
 * given an integer that represents the length you have to use. On the second
 * line you will be given a string array with some names. Print the names,
 * passing the condition in the predicate.
 * 
 * @author Ivelin Gavrailov
 * @since 27.12.2020
 *
 */
public class PredicateForNames {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		Predicate<String> lessLetters = str -> str.length() <= n;
		Arrays.stream(scan.nextLine().split("\\s+")).filter(lessLetters).forEach(System.out::println);
		scan.close();
	}

}
