package jv.oop.exercise.wild.farm.animal;

public class Zebra extends Mammal {

	public Zebra(String animalName, String animalType, double animalWeight, String livingRegion) {
		super(animalName, animalType, animalWeight, livingRegion);
	}

	@Override
	public void makeSound() {
		System.out.println(Constants.ZEBRA_SOUND);
	}
}
