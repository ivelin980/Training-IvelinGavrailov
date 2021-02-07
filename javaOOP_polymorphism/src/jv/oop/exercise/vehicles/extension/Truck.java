package jv.oop.exercise.vehicles.extension;

public class Truck extends Vehicle {

	public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
		super(fuelQuantity, fuelConsumption + Constants.TRUCK_CONSUMPTION_OF_AIR_CONDITIONER, tankCapacity);
	}

	@Override
	public double refuel(double litersToRefuel) {
		return super.refuel(litersToRefuel * Constants.TRUCK_FUEL_PERCENTAGE_GETTING_INTO_TANK / 100);
	}
}
