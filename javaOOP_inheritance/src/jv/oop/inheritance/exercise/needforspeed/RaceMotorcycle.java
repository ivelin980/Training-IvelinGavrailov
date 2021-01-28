package jv.oop.inheritance.exercise.needforspeed;

public class RaceMotorcycle extends Motorcycle {
	private static final double DEFAULT_FUEL_CONSUMPTION = 8;
	
	public RaceMotorcycle(double fuel, int horsePower) {
		super(fuel, horsePower);
		setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
	}
}
