package jv.oop.exercise.wild.farm.animal;

public class AnimalFactoryImpl implements AnimalFactory{
	public Animal createAnimal(String animalName, String animalType, double animalWeight,String...strings) {
		String livingRegion = strings[0];
		String breed = strings[1];
		switch (animalType) {
		case "Mouse":
			return new Mouse(animalName, animalType, animalWeight, livingRegion);
		case "Zebra":
			return new Zebra(animalName, animalType, animalWeight, livingRegion);
		case "Cat":
			return new Cat(animalName, animalType, animalWeight, livingRegion,breed);
		case "Tiger":
			return new Tiger(animalName, animalType, animalWeight, livingRegion);
		default:
			throw new IllegalArgumentException("There is no such animal");
		}
	}
}
