package jv.oop.lab.animals;

/**
 * Create a class Animal, which holds two fields: • name: String •
 * favouriteFood: String Animal has one abstract method explainSelf(): String.
 * You should add two new classes - Cat and Dog. Override the explainSelf()
 * method by adding concrete animal sound on a new line. (Look at examples
 * below)
 * 
 * @author Ivelin Gavrailov
 * @since 01.02.2021
 *
 */
public class Main {

	public static void main(String[] args) {
		Animal cat = new Cat("Oscar", "Whiskas");
		Animal dog = new Dog("Rocky", "Meat");
		System.out.println(cat.explainSelf());
		System.out.println(dog.explainSelf());
	}
}
