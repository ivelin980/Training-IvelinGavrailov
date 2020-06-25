package jv.fundamentals.arrays.exercise;

import java.util.Scanner;

/**
 * Write a program, which prints common elements in two arrays. You have to
 * compare the elements of the second array to the elements of the first.
 * 
 * @author Ivelin Gavrailov
 * @since 16.06.2020
 *
 */
public class CommonElements {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] firstArr = scan.nextLine().split(" ");
		String[] secondArr = scan.nextLine().split(" ");
		for (String secondArrEl : secondArr) {
			for (String firstArrEl : firstArr) {
				if (secondArrEl.equals(firstArrEl)) {
					System.out.print(secondArrEl + " ");
				}
			}
		}
		scan.close();
	}
}
