package jv.fundamentals.methods.exercise;

import java.util.Scanner;

/**
 * You will receive 3 integers. Write a method sum to get the sum of the first
 * two integers and subtract method that subtracts the third integer from the
 * result from the Sum method.
 * 
 * @author Ivelin Gavrailov
 * @since 18.06.2020
 *
 */
public class AddAndSubstract {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int firstNumber = Integer.parseInt(scan.nextLine());
		int secondNumber = Integer.parseInt(scan.nextLine());
		int thirdNumber = Integer.parseInt(scan.nextLine());
		System.out.println(getSubstract(getSum(firstNumber, secondNumber), thirdNumber));
		scan.close();
	}

	private static int getSum(int firstNumber, int secondNumber) {
		return firstNumber + secondNumber;
	}

	private static int getSubstract(int firstNumber, int secondNumber) {
		return firstNumber - secondNumber;
	}
}
