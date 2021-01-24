package exercise.comparingobjects;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * There is a Comparable interface but probably you already know. Your task is
 * simple. Create a Class Person. Each person should have name, age and town.
 * You should implement the interface - Comparable and try to override the
 * compareTo method. When you compare two people, first you should compare their
 * names, after that - their age and last but not at least - compare their town.
 * Input On single lines, you will be given people in format: {name} {age}
 * {town} Collect them till you receive "END" After that, you will receive an
 * integer N - the Nth person in your collection. Output On the single output
 * line, you should bring statistics, how many people are equal to him, how many
 * people are not equal to him and the total people in your collection. Format:
 * {number of equal people} {number of not equal people} {total number of
 * people} Constraints • Names, ages and addresses will be valid. • Input number
 * will be always à valid integer in range [2…100]. • If there are no equal
 * people print: "No matches"
 * 
 * @author Ivelin Gavrailov
 * @since 26.11.2020
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Person> people = new ArrayList<>();
		String[] input = scan.nextLine().split("\\s+");
		while (!"END".equalsIgnoreCase(input[0])) {
			String name = input[0];
			int age = Integer.parseInt(input[1]);
			String town = input[2];
			Person person = new Person(name, age, town);
			people.add(person);
			input = scan.nextLine().split("\\s+");
		}
		int chosenIndex = Integer.parseInt(scan.nextLine()) - 1;
		int equalPeople = 1;
		for (int i = chosenIndex + 1; i < people.size(); i++) {
			equalPeople += people.get(chosenIndex).compareTo(people.get(i));
		}
		for (int i = chosenIndex - 1; i >= 0; i--) {
			equalPeople += people.get(chosenIndex).compareTo(people.get(i));
		}
		if (equalPeople == 1) {
			System.out.println("no matches");
		} else {
			System.out.print(String.format("%d %d %d", equalPeople, people.size() - equalPeople, people.size()));
		}
		scan.close();
	}
}
