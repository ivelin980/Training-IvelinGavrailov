package jv.oop.working.with.abstracion.exercise.card.suit;

import java.util.Scanner;

/**
 * Create an enumeration type that has as its constants the four suits of a deck
 * of playing cards (CLUBS, DIAMONDS, HEARTS, SPADES). Iterate over the values
 * of the enumeration type and print all ordinal values and names.
 * 
 * @author Ivelin Gavrailov
 * @since 05.01.2021
 *
 */
public class CardSuit {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		if ("Card Suits".equalsIgnoreCase(input)) {
			System.out.println("Card Suits:");
			for (Cards card : Cards.values()) {
				System.out.println(String.format("Ordinal value: %d; Name value: %s", card.ordinal(), card.toString()));
			}
			scan.close();
		}
	}

}
