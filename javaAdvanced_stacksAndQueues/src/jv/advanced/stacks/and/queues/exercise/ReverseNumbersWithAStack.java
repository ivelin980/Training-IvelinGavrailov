package jv.advanced.stacks.and.queues.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Write a program that reads N integers from the console and reverses them
 * using a stack. Use the ArrayDeque<Integer> class. Just put the input numbers
 * in the stack and pop them. Examples:
 * 
 * @author Ivelin Gavrailov
 * @since 05.08.2020
 *
 */
public class ReverseNumbersWithAStack {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] numbers = scan.nextLine().split("\\s+");
		ArrayDeque<String> stack = new ArrayDeque<>();
		for (String n : numbers) {
			stack.push(n);
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		scan.close();
	}
}
