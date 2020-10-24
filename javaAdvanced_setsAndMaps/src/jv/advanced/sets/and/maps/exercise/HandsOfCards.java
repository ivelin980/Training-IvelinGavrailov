package jv.advanced.sets.and.maps.exercise;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * You are given a sequence of people and for every person what cards he draws
 * from the deck. The input will be separate lines in the format: {personName}:
 * {PT, PT, PT,… PT} Where P (2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A) is the
 * power of the card and T (S, H, D, C) is the type. The input ends when a
 * "JOKER" is drawn. The name can contain any ASCII symbol except ':'. The input
 * will always be valid and in the format described, there is no need to check
 * it. A single person cannot have more than one card with the same power and
 * type, if he draws such a card he discards it. The people are playing with
 * multiple decks. Each card has a value that is calculated by the power
 * multiplied by the type. Powers 2 to 10 have the same value and J to A are 11
 * to 14. Types are mapped to multipliers the following way (S -> 4, H-> 3, D ->
 * 2, C -> 1). Finally print out the total value each player has in his hand in
 * the format: {personName}: {value}
 * 
 * @author Ivelin Gavrailov
 * @since 26.08.2020
 *
 */
public class HandsOfCards {
	private static final String COLON = ":";
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		LinkedHashMap<String,ArrayList<String>> player = new LinkedHashMap<>();
		while (!"JOKER".equalsIgnoreCase(input)) {
			String name = input.substring(0, input.indexOf(COLON));
			String cardsInput = input.substring(input.indexOf(COLON) + 2, input.length());
			String[] cards = cardsInput.split(", ");
			for (String card : cards) {				
				player.putIfAbsent(name, new ArrayList<>());
				if(!player.get(name).contains(card)) {					
					player.get(name).add(card);
				}
			}
			input = scan.nextLine();
		}
		for (Map.Entry<String, ArrayList<String>> entry : player.entrySet()) {
			System.out.println(entry.getKey() + COLON + " " + getCardsPower(entry.getValue()));
		}
		scan.close();
	}

	private static int getCardsPower(ArrayList<String> cards) {
		int sum = 0;
		for (String card : cards) {
			sum += getCardPower(card);
		}
		return sum;
	}

	private static int getCardPower(String card) {
		String power = card.substring(0,card.length()-1);
		char type = card.charAt(card.length()-1);
		int powerValue = 0;
		int typeValue = 0;
		if (Character.isAlphabetic(power.charAt(0))) {
			switch (power) {
			case "J":
				powerValue = 11;
				break;
			case "Q":
				powerValue = 12;
				break;
			case "K":
				powerValue = 13;
				break;
			case "A":
				powerValue = 14;
				break;
			default:
				break;
			}
		} else {
			powerValue = Integer.parseInt(power);
		}
		switch (type) {
		case 'S':
			typeValue = 4;
			break;
		case 'H':
			typeValue = 3;
			break;
		case 'D':
			typeValue = 2;
			break;
		case 'C':
			typeValue = 1;
			break;
		default:
			break;
		}
		return powerValue * typeValue;
	}
}
