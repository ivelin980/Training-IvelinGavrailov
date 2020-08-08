package jv.advanced.stacks.and.queues.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Somewhere in the future, there is a robotics factory. The current project is
 * assembly line robots. Each robot has a processing time, the time it needs to
 * process a product. When a robot is free it should take a product for
 * processing and log his name, product and processing start time. Each robot
 * processes a product coming from the assembly line. A product is coming from
 * the line each second (so the first product should appear at [start time + 1
 * second]). If a product passes the line and there is not a free robot to take
 * it, it should be queued at the end of the line again. The robots are standing
 * on the line in the order of their appearance.
 * 
 * @author Ivelin Gavrailov
 * @since 07.08.2020
 *
 */
public class Robotics {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(";");
		ArrayDeque<String> queue = new ArrayDeque<>();
		String[] robotName = new String[input.length];
		int[] processTime = new int[input.length];
		int[] currentRobotTime = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			String[] tokens = input[i].split("-");
			robotName[i] = tokens[0];
			processTime[i] = Integer.parseInt(tokens[1]);
		}
		int[] timeInput = Arrays.stream(scan.nextLine().split(":")).mapToInt(Integer::parseInt).toArray();
		int time = timeInput[0] * 3600 + timeInput[1] * 60 + timeInput[2];
		String product = "";
		while (!"End".equalsIgnoreCase(product = scan.nextLine())) {
			queue.offer(product);
		}
		while (!queue.isEmpty()) {
			for (int i = 0; i < robotName.length; i++) {
				if (currentRobotTime[i] > 0) {
					currentRobotTime[i]--;
				}
			}

			time++;

			String currentItem = queue.poll();
			boolean isTaken = false;
			for (int i = 0; i < robotName.length; i++) {
				if (currentRobotTime[i] == 0) {
					System.out.println(String.format("%s - %s [%s]", robotName[i], currentItem, getTime(time)));
					currentRobotTime[i] = processTime[i];
					isTaken = true;
					break;
				}
			}

			if (!isTaken) {
				queue.offer(currentItem);
			}
			scan.close();
		}
	}

	private static String getTime(int time) {
		int hours = time / 3600 % 24;
		int minutes = time / 60 % 60;
		int seconds = time % 60;
		return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}
}
