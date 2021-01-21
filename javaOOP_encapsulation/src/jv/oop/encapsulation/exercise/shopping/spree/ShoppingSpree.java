package jv.oop.encapsulation.exercise.shopping.spree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Create two classes: class Person and class Product. Each person should have a
 * name, money and a bag of products. Each product should have name and cost.
 * Name cannot be an empty string. Be careful about white space in name. Money
 * and cost cannot be a negative number.
 * 
 * @author Ivelin Gavrailov
 * @since 15.01.2021
 *
 */
public class ShoppingSpree {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] tokensConsumers = Arrays.stream(scan.nextLine().split(";")).toArray(String[]::new);
		Map<String, Double> consumerMap = new HashMap<>();
		List<Person> people = new ArrayList<>();
		List<Product> products = new ArrayList<>();
		for (String s : tokensConsumers) {
			String[] input = s.split("=");
			consumerMap.put(input[0], Double.parseDouble(input[1]));
		}
		String[] tokensProducts = Arrays.stream(scan.nextLine().split(";")).toArray(String[]::new);
		Map<String, Double> productMap = new HashMap<>();
		for (String s : tokensProducts) {
			String[] input = s.split("=");
			productMap.put(input[0], Double.parseDouble(input[1]));
		}
		try {
			for (Map.Entry<String, Double> consumer : consumerMap.entrySet()) {
				Person person = new Person(consumer.getKey(), consumer.getValue());
				people.add(person);
			}
			for (Map.Entry<String, Double> p : productMap.entrySet()) {
				Product product = new Product(p.getKey(), p.getValue());
				products.add(product);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			scan.close();
			return;
		}
		String[] shopping = scan.nextLine().split("\\s+");
		while (!"END".equalsIgnoreCase(shopping[0])) {
			getPersonByName(people, shopping[0]).buyProduct(getProductByName(products, shopping[1]));
			shopping = scan.nextLine().split("\\s+");
		}

		for (Person p : people) {
			System.out.println(p);
		}
		scan.close();
	}

	private static Product getProductByName(List<Product> products, String name) {
		for (Product product : products) {
			if (product.getName().equals(name)) {
				return product;
			}
		}
		throw new IllegalStateException("There is no product with this name");

	}

	private static Person getPersonByName(List<Person> people, String name) {
		for (Person person : people) {
			if (person.getName().equals(name)) {
				return person;
			}
		}
		throw new IllegalStateException("There is no person with this name");
	}
}