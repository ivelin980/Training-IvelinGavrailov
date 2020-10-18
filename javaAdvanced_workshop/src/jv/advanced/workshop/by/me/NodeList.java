package jv.advanced.workshop.by.me;

public class NodeList {
	private Node firstElement;

	public void add(Node node) {
		if (this.firstElement == null) {
			this.firstElement = node;
			return;
		}
		Node currentNode = firstElement;
		while (true) {
			if (currentNode.next == null) {
				currentNode.next = node;
				return;
			}
			currentNode = currentNode.next;
		}
	}
}
