package javaFundamentals_basics_exercise;

import java.util.Scanner;

public class RageExpenses {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int lostGames = Integer.parseInt(scan.nextLine());
		double headsetPrice = Double.parseDouble(scan.nextLine());
		double mousePrice = Double.parseDouble(scan.nextLine());
		double keyboardPrice = Double.parseDouble(scan.nextLine());
		double displayPrice = Double.parseDouble(scan.nextLine());
		int trashedHeadset = lostGames / 2;
		int trashedMouse = lostGames / 3;
		int trashedKeyboard = lostGames / 6;
		int trashedDisplay = lostGames / 12;
		double expenses = trashedHeadset * headsetPrice + trashedKeyboard * keyboardPrice + trashedMouse * mousePrice
				+ trashedDisplay * displayPrice;
		System.out.println(String.format("Rage expenses: %.2f lv.", expenses));
	}

}
