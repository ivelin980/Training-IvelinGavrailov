package jv.fundamentals.basics.exercise;

import java.util.Scanner;

/**
 * @author Ivelin Gavrailov 10.06.2020
 * 
 * You are given a group of people, type of the group, on which day of the week they are going to stay. 
 * Based on that information calculate how much they have to pay and print that price on the console. 
 * Use the table below. In each cell is the price for a single person. The output should look like that: 
 * "Total price: {price}". The price should be formatted to the second decimal point.
 *			Friday	Saturday	Sunday
Students	8.45	9.80		10.46
Business	10.90	15.60		16
Regular		15		20			22.50
There are also discounts based on some conditions:
•	Students – if the group is bigger than or equal to 30 people you should reduce the total price by 15%
•	Business – if the group is bigger than or equal to  100 people 10 of them can stay for free.
•	Regular – if the group is bigger than or equal 10 and less than or equal to 20 reduce the total price by 5% 
You should reduce the prices in that EXACT order


 */
public class Vacation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberOfPeople = Integer.parseInt(scan.nextLine());
		String typeOfPeople = scan.nextLine();
		String dayOfTheWeek = scan.nextLine();
		double price = 0.0;
		double totalPrice = 0.0;
		switch (dayOfTheWeek.toLowerCase()) {
		case "friday":
			switch (typeOfPeople.toLowerCase()) {
			case "students":
				price = 8.45;
				break;
			case "business":
				price = 10.90;
				break;
			case "regular":
				price = 15;
				break;
			}
			break;
		case "saturday":
			switch (typeOfPeople.toLowerCase()) {
			case "students":
				price = 9.80;
				break;
			case "business":
				price = 15.60;
				break;
			case "regular":
				price = 20;
				break;
			}
			break;
		case "sunday":
			switch (typeOfPeople.toLowerCase()) {
			case "students":
				price = 10.46;
				break;
			case "business":
				price = 16;
				break;
			case "regular":
				price = 22.50;
				break;
			}
			break;
		}
		totalPrice = price * numberOfPeople;
		if (typeOfPeople.toLowerCase().equals("students") && numberOfPeople >= 30) {
			totalPrice = totalPrice * 0.85;
		}
		if (typeOfPeople.toLowerCase().equals("business") && numberOfPeople >= 100) {
			totalPrice = totalPrice * 0.9;
		}
		if (typeOfPeople.toLowerCase().equals("regular") && numberOfPeople >= 10 && numberOfPeople <= 20) {
			totalPrice = totalPrice * 0.95;
		}
		System.out.print(String.format("Total price: %.2f", totalPrice));
		scan.close();
	}
}
