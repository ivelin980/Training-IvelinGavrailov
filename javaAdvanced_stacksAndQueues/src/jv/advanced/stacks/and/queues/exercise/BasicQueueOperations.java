package jv.advanced.stacks.and.queues.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * You will be given an integer N representing the number of elements to enqueue
 * (add), an integer S representing the number of elements to dequeue
 * (remove/poll) from the queue and finally an integer X, an element that you
 * should check whether is present in the queue. If it is print true on the
 * console, if it’s not print the smallest element currently present in the
 * queue.
 * 
 * @author Ivelin Gavrailov
 * @since 07.08.2020
 *
 */
public class BasicQueueOperations {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] tokens = scan.nextLine().split("\\s+");
		ArrayDeque<String> queue = Arrays.stream(scan.nextLine().split("\\s+"))
				.collect(Collectors.toCollection(ArrayDeque::new));
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < Integer.parseInt(tokens[1]); i++) {
			queue.poll();
		}
		if (queue.contains(tokens[2])) {
			System.out.println(true);
		} else {
			if (!queue.isEmpty()) {
				for (String n : queue) {
					int number = Integer.parseInt(n);
					if (min > number) {
						min = number;
					}
				}
				System.out.println(min);
			} else {
				System.out.println(0);
			}
		}
		scan.close();
	}
}
