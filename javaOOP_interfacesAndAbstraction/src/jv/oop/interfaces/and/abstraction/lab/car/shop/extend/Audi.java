package jv.oop.interfaces.and.abstraction.lab.car.shop.extend;

import jv.interfaces.and.abstraction.constants.Constants;

public class Audi extends CarImpl implements Rentable {
	private int minRentDay;
	private double pricePerDay;

	public Audi(String model, String color, int horsePower, String countryProduced, int minRentDay,
			double pricePerDay) {
		super(model, color, horsePower, countryProduced);
		setMinRentDay(minRentDay);
		setPricePerDay(pricePerDay);
	}
	
	private void setMinRentDay(int minRentDay) {
		if(minRentDay < 0) {
			throw new IllegalArgumentException(Constants.INVALID_MINRENTDAY);
		}
		this.minRentDay = minRentDay;
	}
	
	private void setPricePerDay(double pricePerDay) {
		if(pricePerDay < 0) {
			throw new IllegalArgumentException(Constants.INVALID_PRICE);
		}
		this.pricePerDay = pricePerDay;
	}

	@Override
	public int getMinRentDay() {
		return this.minRentDay;
	}

	@Override
	public double getPricePerDay() {
		return this.pricePerDay;
	}

	@Override
	public String toString() {
		return super.toString() + System.lineSeparator() + String.format(
				"Minimum rental period of %d days. Price per day %.6f", this.getMinRentDay(), this.getPricePerDay());
	}
}
