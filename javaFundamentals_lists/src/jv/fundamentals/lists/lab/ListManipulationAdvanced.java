package jv.fundamentals.lists.lab;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Now we will implement more complicated list commands. Again, read a list, and
 * until you receive "end" read commands: Contains {number} – check if the list
 * contains the number. If yes print "Yes", otherwise print "No such number"
 * Print even – print all the numbers that are even separated by a space Print
 * odd – print all the numbers that are odd separated by a space Get sum – print
 * the sum of all the numbers Filter ({condition} {number}) – print all the
 * numbers that fulfill that condition. The condition will be either '<', '>',
 * ">=", "<="
 * 
 * @author Ivelin Gavrailov
 * @since 21.06.2020
 *
 */
public class ListManipulationAdvanced {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		ArrayList<Integer> listNumbers = new ArrayList<>();
		for (String element : input) {
			listNumbers.add(Integer.parseInt(element));
		}
		manipulatingList(listNumbers, scan);
	}

	private static void manipulatingList(ArrayList<Integer> list, Scanner scan) {
		while (true) {
			String[] tokens = scan.nextLine().split(" ");
			if ("end".equals(tokens[0])) {
				break;
			}
			switch (tokens[0].toLowerCase()) {
			case "contains":
				if (list.contains(Integer.parseInt(tokens[1]))) {
					System.out.println("Yes");
				} else {
					System.out.println("No such number");
				}
				break;
			case "print":
				if (tokens[1].equals("even")) {
					for (int element : list) {
						if (element % 2 == 0) {
							System.out.print(element + " ");
						}
					}
					System.out.println();
				} else if (tokens[1].equals("odd")) {
					for (int element : list) {
						if (element % 2 != 0) {
							System.out.print(element + " ");
						}
					}
					System.out.println();
				}
				break;
			case "get":
				int sum = 0;
				for (int number : list) {
					sum += number;
				}
				System.out.println(sum);
			case "filter":
				switch (tokens[1]) {
				case ">":
					for (int number : list) {
						if (number > Integer.parseInt(tokens[2])) {
							System.out.print(number + " ");
						}
					}
					System.out.println();
					break;
				case "<":
					for (int number : list) {
						if (number < Integer.parseInt(tokens[2])) {
							System.out.print(number + " ");
						}
					}
					System.out.println();
					break;
				case ">=":
					for (int number : list) {
						if (number >= Integer.parseInt(tokens[2])) {
							System.out.print(number + " ");
						}
					}
					System.out.println();
					break;
				case "<=":
					for (int number : list) {
						if (number <= Integer.parseInt(tokens[2])) {
							System.out.print(number + " ");
						}
					}
					System.out.println();
					break;
				default:
					break;
				}
			}
		}
	}
}
