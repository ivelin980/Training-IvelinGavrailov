package jv.advanced.stacks.and.queues.lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Ivelin Gavrailov
 * @since 30.07.2020
 * 
 *        Rework the previous problem so that a child is removed only on a
 *        composite (not prime) cycle (cycles start from 1) If a cycle is prime,
 *        just print the child's name. As before, print the name of the child
 *        that is left last.
 * 
 * 
 */
public class MathPotato {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayDeque<String> queue = Arrays.stream(scan.nextLine().split("\\s+"))
				.collect(Collectors.toCollection(ArrayDeque::new));
		int tosses = Integer.parseInt(scan.nextLine());
		int i = 1;
		int counter = 1;
		while (queue.size() > 1) {
			String person = queue.poll();
			if (i == tosses) {
				if (isPrimeCountExecution(counter)) {
					System.out.println(String.format("Prime %s", person));
					queue.push(person);
				} else {
					System.out.println(String.format("Removed %s", person));
				}
				i = 1;
				counter++;
			} else {
				queue.offer(person);
				i += 1;
			}
		}
		if (queue.size() == 1) {
			System.out.println(String.format("Last is %s", queue.poll()));
		}
		scan.close();
	}

	private static boolean isPrimeCountExecution(int counter) {
		if (counter == 1) {
			return false;
		}
		for (int i = 2; i < counter; i++) {
			if (counter % i == 0) {
				return false;
			}
		}
		return true;
	}
}
