package jv.advanced.stacks.and.queues.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/**
 * You have an empty sequence, and you will be given N commands. Each command is
 * one of the following types: "1 X" - Push the element X into the stack. "2" -
 * Delete the element present at the top of the stack. "3" - Print the maximum
 * element in the stack. Input The first line of input contains an integer N,
 * where 1 ≤ N ≤ 105 The next N lines contain commands. All commands will be
 * valid and in the format described The element X will be in range 1 ≤ X ≤ 109
 * The type of the command will be in range 1 ≤ Type ≤ 3 Output For each command
 * of type "3", print the maximum element in the stack on a new line.
 * 
 * @author Ivelin Gavrailov
 * @since 06.08.2020
 *
 */
public class MaximumElement {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = Integer.parseInt(scan.nextLine());
		int max = Integer.MIN_VALUE;
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			int[] input = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			int commandNumber = input[0];
			switch (commandNumber) {
			case 1:
				int element = input[1];
				stack.push(element);
				break;
			case 2:
				stack.pop();
				break;
			case 3:
				for (int n : stack) {
					if (max < n) {
						max = n;
					}
				}
				System.out.println(max);
				break;
			default:
				break;
			}
		}
		scan.close();
	}
}