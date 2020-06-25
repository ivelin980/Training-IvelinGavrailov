package jv.fundamentals.methods.exercise;

import java.util.Scanner;

/**
 * Write a method to print the smallest of three integer numbers. Use
 * appropriate name for the method.
 * 
 * @author Ivelin Gavrailov
 * @since 17.06.2020
 *
 */
public class SmallestOfThreeNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int firstNumber = Integer.parseInt(scan.nextLine());
		int secondNumber = Integer.parseInt(scan.nextLine());
		int thirdNumber = Integer.parseInt(scan.nextLine());
		System.out.println(getSmallestIntegerOfThree(firstNumber, secondNumber, thirdNumber));
		scan.close();
	}

	private static int getSmallestIntegerOfThree(int firstNumber, int secondNumber, int thirdNumber) {
		if (firstNumber < secondNumber && firstNumber < thirdNumber) {
			return firstNumber;
		} else if (secondNumber < firstNumber && secondNumber < thirdNumber) {
			return secondNumber;
		}
		return thirdNumber;

	}
}
