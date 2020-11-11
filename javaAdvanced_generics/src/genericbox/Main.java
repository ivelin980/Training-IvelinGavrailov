package genericbox;

import java.util.Scanner;

/**
 * Create a generic class Box that can store any type. Override the toString()
 * method to print the type and the value of the stored data in the format
 * {class full name: value}. Use the class that you've created and test it with
 * the class java.lang.String. On the first line you will get n - the number of
 * strings to read from the console. On the next n lines, you will get the
 * actual strings. For each of them create a box and call its toString() method
 * to print its data on the console.
 * 
 * @author Ivelin Gavrailov
 * @since 07.11.2020
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int inputNumber = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < inputNumber; i++) {
			Box<String> box = new Box<>(scan.nextLine());
			System.out.println(box);
		}
		scan.close();
	}

}
