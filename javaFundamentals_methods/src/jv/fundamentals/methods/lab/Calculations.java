package jv.fundamentals.methods.lab;

import java.util.Scanner;

/**
 * Write a program that receives a string on the first line ("add", "multiply",
 * "subtract", "divide") and on the next two lines receives two numbers. Create
 * four methods (for each calculation) and invoke the right one depending on the
 * command. The method should also print the result (needs to be void).
 * 
 * @author Ivelin Gavrailov
 * @since 17.06.2020
 *
 */
public class Calculations {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String command = scan.nextLine();
		int firstNumber = Integer.parseInt(scan.nextLine());
		int secondNumber = Integer.parseInt(scan.nextLine());
		switch (command.toLowerCase()) {
		case "add":
			add(firstNumber, secondNumber);
			break;
		case "divide":
			divide(firstNumber, secondNumber);
			break;
		case "multiply":
			multiply(firstNumber, secondNumber);
			break;
		case "substract":
			substract(firstNumber, secondNumber);
			break;
		}
		scan.close();
	}

	private static void add(int firstNumber, int secondNumber) {
		System.out.println(firstNumber + secondNumber);
	}

	private static void divide(int firstNumber, int secondNumber) {
		System.out.println(firstNumber / secondNumber);
	}

	private static void multiply(int firstNumber, int secondNumber) {
		System.out.println(firstNumber * secondNumber);
	}

	private static void substract(int firstNumber, int secondNumber) {
		System.out.println(firstNumber - secondNumber);
	}
}
