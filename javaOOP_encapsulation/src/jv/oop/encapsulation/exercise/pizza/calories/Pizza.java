package jv.oop.encapsulation.exercise.pizza.calories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
	private String name;
	private Dough dough;
	private List<Topping> toppings;

	public Pizza(String name, int numberOfToppings) {
		setName(name);
		setNumberOfToppings(numberOfToppings);
	}

	private void setNumberOfToppings(int numberOfToppings) {
		if (numberOfToppings < 0 || numberOfToppings > 10) {
			throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
		}
		this.toppings = new ArrayList<>(numberOfToppings);
	}

	private void setName(String name) {
		if (name.trim().isEmpty() || name.trim().length() > 15) {
			throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
		}
		this.name = name;
	}

	public void setDough(Dough dough) {
		this.dough = dough;
	}

	public String getName() {
		return this.name;
	}

	public void addToping(Topping topping) {
		this.toppings.add(topping);
	}

	public double getOverallCalories() {
		double totalCalories = this.dough.calculateCalories();
		for (Topping topping : toppings) {
			totalCalories += topping.calculateCalories();
		}
		return totalCalories;
	}

	@Override
	public String toString() {
		return String.format("%s - %.2f", this.name, getOverallCalories());
	}
}
