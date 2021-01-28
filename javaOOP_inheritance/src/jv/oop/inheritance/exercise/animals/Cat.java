package jv.oop.inheritance.exercise.animals;

public class Cat extends Animal {
	
	public Cat(String name, int age, String gender) {
		super(name, age, gender);
	}

	@Override
	protected String produceSound() {
		return Constants.CAT_SOUND;
	}
}
