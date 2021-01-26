package jv.advanced.lab.functional.programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Write a program that reads an integer N on the first line. And on next N
 * lines read pairs of "[name], [age]". Then read three more lines with: •
 * Condition - "younger" or "older" • Age - Integer • Format - "name", "age" or
 * "name age" Depending on the condition, print the pairs in the right format.
 * Don’t use any build-in functionality. Write your own methods.
 * 
 * @author Ivelin Gavrailov
 * @since 25.12.2020
 *
 */
public class FilterByAge {
	public static class Person {
		private String name;
		private int age;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Person> people = new ArrayList<>();
		Map<String, Predicate<Person>> predicateMap = new HashMap<>();
		int n = Integer.parseInt(scan.nextLine());
		while (n-- > 0) {
			String[] tokens = scan.nextLine().split(", ");
			people.add(new Person(tokens[0], Integer.parseInt(tokens[1])));
		}
		String ageCondition = scan.nextLine();
		int age = Integer.parseInt(scan.nextLine());
		predicateMap.put("younger", person -> age >= person.age);
		predicateMap.put("older", person -> age <= person.age);

		String otputStyle = scan.nextLine();
		Map<String, Consumer<Person>> consumerMap = new HashMap<>();
		consumerMap.put("name", person -> System.out.println(person.name));
		consumerMap.put("age", person -> System.out.println(person.age));
		consumerMap.put("name age", person -> System.out.println(person.name + " - " + person.age));

		people.stream().filter(predicateMap.get(ageCondition)).forEach(consumerMap.get(otputStyle));
		scan.close();
	}
}
