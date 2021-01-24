package exercise.froggy;

import java.util.Iterator;

public class Lake implements Iterable<Integer> {
	private int[] elements;

	public Lake(int... integers) {
		this.elements = integers;
	}

	private class Frog implements Iterator<Integer> {
		private int i = 0;

		@Override
		public boolean hasNext() {
			return i < elements.length;
		}

		@Override
		public Integer next() {
			Integer element = elements[i];
			if (elements.length % 2 == 0) {
				if (i == elements.length - 2) {
					i = -1;
				}
			} else if (i == elements.length - 1) {
				i = -1;
			}
			i += 2;
			return element;
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Frog();
	}
}
