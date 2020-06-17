package jv.fundamentals.variables.exercise;

import java.util.Scanner;

/**
 * Read four integer numbers. Add first to the second, divide (integer) the sum
 * by the third number and multiply the result by the fourth number. Print the
 * result. Constraints • First number will be in the range [-2,147,483,648…
 * 2,147,483,647] • Second number will be in the range [-2,147,483,648…
 * 2,147,483,647] • Third number will be in the range [-2,147,483,648…
 * 2,147,483,647] • Fourth number will be in the range [-2,147,483,648…
 * 2,147,483,647]
 * 
 * @author Ivelin Gavrailov
 * @since 11.06.2020
 *
 */
public class IntegerOperations {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int firstNumber = Integer.parseInt(scan.nextLine());
		int secondNumber = Integer.parseInt(scan.nextLine());
		int thirdNumber = Integer.parseInt(scan.nextLine());
		int fourthNumber = Integer.parseInt(scan.nextLine());
		int result = (firstNumber + secondNumber) / thirdNumber * fourthNumber;
		System.out.println(result);
		scan.close();
	}
}
