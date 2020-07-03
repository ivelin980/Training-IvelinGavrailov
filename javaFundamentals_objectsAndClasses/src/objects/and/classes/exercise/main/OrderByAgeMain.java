package objects.and.classes.exercise.main;

import java.util.ArrayList;
import java.util.Scanner;

import objects.and.classes.exercise.entities.PersonOrderByAge;

/**
 * You will receive an unknown number of lines. On each line, you will receive
 * array with 3 elements. The first element will be string and represents the
 * name of the person. The second element will be a string and will represent
 * the ID of the person. The last element will be an integer and represents the
 * age of the person. When you receive the command "End", stop taking input and
 * print all the people, ordered by age.
 * 
 * @author Ivelin Gavrailov
 * @since 02.07.2020
 *
 */
public class OrderByAgeMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split("\\s+");
		ArrayList<PersonOrderByAge> people = new ArrayList<>();
		while (!input[0].equalsIgnoreCase("End")) {
			String name = input[0];
			String id = input[1];
			int age = Integer.parseInt(input[2]);
			PersonOrderByAge person = new PersonOrderByAge();
			person.setName(name);
			person.setId(id);
			person.setAge(age);
			people.add(person);
			input = scan.nextLine().split("\\s+");
		}
		people.stream().sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
				.forEach(p -> System.out.println(p));
		scan.close();
	}
}
