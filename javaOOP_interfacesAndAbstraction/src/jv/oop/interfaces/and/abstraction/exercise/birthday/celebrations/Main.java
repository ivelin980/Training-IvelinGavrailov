package jv.oop.interfaces.and.abstraction.exercise.birthday.celebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * It is a well known fact that people celebrate birthdays, it is also known
 * that some people also celebrate their pets birthdays. Extend the program from
 * your last task to add birthdates to citizens and include a class Pet, pets
 * have a name and a birthdate. Also create class Robot which has an id and
 * model. Encompass repeated functionality into interfaces and implement them in
 * your classes. You will receive from the console an unknown amount of lines
 * until the command "End" is received, each line will contain information in
 * one of the following formats "Citizen <name> <age> <id> <birthdate>" for
 * citizens, "Robot <model> <id>" for robots or "Pet <name> <birthdate>" for
 * pets. After the end command on the next line you will receive a single number
 * representing a specific year, your task is to print all birthdates (of both
 * citizens and pets) in that year in the format day/month/year (the order of
 * printing doesn’t matter).
 * 
 * @author Ivelin Gavrailov
 * @since 12.02.2021
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		List<Birthable> birthables = new ArrayList<>();
		BirthableFactoryImp factory = new BirthableFactoryImp();
		while (!"End".equalsIgnoreCase(input)) {
			String[] tokens = input.split("\\s+");
			try {
				birthables.add(factory.createBirthable(tokens));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			input = scan.nextLine();
		}
		input = scan.nextLine();
		for (Birthable birthable : birthables) {
			String birthYear = birthable.getBirthDate().substring(birthable.getBirthDate().length() - 4);
			if (input.equals(birthYear)) {
				System.out.println(birthable.getBirthDate());
			}
		}
		scan.close();
	}
}
