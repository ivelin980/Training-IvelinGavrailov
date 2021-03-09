package jv.oop.lab.animals;

public class Cat extends Animal {

	public Cat(String name, String favouriteFood) {
		super(name, favouriteFood);
	}

	@Override
	public String explainSelf() {
		return super.toString() + System.lineSeparator() + "MEEOW";
	}

}
