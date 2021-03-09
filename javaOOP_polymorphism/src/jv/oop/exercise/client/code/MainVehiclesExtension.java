package jv.oop.exercise.client.code;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import jv.oop.exercise.vehicles.extension.Bus;
import jv.oop.exercise.vehicles.extension.Vehicle;
import jv.oop.exercise.vehicles.extension.VehicleFactoryImpl;

/**
 * Use your solution of the previous task for starting point and add more
 * functionality. Add new vehicle – Bus. Now every vehicle has tank capacity and
 * fuel quantity cannot fall (set) below 0 (If fuel quantity become less than 0
 * print on the console "Fuel must be a positive number"). The vehicles cannot
 * be filled with fuel more than their tank capacity. If you try to put more
 * fuel in the tank than the available space, print on the console "Cannot fit
 * fuel in tank" and do not add any fuel in vehicles tank. Add new command for
 * the bus. The bus can drive with or without people. If the bus is driving with
 * people, the air-conditioner is turned on and its fuel consumption per
 * kilometer is increased with 1.4 liters. If there are no people in the bus
 * when driving the air-conditioner is turned off and does not increase the fuel
 * consumption. Input • On the first three lines you will receive information
 * about the vehicles in format: Vehicle {initial fuel quantity} {liters per km}
 * {tank capacity} • On fourth line - number of commands N that will be given on
 * the next N lines • On the next N lines – commands in format o Drive Car
 * {distance} o Drive Truck {distance} o Drive Bus {distance} o DriveEmpty Bus
 * {distance} o Refuel Car {liters} o Refuel Truck {liters} o Refuel Bus
 * {liters} Output • After each Drive command print whether the Car/Truck was
 * able to travel given distance in format if it’s successful: "Car/Truck/Bus
 * traveled {distance} km" • Or if it is not: "Car/Truck/Bus needs refueling" •
 * If given fuel is ≤ 0 print "Fuel must be a positive number". • If given fuel
 * cannot fit in car or bus tank print "Cannot fit fuel in tank"
 * 
 * • Finally print the remaining fuel for car, truck and bus rounded 2 digits
 * after floating point in format: "Car: {liters} Truck: {liters} Bus: {liters}"
 * 
 * @author Ivelin Gavrailov
 * @since 04.02.2021
 *
 */
public class MainVehiclesExtension {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Map<String, Vehicle> vehicles = new LinkedHashMap<>();
		String[] input = scan.nextLine().split("\\s+");
		vehicles.put(input[0], createVehicle(input));
		input = scan.nextLine().split("\\s+");
		vehicles.put(input[0], createVehicle(input));
		input = scan.nextLine().split("\\s+");
		vehicles.put(input[0], createVehicle(input));
		int n = Integer.parseInt(scan.nextLine());
		while (n-- > 0) {
			String[] tokens = scan.nextLine().split("\\s+");
			try {
				double param = Double.parseDouble(tokens[2]);
				if ("Drive".equalsIgnoreCase(tokens[0])) {
					vehicles.get(tokens[1]).drive(param);
				} else if ("Refuel".equalsIgnoreCase(tokens[0])) {
					vehicles.get(tokens[1]).refuel(param);
				} else if ("DriveEmpty".equalsIgnoreCase(tokens[0])) {
					((Bus)vehicles.get(tokens[1])).driveEmpty(param);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		vehicles.values().forEach(System.out::println);
		scan.close();
	}

	private static Vehicle createVehicle(String[] tokens) {
		String type = tokens[0];
		double fuelQuantity = Double.parseDouble(tokens[1]);
		double fuelConsumption = Double.parseDouble(tokens[2]);
		double tankCapacity = Double.parseDouble(tokens[3]);
		VehicleFactoryImpl factory = new VehicleFactoryImpl();
		return factory.createVehicle(type, fuelQuantity, fuelConsumption, tankCapacity);
	}
}
