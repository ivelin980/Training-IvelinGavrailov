package objects_and_classes.exercise.main;

import java.util.ArrayList;
import java.util.Scanner;

import objects_and_classes.exercise.entities.PersonOpinionPoll;

/**
 * Using the Person class, write a program that reads from the console N lines
 * of personal information and then prints all people whose age is more than 30
 * years, sorted in alphabetical order. Note: you can use stream() to filter
 * people.
 * 
 * @author Ivelin Gavrailov
 * @since 01.07.2020
 */
public class OpinionPoll {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		ArrayList<PersonOpinionPoll> people = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			PersonOpinionPoll person = new PersonOpinionPoll();
			String[] input = scan.nextLine().split(" ");
			String name = input[0];
			int age = Integer.parseInt(input[1]);
			person.setName(name);
			person.setAge(age);
			people.add(person);
		}
		people.stream().filter(p -> p.getAge() > 30).sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
				.forEach(p -> System.out.println(p));
		scan.close();
	}
}
