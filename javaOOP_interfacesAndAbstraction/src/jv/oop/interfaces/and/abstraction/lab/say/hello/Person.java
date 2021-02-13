package jv.oop.interfaces.and.abstraction.lab.say.hello;

public interface Person {
	String getName();

	default String sayHello() {
		return "Hello";
	}
}
