package jv.oop.inheritance.lab.multiple.inheritance;

/**
 * Create three classes named Animal, Dog and Puppy. Animal with a single public
 * method eat() that prints: "eating…" Dog with a single public method bark()
 * that prints: "barking…" Puppy with a single public method weep() that prints:
 * "weeping…" Dog should inherit from Animal. Puppy should inherit from Dog.
 * 
 * @author Ivelin Gavrailov
 * @since 24.01.2021
 *
 */
public class Main {

	public static void main(String[] args) {
		Puppy puppy = new Puppy();
		puppy.eat();
		puppy.bark();
		puppy.weep();
	}

}
