package jv.advanced.sets.and.maps.lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Write a program that prints information about food shops in Sofia and the
 * products they store. Until the "Revision" command you will receive an input
 * in the format: "{shop}, {product}, {price}" Take in mind that if you receive
 * a shop you already have received, you must collect its product information.
 * Your output must be ordered by shop name and must be in the format: {shop}->
 * Product: {product}, Price: {price} The price should be formated to one digit
 * after the decimal point.
 * 
 * @author Ivelin Gavrailov
 * @since 24.08.2020
 *
 */
public class ProductShop {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		TreeMap<String, LinkedHashMap<String, Double>> productShop = new TreeMap<>();
		String input = scan.nextLine();
		while (!"Revision".equalsIgnoreCase(input)) {
			String[] tokens = input.split(", ");
			String shop = tokens[0];
			String product = tokens[1];
			Double price = Double.parseDouble(tokens[2]);
			productShop.putIfAbsent(shop, new LinkedHashMap<>());
			LinkedHashMap<String, Double> thisShop = productShop.get(shop);
			thisShop.putIfAbsent(product, 0.0);
			thisShop.put(product, thisShop.get(product) + price);
			input = scan.nextLine();
		}
		for (Map.Entry<String, LinkedHashMap<String, Double>> entry : productShop.entrySet()) {
			System.out.println(entry.getKey() + "->");
			for (Map.Entry<String, Double> innerEntry : entry.getValue().entrySet()) {
				System.out.println(String.format("Product: %s, Price: %.1f", innerEntry.getKey(),innerEntry.getValue()));
			}
		}
		scan.close();
	}
}
