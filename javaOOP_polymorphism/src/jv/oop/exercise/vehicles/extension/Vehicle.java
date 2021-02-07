package jv.oop.exercise.vehicles.extension;

import java.text.DecimalFormat;

public class Vehicle {
	private double tankCapacity;
	private double fuelQuantity;
	private double fuelConsumption;

	protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
		setFuelQuantity(fuelQuantity);
		setFuelConsumption(fuelConsumption);
		setTankCapacity(tankCapacity);
	}

	public double getTankCapacity() {
		return tankCapacity;
	}

	protected void setTankCapacity(double tankCapacity) {
		this.tankCapacity = tankCapacity;
	}

	public double getFuelQuantity() {
		return fuelQuantity;
	}

	protected void setFuelQuantity(double fuelQuantity) {
		if (fuelQuantity <= 0) {
			throw new IllegalArgumentException("Fuel must be a positive number");
		}
		this.fuelQuantity = fuelQuantity;
	}

	public double getFuelConsumption() {
		return fuelConsumption;
	}

	protected void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public double refuel(double litersToRefuel) {
		if (litersToRefuel <= 0) {
			throw new IllegalArgumentException("Fuel must be a positive number");
		}
		if (getTankCapacity() - getFuelQuantity() < litersToRefuel) {
			throw new IllegalArgumentException("Cannot fit fuel in tank");
		}
		this.fuelQuantity += litersToRefuel;
		return this.fuelQuantity;
	}

	public void drive(double distance) {
		DecimalFormat df = new DecimalFormat("###.#");
		double consumption = distance * this.fuelConsumption;
		if (consumption > this.fuelQuantity) {
			throw new IllegalArgumentException(this.getClass().getSimpleName() + " needs refueling");
		}
		setFuelQuantity(getFuelQuantity() - consumption);
		System.out.println(this.getClass().getSimpleName() + " traveled " + df.format(distance) + " km");
	}

	@Override
	public String toString() {
		return String.format("%s : %.2f", this.getClass().getSimpleName(), getFuelQuantity());
	}
}
