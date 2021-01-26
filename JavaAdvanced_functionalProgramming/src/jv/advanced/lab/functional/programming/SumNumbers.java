package jv.advanced.lab.functional.programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

/**
 * Write a program that reads one line of Integers separated by ", ". Print the
 * count of the numbers and their sum. Use a Function<String, Integer>
 * 
 * @author Ivelin Gavrailov
 * @since 24.12.2020
 *
 */
public class SumNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] numbers = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
		Function<int[], Void> printCount = arr -> {
			System.out.println("Count = " + arr.length);
			return null;
		};
		Function<int[], String> sumArray = arr -> "Sum = " + Arrays.stream(arr).sum();
		printCount.apply(numbers);
		System.out.println(sumArray.apply(numbers));
		scan.close();
	}
}