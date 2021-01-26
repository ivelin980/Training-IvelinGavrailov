package jv.advanced.lab.functional.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * You are given a lower and an upper bound for a range of integer numbers. Then
 * a command specifies if you need to list all even or odd numbers in the given
 * range. Use predicates that need to be passed to a method.
 * 
 * @author Ivelin Gavrailov
 * @since 25.12.2020
 *
 */
public class FindEvensOrOdds {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] input = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		int beginNumber = input[0];
		int endNumber = input[1];
		List<Integer> numbers = new ArrayList<>();
		Map<String, Predicate<Integer>> predicateMap = new HashMap<>();
		for (int i = beginNumber; i <= endNumber; i++) {
			numbers.add(i);
		}
		predicateMap.put("odd", number -> number % 2 != 0);
		predicateMap.put("even", number -> number % 2 == 0);
		Consumer<Integer> printEl = el -> System.out.print(el + " ");
		String typeOfNumbers = scan.nextLine();
		numbers.stream().filter(predicateMap.get(typeOfNumbers)).forEach(printEl);
		scan.close();
	}

}
