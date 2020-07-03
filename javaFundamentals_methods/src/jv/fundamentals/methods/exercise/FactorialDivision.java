package jv.fundamentals.methods.exercise;

import java.util.Scanner;

/**
 * Read two integer numbers. Calculate factorial of each number. Divide the
 * first result by the second and print the division formatted to the second
 * decimal point.
 * 
 * @author Ivelin Gavrailov
 * @since 18.06.2020
 *
 */
public class FactorialDivision {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double firstNumber = Double.parseDouble(scan.nextLine());
		double secondNumber = Double.parseDouble(scan.nextLine());
		double result = divideDoublesMadeOfTheirFactorials(firstNumber, secondNumber);
		System.out.println(String.format("%.2f", result));
		scan.close();
	}

	private static double getFactorialOfNumber(double number) {
		double result = 1;
		for (int i = 1; i <= number; i++) {
			result *= i;
			
		}
		return result;
	}

	private static double divideDoublesMadeOfTheirFactorials(double number, double secondNumber) {
		double factorialOfFirst = getFactorialOfNumber(number);
		double factorialOfSecond = getFactorialOfNumber(secondNumber);
		return factorialOfFirst / factorialOfSecond;

	}
}
