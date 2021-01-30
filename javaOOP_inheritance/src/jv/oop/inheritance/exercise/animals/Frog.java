package jv.oop.inheritance.exercise.animals;

public class Frog extends Animal {

	public Frog(String name, int age, String gender) {
		super(name,age,gender);
	}

	@Override
	protected String produceSound() {
		return Constants.FROG_SOUND;
	}
}
