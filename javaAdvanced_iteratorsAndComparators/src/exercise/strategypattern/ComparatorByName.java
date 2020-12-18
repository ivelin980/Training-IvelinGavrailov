package exercise.strategypattern;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {

	@Override
	public int compare(Person first, Person second) {
		int result = first.getName().length() - second.getName().length();
		if (result == 0) {
			result = Character
					.toUpperCase(first.getName().charAt(0)) - Character.toUpperCase(second.getName().charAt(0));
		}
		return result;
	}

}
