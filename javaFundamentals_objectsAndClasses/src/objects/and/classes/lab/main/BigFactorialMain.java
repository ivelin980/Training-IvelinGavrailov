package objects.and.classes.lab.main;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * You will receive N – number in range [0 – 1000]. Calculate Factorial of N and
 * print the result.
 * 
 * @author Ivelin Gavrailov
 * @since 29.06.2020
 *
 */
public class BigFactorialMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		BigInteger factorial = new BigInteger("1");
		for (int i = 2; i <= n; i++) {
			BigInteger multiplier = new BigInteger(Integer.toString(i));
			factorial = factorial.multiply(multiplier);
		}
		System.out.println(factorial);
		scan.close();
	}
}
