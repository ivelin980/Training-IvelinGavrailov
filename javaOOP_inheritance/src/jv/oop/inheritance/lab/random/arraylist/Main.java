package jv.oop.inheritance.lab.random.arraylist;

/**
 * Create a RandomArrayList class that has all the functionality of an
 * ArrayList. Add additional function that returns and removes a random element
 * from the list. • Public method: getRandomElement(): Object
 * 
 * @author Ivelin Gavrailov
 * @since 24.01.2021
 *
 */
public class Main {

	public static void main(String[] args) {
		RandomArrayList<Integer> list = new RandomArrayList<>();
		list.add(12);
		list.add(36);
		list.add(5);
		list.add(8);
		System.out.println(list.getRandomElement());
	}

}
