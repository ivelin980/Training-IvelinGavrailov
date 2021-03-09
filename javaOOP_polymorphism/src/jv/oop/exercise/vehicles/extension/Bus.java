package jv.oop.exercise.vehicles.extension;

public class Bus extends Vehicle {

	public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
		super(fuelQuantity, fuelConsumption, tankCapacity);
	}

	@Override
	public void drive(double distance) {
		setFuelConsumption(getFuelConsumption() + Constants.BUS_CONSUMPTION_OF_AIR_CONDITIONER);
		super.drive(distance);
	}

	public void driveEmpty(double distance) {
		super.drive(distance);
	}
}
