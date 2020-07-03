package jv.fundamentals.methods.lab;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Write a method that receives two numbers and an operator, calculates the
 * result and returns it. You will be given three lines of input. The first will
 * be the first number, the second one will be the operator and the last one
 * will be the second number. The possible operators are: / * + -
 * 
 * @author Ivelin Gavrailov
 * @since 17.06.2020
 *
 */
public class MathOperations {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double firstNumber = Double.parseDouble(scan.nextLine());
		String symbol = scan.nextLine();
		double secondNumber = Double.parseDouble(scan.nextLine());
		switch (symbol) {
		case "*":
			System.out.println(new DecimalFormat("0.##").format(multiplyNumbers(firstNumber, secondNumber)));
			break;
		case "/":
			System.out.println(new DecimalFormat("0.##").format(divideNumbers(firstNumber, secondNumber)));
			break;
		case "+":
			System.out.println(new DecimalFormat("0.##").format(addNumbers(firstNumber, secondNumber)));
			break;
		case "-":
			System.out.println(new DecimalFormat("0.##").format(substractNumbers(firstNumber, secondNumber)));
			break;
		}
		scan.close();
	}

	private static double multiplyNumbers(double firstNumber, double secondNumber) {
		return firstNumber * secondNumber;
	}

	private static double divideNumbers(double firstNumber, double secondNumber) {
		return firstNumber / secondNumber;
	}

	private static double addNumbers(double firstNumber, double secondNumber) {
		return firstNumber + secondNumber;
	}

	private static double substractNumbers(double firstNumber, double secondNumber) {
		return firstNumber - secondNumber;
	}
}
