package jv.advanced.exercise.functional.programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Write a program that reads a collection of names as strings from the console
 * and then appends “Sir” in front of every name and prints it back onto the
 * console. Use a Consumer<T>.
 * 
 * @author Ivelin Gavrailov
 * @since 25.12.2020
 *
 */
public class KnightsOfHonor {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Consumer<String> printKnights = name -> System.out.println("Sir" + " " + name);
		Arrays.stream(scan.nextLine().split("\\s+")).forEach(printKnights);
		scan.close();
	}
}
