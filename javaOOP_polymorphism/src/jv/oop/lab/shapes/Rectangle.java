package jv.oop.lab.shapes;

public class Rectangle extends Shape {
	private double height;
	private double width;

	public Rectangle(double height, double width) {
		this.height = height;
		this.width = width;
	}

	@Override
	public Double calculatePerimeter() {
		if (super.getPerimeter() == 0.0) {
			super.setPerimeter(2 * (height + width));
		}
		return super.getPerimeter();
	}

	@Override
	public Double calculateArea() {
		if (super.getArea() == 0.0) {
			super.setArea(height * width);
		}
		return super.getArea();
	}
}
