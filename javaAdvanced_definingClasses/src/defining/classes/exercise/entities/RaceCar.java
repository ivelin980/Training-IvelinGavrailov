package defining.classes.exercise.entities;

public class RaceCar {
	private String model;
	private double fuelAmount;
	private double fuelCost;
	private int distanceTraveled;
	
	public RaceCar(String model, double fuelAmount, double fuelCost) {
		this.model = model;
		this.fuelAmount = fuelAmount;
		this.fuelCost = fuelCost;
		this.distanceTraveled = 0;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getFuelAmount() {
		return fuelAmount;
	}

	public void setFuelAmount(double fuelAmount) {
		this.fuelAmount = fuelAmount;
	}

	public double getFuelCost() {
		return fuelCost;
	}

	public void setFuelCost(double fuelCost) {
		this.fuelCost = fuelCost;
	}

	public int getDistanceTraveled() {
		return distanceTraveled;
	}

	public void setDistanceTraveled(int distanceTraveled) {
		this.distanceTraveled = distanceTraveled;
	}

	public boolean drive(int amountOfKm) {
		double fuelNeeded = amountOfKm * fuelCost;
		if(fuelNeeded <= this.fuelAmount) {
			fuelAmount -= fuelNeeded;
			this.distanceTraveled = amountOfKm;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("%s %.2f %d", model,fuelAmount,distanceTraveled);
	}
}
