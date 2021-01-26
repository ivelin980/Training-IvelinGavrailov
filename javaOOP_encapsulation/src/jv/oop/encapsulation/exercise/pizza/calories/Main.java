package jv.oop.encapsulation.exercise.pizza.calories;

import java.util.Arrays;
import java.util.Scanner;

/**
 * A Pizza is made of a dough and different toppings. You should model a class
 * Pizza which should have a name, dough and toppings as fields. Every type of
 * ingredient should have its own class.Every ingredient has different fields:
 * the dough can be white or wholegrain and in addition it can be crispy, chewy
 * or homemade. The toppings can be of type meat, veggies, cheese or sauce.
 * Every ingredient should have a weight in grams and a method for calculating
 * its calories according its type. Calories per gram are calculated through
 * modifiers. Every ingredient has 2 calories per gram as a base and a modifier
 * that gives the exact calories.Your job is to model the classes in such a way
 * that they are properly encapsulated and to provide a public method for every
 * pizza that calculates its calories according to the ingredients it has.
 * 
 * @author Ivelin Gavrailov
 * @since 21.01.2021
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] tokens = Arrays.stream(scan.nextLine().split("\\s+")).toArray(String[]::new);
		try {
			Pizza pizza = new Pizza(tokens[1], Integer.parseInt(tokens[2]));
			tokens = Arrays.stream(scan.nextLine().split("\\s+")).toArray(String[]::new);
			Dough dough = new Dough(tokens[1], tokens[2], Double.parseDouble(tokens[3]));
			pizza.setDough(dough);
			String input = scan.nextLine();
			while (!"end".equalsIgnoreCase(input)) {
				tokens = input.split("\\s+");
				Topping topping = new Topping(tokens[1], Double.parseDouble(tokens[2]));
				pizza.addToping(topping);
				input = scan.nextLine();
			}
			System.out.println(pizza);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		scan.close();
	}
}
