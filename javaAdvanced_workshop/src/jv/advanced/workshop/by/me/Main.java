package jv.advanced.workshop.by.me;

public class Main {
	
	public static void main(String[] args) {
		NodeMap map = new NodeMap();
		map.put("Alice", "Sofia");
		map.put("Bertha", "Plovdiv");
		map.put("Carla", "Ruse");
		System.out.println(map.getKeyIndex("Bertha"));
	}
}
