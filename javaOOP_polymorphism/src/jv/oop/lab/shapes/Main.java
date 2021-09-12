package jv.oop.lab.shapes;

/**
 * Create class hierarchy, starting with abstract class Shape: • Fields: o
 * perimeter : Double o area : Double • Encapsulation for this fields • Abstract
 * methods: o calculatePerimeter() o calculateArea() Extend Shape class with two
 * children: • Rectangle • Circle Each of them needs to have: • Fields: For
 * Rectangle o height : Double o width : Double For Circle o radius : Double •
 * Encapsulation for this fields • Public constructor • Concrete methods for
 * calculations (perimeter and area)
 * 
 * @author Ivelin Gavrailov
 * @since 31.01.2021
 *
 */
public class Main {

	public static void main(String[] args) {
		Shape rectangle = new Rectangle(4, 4);
		System.out.println(rectangle.calculatePerimeter());
		System.out.println(rectangle.calculateArea());
		Shape circle = new Circle(5);
		System.out.println(circle.calculatePerimeter());
		System.out.println(circle.calculateArea());
	}
}