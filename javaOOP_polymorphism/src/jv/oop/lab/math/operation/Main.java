package jv.oop.lab.math.operation;

/**
 * Create a class MathOperation, which should have method add(). Method add()
 * have to be invoked with two, three or four Integers. You should be able to
 * use the class like this:
 * 
 * @author Ivelin Gavrailov
 * @since 30.01.2021
 *
 */
public class Main {

	public static void main(String[] args) {
		MathOperation math = new MathOperation();
		System.out.println(math.add(2, 2));
		System.out.println(math.add(3, 3, 3));
		System.out.println(math.add(4, 4, 4, 4));

	}
}
