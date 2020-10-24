package jv.advanced.sets.and.maps.lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Write program that: Read 20 numbers for both players Numbers will be Integer,
 * separated with " " (single space). Every player can hold only unique numbers
 * Each Round both players get the top number from their own deck. Player with
 * the bigger number get both numbers and add it on the bottom of his own
 * sequence Game ends after 50 rounds or if any player lose all of his numbers
 * Output must be "First Player Win!", "Second Player Win!" or "Draw!"
 * 
 * @author Ivelin Gavrailov
 * @since 21.08.2020
 *
 */
public class VoinaNumberGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedHashSet<Integer> firstPlayerCards = Arrays.stream(scan.nextLine().split("\\s+"))
				.mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(LinkedHashSet::new));
		LinkedHashSet<Integer> secondPlayerCards = Arrays.stream(scan.nextLine().split("\\s+"))
				.mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(LinkedHashSet::new));
		int round = 50;
		while (round-- > 0) {
			int firstNumber = firstPlayerCards.iterator().next();
			firstPlayerCards.remove(firstNumber);

			int secondNumber = secondPlayerCards.iterator().next();
			secondPlayerCards.remove(secondNumber);

			if (firstNumber > secondNumber) {
				firstPlayerCards.add(firstNumber);
				firstPlayerCards.add(secondNumber);
			} else if(secondNumber > firstNumber){
				secondPlayerCards.add(firstNumber);
				secondPlayerCards.add(secondNumber);
			}

			if (firstPlayerCards.isEmpty() || secondPlayerCards.isEmpty()) {
				break;
			}
		}
		String output = "Draw";
		if (firstPlayerCards.size() > secondPlayerCards.size()) {
			output = "First player win!";
		} else if (firstPlayerCards.size() < secondPlayerCards.size()) {
			output = "Second player win!";
		}
		System.out.println(output);
		scan.close();
	}
}
