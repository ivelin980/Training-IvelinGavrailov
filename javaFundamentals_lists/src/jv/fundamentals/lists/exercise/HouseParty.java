package jv.fundamentals.lists.exercise;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a program that keeps track of the guests that are going to a house
 * party. On the first input line you are going to receive how many commands you
 * are going to have. On the next lines you are going to receive some of the
 * following inputs: - “{name} is going!” - “{name} is not going!” If you
 * receive the first type of input, you have to add the person if he/she is not
 * in the list. (If he/she is in the list print on the console: “{name} is
 * already in the list!”). If you receive the second type of input, you have to
 * remove the person if he/she is in the list. (if not print: “{name} is not in
 * the list!”). At the end print all the guests.
 * 
 * @author Ivelin Gavrailov
 * @since 22.06.2020
 *
 */
public class HouseParty {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		ArrayList<String> guestsOfParty = new ArrayList<>();
		housePartyList(guestsOfParty, n, scan);
		scan.close();
	}

	private static void housePartyList(ArrayList<String> guestOfParty, int n, Scanner scan) {
		for (int i = 0; i < n; i++) {
			String[] tokens = scan.nextLine().split("\\s+");
			String name = tokens[0];
			if (tokens[2].equals("not")) {
				if (guestOfParty.contains(name)) {
					guestOfParty.remove(name);
				} else {
					System.out.println(String.format("%s is not in the list!", name));
				}
			} else if (tokens[2].equals("going!")) {
				if (guestOfParty.contains(name)) {
					System.out.println(String.format("%s is already in the list!", name));
				} else {
					guestOfParty.add(name);
				}
			}
		}
		for (String guest : guestOfParty) {
			System.out.println(guest);
		}
	}
}
