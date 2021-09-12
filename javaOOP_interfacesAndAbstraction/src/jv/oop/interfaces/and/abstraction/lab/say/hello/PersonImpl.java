package jv.oop.interfaces.and.abstraction.lab.say.hello;

import jv.interfaces.and.abstraction.constants.Constants;

public abstract class PersonImpl implements Person {
	private String name;

	public PersonImpl(String name) {
		setName(name);
	}

	private void setName(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(Constants.INVALID_NAME);
		}
	}

	@Override
	public String getName() {
		return this.name;
	}

}
