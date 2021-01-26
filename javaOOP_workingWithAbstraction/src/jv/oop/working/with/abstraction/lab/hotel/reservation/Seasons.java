package jv.oop.working.with.abstraction.lab.hotel.reservation;

public enum Seasons {
	AUTUMN(1), SPRING(2), WINTER(3), SUMMER(4);

	private int multiplier;

	Seasons(int multiplier) {
		this.multiplier = multiplier;
	}

	public int getMultiplier() {
		return this.multiplier;
	}
}
