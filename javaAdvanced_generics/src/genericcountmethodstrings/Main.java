package genericcountmethodstrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Create a method that receives as argument a list of any type that can be
 * compared and an element of the given type. The method should return the count
 * of elements that are greater than the value of the given element. Modify your
 * Box class to support comparing by value of the data stored. On the first line
 * you will receive n - the number of elements to add to the list. On the next n
 * lines, you will receive the actual elements. On the last line you will get
 * the value of the element to which you need to compare every element in the
 * list.
 * 
 * @author Ivelin Gavrailov
 * @since 08.11.2020
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Box<String>> boxes = new ArrayList<>();
		int inputNumber = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < inputNumber; i++) {
			Box<String> box = new Box<>(scan.nextLine());
			boxes.add(box);
		}
		String element = scan.nextLine();
		int count = 0;
		for (Box<String> box : boxes) {
			if (box.getInput().compareTo(element) > 0) {
				count++;
			}
		}
		System.out.println(count);
		scan.close();
	}
}
