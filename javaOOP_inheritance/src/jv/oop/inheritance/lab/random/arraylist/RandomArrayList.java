package jv.oop.inheritance.lab.random.arraylist;

import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("serial")
public class RandomArrayList<T> extends ArrayList<T> {
	private Random random;

	public RandomArrayList() {
		this.random = new Random();
	}

	public T getRandomElement() {
		return super.remove(this.random.nextInt(super.size()));
	}
}
