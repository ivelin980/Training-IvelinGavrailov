package jv.advanced.exercise.functional.programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/**
 * On the first line you are given a list of numbers. On the next lines you are
 * passed different commands that you need to apply to all numbers in the list:
 * "add" -> adds 1; "multiply" -> multiplies by 2; "subtract" -> subtracts 1;
 * "print" -> prints all numbers on a new line. The input will end with an "end"
 * command, after which you need to print the result.
 * 
 * @author Ivelin Gavrailov
 * @since 26.12.2020
 *
 */
public class AppliedArithmetic {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Integer> numbers = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed()
				.collect(Collectors.toList());
		String action = scan.nextLine();
		Map<String, UnaryOperator<List<Integer>>> unaryMap = new HashMap<>();
		Consumer<List<Integer>> printAll = list -> list.stream().forEach(el -> System.out.print(el + " "));
		unaryMap.put("add", list -> {
			for (int i = 0; i < list.size(); i++) {
				numbers.set(i, numbers.get(i) + 1);
			}
			return list;
		});
		unaryMap.put("multiply", list -> {
			for (int i = 0; i < list.size(); i++) {
				numbers.set(i, numbers.get(i) * 2);
			}
			return list;
		});
		unaryMap.put("subtract", list -> {
			for (int i = 0; i < list.size(); i++) {
				numbers.set(i, numbers.get(i) - 1);
			}
			return list;
		});
		while (!"end".equalsIgnoreCase(action)) {
			if ("print".equals(action)) {
				printAll.accept(numbers);
			} else {
				unaryMap.get(action).apply(numbers);
			}
			action = scan.nextLine();
		}
		scan.close();
	}
}
