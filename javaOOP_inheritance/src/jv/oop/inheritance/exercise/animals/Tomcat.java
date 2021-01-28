package jv.oop.inheritance.exercise.animals;

public class Tomcat extends Cat {

	public Tomcat(String name, int age, String gender) {
		super(name, age, gender);
	}
	
	@Override
	protected String produceSound() {
		return Constants.TOMCAT_SOUND;
	}
}
