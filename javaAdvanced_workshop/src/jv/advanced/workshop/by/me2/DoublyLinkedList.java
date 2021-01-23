package jv.advanced.workshop.by.me2;

public class DoublyLinkedList {
	private Node head;
	private Node tail;
	private int size;

	private static class Node {
		private int element;
		private Node prev;
		private Node next;

		public Node(int element) {
			this.element = element;
		}
	}

	public int size() {
		return this.size;
	}

	/**
	 * Add new element at first position to the list
	 * 
	 * @param element
	 */
	public void addFirst(int element) {
		Node newNode = new Node(element);
		size++;
		if (this.head == null) {
			this.head = this.tail = newNode;
			return;
		}
		newNode.next = this.head;
		newNode.next.prev = newNode;
		this.head = newNode;

	}

	public void addLast(int element) {
		Node newNode = new Node(element);
		size++;
		if (this.head == null) {
			this.head = this.tail = newNode;
			return;
		}
		newNode.prev = this.tail;
		newNode.prev.next = newNode;
		this.tail = newNode;
	}

	public boolean removeFirst() {
		if (this.head == null) {
			return false;
		}
		this.head = this.head.next;
		this.head.prev = null;
		size--;
		return true;
	}

	public boolean removeLast() {
		if (this.tail == null) {
			return removeFirst();
		}
		this.tail = this.tail.prev;
		this.tail.next = null;
		size--;
		return true;
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	public void insertAfter(int nodeValue, int element) {
		Node current = this.head;
		while (true) {
			if (current.element == nodeValue) {
				if (current.next == null) {
					addLast(element);
					return;
				}
				Node newNode = new Node(element);
				newNode.next = current.next;
				newNode.prev = current.prev;
				current.next = newNode;
				current.next.prev = current;
				this.size++;
				return;
			}
			current = current.next;
		}
	}

	public void insertBefore(int nodeValue, int element) {
		Node current = this.head;
		while (true) {
			if (current.element == nodeValue) {
				if (current.prev == null) {
					addFirst(element);
					return;
				}
				Node newNode = new Node(element);
				newNode.prev = current.prev;
				newNode.next = current;
				current.prev.next = newNode;
				current.prev = newNode;
				this.size++;
				return;
			}
			current = current.next;
		}
	}
}
