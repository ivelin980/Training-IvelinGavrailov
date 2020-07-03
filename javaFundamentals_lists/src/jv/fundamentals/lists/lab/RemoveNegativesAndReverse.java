package jv.fundamentals.lists.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Read a list of integers, remove all negative numbers from it and print the
 * remaining elements in reversed order. In case of no elements left in the
 * list, print "empty".
 * 
 * @author Ivelin Gavrailov
 * @since 22.06.2020
 *
 */
public class RemoveNegativesAndReverse {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		ArrayList<Integer> numberList = new ArrayList<>();
		for (String element : input) {
			numberList.add(Integer.parseInt(element));
		}
		reverseListWithoutNegatives(numberList);
		scan.close();
	}

	private static void reverseListWithoutNegatives(ArrayList<Integer> list) {
		list.removeIf(n -> n < 0);
		if (!list.isEmpty()) {
			Collections.reverse(list);
			for (Integer number : list) {
				System.out.print(number + " ");
			}
		} else {
			System.out.println("empty");
		}
	}
}
