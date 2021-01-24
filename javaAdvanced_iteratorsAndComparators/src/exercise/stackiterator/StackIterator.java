package exercise.stackiterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackIterator<T> implements Iterable<T>{
	private static final int INITIAL_SIZE = 11;
	private Object[] elements;
	private int head;
	private int tail;
	private int size;

	public StackIterator() {
		this.elements = new Object[INITIAL_SIZE];
		this.head = this.tail = elements.length / 3;
	}

	public void push(T element) {
		if (this.elements[this.head] == null) {
			this.elements[this.head] = element;
		} else {
			if (this.head == 0) {
				this.elements = grow();
			}
			this.elements[--this.head] = element;
			}
			size++;
		}
	
	@SuppressWarnings("unchecked")
	public T pop() {
		if(this.elements[this.head] == null) {
			throw new NoSuchElementException("The stack is empty!");
		}
			T elementToRemove = (T) this.elements[this.head];
			this.elements[this.head++] = null;
			size--;
			return elementToRemove;		
	}

	private Object[] grow() {
		Object[] numbers = new Object[this.elements.length * 2];
		System.arraycopy(this.elements, this.head, numbers, numbers.length / 3, this.size);
		this.head = numbers.length / 3;
		this.tail = this.head + this.size - 1;
		return numbers;
	}
	
	private class StackIter implements Iterator<T> {
		private int i = StackIterator.this.head;
		@Override
		public boolean hasNext() {
			return i <= StackIterator.this.tail;
		}

		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			return (T) StackIterator.this.elements[i++];
		}
		
	}

	@Override
	public Iterator<T> iterator() {
		return new StackIter();
	}
}
