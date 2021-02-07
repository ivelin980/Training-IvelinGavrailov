import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import jv.oop.exercise.vehicles.Car;
import jv.oop.exercise.vehicles.Truck;
import jv.oop.exercise.vehicles.Vehicle;

/**
 * Write a program that models 2 vehicles (Car and Truck) and will be able to
 * simulate driving and refueling them in the summer. Car and truck both have
 * fuel quantity, fuel consumption in liters per km and can be driven given
 * distance and refueled with given liters. But in the summer both vehicles use
 * air conditioner and their fuel consumption per km is increased by 0.9 liters
 * for the car and with 1.6 liters for the truck. Also the truck has a tiny hole
 * in his tank and when it gets refueled it gets only 95% of given fuel. The car
 * has no problems when refueling and adds all given fuel to its tank. If
 * vehicle cannot travel given distance its fuel does not change. Input • On the
 * first line - information about the car in format "Car {fuel quantity} {liters
 * per km}" • On the second line – info about the truck in format "Truck {fuel
 * quantity} {liters per km}" • On third line - number of commands N that will
 * be given on the next N lines • On the next N lines – commands in format: o
 * Drive Car {distance} o Drive Truck {distance} o Refuel Car {liters} o Refuel
 * Truck {liters} Output After each Drive command print whether the Car/Truck
 * was able to travel given distance in format if it’s successful. Print the
 * distance with two digits after the decimal separator except trailing zeros.
 * Use the DecimalFormat class: "Car/Truck traveled {distance} km" Or if it is
 * not: "Car/Truck needs refueling" Finally print the remaining fuel for both
 * car and truck rounded 2 digits after floating point in format: "Car: {liters}
 * Truck: {liters}"
 * 
 * @author Ivelin Gavrailov
 * @since 04.02.2021
 *
 */
public class MainVehicles {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Map<String, Vehicle> vehicles = new HashMap<>();
		String[] input = scan.nextLine().split("\\s+");
		double fuelQuantity = Double.parseDouble(input[1]);
		double fuelConsumption = Double.parseDouble(input[2]);
		vehicles.put("car", new Car(fuelQuantity, fuelConsumption));
		input = scan.nextLine().split("\\s+");
		fuelQuantity = Double.parseDouble(input[1]);
		fuelConsumption = Double.parseDouble(input[2]);
		vehicles.put("truck", new Truck(fuelQuantity, fuelConsumption));
		int n = Integer.parseInt(scan.nextLine());
		while (n-- > 0) {
			String[] tokens = scan.nextLine().split("\\s+");
			try {
				double param = Double.parseDouble(tokens[2]);
				if ("Drive".equalsIgnoreCase(tokens[0])) {
					vehicles.get(tokens[1].toLowerCase()).drive(param);
				} else if ("Refuel".equalsIgnoreCase(tokens[0])) {
					vehicles.get(tokens[1].toLowerCase()).refuel(param);

				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		vehicles.values().forEach(System.out::println);
		scan.close();
	}
}
