package jv.fundamentals.lists.exercise;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * You will be given a list of integer numbers on the first input line. Until
 * you receive "End" you will be given operations you have to apply on the list.
 * The possible commands are: • Add {number} – add number at the end • Insert
 * {number} {index}” – insert number at given index • Remove {index} – remove at
 * index • Shift left {count} – first number becomes last ‘count’ times • Shift
 * right {count} – last number becomes first ‘count’ times Note: it is possible
 * that the index given is outside of the bounds of the array. In that case
 * print "Invalid index"
 * 
 * @author Ivelin Gavrailov
 * @since 23.06.2020
 *
 */
public class ListOperations {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		ArrayList<String> numbers = new ArrayList<>();
		for (String element : input) {
			numbers.add(element);
		}
		listOperations(numbers, scan);
		scan.close();
	}

	private static void listOperations(ArrayList<String> numbers, Scanner scan) {
		while (true) {
			String[] tokens = scan.nextLine().split("\\s+");
			String command = tokens[0];
			if (command.equalsIgnoreCase("end")) {
				break;
			}
			switch (command.toLowerCase()) {
			case "add":
				numbers.add(tokens[1]);
				break;
			case "insert": {
				int index = Integer.parseInt(tokens[2]);
				if (index>=0 && index<numbers.size()) {
					String element = tokens[1];
					numbers.add(index, element);
				} else {
					System.out.println("Invalid index");
				}
			}
				break;
			case "remove":
				int index = Integer.parseInt(tokens[1]);
				if (index>=0 && index<numbers.size()) {
					numbers.remove(index);
				} else {
					System.out.println("Invalid index");
				}
				break;
			case "shift":
				String direction = tokens[1];
				int count = Integer.parseInt(tokens[2]);
				if (direction.equalsIgnoreCase("left")) {
					shiftLeft(numbers, count);
				}
				if (direction.equalsIgnoreCase("right")) {
					shiftRight(numbers, count);
				}
				break;
			default:
				break;
			}
		}
		for (String element : numbers) {
			System.out.print(element + " ");
		}
	}

	private static void shiftLeft(ArrayList<String> list, int count) {
		for (int i = 0; i < count; i++) {
			String temp = list.get(0);
			for (int j = 0; j < list.size() - 1; j++) {
				String nextElement = list.get(j + 1);
				list.set(j, nextElement);
			}
			list.set(list.size() - 1, temp);
		}
	}

	private static void shiftRight(ArrayList<String> list, int count) {
		for (int i = list.size() - 1; i > list.size() - 1 - count; i--) {
			String temp = list.get(list.size() - 1);
			for (int j = list.size() - 2; j >= 0; j--) {
				String previousElement = list.get(j);
				list.set(j + 1, previousElement);
			}
			list.set(0, temp);
		}
	}
}
