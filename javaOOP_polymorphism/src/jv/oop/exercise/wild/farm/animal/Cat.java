package jv.oop.exercise.wild.farm.animal;

public class Cat extends Felime {
	private String breed;

	public Cat(String animalName, String animalType, double animalWeight, String livingRegion, String breed) {
		super(animalName, animalType, animalWeight, livingRegion);
		setBreed(breed);
	}

	protected String getBreed() {
		return this.breed;
	}

	public void setBreed(String breed) {
		if (breed.length() == 0) {
			throw new IllegalArgumentException("Breed cannot be empty");
		}
		this.breed = breed;
	}

	@Override
	public void makeSound() {
		System.out.println(Constants.CAT_SOUND);
	}

}
