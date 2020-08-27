package jv.advanced.sets.and.maps.lab;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * There is a party in SoftUni. Many guests are invited and they are two types:
 * VIP and regular. When guest come check if he/she exist in any of two
 * reservation lists. All reservation numbers will be with 8 chars. All VIP
 * numbers start with digit. There will be 2 command lines. First is "PARTY" -
 * party is on and guests start coming. Second is "END" – then party is over and
 * no more guest will come. Output shows all guests, who didn't come to the
 * party (VIP must be first).
 * 
 * @author Ivelin Gavrailov
 * @since 21.08.2020
 *
 */
public class SoftUniParty {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		TreeSet<String> vip = new TreeSet<>();
		TreeSet<String> regular = new TreeSet<>();
		while (!"Party".equalsIgnoreCase(input)) {
			if (Character.isDigit(input.charAt(0))) {
				vip.add(input);
			} else {
				regular.add(input);
			}
			input = scan.nextLine();
		}
		input = scan.nextLine();
		while (!"End".equalsIgnoreCase(input)) {
			if (Character.isDigit(input.charAt(0))) {
				vip.remove(input);
			} else {
				regular.remove(input);
			}
			input = scan.nextLine();
		}
		System.out.println(vip.size() + regular.size());
		for (String guest : vip) {
			System.out.println(guest);
		}
		for (String guest : regular) {
			System.out.println(guest);
		}
		scan.close();
	}
}
