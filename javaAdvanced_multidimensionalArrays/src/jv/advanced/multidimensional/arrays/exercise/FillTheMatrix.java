package jv.advanced.multidimensional.arrays.exercise;

import java.util.Scanner;

/**
 * Filling a matrix in the regular way (top to bottom and left to right) is
 * boring. Write two methods that fill a matrix of size N x N in two different
 * patterns.
 * 
 * @author Ivelin Gavrailov
 * @since 13.08.2020
 *
 */
public class FillTheMatrix {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] tokens = scan.nextLine().split(", ");
		int size = Integer.parseInt(tokens[0]);
		String pattern = tokens[1];
		int[][] matrix = new int[size][size];
		if ("A".equals(pattern)) {
			fillMatrixPatternA(matrix);
			printMatrix(matrix);
		} else if ("B".equals(pattern)) {
			fillMatrixPatternB(matrix);
			printMatrix(matrix);
		}
		scan.close();
	}

	private static void fillMatrixPatternA(int[][] matrix) {
		int count = 1;
		for (int col = 0; col < matrix.length; col++) {
			for (int row = 0; row < matrix[col].length; row++) {
				matrix[row][col] = count;
				count++;
			}
		}
	}

	private static void fillMatrixPatternB(int[][] matrix) {
		int count = 1;
		for (int col = 0; col < matrix.length; col++) {
			if (col % 2 == 0) {
				for (int row = 0; row < matrix[col].length; row++) {
					matrix[row][col] = count;
					count++;
				}
			} else {
				for (int row = matrix[col].length - 1; row >= 0; row--) {
					matrix[row][col] = count;
					count++;
				}
			}
		}
	}

	private static void printMatrix(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}
	}

}
