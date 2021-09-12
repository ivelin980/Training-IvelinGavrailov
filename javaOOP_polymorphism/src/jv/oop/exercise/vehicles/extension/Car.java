package jv.oop.exercise.vehicles.extension;

public class Car extends Vehicle {

	public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
		super(fuelQuantity, fuelConsumption + Constants.CAR_CONSUMPTION_OF_AIR_CONDITIONER, tankCapacity);
	}

}
