package jv.oop.exercise.wild.farm.food;

public abstract class Food {
	private int quantity;

	public Food(int quantity) {
		setQuantity(quantity);
	}

	public int getQuantity() {
		return quantity;
	}

	protected void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
