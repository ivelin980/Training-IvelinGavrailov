package jv.oop.interfaces.and.abstraction.lab.border.control;

public class IdentifiableFactoryImpl implements IdentifiableFactory {

	@Override
	public Identifiable createIdentifiable(String[] input) {
		if (input.length == 2) {
			String model = input[0];
			String id = input[1];
			return new Robot(id, model);
		} else if (input.length == 3) {
			String name = input[0];
			int age = Integer.parseInt(input[1]);
			String id = input[2];
			return new Citizen(name, age, id);
		}
		return null;
	}

}
