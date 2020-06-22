package jv.fundamentals.lists.lab;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a program that sum all numbers in a list in the following order: first
 * + last, first + 1 + last - 1, first + 2 + last - 2, … first + n, last - n.
 * 
 * @author Ivelin Gavrailov
 * @since 21.06.2020
 *
 */
public class GaussTrick {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		ArrayList<Integer> numbers = new ArrayList<>();
		for (String element : input) {
			numbers.add(Integer.parseInt(element));
		}
		gaussTrick(numbers);
		scan.close();

	}

	private static void gaussTrick(ArrayList<Integer> numbers) {
		String output = "";
		for (int i = 0; i < numbers.size() - 1; i++) {
			numbers.set(i, numbers.get(i) + numbers.get(numbers.size() - 1));
			numbers.remove(numbers.size() - 1);
		}
		for (Integer number : numbers) {
			output += number + " ";
		}
		System.out.println(output);
	}
}