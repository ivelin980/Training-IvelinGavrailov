package jv.oop.encapsulation.exercise.classbox;

import java.util.Scanner;

/**
 * You are given a geometric figure Box with fields length, width and height.
 * Model a class Box that can be instantiated by the same three parameters.
 * Expose to the outside world only methods for its surface area, lateral
 * surface area and its volume (formulas:
 * http://www.mathwords.com/r/rectangular_parallelepiped.htm). On the first
 * three lines you will get the length, width and height. On the next three
 * lines print the surface area, lateral surface area and the volume of the box.
 * A box’s side should not be zero or a negative number. Add data validation for
 * each parameter given to the constructor. Make a private setter that performs
 * data validation internally.
 * 
 * @author Ivelin Gavrailov
 * @since 15.01.2021
 *
 */
public class ClassBox {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double length = Double.parseDouble(scan.nextLine());
		double width = Double.parseDouble(scan.nextLine());
		double height = Double.parseDouble(scan.nextLine());
		try {
			Box box = new Box(length, width, height);
			System.out.println(box);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		scan.close();
	}
}
