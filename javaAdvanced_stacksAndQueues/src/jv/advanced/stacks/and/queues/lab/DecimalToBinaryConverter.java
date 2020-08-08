package jv.advanced.stacks.and.queues.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Create a simple program that can convert a decimal number to its binary
 * representation. Implement an elegant solution using a Stack. Print the binary
 * representation back at the terminal.
 * 
 * @author Ivelin Gavrailov
 * @since 30.06.2020
 *
 */
public class DecimalToBinaryConverter {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int decimal = Integer.parseInt(scan.nextLine());
		if (decimal == 0) {
			System.out.println(decimal);
			scan.close();
			return;
		}
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		while (decimal != 0) {
			stack.push(decimal % 2);
			decimal /= 2;
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		scan.close();
	}
}
