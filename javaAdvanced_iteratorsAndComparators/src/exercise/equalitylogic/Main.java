package exercise.equalitylogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Create a class Person holding name and age. A person with the same name and
 * age should be considered the same, override any methods needed to enforce
 * this logic. Your class should work with both standard and hashed collections.
 * Create a TreeSet and a HashSet of type Person. Input On the first line of
 * input you will receive a number N. On each of the next N lines you will
 * receive information about people in the format "<name> <age>". Add the people
 * from the input into both sets (both sets should hold all the people passed in
 * from the input). Output The output should consist of exactly 2 lines. On the
 * first you should print the size of the TreeSet and on the second - the size
 * of the HashSet. Constraints • A person’s name will be a string that contains
 * only alphanumerical characters with a length between [1…50] symbols. • A
 * person’s age will be a positive integer between [1…100]. • The number of
 * people N will be a positive integer between [0…100].
 * 
 * @author Ivelin Gavrailov
 * @since 15.12.2020
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		Set<Person> byName = new TreeSet<>();
		Set<Person> byAge = new HashSet<>();
		while (n-- > 0) {
			String[] tokens = scan.nextLine().split("\\s+");
			String name = tokens[0];
			int age = Integer.parseInt(tokens[1]);
			Person person = new Person(name, age);
			byName.add(person);
			byAge.add(person);
		}
		System.out.println(byName.size());
		System.out.println(byAge.size());
		scan.close();
	}
}
