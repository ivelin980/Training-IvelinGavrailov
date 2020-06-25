package jv.fundamentals.methods.lab;

import java.util.Scanner;

/**
 * Write a method that calculates the total price of an order and prints it on
 * the console. The method should receive one of the following products: coffee,
 * water, coke, snacks; and a quantity of the product. The prices for a single
 * piece of each product are: • coffee – 1.50 • water – 1.00 • coke – 1.40 •
 * snacks – 2.00 Print the result rounded to the second decimal place.
 * 
 * @author Ivelin Gavrailov
 * @since 17.06.2020
 *
 */
public class Orders {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String product = scan.nextLine();
		int quantity = Integer.parseInt(scan.nextLine());
		printOrderPrice(product, quantity);
		scan.close();
	}

	private static void printOrderPrice(String product, int quantity) {
		double price = 0;
		switch (product.toLowerCase()) {
		case "coffee":
			price = 1.50;
			break;
		case "water":
			price = 1;
			break;
		case "coke":
			price = 1.40;
			break;
		case "snacks":
			price = 2.00;
			break;
		}
		double totalPrice = price * quantity;
		System.out.println(String.format("%.2f", totalPrice));
	}
}
