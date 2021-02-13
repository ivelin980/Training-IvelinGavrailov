package jv.oop.interfaces.and.abstraction.exercise.birthday.celebrations;

public class BirthableFactoryImp implements BirthableFactory {

	@Override
	public Birthable createBirthable(String[] input) {
		switch (input[0]) {
		case "Citizen":
			String name = input[1];
			int age = Integer.parseInt(input[2]);
			String id = input[3];
			String birthDate = input[4];
			return new Citizen(name, age, id, birthDate);
		case "Pet":
			name = input[1];
			birthDate = input[2];
			return new Pet(name, birthDate);
		default:
			break;
		}
		return null;
	}
}
