package objects_and_classes.exercise.entities;

public class PersonOrderByAge {
	private String name;
	private String id;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		String output = String.format("%s with ID: %s is %d years old.", this.name, this.id, this.age);
		return output;
	}

}
