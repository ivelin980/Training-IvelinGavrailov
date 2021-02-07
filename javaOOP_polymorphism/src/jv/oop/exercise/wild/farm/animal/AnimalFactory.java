package jv.oop.exercise.wild.farm.animal;

public interface AnimalFactory {
	Animal createAnimal(String animalName, String animalType, double animalWeight, String... strings);
}
