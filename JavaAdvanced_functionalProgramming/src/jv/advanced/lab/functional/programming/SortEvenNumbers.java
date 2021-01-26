package jv.advanced.lab.functional.programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Write a program that reads one line of Integers separated by ", ". • Print
 * the even numbers • Sort them in ascending order • Print them again. Use 2
 * Lambda Expresions to do so.
 * 
 * @author Ivelin Gavrailov
 * @since 24.12.2020
 *
 */
public class SortEvenNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] numbers = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt)
				.filter(num -> num % 2 == 0).toArray();

		printArray(numbers);

		Arrays.sort(numbers);

		printArray(numbers);
		scan.close();
	}

	public static void printArray(int[] numbers) {
		System.out.println(Arrays.stream(numbers).mapToObj(Integer::toString).collect(Collectors.joining(", ")));
	}
}
