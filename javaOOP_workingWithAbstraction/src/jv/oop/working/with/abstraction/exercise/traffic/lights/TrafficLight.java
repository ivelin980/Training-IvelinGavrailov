package jv.oop.working.with.abstraction.exercise.traffic.lights;

public class TrafficLight {
	private Color color;

	public TrafficLight(Color color) {
		this.color = color;
	}

	public void update() {
		switch (this.color) {
		case RED:
			this.color = Color.GREEN;
			break;
		case GREEN:
			this.color = Color.YELLOW;
			break;
		case YELLOW:
			this.color = Color.RED;
			break;
		default:
			break;
		}
	}

	public Color getColor() {
		return this.color;
	}
}