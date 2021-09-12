package jv.oop.exercise.vehicles.extension;

public interface VehicleFactory {
	Vehicle createVehicle(String type, double fuelQuantity,double fuelConsumption, double tankCapacity);
}
