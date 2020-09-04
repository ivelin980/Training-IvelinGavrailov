package jv.advanced.stacks.and.queues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Create a simple calculator that can evaluate simple expressions that will not
 * hold any operator different from addition and subtraction. There will not be
 * parentheses or operator precedence. Solve the problem using a Stack.
 * 
 * @author Ivelin Gavrailov
 * @since 29.07.2020
 */
public class SimpleCalculator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayDeque<Integer> numStack = new ArrayDeque<>();
		ArrayDeque<String> operationStack = new ArrayDeque<>();
		String[] calculation = scan.nextLine().split(" ");
		for (int i = 0; i < calculation.length; i++) {
			String element = calculation[i];
			if (isNumeric(element)) {
				numStack.add(Integer.parseInt(element));
			} else {
				operationStack.add(element);
			}
		}
		int result = numStack.pop();
		while (!operationStack.isEmpty()) {
			switch (operationStack.pop()) {
			case "-":
				result -= numStack.pop();
				break;
			case "+":
				result += numStack.pop();
				break;
			default:
				break;
			}
		}
		System.out.println(result);
		scan.close();
	}

	public static boolean isNumeric(String element) {
		return element.matches("-?\\d+(\\.\\d+)?"); // match a number with optional '-' and decimal.
	}
}