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
		manipulatingList(list, scan);
		scan.close();
	}

	private static void manipulatingList(ArrayList<String> list, Scanner scan) {
		while (true) {
			String[] manipulation = scan.nextLine().split(" ");
			if (manipulation[0].equals("end")) {
				break;
			}
			switch (manipulation[0]) {
			case "Add": {
				String element = manipulation[1];
				list.add(element);
			}
				break;
			case "Remove": {
				String element = manipulation[1];
				list.remove(element);
			}
				break;
			case "RemoveAt": {
				int index = Integer.parseInt(manipulation[1]);
				list.remove(index);
			}
				break;
			case "Insert": {
				String element = manipulation[1];
				int index = Integer.parseInt(manipulation[2]);
				list.add(index, element);
			}
				break;
			default:
				break;
			}
		}
		String output = "";
		for (String element : list) {
			output += element + " ";
		}
		System.out.println(output);
	}
}
