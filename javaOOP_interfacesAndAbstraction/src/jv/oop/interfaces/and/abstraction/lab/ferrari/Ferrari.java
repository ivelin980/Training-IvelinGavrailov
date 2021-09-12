package jv.oop.interfaces.and.abstraction.lab.ferrari;

import jv.interfaces.and.abstraction.constants.Constants;

public class Ferrari implements Car {
	private String driverName;
	private String model;

	public Ferrari(String driverName) {
		setDriverName(driverName);
		this.model = "488-Spider";
	}

	private void setDriverName(String driverName) {
		if (driverName.isEmpty()) {
			throw new IllegalArgumentException(Constants.INVALID_NAME);
		}
		this.driverName = driverName;
	}

	@Override
	public String brakes() {
		return "Brakes!";
	}

	@Override
	public String gas() {
		return "brum-brum-brum-brrrrr";
	}

	@Override
	public String toString() {
		return String.format("%s/%s/%s/%s", this.model, this.brakes(), this.gas(), this.driverName);
	}

}
