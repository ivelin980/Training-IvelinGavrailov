package defining.classes.exercise.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import defining.classes.exercise.entities.Car;
import defining.classes.exercise.entities.Cargo;
import defining.classes.exercise.entities.Engine;
import defining.classes.exercise.entities.Tires;

/**
 * You are the owner of a courier company and you want to make a system for
 * tracking your cars and their cargo. Define a class Car that holds information
 * about model, engine, cargo and a collection of exactly 4 tires. The engine,
 * cargo and tire should be separate classes, create a constructor that receives
 * all information about the Car and creates and initializes its inner
 * components (engine, cargo and tires). On the first line of the input you will
 * receive a number N - the number of cars you have, on each of the next N lines
 * you will receive information about a car in the format "<Model> <EngineSpeed>
 * <EnginePower> <CargoWeight> <CargoType> <Tire1Pressure> <Tire1Age>
 * <Tire2Pressure> <Tire2Age> <Tire3Pressure> <Tire3Age> <Tire4Pressure>
 * <Tire4Age>" where the speed, power, weight and tire age are integers, tire
 * pressure is a double. After the N lines you will receive a single line with
 * one of 2 commands "fragile" or "flamable" , if the command is "fragile" print
 * all cars whose Cargo Type is "fragile" with a tire whose pressure is < 1, if
 * the command is "flamable" print all cars whose Cargo Type is "flamable" and
 * have Engine Power > 250. The cars should be printed in order of appearing in
 * the input.
 * 
 * @author Ivelin Gavrailov
 * @since 10.09.2020
 *
 */
public class RawData {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		ArrayList<Car> cars = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			ArrayList<Double> tirePressure = new ArrayList<>();
			ArrayList<Integer> tireAge = new ArrayList<>();
			String input = scan.nextLine();
			String[] tokens = input.split(" ");
			String model = tokens[0];
			int engineSpeed = Integer.parseInt(tokens[1]);
			int enginePower = Integer.parseInt(tokens[2]);
			int cargoWeight = Integer.parseInt(tokens[3]);
			String cargoType = tokens[4];
			String tiresInput = input.substring(input.indexOf(cargoType) + cargoType.length() + 1);
			String[] tiresStats = tiresInput.split(" ");
			for (int j = 0; j < 8; j += 2) {
				tirePressure.add(Double.parseDouble(tiresStats[j]));
				tireAge.add(Integer.parseInt(tiresStats[j + 1]));
			}
			Engine engine = new Engine(engineSpeed, enginePower);
			Cargo cargo = new Cargo(cargoWeight, cargoType);
			Tires tires = new Tires(tirePressure, tireAge);
			Car car = new Car(model, engine, cargo, tires);
			cars.add(car);
		}
		String command = scan.nextLine();
		for (Car car : cars) {
			if ("fragile".equalsIgnoreCase(command)) {
				if (command.equalsIgnoreCase(car.getCargo().getCargoType())
						&& hasRequiredTirePressure(car.getTires().getTirePressure())) {
					System.out.println(car.getModel());
				}
			} else if ("flamable".equalsIgnoreCase(command)) {
				if (command.equalsIgnoreCase(car.getCargo().getCargoType()) && car.getEngine().getEnginePower() > 250) {
					System.out.println(car.getModel());
				}
			}
		}
		scan.close();
	}

	private static boolean hasRequiredTirePressure(List<Double> tirePressure) {
		for (Double d : tirePressure) {
			if (d < 1) {
				return true;
			}
		}
		return false;
	}
}
