package jv.fundamentals.arrays.exercise;

import java.util.Scanner;

/**
 * You will be given a count of wagons in a train n. On the next n lines you
 * will receive how many people are going to get on that wagon. At the end print
 * the whole train and after that the sum of the people in the train.
 * 
 * @author Ivelin Gavrailov
 * @since 16.06.2020
 *
 */
public class Train {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		int[] train = new int[n];
		int peopleInTheTrain = 0;
		for (int i = 0; i < n; i++) {
			train[i] = Integer.parseInt(scan.nextLine());
			peopleInTheTrain += train[i];
		}
		for (int i = 0; i < train.length; i++) {
			System.out.print(train[i] + " ");
		}
		System.out.println();
		System.out.println(peopleInTheTrain);
		scan.close();
	}
}
