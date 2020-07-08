package objects.and.classes.exercise.main;

import java.util.ArrayList;
import java.util.Scanner;

import objects.and.classes.exercise.entities.VehicleCatalogue;

/**
 * You have to make a catalogue for vehicles. You will receive two types of
 * vehicle – car or truck. Until you receive the command “End” you will receive
 * lines of input in the format: {typeOfVehicle} {model} {color} {horsepower}
 * After the “End” command, you will start receiving models of vehicles. Print
 * for every received vehicle its data in the format: Type: {typeOfVehicle}
 * Model: {modelOfVehicle} Color: {colorOfVehicle} Horsepower:
 * {horsepowerOfVehicle}
 * 
 * When you receive the command "Close the Catalogue", stop receiving input and
 * print the average horsepower for the cars and for the trucks in the format:
 * "{typeOfVehicles} have average horsepower of {averageHorsepower}." The
 * average horsepower is calculated by dividing the sum of horsepower for all
 * vehicles of the type by the total count of vehicles from the same type.
 * Format the answer to the 2nd decimal point. Constraints • The type of vehicle
 * will always be car or truck. • You will not receive the same model twice. •
 * The received horsepower will be integer in the interval [1…1000] • You will
 * receive at most 50 vehicles. • Single whitespace will be used for separator.
 * 
 * @author Ivelin Gavrailov
 * @since 01.07.2020
 *
 */
public class VehicleCatalogueMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<VehicleCatalogue> vehicles = new ArrayList<>();
		String[] input = scan.nextLine().split("\\s+");
		while (!input[0].equalsIgnoreCase("end")) {
			String type = input[0];
			String brand = input[1];
			String color = input[2];
			double horsepower = Double.parseDouble(input[3]);
			VehicleCatalogue vehicle = new VehicleCatalogue(type, brand, color, horsepower);
			vehicles.add(vehicle);
			input = scan.nextLine().split("\\s+");
		}
		String searchedBrand = scan.nextLine();
		while (!searchedBrand.equalsIgnoreCase("Close the Catalogue")) {
			for (VehicleCatalogue vehicle : vehicles) {
				if (searchedBrand.equalsIgnoreCase(vehicle.getBrand())) {
					System.out.println(vehicle);
					break;
				}
			}
			searchedBrand = scan.nextLine();
		}
		double carHP = getSumOfHorsepower(vehicles, "Car");
		System.out.println(String.format("Cars have average horsepower of: %.2f.", carHP));
		double truckHP = getSumOfHorsepower(vehicles, "Truck");
		System.out.println(String.format("Trucks have average horsepower of: %.2f.", truckHP));
		scan.close();
	}

	public static double getSumOfHorsepower(ArrayList<VehicleCatalogue> vehicles, String type) {
		double sum = 0.0;
		int counter = 0;
		for (VehicleCatalogue vehicle : vehicles) {
			if (vehicle.getType().equalsIgnoreCase(type)) {
				sum += vehicle.getHorsepower();
				counter++;
			}
		}
		if (counter == 0) {
			return 0;
		}
		return sum / counter;
	}
}
