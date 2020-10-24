package defining.classes.lab.entities;

public class Car {
	private String make;
	private String model;
	private int hp;

	public Car(String make, String model, int hp) {
		this.make = make;
		this.model = model;
		this.hp = hp;
	}
	
	public Car(String make) {
		this.make = make;
		this.model = "unknown";
		this.hp = -1;	
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getInfo() {
		String output = String.format("The car is: %s %s - %d HP.", make, model, hp);
		return output;
	}

}
