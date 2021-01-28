package jv.oop.inheritance.exercise.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * NOTE: You need a public class Main. Create a hierarchy(package) of animals.
 * Your program should have three different animals – Dog, Frog and Cat. Deeper
 * in the hierarchy you should have two additional classes – Kitten and Tomcat.
 * Kittens are "Female" and Tomcats are "Male". All types of animals should be
 * able to produce some kind of sound - String produceSound(). For example, the
 * dog should be able to bark. Your task is to model the hierarchy and test its
 * functionality. Create an animal of each kind and make them all produce sound
 * and create getters for all fields. You will be given some lines of input.
 * Each two lines will represent an animal. On the first line will be the type
 * of animal and on the second – the name, the age and the gender. When the
 * command "Beast!" is given, stop the input and print all the animals in the
 * format shown below. Output • Print the information for each animal on three
 * lines. On the first line, print: "{animalType}" • On the second line print:
 * "{name} {age} {gender}" • On the third line print the sounds it produces:
 * "{produceSound()}" Constraints • Each Animal should have a name, an age and a
 * gender • All input values should not be blank (e.g. name, age and so on…) •
 * If you receive an input for the gender of a Tomcat or a Kitten, ignore it but
 * create the animal • If the input is invalid for one of the properties, throw
 * an exception with message: "Invalid input!" • Each animal should have the
 * functionality to produceSound() • Here is the type of sound each animal
 * should produce: o Dog: "Woof!" o Cat: "Meow meow" o Frog: "Ribbit" o Kittens:
 * "Meow" o Tomcat: "MEOW"
 * 
 * @author Ivelin Gavrailov
 * @since 28.01.2021
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String typeInput = scan.nextLine();
		AnimalsFactory factory = new AnimalsFactory();
		List<Animal> animals = new ArrayList<>();
		while (!"Beast!".equalsIgnoreCase(typeInput)) {
			String[] tokens = scan.nextLine().split("\\s+");
			String type = typeInput;
			String name = tokens[0];
			int age = Integer.parseInt(tokens[1]);
			String gender = tokens[2];
			try {
				Animal animal = factory.createAnimal(type, name, age, gender);
				animals.add(animal);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			typeInput = scan.nextLine();
		}

		for (Animal animal : animals) {
			System.out.println(animal);
		}
		scan.close();
	}
}
