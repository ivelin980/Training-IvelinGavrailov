package jv.oop.exercise.wild.farm.animal;

public class Mouse extends Mammal {

	public Mouse(String animalName, String animalType, double animalWeight, String livingRegion) {
		super(animalName, animalType, animalWeight, livingRegion);
	}

	@Override
	public void makeSound() {
		System.out.println(Constants.MOUSE_SOUND);
	}
}
