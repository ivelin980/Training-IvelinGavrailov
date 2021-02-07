package jv.oop.lab.animals;

public abstract class Animal {
	private String name;
	private String favouriteFood;

	public Animal(String name, String favouriteFood) {
		this.name = name;
		this.favouriteFood = favouriteFood;
	}

	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	public String getFavouriteFood() {
		return favouriteFood;
	}

	protected void setFavouriteFood(String favouriteFood) {
		this.favouriteFood = favouriteFood;
	}

	public abstract String explainSelf();

	@Override
	public String toString() {
		return "I am " + getName() + " and my favourite food is " + getFavouriteFood();
	}
}
