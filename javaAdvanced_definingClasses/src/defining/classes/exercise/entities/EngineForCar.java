package defining.classes.exercise.entities;

public class EngineForCar {
	private String model;
	private int power;
	private String displacement;
	private String efficiency;
	
	public EngineForCar(String model, int power, String displacement, String efficiency) {
		this.model = model;
		this.power = power;
		if(displacement == null) {
			this.displacement = "n/a";
		} else {
		this.displacement = displacement;
		}
		if(efficiency == null) {
			this.efficiency = "n/a";
		} else {
		this.efficiency = efficiency;
		}
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getDisplacement() {
		return displacement;
	}

	public void setDisplacement(String displacement) {
		this.displacement = displacement;
	}

	public String getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(String efficiency) {
		this.efficiency = efficiency;
	}
	
	
}
