package customlist;

import java.util.Scanner;

/**
 * Create a generic data structure that can store any type that can be compared.
 * Implement functions: • void add(T element) • T remove(int index) • boolean
 * contains(T element) • void swap(int index, int index) • int
 * countGreaterThan(T element) • T getMax() • T getMin() Create a command
 * interpreter that reads commands and modifies the custom list that you have
 * created. Implement the commands: • Add <element> - Adds the given element to
 * the end of the list • Remove <index> - Removes the element at the given index
 * • Contains <element> - Prints if the list contains the given element (true or
 * false) • Swap <index> <index> - Swaps the elements at the given indexes •
 * Greater <element> - Counts the elements that are greater than the given
 * element and prints their count • Max - Prints the maximum element in the list
 * • Min - Prints the minimum element in the list • Print - Prints all elements
 * in the list, each on a separate line • END - stops the reading of commands
 * Note: For the Judge tests, use String as T.
 * 
 * @author Ivelin Gavrailov
 * @since 11.11.2020
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CustomList<String> list = new CustomList<>();
		String[] input = scan.nextLine().split(" ");
		while (!"end".equalsIgnoreCase(input[0])) {
			switch (input[0].toLowerCase()) {
			case "add": {
				String element = input[1];
				list.add(element);
			}
				break;
			case "remove":
				int index = Integer.parseInt(input[1]);
				list.remove(index);
				break;
			case "contains": {
				String element = input[1];
				System.out.println(list.contains(element));
			}
				break;
			case "swap":
				int firstIndex = Integer.parseInt(input[1]);
				int secondIndex = Integer.parseInt(input[2]);
				list.swap(firstIndex, secondIndex);
				break;
			case "greater":
				String element = input[1];
				System.out.println(list.countGreaterThan(element));
				break;
			case "max":
				System.out.println(list.getMax());
				break;
			case "min":
				System.out.println(list.getMin());
				break;
			case "print":
				System.out.println(list.toString());
				break;
			default:
				break;
			}
			input = scan.nextLine().split(" ");
		}
		scan.close();
	}
}
