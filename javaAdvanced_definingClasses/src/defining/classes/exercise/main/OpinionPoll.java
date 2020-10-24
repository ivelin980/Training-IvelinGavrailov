package defining.classes.exercise.main;

import java.util.ArrayList;
import java.util.Scanner;

import defining.classes.exercise.entities.Person;

/**
 * Create Person class with two fields String name and int age, write a program
 * that reads from the console N lines of personal information and then prints
 * all people whose age is more than 30 years, sorted in alphabetical order.
 * Note: you can use stream() to filter people.
 * 
 * @author Ivelin Gavrailov
 * @since 08.09.2020
 *
 */
public class OpinionPoll {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = Integer.parseInt(scan.nextLine());
		ArrayList<Person> people = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			String[] tokens = scan.nextLine().split(" ");
			String name = tokens[0];
			int age = Integer.parseInt(tokens[1]);
			Person person = new Person(name, age);
			people.add(person);
		}
		people.stream().filter(p -> p.getAge() > 30).sorted((p1,p2) -> p1.getName().compareTo(p2.getName()))
				.forEach(p -> System.out.println(String.format("%s - %d", p.getName(), p.getAge())));
		scan.close();
	}
}
