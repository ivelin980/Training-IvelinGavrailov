package jv.fundamentals.arrays.exercise;

import java.util.Scanner;

/**
 * Write a program that finds the longest sequence of equal elements in an array
 * of integers. If several longest sequences exist, print the leftmost one.
 * 
 * @author Ivelin Gavrailov
 * @since 16.06.2020
 *
 */
public class MaxSequenceOfEqualElements {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] elements = scan.nextLine().split(" ");
		int streak = 1;
		int longestStreak = 0;
		int endIndex = -1;
		for (int i = 0; i < elements.length - 1; i++) {
			if (elements[i].equals(elements[i + 1])) {
				streak++;
				if (streak > longestStreak) {
					longestStreak = streak;
					endIndex = i + 1;
				}
			} else {
				streak = 1;
			}
		}
		for (int i = endIndex; i >= endIndex + 1 - longestStreak; i--) {
			System.out.print(elements[i] + " ");
		}
		scan.close();
	}
}
