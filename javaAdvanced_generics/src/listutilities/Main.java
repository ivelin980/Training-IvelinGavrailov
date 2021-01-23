package listutilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Create a class ListUtils that you will use through several other exercises:
 * The class should have two static methods: • T getMin(List<T> list) • T
 * getMax(List<T> list) The methods should throw IllegalArgumentException if an
 * empty list is passed.
 * 
 * @author Ivelin Gavrailov
 * @since 06.11.2020
 *
 */
public class Main {

	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		List<Integer> integers = new ArrayList<>();
		Collections.addAll(integers, 100, 20, 35, 52);
		System.out.println(ListUtils.getMax(integers));
		Collections.addAll(strings, "abc", "abcd", "bda");
		System.out.println(ListUtils.getMax(strings));
		ListUtils.sort(integers);
		System.out.println();
	}
}
