package jv.fundamentals.lists.exercise;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a program that reads sequence of numbers and special bomb number with a
 * certain power. Your task is to detonate every occurrence of the special bomb
 * number and according to its power his neighbors from left and right.
 * Detonations are performed from left to right and all detonated numbers
 * disappear. Finally print the sum of the remaining elements in the sequence.
 * 
 * @author Ivelin Gavrailov
 * @since 23.06.2020
 *
 */
public class BombNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split("\\s+");
		ArrayList<Integer> numbers = new ArrayList<>();
		for (String element : input) {
			numbers.add(Integer.parseInt(element));
		}
		String[] tokens = scan.nextLine().split("\\s+");
		int specialNumber = Integer.parseInt(tokens[0]);
		int power = Integer.parseInt(tokens[1]);
		removeElementsAroundOne(numbers, specialNumber, power);
		System.out.println(sumOfListElements(numbers));
		scan.close();
	}

	private static void removeElementsAroundOne(ArrayList<Integer> list, int number, int range) {
		while (list.contains(number)) {
			removeElementsOnRight(list, number, range);
			removeElementsOnLeft(list, number, range);
			list.remove(list.indexOf(number));
		}
	}

	private static int sumOfListElements(ArrayList<Integer> list) {
		int sum = 0;
		for (Integer number : list) {
			sum += number;
		}
		return sum;
	}

	private static void removeElementsOnRight(ArrayList<Integer> list, int number, int range) {
		int numberIndex = list.indexOf(number);
		int elementsOnRight = list.size() - 1 - list.indexOf(number);
		if (elementsOnRight < range) {
			for (int i = numberIndex + 1; i <= list.size() - 1; i++) {
				list.remove(numberIndex + 1);
			}
		} else {
			for (int i = numberIndex + 1; i <= numberIndex + range; i++) {
				list.remove(numberIndex + 1);
			}
		}
	}

	private static void removeElementsOnLeft(ArrayList<Integer> list, int number, int range) {
		int numberIndex = list.indexOf(number);
		if (numberIndex - range < 0) {
			for (int i = numberIndex - 1; i >= 0; i--) {
				list.remove(i);
			}
		} else {
			for (int i = numberIndex - 1; i >= numberIndex - range; i--) {
				list.remove(i);
			}
		}
	}
}
