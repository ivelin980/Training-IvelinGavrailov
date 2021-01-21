package jv.oop.encapsulation.exercise.classbox;

public class Box {
	private double length;
	private double width;
	private double height;

	public Box(double length, double width, double height) {
		setLength(length);
		setWidth(width);
		setHeight(height);
	}

	private void setLength(double length) {
		validateData(length, "Length");
		this.length = length;
	}

	private void setWidth(double width) {
		validateData(width, "Width");
		this.width = width;
	}

	private void setHeight(double height) {
		validateData(height, "Height");
		this.height = height;
	}

	public double calculateSurfaceArea() {
		return calculateLateralSurfaceArea() + 2 * this.length * this.width;
	}

	public double calculateLateralSurfaceArea() {
		return 2 * this.length * this.height + 2 * this.width * this.height;
	}

	public double calculateVolume() {
		return this.length * this.width * this.height;
	}
	
	public void validateData(double parameter, String prefix) {
		if(parameter <= 0) {
			throw new IllegalArgumentException(prefix + " cannot be zero or negative");
		}
	}
	
	@Override
	public String toString() {
		return String.format("Surface Area - %.2f%nLateral Surface Area - %.2f%nVolume - %.2f", calculateSurfaceArea(),calculateLateralSurfaceArea(),calculateVolume());
	}
}
