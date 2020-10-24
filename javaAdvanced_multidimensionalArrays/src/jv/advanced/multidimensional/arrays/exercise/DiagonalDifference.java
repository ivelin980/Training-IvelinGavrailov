package jv.advanced.multidimensional.arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Write a program that finds the difference between the sums of the square
 * matrix diagonals (absolute value).
 * 
 * @author Ivelin Gavrailov
 * @since 15.08.2020
 *
 */
public class DiagonalDifference {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = Integer.parseInt(scan.nextLine());
		int[][] matrix = new int[size][size];
		fillMatrix(scan, matrix);
		System.out.println(getDiagonalsSumsDifference(matrix));
		scan.close();
	}

	private static void fillMatrix(Scanner scan, int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			int[] arr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			for (int col = 0; col < arr.length; col++) {
				matrix[row] = arr;
			}
		}
	}

	private static int getDiagonalsSumsDifference(int[][] matrix) {
		int sum1 = 0;
		int sum2 = 0;
		int col = 0;
		for (int row = 0; row < matrix.length; row++) {
			sum1 += matrix[row][col];
			col++;
		}
		col = 0;
		for (int row = matrix.length - 1; row >= 0; row--) {
			sum2 += matrix[row][col];
			col++;
		}
		return Integer.max(sum1, sum2) - Integer.min(sum1, sum2);
	}
}
