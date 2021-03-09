package jv.oop.lab.shapes;

public class Circle extends Shape {
	private double radius;

	public Circle(int radius) {
		this.radius = radius;
	}

	@Override
	public Double calculatePerimeter() {
		if (super.getPerimeter() == 0.0) {
			setPerimeter(2 * Math.PI * radius);
		}
		return getPerimeter();
	}

	@Override
	public Double calculateArea() {
		if (super.getArea() == 0.0) {
			setArea(Math.PI * radius * radius);
		}
		return getArea();
	}
}
