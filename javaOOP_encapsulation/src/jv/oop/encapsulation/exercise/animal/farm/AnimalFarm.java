package jv.oop.encapsulation.exercise.animal.farm;

import java.util.Scanner;

/**
 * You should be familiar with encapsulation already. For this problem, you’ll
 * need to create class called Chicken. Chicken should contain several fields, a
 * constructor, and several methods. Your task is to encapsulate or hide
 * anything that is not intended to be viewed or modified from outside the
 * class. Chicken lives for 15 years. Chicken have name for sure, at least 1
 * symbol long. Chicken producing eggs: • First 6 years it produces 2 eggs per
 * day [0 - 5] • Next 6 years it produces 1 egg per day [6 - 11] • And after
 * that it produces 0.75 eggs per day
 * 
 * 
 * @author Ivelin Gavrailov
 * @since 15.01.2021
 *
 */
public class AnimalFarm {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		int age = Integer.parseInt(scan.nextLine());
		try {
			Chicken chicken = new Chicken(name, age);
			System.out.println(chicken);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		scan.close();
	}
}