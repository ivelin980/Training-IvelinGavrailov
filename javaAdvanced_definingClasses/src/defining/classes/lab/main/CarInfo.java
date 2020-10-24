package defining.classes.lab.main;

import java.util.ArrayList;
import java.util.Scanner;

import defining.classes.lab.entities.Car;

/**
 * Read a cars objects, add them to collection of your chose and the print each
 * one on the console using the carInfo() method. The input consists of single
 * integer N the number of lines representing car objects. One each line you
 * will read car info in the following format {make} {model} {horsePower}
 * separated by single space.
 * 
 * @author Ivelin Gavrailov
 * @since 08.09.2020
 *
 */
public class CarInfo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = Integer.parseInt(scan.nextLine());
		ArrayList<Car> cars = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			String carInput = scan.nextLine();
			String[] tokens = carInput.split(" ");
			String make = tokens[0];
			if (tokens.length == 3) {
				String model = tokens[1];
				int hp = Integer.parseInt(tokens[2]);
				Car car = new Car(make, model, hp);
				cars.add(car);
			} else {
				Car car = new Car(make);
				cars.add(car);
			}
		}
		cars.stream().forEach(c -> System.out.println(c.getInfo()));
		scan.close();
	}
}
