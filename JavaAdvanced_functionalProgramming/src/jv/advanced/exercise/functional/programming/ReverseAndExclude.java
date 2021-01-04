package jv.advanced.exercise.functional.programming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Write a program that reverses a collection and removes elements that are
 * divisible by a given integer n.
 * 
 * @author Ivelin Gavrailov
 * @since 26.12.2020
 *
 */
public class ReverseAndExclude {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
		int divisedBy = Integer.parseInt(scan.nextLine());
		Predicate<Integer> divisible = number -> number % divisedBy != 0;
		Collections.reverse(numbers);
		numbers.stream().filter(divisible).forEach(el->System.out.print(el + " "));
		scan.close();
	}
}
