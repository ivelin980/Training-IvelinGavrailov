package jv.oop.inheritance.exercise.person;

import java.util.Scanner;

/**
 * NOTE: You need a public class Main. Create a package person. You are asked to
 * model an application for storing data about people. You should be able to
 * have a Person and a Child. The child derives from the person. Every person
 * has a name, and an age. Your task is to model the application. The Person
 * class also have getters for the fields. Create a Child class that inherits
 * Person and has the same public constructor definition. However, do not copy
 * the code from the Person class - reuse the Person class's constructor.
 * 
 * @author Ivelin Gavrailov
 * @since 25.01.2021
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		int age = Integer.parseInt(scan.nextLine());
		Child child = new Child(name, age);
		System.out.println(child.getName());
		System.out.println(child.getAge());
		scan.close();
	}

}
