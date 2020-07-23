package jv.fundamentals.regular.expressions.exercise;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a program to calculate the total cost of different types of furniture.
 * You will be given some lines of input until you receive the line "Purchase".
 * For the line to be valid it should be in the following format: ">>{furniture
 * name}<<{price}!{quantity}" The price can be a floating-point number or a
 * whole number. Store the names of the furniture and the total price. At the
 * end print each bought furniture on a separate line in the format: "Bought
 * furniture: {1st name} {2nd name} …" And on the last line print the following:
 * "Total money spend: {spend money}" formatted to the second decimal point.
 * 
 * @author Ivelin Gavrailov
 * @since 16.07.2020
 *
 */
public class Furniture {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String regex = ">>(?<furniture>\\w+)<<(?<price>[0-9]+\\.?[0-9]+)\\!(?<quantity>[0-9]+)";
		Pattern pattern = Pattern.compile(regex);
		ArrayList<String> furnitureNames = new ArrayList<>();
		double totalPrice = 0;
		while (!"Purchase".equalsIgnoreCase(input)) {
			Matcher matcher = pattern.matcher(input);
			if (matcher.find()) {
				String name = matcher.group("furniture");
				double price = Double.parseDouble(matcher.group("price"));
				int quantity = Integer.parseInt(matcher.group("quantity"));
				totalPrice += price * quantity;
				furnitureNames.add(name);
			}
			input = scan.nextLine();
		}
		System.out.println("Bought furniture:");
		furnitureNames.forEach(f -> System.out.println(f));
		System.out.println(String.format("Total money spend: %.2f", totalPrice));
		scan.close();
	}
}
