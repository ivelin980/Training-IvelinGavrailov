package jv.advanced.exercise.functional.programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.ToIntFunction;

/**
 * Write a simple program that reads a set of numbers from the console and finds
 * the smallest of the numbers using a simple Function<Integer[], Integer> .
 * 
 * @author Ivelin Gavrailov
 * @since 26.12.2020
 *
 */
public class CustomMinFunction {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		ToIntFunction<int[]> minFunction = arr -> {
			Arrays.sort(numbers);
			return arr[0];
		};
		System.out.println(minFunction.applyAsInt(numbers));
		scan.close();
	}

}
