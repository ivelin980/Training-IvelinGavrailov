package jv.oop.interfaces.and.abstraction.lab.say.hello;

import java.util.ArrayList;
import java.util.List;

/**
 * Build hierarchy from classes and interfaces for this UML diagram
 * 
 * <<Person>> +getName(): String +sayHello(): String All the classes below
 * implement the interface Person
 * 
 * Bulgarian -name: String +sayHello(): String
 * 
 * European -name: String
 * 
 * Chinese -name: String +sayHello(): String
 * 
 * 
 * 
 * @author Ivelin Gavrailov
 * @since 09.02.2021
 *
 */
public class Main {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();

		persons.add(new Bulgarian("Gosho"));
		persons.add(new European("Pesho"));
		persons.add(new Chinese("Misho"));
		persons.stream().forEach(Main::print);
	}

	private static void print(Person person) {
		System.out.println(person.sayHello());
	}
}
