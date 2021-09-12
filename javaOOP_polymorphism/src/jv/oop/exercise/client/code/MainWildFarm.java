package jv.oop.exercise.client.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jv.oop.exercise.wild.farm.animal.Animal;
import jv.oop.exercise.wild.farm.animal.AnimalFactoryImpl;
import jv.oop.exercise.wild.farm.food.Meat;
import jv.oop.exercise.wild.farm.food.Vegetable;

/**
 * Your task is to create a class hierarchy like the picture below. All the
 * classes except Vegetable, Meat, Mouse, Tiger, Cat & Zebra should be abstract.
 * Input should be read from the console. Every even line will contain
 * information about the Animal in following format: {AnimalType} {AnimalName}
 * {AnimalWeight} {AnimalLivingRegion} [{CatBreed} = Only if its cat] On the odd
 * lines you will receive information about the food that you should give to the
 * Animal. The line will consist of FoodType and quantity separated by a
 * whitespace. You should build the logic to determine if the animal is going to
 * eat the provided food. The Mouse and Zebra should check if the food is a
 * Vegetable. If it is they will eat it. Otherwise you should print a message in
 * the format: {AnimalType} are not eating that type of food! Cats eat any kind
 * of food, but Tigers accept only Meat. If Vegetable is provided to a tiger
 * message like the one above should be printed on the console. After you read
 * information about the Animal and Food then invoke makeSound() method of the
 * current animal and then feed it. At the end print the whole object and
 * proceed reading information about the next animal/food. The input will
 * continue until you receive "End". After that print the information of all
 * received animals in format: {AnimalType} [{AnimalName}, {CatBreed},
 * {AnimalWeight}, {AnimalLivingRegion}, {FoodEaten}] Print all AnimalWeight
 * with no trailing zeroes after the decimal separator. Use the DecimalFormat
 * class. Note: consider overriding toString() method.
 * 
 * @author Ivelin Gavrailov
 * @since 05.02.2021
 *
 */
public class MainWildFarm {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] inputTokens = scan.nextLine().split("\\s+");
		List<Animal> animals = new ArrayList<>();
		while (!"End".equalsIgnoreCase(inputTokens[0])) {
			Animal animal = createAnimal(inputTokens);
			animal.makeSound();
			inputTokens = scan.nextLine().split("\\s+");
			String foodType = inputTokens[0];
			int quantity = Integer.parseInt(inputTokens[1]);
			try {
				switch (foodType) {
				case "Vegetable":
					animal.eatFood(new Vegetable(quantity));
					break;
				case "Meat":
					animal.eatFood(new Meat(quantity));
					break;
				default:
					throw new IllegalArgumentException("There is no such food");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			animals.add(animal);
			inputTokens = scan.nextLine().split("\\s+");
		}
		animals.stream().forEach(System.out::println);
		scan.close();
	}

	private static Animal createAnimal(String[] inputTokens) {
		String type = inputTokens[0];
		String name = inputTokens[1];
		double weight = Double.parseDouble(inputTokens[2]);
		String livingRegion = inputTokens[3];
		String breed = "Cat".equalsIgnoreCase(type) ? inputTokens[4] : "";
		AnimalFactoryImpl factory = new AnimalFactoryImpl();
		return factory.createAnimal(name, type, weight, livingRegion, breed);
	}
}
