package defining.classes.exercise.entities;

import java.util.List;

public class Tires {
	private List<Double> tirePressure;
	private List<Integer> tireAge;

	public Tires(List<Double> tirePressure, List<Integer> tireAge) {
		this.tirePressure = tirePressure;
		this.tireAge = tireAge;
	}

	public List<Double> getTirePressure() {
		return tirePressure;
	}

	public void setTirePressure(List<Double> tirePressure) {
		this.tirePressure = tirePressure;
	}

	public List<Integer> getTireAge() {
		return tireAge;
	}

	public void setTireAge(List<Integer> tireAge) {
		this.tireAge = tireAge;

	}
}