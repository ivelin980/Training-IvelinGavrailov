package jv.oop.exercise.vehicles;

public class Truck extends Vehicle {

	public Truck(double fuelQuantity, double fuelConsumption) {
		super(fuelQuantity, fuelConsumption + Constants.TRUCK_CONSUMPTION_OF_AIR_CONDITIONER);
	}

	@Override
	public double refuel(double litersToRefuel) {
		return super.refuel(litersToRefuel * Constants.TRUCK_FUEL_PERCENTAGE_GETTING_INTO_TANK / 100);
	}
}
