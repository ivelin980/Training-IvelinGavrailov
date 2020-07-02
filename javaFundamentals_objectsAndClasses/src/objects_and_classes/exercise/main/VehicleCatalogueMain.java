package objects_and_classes.exercise.main;

import java.util.ArrayList;
import java.util.Scanner;

import objects_and_classes.exercise.entities.VehicleCatalogue;

/**
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
			VehicleCatalogue vehicle = new VehicleCatalogue();
			vehicle.setType(type);
			vehicle.setBrand(brand);
			vehicle.setColor(color);
			vehicle.setHorsepower(horsepower);
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
		System.out.println(String.format("Cars have average horsepower of: %.2f.",carHP));
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
		if(counter == 0) {
			return 0;
		}
		return sum / counter;
	}
}
