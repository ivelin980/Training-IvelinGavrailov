package jv.advanced.exercise.functional.programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

/**
 * Find all numbers in the range 1..N that are divisible by the numbers of a
 * given sequence. Use predicates.
 * 
 * @author Ivelin Gavrailov
 * @since 27.12.2020
 *
 */
public class ListOfPredicates {
	public static BiPredicate<Integer, Integer> predicate = (f, s) -> f % s == 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		Set<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt)
				.collect(Collectors.toSet());
		divisibleNumbers(1, numbers, n);
		scan.close();
	}

	public static void divisibleNumbers(int currentNum, Set<Integer> divisibleBy, int rangeTo) {
		boolean result = true;
		if (currentNum > rangeTo) {
			return;
		}
		for (Integer number : divisibleBy) {
			result = predicate.test(currentNum, number);
			if (!result) {
				break;
			}
		}
		if (result) {
			System.out.print(currentNum + " ");
		}
		divisibleNumbers(currentNum + 1, divisibleBy, rangeTo);
	}
}
