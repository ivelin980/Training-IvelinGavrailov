package jv.oop.working.with.abstraction.lab.hotel.reservation;

public class PriceCalculator {
	private double price;
	private int days;
	private Seasons season;
	private DiscountType discount;

	public PriceCalculator(double price, int days, Seasons season, DiscountType discount) {
		this.price = price;
		this.days = days;
		this.season = season;
		this.discount = discount;
	}

	public double calculatePrice() {
		return this.price * this.days * this.season.getMultiplier() * (1.00 - (this.discount.getDiscount() / 100.00));
	}
}
