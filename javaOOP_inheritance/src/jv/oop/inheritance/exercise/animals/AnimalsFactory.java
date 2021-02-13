package jv.oop.inheritance.exercise.animals;

public class AnimalsFactory implements AnimalsFactoryInt {

	@Override
	public Animal createAnimal(String type, String name, int age, String gender) {
		switch (type) {
		case "Cat":
			return new Cat(name, age, gender);
		case "Dog":
			return new Dog(name, age, gender);
		case "Frog":
			return new Frog(name, age, gender);
		case "Kitten":
			return new Kitten(name, age, gender);
		case "Tomcat":
			return new Tomcat(name, age, gender);
		default:
			throw new IllegalArgumentException(Constants.INVALID_INPUT_MESSAGE);
		}
	}

}
