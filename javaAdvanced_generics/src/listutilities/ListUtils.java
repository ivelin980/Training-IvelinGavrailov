package listutilities;

import java.util.Collections;
import java.util.List;

public class ListUtils {
	private ListUtils() {
	}

	public static <T extends Comparable<T>> T getMin(List<T> list) {
		if (list.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return Collections.min(list);
	}

	public static <T extends Comparable<T>> T getMax(List<T> list) {
		if (list.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return Collections.max(list);
	}

	public static <T extends Comparable<T>> void sort(List<T> list) {
		if (list.isEmpty()) {
			throw new IllegalArgumentException("Empty list cannot be sorted!");
		}
		Collections.sort(list);
	}
}
