package jv.fundamentals.lists.exercise;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * You will be given two hands of cards, which will be integer numbers. Assume
 * that you have two players. You have to find out the winning deck and
 * respectively the winner. You start from the beginning of both hands. Compare
 * the cards from the first deck to the cards from the second deck. The player,
 * who has the bigger card, takes both cards and puts them at the back of his
 * hand - the second player’s card is last, and the first person’s card (the
 * winning one) is before it (second to last) and the player with the smaller
 * card must remove the card from his deck. If both players’ cards have the same
 * values - no one wins, and the two cards must be removed from the decks. The
 * game is over, when one of the decks is left without any cards. You have to
 * print the winner on the console and the sum of the left cards: "Player
 * {one/two} wins! Sum: {sum}".
 * 
 * @author Ivelin Gavrailov
 * @since 24.06.2020
 *
 */
public class CardsGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] firstInput = scan.nextLine().split("\\s+");
		String[] secondInput = scan.nextLine().split("\\s+");
		ArrayList<Integer> playerOneCards = new ArrayList<>();
		ArrayList<Integer> playerTwoCards = new ArrayList<>();
		for (String element : firstInput) {
			playerOneCards.add(Integer.parseInt(element));
		}
		for (String element : secondInput) {
			playerTwoCards.add(Integer.parseInt(element));
		}
		cardsGame(playerOneCards, playerTwoCards);
		scan.close();
	}

	private static void cardsGame(ArrayList<Integer> playerOneCards, ArrayList<Integer> playerTwoCards) {
		int index = 0;
		int sum = 0;
		while (!playerOneCards.isEmpty() && !playerTwoCards.isEmpty()) {
			if (playerOneCards.get(index) > playerTwoCards.get(index)) {
				playerOneCards.add(playerOneCards.get(index));
				playerOneCards.add(playerTwoCards.get(index));
				playerTwoCards.remove(index);
				playerOneCards.remove(index);
			} else if (playerOneCards.get(index) < playerTwoCards.get(index)) {
				playerTwoCards.add(playerTwoCards.get(index));
				playerTwoCards.add(playerOneCards.get(index));
				playerOneCards.remove(index);
				playerTwoCards.remove(index);
			} else {
				playerOneCards.remove(index);
				playerTwoCards.remove(index);
			}
		}
		if (!playerOneCards.isEmpty()) {
			for (Integer card : playerOneCards) {
				sum += card;
			}
			System.out.println(String.format("First player wins! Sum: %d", sum));
		} else {
			for (Integer card : playerTwoCards) {
				sum += card;
			}
			System.out.println(String.format("Second player wins! Sum: %d", sum));
		}
	}
}
