package jv.oop.exercise.vehicles;

public class Car extends Vehicle {

	public Car(double fuelQuantity, double fuelConsumption) {
		super(fuelQuantity, fuelConsumption + Constants.CAR_CONSUMPTION_OF_AIR_CONDITIONER);
	}

}
