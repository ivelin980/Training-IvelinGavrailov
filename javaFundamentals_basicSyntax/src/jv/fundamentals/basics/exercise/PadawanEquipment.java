package jv.fundamentals.basics.exercise;

import java.util.Scanner;

public class PadawanEquipment {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double budget = Double.parseDouble(scan.nextLine());
		int students = Integer.parseInt(scan.nextLine());
		double priceOfLightsabers = Double.parseDouble(scan.nextLine());
		double priceOfRobes = Double.parseDouble(scan.nextLine());
		double priceOfBelts = Double.parseDouble(scan.nextLine());
		double totalForLightsabers = Math.ceil(students * 1.1) * priceOfLightsabers;
		double totalForBelts = (Math.ceil((students - (students / 6)))) * priceOfBelts;
		double totalForRobes = students * priceOfRobes;
		double totalPrice = totalForLightsabers + totalForBelts + totalForRobes;
		if (budget >= totalPrice) {
			System.out.println(String.format("The money is enough - it would cost %.2flv.", totalPrice));
		} else {
			System.out.println(String.format("Ivan Cho will need %.2flv more.", totalPrice - budget));
		}
		scan.close();
	}

}
