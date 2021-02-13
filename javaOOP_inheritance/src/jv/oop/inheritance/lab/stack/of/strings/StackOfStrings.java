package jv.oop.inheritance.lab.stack.of.strings;

import java.util.ArrayList;

public class StackOfStrings {
	private ArrayList<String> data;

	public StackOfStrings() {
		this.data = new ArrayList<>();
	}

	public void push(String item) {
		data.add(item);
	}

	public String pop() {
		return data.remove(this.data.size() - 1);
	}

	public String peek() {
		return this.data.get(this.data.size() - 1);
	}

	public boolean isEmpty() {
		return this.data.isEmpty();
	}
}
