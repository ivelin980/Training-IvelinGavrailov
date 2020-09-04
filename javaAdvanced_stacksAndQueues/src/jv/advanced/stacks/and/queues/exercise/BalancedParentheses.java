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
	
	public static final char CURLY_BRACKETS_OPEN = '{';
	public static final char SQUARE_BRACKETS_OPEN = '[';
	public static final char ROUND_BRACKETS_OPEN = '(';
	public static final char CURLY_BRACKETS_CLOSE = '}';
	public static final char SQUARE_BRACKETS_CLOSE = ']';
	public static final char ROUND_BRACKETS_CLOSE = ')';
	public static final String NEGATIVE_RESULT = "NO";
	public static final String POSITIVE_RESULT = "YES";
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		ArrayDeque<Character> stack = new ArrayDeque<>();
		ArrayDeque<Character> queue = new ArrayDeque<>();
		String result = POSITIVE_RESULT;
		for (int i = 0; i < input.length(); i++) {
			char n = input.charAt(i);
			switch (n) {
			case CURLY_BRACKETS_OPEN:
			case SQUARE_BRACKETS_OPEN:
			case ROUND_BRACKETS_OPEN:
				stack.push(n);
				break;
			case CURLY_BRACKETS_CLOSE:							
			case SQUARE_BRACKETS_CLOSE:								
			case ROUND_BRACKETS_CLOSE:							  
				queue.offer(n);
				break;
			default:
				break;
			}
		}

		if (stack.size() != queue.size()) {
			result = NEGATIVE_RESULT;
		} else {
			while (!stack.isEmpty()) {
				switch (stack.pop()) {
				case CURLY_BRACKETS_OPEN:
					if (CURLY_BRACKETS_CLOSE != queue.peek()) {
						result = NEGATIVE_RESULT;
						break;
					} else {
						queue.poll();
					}
					break;
				case SQUARE_BRACKETS_OPEN:
					if(SQUARE_BRACKETS_CLOSE != queue.peek()) {
						result = NEGATIVE_RESULT;
						break;
					}
					else {
						queue.poll();
					}
					break;
				case ROUND_BRACKETS_OPEN:
					if(ROUND_BRACKETS_CLOSE != queue.peek()) {
						result = NEGATIVE_RESULT;
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
