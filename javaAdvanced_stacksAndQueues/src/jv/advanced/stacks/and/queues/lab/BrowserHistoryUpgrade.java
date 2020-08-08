package jv.advanced.stacks.and.queues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Extend "Browser History" with a "forward" instruction which visits URLs that
 * were navigated away from by "back" Each forward instruction visits the next
 * most-recent such URL. If a normal navigation happens, all potential forward
 * URLs are removed until a new back instruction is given If the forward
 * instruction can’t be executed, print "no next URLs".
 * 
 * @author Ivelin Gavrailov
 * @since 04.08.2020
 *
 */
public class BrowserHistoryUpgrade {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayDeque<String> stack = new ArrayDeque<>();
		ArrayDeque<String> queue = new ArrayDeque<>();
		String navigation = scan.nextLine();
		navigation = navigation.replaceAll("\\s+", "");
		String currentPage = "";
		while (!"home".equalsIgnoreCase(navigation)) {
			if (navigation.isEmpty()) {
				navigation = scan.nextLine();
			}
			if ("back".equalsIgnoreCase(navigation)) {
				if (stack.isEmpty()) {
					System.out.println("no previous URLs");
				} else {
					if (!currentPage.isEmpty()) {
						queue.offer(currentPage);
					}
					currentPage = stack.pop();
					System.out.println(currentPage);
				}
			} else if ("forward".equalsIgnoreCase(navigation)) {
				if (queue.isEmpty()) {
					System.out.println("no next URLs");
				} else {
					if (!currentPage.isEmpty()) {
						stack.push(currentPage);
					}
					currentPage = queue.pollLast();
					System.out.println(currentPage);
				}
			} else {
				if (!currentPage.isEmpty()) {
					stack.push(currentPage);
					queue.clear();
				}
				System.out.println(navigation);
				currentPage = navigation;
			}
			navigation = scan.nextLine();
			navigation = navigation.replaceAll("\\s+", "");
		}
		scan.close();
	}
}