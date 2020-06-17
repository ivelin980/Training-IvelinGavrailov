package jv.fundamentals.variables.exercise;

import java.util.Scanner;

/**
 * Write a program, which sums the ASCII codes of n characters. Print the sum on
 * the console. Input • On the first line, you will receive n – the number of
 * lines, which will follow • On the next n lines – you will receive letters
 * from the Latin alphabet Output Print the total sum in the following format:
 * The sum equals: {totalSum} Constraints • n will be in the interval [1…20]. •
 * The characters will always be either upper or lower-case letters from the
 * English alphabet • You will always receive one letter per line
 * 
 * @author Ivelin Gavrailov
 * @since 11.06.2020
 *
 */
public class SumOfChars {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		int sum = 0;
		for (int i = 0; i < n; i++) {
			char letter = scan.nextLine().charAt(0);
			sum += letter;
		}
		System.out.print(String.format("The sum equals: %d", sum));
		scan.close();
	}
}
