package jv.oop.interfaces.and.abstraction.exercise.birthday.celebrations;

import jv.interfaces.and.abstraction.constants.Constants;

public class Robot implements Identifiable {
	private String id;
	private String model;

	public Robot(String id, String model) {
		setId(id);
		setModel(model);
	}

	public String getModel() {
		return this.model;
	}

	private void setModel(String model) {
		if (model.isEmpty()) {
			throw new IllegalArgumentException(Constants.INVALID_MODEL);
		}
		this.model = model;
	}

	@Override
	public String getId() {
		return this.id;
	}

	private void setId(String id) {
		if (id.isEmpty()) {
			throw new IllegalArgumentException(Constants.INVALID_ID);
		}
		this.id = id;
	}
}
