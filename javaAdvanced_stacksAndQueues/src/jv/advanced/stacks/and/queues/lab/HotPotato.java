package jv.advanced.stacks.and.queues.lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Ivelin Gavrailov
 * @since 30.07.2020
 * 
 *        Hot potato is a game in which children form a circle and start passing
 *        a hot potato. The counting starts with the fist kid. Every nth toss
 *        the child left with the potato leaves the game. When a kid leaves the
 *        game, it passes the potato forward. This continues repeating until
 *        there is only one kid left. Create a program that simulates the game
 *        of Hot Potato. Print every kid that is removed from the circle. In the
 *        end, print the kid that is left last.
 *
 * 
 */
public class HotPotato {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayDeque<String> queue = Arrays.stream(scan.nextLine().split("\\s+"))
				.collect(Collectors.toCollection(ArrayDeque::new));
		int tosses = Integer.parseInt(scan.nextLine());
		int i = 1;
		while (queue.size() > 1) {
			String person = queue.poll();

			if (i == tosses) {
				System.out.println(String.format("Removed %s", person));
				i = 1;
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
}