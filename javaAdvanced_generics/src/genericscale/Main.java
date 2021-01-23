package genericscale;

/**
 * Create a class Scale<T> that holds two elements - left and right. The scale
 * should receive the elements through its single constructor: • Scale(T left, T
 * right) The scale should have a single method: • T getHeavier() The greater of
 * the two elements is heavier. The method should return null if elements are
 * equal.
 * 
 * @author Ivelin Gavrailov
 * @since 05.11.2020
 *
 */
public class Main {

	public static void main(String[] args) {
		Scale<String> stringScale = new Scale<>("a", "c");
		System.out.println(stringScale.getHeavier());

		Scale<Integer> integerScale = new Scale<>(1, 2);
		System.out.println(integerScale.getHeavier());
	}
}
