package jv.advanced.sets.and.maps.lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Write a program that counts the occurrence of real numbers. The input is a
 * single line with real numbers separated by spaces. Print the numbers in the
 * order of appearance. All numbers must be formatted to one digit after the
 * decimal point.
 * 
 * @author Ivelin Gavrailov
 * @since 24.08.2020
 *
 */
public class CountRealNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double[] input = Arrays.stream(scan.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
		LinkedHashMap<Double, Integer> numbers = new LinkedHashMap<>();
		for (double d : input) {
			numbers.putIfAbsent(d, 0);
			numbers.put(d, numbers.get(d)+1);
		}
		for (Map.Entry<Double, Integer> entry : numbers.entrySet()) {
			System.out.println(String.format("%.1f -> %d", entry.getKey(),entry.getValue()));
		}
		scan.close();
	}
}
