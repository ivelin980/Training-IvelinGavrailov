package jv.advanced.multidimensional.arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Write a program to generate the following matrix of palindromes of 3 letters
 * with r rows and c columns like the one in the examples below. Rows define the
 * first and the last letter: row 0  ‘a’, row 1  ‘b’, row 2  ‘c’, … Columns +
 * rows define the middle letter: o column 0, row 0  ‘a’, column 1, row 0 ‘b’,
 * column 2, row 0 ‘c’, … o column 0, row 1  ‘b’, column 1, row 1 ‘c’, column
 * 2, row 1 ‘d’, … Input The numbers r and c stay at the first line at the
 * input. r and c are integers in the range [1…26]. r + c ≤ 27
 * 
 * @author Ivelin Gavrailov
 * @since 13.08.2020
 *
 */
public class MatrixOfPalindromes {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] input = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		int rows = input[0];
		int cols = input[1];
		String[][] matrix = new String[rows][cols];
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				matrix[row][col] = "" + (char) ('a' + row) + (char) ('a' + row + col) + (char) ('a' + row);
			}
		}
		printMatrix(matrix);
		scan.close();
	}

	private static void printMatrix(String[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}
	}
}
