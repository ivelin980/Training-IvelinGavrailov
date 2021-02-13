package jv.oop.inheritance.lab.stack.of.strings;

/**
 * Create a class Stack which can store only strings and has the following
 * functionality: � Private field: data: ArrayList<String> � Public method:
 * push(String item): void � Public method: pop(): String � Public method:
 * peek(): String � Public method: isEmpty(): boolean
 * 
 * @author Ivelin Gavrailov
 * @since 25.01.2021
 *
 */
public class Main {

	public static void main(String[] args) {
		StackOfStrings sos = new StackOfStrings();
		sos.push("one");
		sos.push("two");
		sos.push("three");

		System.out.println(sos.isEmpty());
		System.out.println(sos.peek());

		System.out.println(sos.pop());
		System.out.println(sos.pop());
		System.out.println(sos.pop());

	}

}
