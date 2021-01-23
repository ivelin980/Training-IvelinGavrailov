package customlist;

import java.util.Arrays;
import java.util.Comparator;

public class CustomList<E extends Comparable<E>> {
	private static final int INITIAL_CAPACITY = 4;
	private Object[] elements;
	private int size;

	public CustomList() {
		this.elements = new Object[INITIAL_CAPACITY];
	}

	public int size() {
		return this.size;
	}

	public void add(E element) {
		if (this.size == this.elements.length) {
			this.elements = grow();
		}
		this.elements[this.size++] = element;
	}

	private Object[] grow() {
		return Arrays.copyOf(this.elements, this.elements.length * 2);
	}

	public E get(int index) {
		ensureIndex(index);
		return getAt(index);
	}

	private void ensureIndex(int index) {
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException();
		}
	}

	@SuppressWarnings("unchecked")
	private E getAt(int index) {
		return (E) this.elements[index];
	}

	E remove(int index) {
		ensureIndex(index);
		@SuppressWarnings("unchecked")
		E elementToRemove = (E) this.elements[index];
		this.elements[index] = null;
		for (int i = index; i < this.size; i++) {
			this.elements[index] = this.elements[index + 1];
		}
		size--;
		return elementToRemove;
	}

	public boolean contains(E element) {
		return this.indexOf(element) >= 0;
	}

	public int indexOf(E obj) {
		for (int i = 0; i < this.size; i++) {
			E at = this.getAt(i);
			if (at.equals(obj)) {
				return i;
			}
		}
		return -1;
	}

	void swap(int firstIndex, int secondIndex) {
		ensureIndex(firstIndex);
		ensureIndex(secondIndex);
		Object temp = this.elements[firstIndex];
		elements[firstIndex] = elements[secondIndex];
		elements[secondIndex] = temp;
	}

	public int countGreaterThan(E element) {
		int count = 0;
		for (int i = 0; i < this.size; i++) {
			if (this.get(i).compareTo(element) > 0) {
				count++;
			}
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	public E getMax() {
		return Arrays.stream(this.elements).limit(this.size).map(e -> (E) e).max(Comparator.comparing(e -> e))
				.orElse(null);
	}

	@SuppressWarnings("unchecked")
	public E getMin() {
		return Arrays.stream(this.elements).limit(this.size).map(e -> (E) e).min(Comparator.comparing(e -> e))
				.orElse(null);
	}

	@Override
	public String toString() {
		for (int i = 0; i < this.size; i++) {
			System.out.print(this.elements[i] + " ");
		}
		return "";
	}
}
