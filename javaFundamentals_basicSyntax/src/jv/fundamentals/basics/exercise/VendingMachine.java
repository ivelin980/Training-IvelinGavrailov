package jv.fundamentals.basics.exercise;

import java.util.Scanner;

public class VendingMachine {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = "";
		double money = 0.0;
		double sum = 0.0;
		while (!input.toLowerCase().equals("start")) {
			input = scan.nextLine();
			switch (input.toLowerCase()) {
			case "0.1":
			case "0.2":
			case "0.5":
			case "1":
			case "2":
				money = Double.parseDouble(input);
				sum += money;
				break;
			case "start":
				break;
			default:
				money = Double.parseDouble(input);
				System.out.println(String.format("Cannot accept %.2f", money));
			}
		}
		while (!input.toLowerCase().equals("end")) {
			input = scan.nextLine();
			switch (input.toLowerCase()) {
			case "nuts":
				sum -= 2.00;
				if (sum >= 0) {
					System.out.println(String.format("Purchased %s", input));
				} else {
					System.out.println("Sorry, not enough money");
					sum += 2.00;
				}
				break;
			case "water":
				sum -= 0.70;
				if (sum >= 0) {
					System.out.println(String.format("Purchased %s", input));
				} else {
					System.out.println("Sorry, not enough money");
					sum += 0.70;
				}
				break;
			case "crisps":
				sum -= 1.50;
				if (sum >= 0) {
					System.out.println(String.format("Purchased %s", input));
				} else {
					System.out.println("Sorry, not enough money");
					sum += 1.50;
				}
				break;
			case "soda":
				sum -= 0.8;
				if (sum >= 0) {
					System.out.println(String.format("Purchased %s", input));
				} else {
					System.out.println("Sorry, not enough money");
					sum += 0.8;
				}
				break;
			case "coke":
				sum -= 1.00;
				if (sum >= 0) {
					System.out.println(String.format("Purchased %s", input));
				} else {
					System.out.println("Sorry, not enough money");
					sum += 1.00;
				}
				break;
			case "end":
				break;
			default:
				System.out.println(String.format("Invalid product", input));
			}
		}
		System.out.println(String.format("Change: %.2f", sum));
		scan.close();
	}
}
