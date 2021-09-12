package jv.oop.interfaces.and.abstraction.exercise.food.shortage;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Your totalitarian dystopian society suffers a shortage of food, so many
 * rebels appear. Extend the code from your previous (Problem 2.Multiple
 * Implementation) task with new functionality to solve this task. Define a
 * class Rebel which has a name, age and group (String), names are unique -
 * there will never be 2 Rebels/Citizens or a Rebel and Citizen with the same
 * name. Define an interface Buyer which defines a methods buyFood() and a
 * getFood(). Implement the Buyer interface in the Citizen and Rebel class, both
 * Rebels and Citizens start with 0 food, when a Rebel buys food his food
 * increases by 5, when a Citizen buys food his food increases by 10. On the
 * first line of the input you will receive an integer N - the number of people,
 * on each of the next N lines you will receive information in one of the
 * following formats "<name> <age> <id> <birthdate>" for a Citizen or "<name>
 * <age><group>" for a Rebel. After the N lines until the command "End" is
 * received, you will receive names of people who bought food, each on a new
 * line. Note that not all names may be valid, in case of an incorrect name -
 * nothing should happen. On the only line of output, you should print the total
 * amount of food purchased.
 * 
 * @author Ivelin Gavrailov
 * @since 12.02.2021
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Set<Buyer> buyer = new HashSet<>();
		BuyerFactoryImp factory = new BuyerFactoryImp();
		int n = Integer.parseInt(scan.nextLine());
		while (n-- > 0) {
			String[] tokens = scan.nextLine().split("\\s+");
			buyer.add(factory.createBuyer(tokens));
		}
		String input = scan.nextLine();
		while (!"End".equalsIgnoreCase(input)) {
			for (Buyer b : buyer) {
				if (b.getName().equals(input)) {
					b.buyFood();
				}
			}
			input = scan.nextLine();
		}
		System.out.println(buyer.stream().mapToInt(Buyer::getFood).sum());
		scan.close();
	}
}
