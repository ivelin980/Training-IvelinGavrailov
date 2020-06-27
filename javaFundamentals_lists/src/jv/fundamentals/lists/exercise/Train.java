package jv.fundamentals.lists.exercise;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * On the first line you will be given a list of wagons (integers). Each integer
 * represents the number of passengers that are currently in each wagon. On the
 * next line you will get the max capacity of each wagon (single integer). Until
 * you receive "end" you will be given two types of input: • Add {passengers} –
 * add a wagon to the end with the given number of passengers. • {passengers} -
 * find an existing wagon to fit all the passengers (starting from the first
 * wagon) At the end print the final state of the train (all the wagons
 * separated by a space)
 * 
 * @author Ivelin Gavrailov
 * @since 22.06.2020
 *
 */
public class Train {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		int maxCapacity = Integer.parseInt(scan.nextLine());
		ArrayList<Integer> train = new ArrayList<>();
		for (String element : input) {
			train.add(Integer.parseInt(element));
		}
		manipulatingTrainData(train, maxCapacity, scan);
		scan.close();
	}

	private static void manipulatingTrainData(ArrayList<Integer> train, int capacity, Scanner scan) {
		while (true) {
			String[] tokens = scan.nextLine().split(" ");
			if (tokens[0].equalsIgnoreCase("end")) {
				break;
			} else if (tokens[0].equalsIgnoreCase("add")) {
				train.add(Integer.parseInt(tokens[1]));
			} else {
				for (int i = 0; i < train.size(); i++) {
					int total = Integer.parseInt(tokens[0]) + train.get(i);
					if (total <= capacity) {
						train.set(i, total);
						break;
					}
				}
			}
		}
		for (Integer wagon : train) {
			System.out.print(wagon + " ");
		}
	}
}