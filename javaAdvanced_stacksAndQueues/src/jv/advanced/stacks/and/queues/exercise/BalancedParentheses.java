package jv.advanced.stacks.and.queues.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Given a sequence consisting of parentheses, determine whether the expression
 * is balanced. A sequence of parentheses is balanced if every open parenthesis
 * can be paired uniquely with a closed parenthesis that occurs after the
 * former. Also, the interval between them must be balanced. You will be given
 * three types of parentheses: (, {, and [. {[()]} - This is a balanced
 * parenthesis. {[(])} - This is not a balanced parenthesis.
 * 
 * @author Ivelin Gavrailov
 * @since 07.08.2020
 *
 */
public class BalancedParentheses {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		ArrayDeque<Character> stack = new ArrayDeque<>();
		ArrayDeque<Character> queue = new ArrayDeque<>();
		String result = "YES";
		for (int i = 0; i < input.length(); i++) {
			char n = input.charAt(i);
			switch (n) {
			case '{':
			case '[':
			case '(':
				stack.push(n);
				break;
			case '}':							
			case ']':								
			case ')':							  
				queue.offer(n);
				break;
			default:
				break;
			}
		}

		if (stack.size() != queue.size()) {
			result = "NO";
		} else {
			while (!stack.isEmpty()) {
				switch (stack.pop()) {
				case '{':
					if ('}' != queue.peek()) {
						result = "NO";
						break;
					} else {
						queue.poll();
					}
					break;
				case '[':
					if(']' != queue.peek()) {
						result = "NO";
						break;
					}
					else {
						queue.poll();
					}
					break;
				case '(':
					if(')' != queue.peek()) {
						result = "NO";
						break;
					}
					else {
						queue.poll();
					}
					break;
				default:
					break;
				}
			}
		}
		System.out.println(result);
		scan.close();
	}
}
