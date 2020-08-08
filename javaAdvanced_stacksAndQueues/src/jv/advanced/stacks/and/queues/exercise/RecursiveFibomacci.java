package jv.advanced.stacks.and.queues.exercise;

import java.util.Scanner;

/**
 * Each member of the Fibonacci sequence is calculated from the sum of the two
 * previous members. The first two elements are 1, 1. Therefore the sequence
 * goes as 1, 1, 2, 3, 5, 8, 13, 21, 34… The following sequence can be generated
 * with an array, but that’s easy, so your task is to implement it recursively.
 * If the function getFibonacci(n) returns the nth Fibonacci number, we can
 * express it using getFibonacci(n) = getFibonacci(n-1) + getFibonacci(n-2).
 * However, this will never end and in a few seconds a Stack Overflow Exception
 * is thrown. In order for the recursion to stop it has to have a "bottom". The
 * bottom of the recursion is getFibonacci(1), and should return 1. The same
 * goes for getFibonacci(0).
 * 
 * @author Ivelin Gavrailov
 * @since 08.08.2020
 *
 */
public class RecursiveFibomacci {
	private static long[] memorization;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = Integer.parseInt(scan.nextLine());
		memorization = new long[input + 1];
		System.out.println(getFibonacci(input));
		scan.close();
	}

	private static long getFibonacci(int input) {
		if (input <= 2) {
			return input;
		}
		if (memorization[input] != 0) {
			return memorization[input];
		}
		return memorization[input] = getFibonacci(input - 1) + getFibonacci(input - 2);
	}
}
