package jv.oop.encapsulation.exercise.shopping.spree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Person {
	private String name;
	private double money;
	private List<Product> products;

	public Person(String name, double money) {
		setName(name);
		setMoney(money);
		this.products = new ArrayList<>();
	}

	private void setName(String name) {
		validateName(name);
		this.name = name;
	}

	private void setMoney(double money) {
		validateMoney(money);
		this.money = money;
	}

	public void buyProduct(Product product) {
		if (product.getCost() <= this.money) {
			this.products.add(product);
			System.out.println(String.format("%s bought %s", this.name, product.getName()));
			money -= product.getCost();
		} else {
			System.out.println(String.format("%s can't afford %s", this.name, product.getName()));
		}
	}

	private void validateName(String name) {
		if (name.trim().isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty!");
		}
	}

	private void validateMoney(double money) {
		if (money < 0) {
			throw new IllegalArgumentException("Money cannot be negative number.");
		}
	}

	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		String productsOutput = products.isEmpty() ? "Nothing bought" : products.stream().map(p -> p.getName()).collect(Collectors.joining(", "));
		return this.name + " - " + productsOutput;
	}
}
