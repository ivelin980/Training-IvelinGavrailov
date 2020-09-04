package jv.advanced.stacks.and.queues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Write a program which takes 2 types of browser instructions: • Normal
 * navigation: a URL is set, given by a string • The string "back" that sets the
 * current URL to the last set URL After each instruction the program should
 * print the current URL. If the back instruction can’t be executed, print "no
 * previous URLs". The input ends with "Home" command, then simply you have to
 * stop the program.
 * 
 * @author Ivelin Gavrailov
 * @since 29.07.2020
 *
 */
public class BrowserHistory {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayDeque<String> stack = new ArrayDeque<>();

		String navigation = scan.nextLine();
		String currentPage = "";
		while (!"home".equalsIgnoreCase(navigation)) {
			if ("back".equalsIgnoreCase(navigation)) {
				if (stack.isEmpty()) {
					System.out.println("no previous URLs");
				} else {
					currentPage = stack.pop();
					System.out.println(currentPage);
				}
			} else {
				if (!currentPage.isBlank()) {
					stack.push(currentPage);
				}
				System.out.println(navigation);
				currentPage = navigation;
			}
			navigation = scan.nextLine();
		}
		scan.close();
	}
}
