package defining.classes.exercise.main;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import defining.classes.exercise.entities.RaceCar;

/**
 * Your task is to implement a program that keeps track of cars and their fuel
 * and supports methods for moving the cars. Define a class Car that keeps track
 * of a car information Model, fuel amount, fuel cost for 1 kilometer and
 * distance traveled. A Car Model is unique - there will never be 2 cars with
 * the same model. On the first line of the input you will receive a number N -
 * the number of cars you need to track, on each of the next N lines you will
 * receive information for a car in the following format "<Model> <FuelAmount>
 * <FuelCostFor1km>", all cars start at 0 kilometers traveled.
 * 
 * After the N lines until the command "End" is received, you will receive
 * commands in the following format "Drive <CarModel> <amountOfKm>", implement a
 * method in the Car class to calculate whether a car can move that distance or
 * not. If it can the car fuel amount should be reduced by the amount of used
 * fuel and its distance traveled should be increased by the amount of
 * kilometers traveled, otherwise the car should not move (Its fuel amount and
 * distance traveled should stay the same) and you should print on the console
 * "Insufficient fuel for the drive". After the "End" command is received, print
 * each car in order of appearing in input and its current fuel amount and
 * distance traveled in the format "<Model> <fuelAmount> <distanceTraveled>",
 * where the fuel amount should be printed to two decimal places after the
 * separator.
 * 
 * @author Ivelin Gavrailov
 * @since 13.09.2020
 *
 */
public class SpeedRacing {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		Map<String, RaceCar> cars = new LinkedHashMap<>();
		for (int i = 0; i < n; i++) {
			String input = scan.nextLine();
			String[] tokens = input.split(" ");
			String model = tokens[0];
			double fuelAmount = Double.parseDouble(tokens[1]);
			double fuelCostFor1Km = Double.parseDouble(tokens[2]);
			cars.put(model, new RaceCar(model, fuelAmount, fuelCostFor1Km));
		}
		String[] tokens = scan.nextLine().split(" ");
		while (!"End".equals(tokens[0])) {
			if ("Drive".equalsIgnoreCase(tokens[0])) {
				String carModel = tokens[1];
				int amountOfKm = Integer.parseInt(tokens[2]);
				if (cars.get(carModel).drive(amountOfKm)) {
					System.out.println("Insufficient fuel for the drive");
				}
			}
			tokens = scan.nextLine().split(" ");
		}
		for (RaceCar value : cars.values()) {
			System.out.println(value);
		}
		scan.close();
	}
}
