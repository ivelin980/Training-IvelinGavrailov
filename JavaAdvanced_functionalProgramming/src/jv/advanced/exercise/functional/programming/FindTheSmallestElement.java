package jv.advanced.exercise.functional.programming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 * Write a program which is using a custom function (written by you) to find the
 * smallest integer in a sequence of integers. The input could have more than
 * one space. Your task is to collect the integers from the console, find the
 * smallest one and print its index (if more than one such elements exist, print
 * the index of the rightmost one).
 * 
 * @author Ivelin Gavrailov
 * @since 27.12.2020
 *
 */
public class FindTheSmallestElement {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed()
				.collect(Collectors.toList());
		ToIntFunction<List<Integer>> smallestElement = list -> {
			int min = Collections.min(numbers);
			return numbers.lastIndexOf(min);
		};
		System.out.println(smallestElement.applyAsInt(numbers));
		scan.close();
	}

}
