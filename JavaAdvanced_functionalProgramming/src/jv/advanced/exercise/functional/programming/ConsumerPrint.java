package jv.advanced.exercise.functional.programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Write a program that reads a collection of strings, separated by one or more
 * whitespaces, from the console and then prints them onto the console. Each
 * string should be printed on a new line. Use a Consumer<T>.
 * 
 * @author Ivelin Gavrailov
 * @since 25.12.2020
 *
 */
public class ConsumerPrint {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Consumer<String> printAll = System.out::println;
		Arrays.stream(scan.nextLine().split("\\s+")).forEach(printAll);
		scan.close();
	}

}
