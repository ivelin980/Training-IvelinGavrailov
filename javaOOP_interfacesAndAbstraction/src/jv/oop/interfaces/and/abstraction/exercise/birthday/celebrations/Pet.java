package jv.oop.interfaces.and.abstraction.exercise.birthday.celebrations;

import jv.interfaces.and.abstraction.constants.Constants;

public class Pet implements Birthable {
	private String name;
	private String birthDate;

	public Pet(String name, String birthDate) {
		setName(name);
		setBirthDate(birthDate);
	}

	public String getName() {
		return this.name;
	}

	private void setName(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(Constants.INVALID_NAME);
		}
		this.name = name;
	}

	@Override
	public String getBirthDate() {
		return this.birthDate;
	}

	private void setBirthDate(String birthDate) {
		if (birthDate.length() != 10) {
			throw new IllegalArgumentException(Constants.INVALID_BIRTHDATE);
		}
		int date = Integer.parseInt(birthDate.substring(0, 2));
		int month = Integer.parseInt(birthDate.substring(3, 5));
		int year = Integer.parseInt(birthDate.substring(6, 10));
		if (date < 0 || date > 31 || month < 0 || month > 31 || year < 0 || year > 2021) {
			throw new IllegalArgumentException(Constants.INVALID_BIRTHDATE);
		}
		this.birthDate = birthDate;
	}
}
