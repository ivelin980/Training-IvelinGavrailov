package jv.oop.interfaces.and.abstraction.lab.car.shop.extend;

import jv.interfaces.and.abstraction.constants.Constants;

public class Seat extends CarImpl implements Sellable {
	private double price;

	public Seat(String model, String color, int horsePower, String countryProduced, double price) {
		super(model, color, horsePower, countryProduced);
		setPrice(price);
	}

	@Override
	public double getPrice() {
		return this.price;
	}

	private void setPrice(double price) {
		if (price < 0) {
			throw new IllegalArgumentException(Constants.INVALID_PRICE);
		}
		this.price = price;
	}

	@Override
	public String toString() {
		return super.toString() + System.lineSeparator()
				+ String.format("%s sells for %.6f", super.getModel(), this.getPrice());
	}
}
