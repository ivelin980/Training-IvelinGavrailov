package jv.advanced.lab.functional.programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;

/**
 * Write a program that reads one line of Double prices separated by ", ". Print
 * the prices with added VATs for all of them. Format them to the 2nd digit
 * after the decimal point. The order of the prices must remain the same. Use an
 * UnaryOperator<Double>
 * 
 * @author Ivelin Gavrailov
 * @since 25.12.2020
 *
 */
public class AddVat {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DoubleUnaryOperator applyVat = p -> p * 1.2;
		System.out.println("Prices with VAT:");
		Arrays.stream(scan.nextLine().split(", ")).mapToDouble(p -> applyVat.applyAsDouble((Double.parseDouble(p))))
				.forEach(vatValue -> System.out.println(String.format("%.2f", vatValue)));
		scan.close();
	}
}
