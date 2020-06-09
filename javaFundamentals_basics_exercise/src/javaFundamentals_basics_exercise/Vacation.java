package javaFundamentals_basics_exercise;

import java.util.Scanner;

public class Vacation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberOfPeople = Integer.parseInt(scan.nextLine());
		String typeOfPeople = scan.nextLine();
		String dayOfTheWeek = scan.nextLine();
		double price = 0.0;
		double totalPrice = 0.0;
		switch (dayOfTheWeek) {
		case "Friday":
			switch (typeOfPeople) {
			case "Students":
				price = 8.45;
				break;
			case "Business":
				price = 10.90;
				break;
			case "Regular":
				price = 15;
				break;
			}
			break;
		case "Saturday":
			switch (typeOfPeople) {
			case "Students":
				price = 9.80;
				break;
			case "Business":
				price = 15.60;
				break;
			case "Regular":
				price = 20;
				break;
			}
			break;
		case "Sunday":
			switch (typeOfPeople) {
			case "Students":
				price = 10.46;
				break;
			case "Business":
				price = 16;
				break;
			case "Regular":
				price = 22.50;
				break;
			}
			break;
		}
		totalPrice = price * numberOfPeople;
		if (typeOfPeople.equals("Students") && numberOfPeople >= 30) {
			totalPrice = totalPrice * 0.85;
		}
		if (typeOfPeople.equals("Business") && numberOfPeople >= 100) {
			totalPrice = totalPrice * 0.9;
		}
		if (typeOfPeople.equals("Regular") && numberOfPeople >= 10 && numberOfPeople <= 20) {
			totalPrice = totalPrice * 0.95;
		}
		System.out.print(String.format("Total price: %.2f", totalPrice));
	}

}
