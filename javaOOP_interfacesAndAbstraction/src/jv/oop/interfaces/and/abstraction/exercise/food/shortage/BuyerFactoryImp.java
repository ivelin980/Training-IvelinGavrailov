package jv.oop.interfaces.and.abstraction.exercise.food.shortage;

public class BuyerFactoryImp implements BuyerFactory{

	@Override
	public Buyer createBuyer(String[] input) {
		if (input.length == 4) {
			String name = input[0];
			int age = Integer.parseInt(input[1]);
			String id = input[2];
			String birthDate = input[3];
			return new Citizen(name, age, id, birthDate);
		} else if (input.length == 3) {
			String name = input[0];
			int age = Integer.parseInt(input[1]);
			String group = input[2];
			return new Rebel(name, age, group);
		}
		return null;
	}
}
