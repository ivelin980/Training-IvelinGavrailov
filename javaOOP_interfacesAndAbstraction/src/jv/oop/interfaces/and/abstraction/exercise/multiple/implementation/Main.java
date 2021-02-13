package jv.oop.interfaces.and.abstraction.exercise.multiple.implementation;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Using the code from the previous task, define an interface Identifiable with
 * a String method getId and an interface Birthable with a String method
 * getBirthDate and implement them in the Citizen class. Rewrite the Citizen
 * constructor to accept the new parameters.
 * 
 * @author Ivelin Gavrailov
 * @since 12.2.2021
 *
 */
public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		Class[] citizenInterfaces = Citizen.class.getInterfaces();
		if (Arrays.asList(citizenInterfaces).contains(Birthable.class)
				&& Arrays.asList(citizenInterfaces).contains(Identifiable.class)) {
			Method[] methods = Birthable.class.getDeclaredMethods();
			methods = Identifiable.class.getDeclaredMethods();
			Scanner scanner = new Scanner(System.in);
			String name = scanner.nextLine();
			int age = Integer.parseInt(scanner.nextLine());
			String id = scanner.nextLine();
			String birthDate = scanner.nextLine();
			Identifiable identifiable = new Citizen(name, age, id, birthDate);
			Birthable birthable = new Citizen(name, age, id, birthDate);
			System.out.println(methods.length);
			System.out.println(methods[0].getReturnType().getSimpleName());
			System.out.println(methods.length);
			System.out.println(methods[0].getReturnType().getSimpleName());
			scanner.close();
		}
	}
}
