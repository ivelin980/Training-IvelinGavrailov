package jv.advanced.exercise.functional.programming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Write a custom comparator that sorts all even numbers before all odd ones in
 * ascending order. Pass it to an Arrays.sort() function and print the result.
 * 
 * @author Ivelin Gavrailov
 * @since 27.12.2020
 *
 */
public class CustomComparator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).sorted((f,s) -> {
			int result = Integer.compare(Math.abs(f % 2),Math.abs(s % 2));
			if(result == 0) {
				result = f - s;
			}
			return result;
		}).forEach(el -> System.out.print(el + " "));
		scan.close();
	}
}
