package arraycreator;

/**
 * Create a class ArrayCreator with a method and a single overload to it: •
 * static T[] create(int length, T item) • static T[] create(Class<T> class, int
 * length, T item) The method should return an array with the given length and
 * every element should be set to the given default item.
 * 
 * @author Ivelin Gavrailov
 * @since 05.11.2020
 *
 */
public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Integer[] arr = ArrayCreator.create(12, 12);
		@SuppressWarnings("unused")
		String[] arr2 = ArrayCreator.create(String.class, 5, "12");
	}
}
