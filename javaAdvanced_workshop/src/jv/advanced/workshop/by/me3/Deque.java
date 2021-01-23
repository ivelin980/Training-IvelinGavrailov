package jv.advanced.workshop.by.me3;

import java.util.NoSuchElementException;

public class Deque {
	private static final String NULL_POINTER_MESSAGE = "The element you want to add is null";
	private Integer[] elements;
	private int head;
	private int tail;
	private int size;

	public Deque() {
		this.elements = new Integer[5];
		this.head = this.elements.length / 2;
		this.tail = this.elements.length / 2;
	}

	public void offer(Integer element) {
		if (element == null) {
			throw new NullPointerException(NULL_POINTER_MESSAGE);
		}
		if (this.elements[this.tail] == null) {
			this.elements[this.tail] = element;
		} else {
			if (this.tail == this.elements.length - 1) {
				this.elements = grow();
			}
			this.elements[++this.tail] = element;
		}
		this.size++;
	}

	public void push(Integer element) {
		if (element == null) {
			throw new NullPointerException(NULL_POINTER_MESSAGE);
		}
		if (this.elements[this.head] == null) {
			this.elements[this.head] = element;
		} else {
			if (this.head == 0) {
				this.elements = grow();
			}
			this.elements[--this.head] = element;
		}
		this.size++;
	}
	
	/**
	 * Inserts the specified element at the end of this deque. 
	 * @param element
	 * @return true
	 * @throws NullPointerException - if the specified element is null
	 */
	public boolean add(Integer element) {
		this.offer(element);
		return true;
	}

	public boolean addFirst(Integer element) {
		this.push(element);
		return true;
	}

	public boolean addLast(Integer element) {
		return add(element);
	}

	private Integer[] grow() {
		Integer[] numbers = new Integer[this.elements.length * 3];
		System.arraycopy(this.elements, this.head, numbers, numbers.length / 4, this.size);
		this.head = numbers.length / 4;
		this.tail = this.head + this.size - 1;
		return numbers;
	}

	public Integer pop() {
		if (this.elements[this.head] == null) {
			throw new NoSuchElementException("Cannot remove elements from empty deque!");
		}
		Integer element = this.elements[this.head];
		this.elements[this.head++] = null;
		this.size--;
		return element;
	}

	public Integer removeFirst() {
		return pop();
	}

	public Integer removeLast() {
		if (this.elements[this.tail] == null) {
			return pop();
		}
		Integer element = this.elements[this.tail];
		this.elements[this.tail--] = null;
		this.size--;
		return element;
	}

	public Integer remove() {
		return pop();

	}

	public boolean remove(Integer element) {
		if (this.size == 0) {
			return false;
		}
		for (int i = this.head; i <= this.tail; i++) {
			if (this.elements[i].equals(element)) {
				if (i == this.head) {
					removeFirst();
				} else {
					while (this.elements[i] != null) {
						int current = i;
						Integer nextElement = this.elements[++i];
						this.elements[current] = nextElement;
					}
					removeLast();
				}
			}
		}
		return true;
	}

	public boolean removeFirstOccurence(Integer element) {
		return remove(element);
	}

	public Integer poll() {
		Integer element = this.elements[this.head];
		if (element == null) {
			return element;
		}
		this.elements[this.head++] = null;
		this.size--;
		return element;
	}

	public Integer pollFirst() {
		return poll();
	}

	public Integer pollLast() {
		Integer element = this.elements[this.tail];
		if (element == null) {
			return element;
		}
		this.elements[this.tail--] = null;
		this.size--;
		return element;
	}

	public boolean removeAll() {
		if (this.size == 0) {
			return false;
		} else {
			for (int i = this.head; i <= this.tail; i++) {
				this.elements[i] = null;
			}
			this.elements = new Integer[5];
			this.head = this.elements.length / 2;
			this.tail = this.elements.length / 2;
			this.size = 0;
			return true;
		}
	}

	public Integer peek() {
		return this.elements[this.head];
	}

	public Integer peekFirst() {
		return peek();
	}

	public Integer peekLast() {
		return this.elements[this.tail];
	}

	public boolean isEmpty() {
		return size == 0;
	}
}
