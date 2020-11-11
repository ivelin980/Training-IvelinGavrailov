package customlistsorter;

public class Sorter<T extends Comparable<T>> {
	public void sort(CustomList<T> list) {
		for (int i = 0; i < list.size(); i++) {
			T element = list.get(i);
			for (int j = 0; j < list.size(); j++) {
				if (element.compareTo(list.get(j)) < 0) {
					list.swap(i, j);
				}
			}
		}
	}
}
