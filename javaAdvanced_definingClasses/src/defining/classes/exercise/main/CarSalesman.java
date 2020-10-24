package defining.classes.exercise.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import defining.classes.exercise.entities.CarForSale;
import defining.classes.exercise.entities.EngineForCar;

/**
 * Define two classes Car and Engine. A Car has a model, engine, weight and
 * color. An Engine has model, power, displacement and efficiency. A Cars weight
 * and color and its Engine’s displacements and efficiency are optional. On the
 * first line, you will read a number N which will specify how many lines of
 * engines you will receive, on each of the next N lines you will receive
 * information about an Engine in the following format "<Model> <Power>
 * <Displacement> <Efficiency>". After the lines with engines, on the next line
 * you will receive a number M – specifying the number of Cars that will follow,
 * on each of the next M lines the information about a Car will follow in the
 * following format "<Model> <Engine> <Weight> <Color>", where the engine in the
 * format will be the model of an existing Engine. When creating the object for
 * a Car, you should keep a reference to the real engine in it, instead of just
 * the engines model, note that the optional properties might be missing from
 * the formats. Your task is to print each car (in the order you received them)
 * and its information in the format defined bellow. If any of the optional
 * fields has not been given print "n/a" in its place instead of: <CarModel>:
 * <EngineModel>: Power: <EnginePower> Displacement: <EngineDisplacement>
 * Efficiency: <EngineEfficiency> Weight: <CarWeight> Color: <CarColor> Optional
 * Override the classes ToString() methods to have a reusable way of displaying
 * the objects.
 * 
 * @author Ivelin Gavrailov
 * @since 11.09.2020
 *
 */
public class CarSalesman {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<EngineForCar> engines = new ArrayList<>();
		ArrayList<CarForSale> cars = new ArrayList<>();
		int engineCount = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < engineCount; i++) {
			String[] tokens = scan.nextLine().split(" ");
			String engineModel = tokens[0];
			int enginePower = Integer.parseInt(tokens[1]);
			String engineDisplacement = null;
			String engineEfficiency = null;
			try {
				if (Character.isDigit(tokens[2].charAt(0))) {
					engineDisplacement = tokens[2];
					engineEfficiency = tokens[3];
				} else {
					engineEfficiency = tokens[2];
					engineDisplacement = tokens[3];
				}
			} catch (IndexOutOfBoundsException e) {
			}
			EngineForCar engine = new EngineForCar(engineModel, enginePower, engineDisplacement, engineEfficiency);
			engines.add(engine);
		}
		int carCount = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < carCount; i++) {
			String[] tokens = scan.nextLine().split(" ");
			String carModel = tokens[0];
			String carEngineName = tokens[1];
			String carWeight = null;
			String carColor = null;
			try {
				if (Character.isDigit(tokens[2].charAt(0))) {
					carWeight = tokens[2];
					carColor = tokens[3];
				} else {
					carColor = tokens[2];
					carWeight = tokens[3];
				}
			}

			catch (IndexOutOfBoundsException e) {
			}
			EngineForCar carEngine = engines.get(getIndexOfEngine(engines, carEngineName));
			CarForSale car = new CarForSale(carModel, carEngine, carWeight, carColor);
			cars.add(car);
		}
		cars.stream().forEach(c -> System.out.println(c.toString()));
		scan.close();
	}

	public static int getIndexOfEngine(List<EngineForCar> engines, String engineModel) {
		for (int i = 0; i < engines.size(); i++) {
			if (engines.get(i).getModel().equals(engineModel)) {
				return i;
			}
		}
		return 0;
	}

}
