package jv.advanced.workshop.by.me3;

public class Main {

	public static void main(String[] args) {
		Deque deque = new Deque();
		deque.add(12);
		deque.add(20);
		deque.add(50);
		deque.add(69);
		deque.addFirst(15);
		deque.addLast(14);
		deque.remove(14);
		System.out.println(deque.peekFirst());
		deque.pop();
	}
}
