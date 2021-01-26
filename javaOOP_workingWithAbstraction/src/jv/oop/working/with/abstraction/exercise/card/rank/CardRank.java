package jv.oop.working.with.abstraction.exercise.card.rank;

import java.util.Scanner;

/**
 * Create an enumeration type that has as its constants the fourteen ranks of a
 * deck of playing cards (ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE,
 * TEN, JACK, QUEEN, KING). Iterate over the values of the enumeration type and
 * print all ordinal values and names.
 * 
 * @author Ivelin Gavrailov
 * @since 05.01.2021
 *
 */
public class CardRank {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		if ("Card Ranks".equalsIgnoreCase(scan.nextLine())) {
			System.out.println("Card Ranks:");
			for (Cards card : Cards.values()) {
				System.out.println(String.format("Ordinal value: %d; Name value: %s", card.ordinal(), card.toString()));
			}
		}
		scan.close();
	}
}
