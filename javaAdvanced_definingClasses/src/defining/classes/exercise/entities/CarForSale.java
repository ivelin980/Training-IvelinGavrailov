package defining.classes.exercise.entities;

public class CarForSale {
	private String model;
	private EngineForCar engine;
	private String weight;
	private String color;

	public CarForSale(String model, EngineForCar engine, String weight, String color) {
		this.model = model;
		this.engine = engine;
		this.weight = weight == null ? "n/a" : weight;
		this.color = color == null ? "n/a" : color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public EngineForCar getEngine() {
		return engine;
	}

	public void setEngine(EngineForCar engine) {
		this.engine = engine;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return String.format("%s:%n%s%nPower: %d%nDisplacement: %s%nEfficiency: %s%nWeight: %s%nColor: %s", model,
				engine.getModel(), engine.getPower(), engine.getDisplacement(), engine.getEfficiency(), weight, color);
	}

}
