package exercise.listyiterator;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Create a class "ListyIterator", it should receive the collection of Strings
 * which it will iterate, through its constructor. You should store the elements
 * in a List. The class should have three main functions: • Move - should move
 * an internal index position to the next index in the list, the method should
 * return true if it successfully moved and false if there is no next index. •
 * HasNext - should return true if there is a next index and false if the index
 * is already at the last element of the list. • Print - should print the
 * element at the current internal index, calling Print on a collection without
 * elements should throw an appropriate exception with the message "Invalid
 * Operation!". By default, the internal index should be pointing to the 0th
 * index of the List. Your program should support the following commands:
 * 
 * @author Ivelin Gavrailov
 * @since 20.11.2020
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		if ("create".equalsIgnoreCase(input[0]) && input.length > 1) {
			String[] array = Arrays.copyOfRange(input, 1, input.length);
			ListyIterator<String> list = new ListyIterator<>(array);
			input = scan.nextLine().split(" ");
			while (!"end".equalsIgnoreCase(input[0])) {
				switch (input[0].toLowerCase()) {
				case "move":
					System.out.println(list.move());
					break;
				case "print":
					list.print();
					break;
				case "hasnext":
					System.out.println(list.hasNext());
					break;
				case "end":
					break;
				default:
					break;
				}
				input = scan.nextLine().split(" ");
			}
		} else {
			System.out.println("Invalid Operation!");
		}
		scan.close();
	}
}
