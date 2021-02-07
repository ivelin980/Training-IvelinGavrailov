package jv.oop.exercise.wild.farm.animal;

import jv.oop.exercise.wild.farm.food.Food;

public abstract class Animal {
	private String animalName;
	private String animalType;
	private double animalWeight;
	private int foodEaten = 0;

	public Animal(String animalName, String animalType, double animalWeight) {
		setAnimalName(animalName);
		setAnimalType(animalType);
		setAnimalWeight(animalWeight);
	}

	public String getAnimalName() {
		return animalName;
	}

	protected void setAnimalName(String animalName) {
		if (animalName.length() == 0) {
			throw new IllegalArgumentException("Name cannot be empty or null");
		}
		this.animalName = animalName;
	}

	public String getAnimalType() {
		return animalType;
	}

	protected void setAnimalType(String animalType) {
		if (animalType.length() == 0) {
			throw new IllegalArgumentException("Type cannot be empty or null");
		}
		this.animalType = animalType;
	}

	public double getAnimalWeight() {
		return animalWeight;
	}

	protected void setAnimalWeight(double animalWeight) {
		if (animalWeight <= 0) {
			throw new IllegalArgumentException("Weight cannot be zero or less");
		}
		this.animalWeight = animalWeight;
	}

	public int getFoodEaten() {
		return foodEaten;
	}

	protected void setFoodEaten(int foodEaten) {
		if (foodEaten <= 0) {
			throw new IllegalArgumentException("The amount of food eaten cannot be zero or less");
		}
		this.foodEaten = foodEaten;
	}

	public abstract void makeSound();

	public void eatFood(Food food) {
		if ("Tiger".equalsIgnoreCase(this.getClass().getSimpleName())
				&& "Vegetable".equalsIgnoreCase(food.getClass().getSimpleName())) {
			throw new IllegalArgumentException("Tigers are not eating that type of food!");
		}
		setFoodEaten(this.foodEaten + food.getQuantity());
	}
}
