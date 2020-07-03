package objects.and.classes.lab.main;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * You will receive two numbers (0 to 1050), print their sum.
 * 
 * @author Ivelin Gavrailov
 * @since 29.06.2020
 *
 */
public class SumBigNumbersMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BigInteger firstNumber = new BigInteger(scan.nextLine());
		BigInteger secondNumber = new BigInteger(scan.nextLine());
		BigInteger sum = firstNumber.add(secondNumber);
		System.out.println(sum);
		scan.close();
	}

}
