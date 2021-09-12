package jv.oop.interfaces.and.abstraction.lab.car.shop.extend;

import jv.interfaces.and.abstraction.constants.Constants;

public class CarImpl implements Car {

	private String model;
	private String color;
	private int horsePower;
	private String countryProduced;

	public CarImpl(String model, String color, int horsePower, String countryProduced) {
		setModel(model);
		setColor(color);
		setHorsePower(horsePower);
		setCountryProduced(countryProduced);
	}

	private void setModel(String model) {
		if (model.isEmpty()) {
			throw new IllegalArgumentException(Constants.INVALID_MODEL);
		}
		this.model = model;
	}

	private void setColor(String color) {
		if (color.isEmpty()) {
			throw new IllegalArgumentException(Constants.INVALID_COLOR);
		}
		this.color = color;
	}

	private void setHorsePower(int horsePower) {
		if (horsePower < 0) {
			throw new IllegalArgumentException(Constants.INVALID_HORSEPOWER);
		}
		this.horsePower = horsePower;
	}

	private void setCountryProduced(String countryProduced) {
		if (countryProduced.isEmpty()) {
			throw new IllegalArgumentException(Constants.INVALID_COUNTRYPRODUCED);
		}
		this.countryProduced = countryProduced;
	}

	@Override
	public String getModel() {
		return model;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public int getHorsePower() {
		return horsePower;
	}

	@Override
	public String countryProduced() {
		return countryProduced;
	}

	@Override
	public String toString() {
		return "This is " + this.model + " produced in " + this.countryProduced + " and have " + TIRES + " tires";
	}

}
