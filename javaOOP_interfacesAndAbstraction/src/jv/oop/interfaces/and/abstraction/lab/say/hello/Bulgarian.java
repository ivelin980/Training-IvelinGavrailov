package jv.oop.interfaces.and.abstraction.lab.say.hello;

public class Bulgarian extends PersonImpl {

	public Bulgarian(String name) {
		super(name);
	}

	@Override
	public String sayHello() {
		return "Здравей";
	}

}
