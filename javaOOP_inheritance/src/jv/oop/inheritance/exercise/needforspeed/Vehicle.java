package jv.oop.inheritance.exercise.needforspeed;

public class Vehicle {
	private static final double DEFAULT_FUEL_CONSUMPTION = 1.25;
	private double fuelConsumption;
	private double fuel;
	private int horsePower;

	public Vehicle(double fuel, int horsePower) {
		setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
		setFuel(fuel);
		setHorsePower(horsePower);
	}

	public double getFuelConsumption() {
		return fuelConsumption;
	}

	protected void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public double getFuel() {
		return fuel;
	}

	private void setFuel(double fuel) {
		this.fuel = fuel;
	}

	public int getHorsePower() {
		return horsePower;
	}

	private void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	public void drive(double kilometers) {
		double consumption = getFuelConsumption() * kilometers;
		if (getFuel() < consumption) {
			throw new IllegalStateException("The fuel of" + getFuel() + " is not enough");
		}
		setFuel(getFuel() - consumption);

	}
}
