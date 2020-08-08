package jv.advanced.stacks.and.queues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * We are given an arithmetical expression with brackets. Scan through the
 * string and extract each sub-expression. Print the result back at the
 * terminal.
 * 
 * @author Ivelin Gavrailov
 * @since 30.07.2020
 *
 */
public class MatchingBrackets {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String symbols = scan.nextLine();
		ArrayDeque<Integer> openingSymbol = new ArrayDeque<>();
		for (int i = 0; i < symbols.length(); i++) {
			if (symbols.charAt(i) == '(') {
				openingSymbol.push(i);
			} else if (symbols.charAt(i) == ')') {
				int beginIndex = openingSymbol.pop();
				String subExpression = symbols.substring(beginIndex, i + 1);
				System.out.println(subExpression);
			}
		}
		scan.close();
	}
}
