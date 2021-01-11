package jv.oop.working.with.abstracion.lab.cards.with.power;

public enum SuitPowers {
	CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);
	
	private int powers;
	
	SuitPowers(int powers) {
		this.powers = powers;
	}
	
	public int getPowers() {
		return powers;
	}
}
