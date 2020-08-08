package jv.advanced.stacks.and.queues.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/**
 * You will be given an integer N representing the number of elements to push
 * onto the stack, an integer S representing the number of elements to pop from
 * the stack and finally an integer X, an element that you should check whether
 * is present in the stack. If it is, print true on the console. If it’s not,
 * print the smallest element currently present in the stack. Input On the first
 * line, you will be given N, S and X separated by a single space. On the next
 * line, you will be given a line of numbers separated by one or more white
 * spaces. Output On a single line print either true if X is present in the
 * stack otherwise print the smallest element in the stack. If the stack is
 * empty print 0.
 * 
 * @author Ivelin Gavrailov
 * @since 05.08.2020
 *
 */
public class BasicStackOperations {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] tokens = scan.nextLine().split("\\s+");
		int N = Integer.parseInt(tokens[0]);
		int S = Integer.parseInt(tokens[1]);
		int X = Integer.parseInt(tokens[2]);
		int min = Integer.MAX_VALUE;
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		int[] elements = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		for (int i = 0; i < N; i++) {
			stack.push(elements[i]);
		}
		for (int i = 0; i < S; i++) {
			stack.pop();
		}
		if (stack.contains(X)) {
			System.out.println("true");
		} else {
			while (!stack.isEmpty()) {
				int currentElement = stack.pop();
				if (min > currentElement) {
					min = currentElement;
				}
			}
			if (min == Integer.MAX_VALUE) {
				min = 0;
			}
			System.out.println(min);
		}
		scan.close();
	}
}
