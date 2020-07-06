package objects.and.classes.exercise.entities;

public class VehicleCatalogue {
	private String type;
	private String brand;
	private String color;
	private double horsepower;

	public VehicleCatalogue(String type, String brand, String color, double horsepower) {
		this.type = type;
		this.brand = brand;
		this.color = color;
		this.horsepower = horsepower;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getHorsepower() {
		return horsepower;
	}

	public void setHorsepower(double horsepower) {
		this.horsepower = horsepower;
	}

	@Override
	public String toString() {
		if (this.type.equals("car")) {
			String output = String.format("Type: Car%nModel: %s%nColor: %s%nHorsepower: %.0f", this.brand, this.color,
					this.horsepower);
			return output;
		}
		String output = String.format("Type: Truck%nModel: %s%nColor: %s%nHorsepower: %.0f", this.brand, this.color,
				this.horsepower);
		return output;
	}
}
