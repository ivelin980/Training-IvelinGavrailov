package jv.fundamentals.maps.exercise;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Write a program, which keeps information about products and their prices.
 * Each product has a name, a price and its quantity. If the product doesn’t
 * exist yet, add it with its starting quantity. If you receive a product, which
 * already exists increase its quantity by the input quantity and if its price
 * is different, replace the price as well. You will receive products’ names,
 * prices and quantities on new lines. Until you receive the command "buy", keep
 * adding items. When you do receive the command "buy", print the items with
 * their names and total price of all the products with that name. Input • Until
 * you receive "buy", the products come in the format: "{name} {price}
 * {quantity}". • The product data is always delimited by a single space. Output
 * • Print information about each product, following the format: "{productName}
 * -> {totalPrice}" • Format the average grade to the 2nd decimal place.
 * 
 * @author Ivelin Gavrailov
 * @since 07.07.2020
 *
 */
public class Orders {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split("\\s+");
		LinkedHashMap<String, ArrayList<Double>> products = new LinkedHashMap<>();
		while (!"buy".equalsIgnoreCase(input[0])) {
			String name = input[0];
			double price = Double.parseDouble(input[1]);
			double quantity = Double.parseDouble(input[2]);
			if (products.containsKey(name)) {
				double totalQuantity = products.get(name).get(1) + quantity;
				products.get(name).set(1, totalQuantity);
				products.get(name).set(0, price);
			} else {
				products.put(name, new ArrayList<>());
				products.get(name).add(price);
				products.get(name).add(quantity);

			}
			input = scan.nextLine().split("\\s+");
		}
		products.entrySet().stream().forEach(p -> System.out
				.print(String.format("%s -> %.2f%n", p.getKey(), p.getValue().get(1) * p.getValue().get(0))));
		scan.close();
	}
}
