package jv.oop.inheritance.lab.single.inheritance;

/**
 * Create two classes named Animal and Dog. Animal with a single public method
 * eat() that prints: "eating…" Dog with a single public method bark() that
 * prints: "barking…" Dog should inherit from Animal.
 * 
 * @author Ivelin Gavrailov
 * @since 24.01.2021
 *
 */
public class Main {

	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.eat();
		dog.bark();
	}
}
