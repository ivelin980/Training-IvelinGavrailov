package jv.advanced.workshop.by.me2;

public class Main {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addFirst(12);
		list.removeFirst();
		list.addFirst(76);
		list.insertAfter(76, 20);
		list.insertBefore(20, 26);
		list.addLast(15);
		list.removeLast();
	}
}
