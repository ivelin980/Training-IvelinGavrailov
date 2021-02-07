package jv.oop.lab.shapes;

public abstract class Shape {
	private double perimeter;
	private double area;

	public abstract Double calculatePerimeter();

	public abstract Double calculateArea();

	public double getPerimeter() {
		return perimeter;
	}

	protected void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}

	public double getArea() {
		return area;
	}

	protected void setArea(double area) {
		this.area = area;
	}

}
