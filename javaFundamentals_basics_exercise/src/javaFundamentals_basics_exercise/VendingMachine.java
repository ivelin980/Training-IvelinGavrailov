package javaFundamentals_basics_exercise;

import java.util.Scanner;

public class VendingMachine {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = "";
		double money = 0.0;
		double sum = 0.0;
		while (!input.equals("Start")) {
			input = scan.nextLine();
			switch (input) {
			case "0.1":
			case "0.2":
			case "0.5":
			case "1":
			case "2":
				money = Double.parseDouble(input);
				sum += money;
				break;
			case "Start":
				break;
			default:
				money = Double.parseDouble(input);
				System.out.println(String.format("Cannot accept %.2f", money));
			}
		}
		while (!input.equals("End")) {
			input = scan.nextLine();
			switch (input) {
			case "Nuts":
				sum -= 2.00;
				if (sum >= 0) {
					System.out.println(String.format("Purchased %s", input));
				} else {
					System.out.println("Sorry, not enough money");
					sum += 2.00;
				}
				break;
			case "Water":
				sum -= 0.70;
				if (sum >= 0) {
					System.out.println(String.format("Purchased %s", input));
				} else {
					System.out.println("Sorry, not enough money");
					sum += 0.70;
				}
				break;
			case "Crisps":
				sum -= 1.50;
				if (sum >= 0) {
					System.out.println(String.format("Purchased %s", input));
				} else {
					System.out.println("Sorry, not enough money");
					sum += 1.50;
				}
				break;
			case "Soda":
				sum -= 0.8;
				if (sum >= 0) {
					System.out.println(String.format("Purchased %s", input));
				} else {
					System.out.println("Sorry, not enough money");
					sum += 0.8;
				}
				break;
			case "Coke":
				sum -= 1.00;
				if (sum >= 0) {
					System.out.println(String.format("Purchased %s", input));
				} else {
					System.out.println("Sorry, not enough money");
					sum += 1.00;
				}
				break;
			case "End":
				break;
			default:
				System.out.println(String.format("Invalid product", input));
			}
		}
		System.out.println(String.format("Change: %.2f", sum));
		scan.close();
	}
}
