package jv.oop.working.with.abstraction.exercise.traffic.lights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Implement a simple state machine in the form of a traffic light. Every
 * traffic light has three possible signals - red, green and yellow. Each
 * traffic light can be updated, which changes the color of its signal (e.g. if
 * it is currently red, it changes to green, if it is green it changes to
 * yellow). The order of signals is red -> green -> yellow -> red and so on. On
 * the first line you will be given multiple traffic light signals in the format
 * "RED GREEN YELLOW". They may be 3, more or less than 3. You need to make as
 * many traffic lights as there are signals in the input. On the second line,
 * you will receive the n number of times you need to change each traffic
 * light's signal. Your output should consist of n number of lines, including
 * each updated traffic light's signal. To better understand the problem, see
 * the example below.
 * 
 * @author Ivelin Gavrailov
 * @since 06.01.2020
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = Arrays.stream(scan.nextLine().split("\\s+")).toArray(String[]::new);
		List<TrafficLight> lights = new ArrayList<>();
		int rotate = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < input.length; i++) {
			TrafficLight light = new TrafficLight(Color.valueOf(input[i]));
			lights.add(light);
		}
		for (int i = 0; i < rotate; i++) {
			for (TrafficLight trafficLight : lights) {
				trafficLight.update();
			}
			for (TrafficLight trafficLight : lights) {
				System.out.print(trafficLight.getColor().toString() + " ");
			}
			System.out.println();
		}
		scan.close();
	}

}
