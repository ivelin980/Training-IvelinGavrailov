package jv.oop.exercise.wild.farm.animal;

public class Tiger extends Felime {

	public Tiger(String animalName, String animalType, double animalWeight, String livingRegion) {
		super(animalName, animalType, animalWeight, livingRegion);
	}

	@Override
	public void makeSound() {
		System.out.println(Constants.TIGER_SOUND);
	}
}
