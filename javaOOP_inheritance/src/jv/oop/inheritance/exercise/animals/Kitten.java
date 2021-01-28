package jv.oop.inheritance.exercise.animals;

public class Kitten extends Cat{

	public Kitten(String name, int age, String gender) {
		super(name, age, gender);
	}	
	
	@Override
	protected String produceSound() {
		return Constants.KITTEN_SOUND;
	}
}
