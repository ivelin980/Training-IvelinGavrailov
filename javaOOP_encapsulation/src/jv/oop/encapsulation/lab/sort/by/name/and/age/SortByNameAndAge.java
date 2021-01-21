package jv.oop.encapsulation.lab.sort.by.name.and.age;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Create a class Person, which should have private fields for: • firstName:
 * String • lastName: String • age: int • toString() - override You should be
 * able to use the class like this:
 * 
 * @author Ivelin Gavrailov
 * @since 12.01.2021
 *
 */
public class SortByNameAndAge {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());

		List<Person> people = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String[] input = reader.readLine().split(" ");
			try {
				people.add(new Person(input[0], input[1], Integer.parseInt(input[2])));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return;
			}
		}

		Collections.sort(people, (firstPerson, secondPerson) -> {
			int sComp = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());
			if (sComp != 0) {
				return sComp;
			} else {
				return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
			}
		});

		for (Person person : people) {
			System.out.println(person.toString());
		}
	}

}
