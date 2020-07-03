package jv.fundamentals.lists.lab;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a program that reads a list of integers. Then until you receive "end",
 * you will be given different commands: Add {number}: add a number to the end
 * of the list Remove {number}: remove number from the list RemoveAt {index}:
 * removes number at a given index Insert {number} {index}: inserts a number at
 * a given index Note: All the indices will be valid! When you receive the "end"
 * command print the final state of the list (separated by spaces)
 * 
 * @author Ivelin Gavrailov
 * @since 21.06.2020
 *
 */
public class ListManipulationBasics {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] array = scan.nextLine().split(" ");
		ArrayList<String> list = new ArrayList<>();
		for (String element : array) {
			list.add(element);
		}
		manipulateList(list, scan);
		scan.close();
	}

	private static void manipulateList(ArrayList<String> list, Scanner scan) {
		while (true) {
			String[] manipulation = scan.nextLine().split(" ");
			if (manipulation[0].equals("end")) {
				break;
			}
			switch (manipulation[0].toLowerCase()) {
			case "add": {
				String element = manipulation[1];
				list.add(element);
			}
				break;
			case "remove": {
				String element = manipulation[1];
				list.remove(element);
			}
				break;
			case "removeat": {
				int index = Integer.parseInt(manipulation[1]);
				list.remove(index);
			}
				break;
			case "insert": {
				String element = manipulation[1];
				int index = Integer.parseInt(manipulation[2]);
				list.add(index, element);
			}
				break;
			default:
				break;
			}
		}
		for (String element : list) {
			System.out.print(element + " ");
		}
	}
}
