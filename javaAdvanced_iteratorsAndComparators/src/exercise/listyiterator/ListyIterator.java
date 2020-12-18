package exercise.listyiterator;

import java.util.Arrays;
import java.util.List;

public class ListyIterator<T> {
	private int index;
	private List<T> elements;

	@SuppressWarnings("unchecked")
	public ListyIterator(T... elements) {
		this.setElements(elements);
	}

	public List<T> getElements() {
		return elements;
	}

	@SuppressWarnings("unchecked")
	public void setElements(T... elements) {
		this.elements = Arrays.asList(elements);
	}

	public boolean hasNext() {
		return index != elements.size() - 1;
	}

	public boolean move() {
		if (this.hasNext()) {
			index++;
			return true;
		}
		return false;
	}

	public void print() {
		System.out.println(elements.get(index));
	}
}
