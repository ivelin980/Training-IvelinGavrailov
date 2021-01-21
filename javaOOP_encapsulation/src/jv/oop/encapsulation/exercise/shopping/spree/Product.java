package jv.oop.encapsulation.exercise.shopping.spree;

public class Product {
	private String name;
	private double cost;

	public Product(String name, double cost) {
		setName(name);
		setCost(cost);
		this.cost = cost;
	}

	private void setName(String name) {
		validateName(name);
		this.name = name;
	}

	private void setCost(double cost) {
		validateCost(cost);
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public double getCost() {
		return cost;
	}
	
	private void validateName(String name) {
		if(name.trim().isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty!");
		}
	}
	
	private void validateCost(double cost) {
		if(cost<0) {
			throw new IllegalArgumentException("Cost cannot be negative number.");
		}
	}
}
