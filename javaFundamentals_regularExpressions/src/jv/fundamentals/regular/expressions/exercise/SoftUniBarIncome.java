package jv.fundamentals.regular.expressions.exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Let`s take a break and visit the game bar at SoftUni. It is about time for
 * the people behind the bar to go home and you are the person who has to draw
 * the line and calculate the money from the products that were sold throughout
 * the day. Until you receive a line with text "end of shift" you will be given
 * lines of input. But before processing that line you have to do some
 * validations first. Each valid order should have a customer, product, count
 * and a price: • Valid customer's name should be surrounded by '%' and must
 * start with a capital letter, followed by lower-case letters • Valid product
 * contains any word character and must be surrounded by '<' and '>' • Valid
 * count is an integer, surrounded by '|' • Valid price is any real number
 * followed by '$' The parts of a valid order should appear in the order given:
 * customer, product, count and a price. Between each part there can be other
 * symbols, except ('|', '$', '%' and '.') For each valid line print on the
 * console: "{customerName}: {product} - {totalPrice}" When you receive "end of
 * shift" print the total amount of money for the day rounded to 2 decimal
 * places in the following format: "Total income: {income}".
 * 
 * @author Ivelin Gavrailov
 * @since 16.07.2020
 *
 */
public class SoftUniBarIncome {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String regex = "\\%(?<name>[A-Z][a-z]+)\\%\\<(?<product>[A-Z][a-z]+)\\>([^\\|\\%\\.\\$]+)?\\|(?<quantity>[0-9]+)\\|([^\\|\\%\\.\\$\\d]+)?(?<price>[0-9]+\\.?[0-9]+)?\\$";
		String input = scan.nextLine();
		LinkedHashMap<String, Customer> products = new LinkedHashMap<>();
		Pattern pattern = Pattern.compile(regex);
		double[] totalIncome = { 0.0 };
		while (!"end of shift".equalsIgnoreCase(input)) {
			Matcher match = pattern.matcher(input);
			while (match.find()) {
				String name = match.group("name");
				String product = match.group("product");
				int quantity = Integer.parseInt(match.group("quantity"));
				double price = Double.parseDouble(match.group("price"));
				if (!products.containsKey(name)) {
					products.put(name, new Customer(product, quantity * price));
				}
			}
			input = scan.nextLine();
		}
		products.entrySet().stream()
				.forEach(c -> System.out.println(String.format("%s: %s", c.getKey(), c.getValue())));
		products.entrySet().stream().forEach(c -> totalIncome[0] += c.getValue().getTotalPrice());
		System.out.println(String.format("Total income: %.2f", totalIncome[0]));
		scan.close();
	}
}

class Customer {
	private String product;
	private double totalPrice;

	public Customer(String product, double totalPrice) {
		this.product = product;
		this.totalPrice = totalPrice;
	}

	public String getProduct() {
		return product;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	@Override
	public String toString() {
		return String.format("%s - %.2f", product, totalPrice);
	}
}
