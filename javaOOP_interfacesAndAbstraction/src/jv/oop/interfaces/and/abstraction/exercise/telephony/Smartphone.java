package jv.oop.interfaces.and.abstraction.exercise.telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
	private List<String> numbers;
	private List<String> urls;

	public Smartphone(List<String> numbers, List<String> urls) {
		this.numbers = numbers;
		this.urls = urls;
	}

	@Override
	public String browse() {
		String finalUrls = "";
		for (String url : urls) {
			if (url.matches(".*\\d.*")) {
				finalUrls += "Invalid URL!";
			} else {
				finalUrls += "Browsing: " + url + "\n";
			}
		}
		return finalUrls;
	}

	@Override
	public String call() {
		String finalCalls = "";
		for (String number : numbers) {
			if (!number.matches(".*\\d.*")) {
				System.out.println("Invalid number!");
			} else {
				finalCalls += "Calling... " + number + "\n";
			}
		}
		return finalCalls;
	}

}
