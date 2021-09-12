package jv.oop.interfaces.and.abstraction.exercise.define.an.interfaceperson;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Define an interface Person with methods getName and getAge. Define a class
 * Citizen which implements Person and has a constructor which takes a String
 * name and an int age. Add the following code to your main method and submit it
 * to Judge.
 * 
 * @author Ivelin Gavrailov
 * @since 12.02.2021
 *
 */
public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		Class[] citizenInterfaces = Citizen.class.getInterfaces();
		if (Arrays.asList(citizenInterfaces).contains(Person.class)) {
			Method[] fields = Person.class.getDeclaredMethods();
			Scanner scanner = new Scanner(System.in);
			String name = scanner.nextLine();
			int age = Integer.parseInt(scanner.nextLine());
			try {
				Person person = new Citizen(name, age);
				System.out.println(fields.length);
				System.out.println(person.getName());
				System.out.println(person.getAge());
				scanner.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}