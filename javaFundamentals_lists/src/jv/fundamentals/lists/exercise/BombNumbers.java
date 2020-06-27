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
		bombInList(numbers, specialNumber, power);
		scan.close();
	}

	private static void bombInList(ArrayList<Integer> list, int specialNumber, int power) {
		int sum = 0;
		while (list.contains(specialNumber)) {
			int specialNumberIndex = list.indexOf(specialNumber);
			if (list.size() - 1 - list.indexOf(specialNumber) > power) {
				for (int i = list.indexOf(specialNumber) + 1; i <= list.indexOf(specialNumber) + power; i++) {
					list.remove(i);
				}
			} else {
				for (int j = list.size() - 1; j > list.indexOf(specialNumber); j--) {
					list.remove(j);
				}
			}
			if (specialNumberIndex - power > 0) {

				for (int i = specialNumberIndex - 1; i >= specialNumberIndex - power; i--) {
					list.remove(i);
				}
			} else {
				for (int j = specialNumberIndex - 1; j >= 0; j--) {
					list.remove(j);
					specialNumberIndex--;
				}
			}
			list.remove(list.indexOf(specialNumber));
		}
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		System.out.println(sum);
	}
}
