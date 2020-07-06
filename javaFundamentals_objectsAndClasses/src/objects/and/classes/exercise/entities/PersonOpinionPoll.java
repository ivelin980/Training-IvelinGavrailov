package objects.and.classes.exercise.entities;

public class PersonOpinionPoll {
	private String name;
	private int age;
	
	public PersonOpinionPoll(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		String result = String.format("%s - %d", name,age);
		return result;
		
	}
}
