package jv.fundamentals.lists.exercise;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a program, which reads a list of integers from the console and receives
 * commands, which manipulate the list. Your program may receive the following
 * commands: • Delete {element} – delete all elements in the array, which are
 * equal to the given element • Insert {element} {position} – insert element and
 * the given position You should stop the program when you receive the command
 * "end". Print all numbers in the array separated with single whitespace.
 * 
 * @author Ivelin Gavrailov
 * @since 22.06.2020
 *
 */
public class ChangeList {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split("\\s+");
		ArrayList<Integer> numberList = new ArrayList<>();
		for (String element : input) {
			numberList.add(Integer.parseInt(element));
		}
		changeList(numberList, scan);
		scan.close();
	}

	private static void changeList(ArrayList<Integer> numberList, Scanner scan) {
		while (true) {
			String[] tokens = scan.nextLine().split("\\s+");
			if (tokens[0].equalsIgnoreCase("end")) {
				break;
			}
			switch (tokens[0].toLowerCase()) {
			case "delete":
				numberList.removeIf(number -> number == Integer.parseInt(tokens[1]));
				break;
			case "insert":
				int element = Integer.parseInt(tokens[1]);
				int index = Integer.parseInt(tokens[2]);
				if(index < numberList.size()) {
				numberList.add(index, element);
				}
				break;
			default:
				break;
			}
		}
		for (Integer number : numberList) {
			System.out.print(number + " ");
		}
	}
}
