package jv.oop.working.with.abstraction.lab.point.in.rectangle;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Create a class Point and a class Rectangle. The Point should hold coordinates
 * X and Y and the Rectangle should hold 2 Points – its bottom left and top
 * right corners. In the Rectangle class, you should implement a contains(Point
 * point) method that returns true or false, based on whether the Point given as
 * attribute is inside or outside of the Rectangle object. Points on the side of
 * a Square are considered inside.
 * 
 * @author Ivelin Gavrailov
 * @since 04.01.2020
 *
 */
public class PointInRectangle {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] input = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		Point bottomLeft = new Point(input[0], input[1]);
		Point topRight = new Point(input[2], input[3]);
		Rectangle rectangle = new Rectangle(bottomLeft, topRight);
		int n = Integer.parseInt(scan.nextLine());
		while (n-- > 0) {
			input = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			Point point = new Point(input[0], input[1]);
			System.out.println(rectangle.contains(point));
		}
		scan.close();
	}
}
