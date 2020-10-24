package jv.advanced.multidimensional.arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Write a program that reads a matrix from the console. Then find the biggest
 * sum of a 2x2 submatrix. Print the submatrix and its sum. On the first line
 * you will get the dimensions of the matrix in format {rows, columns}. On the
 * next lines you will get the elements for each row separated with a coma.
 * 
 * @author Ivelin Gavrailov
 * @since 11.08.2020
 *
 */
public class MaximumSumOf2x2Submatrix {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] tokens = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
		int rows = tokens[0];
		int cols = tokens[1];
		int[][] matrix = createMatrix(scan, rows, cols);
		int bestSum = Integer.MIN_VALUE;
		int resultRow = 0;
		int resultCol = 0;
		for (int i = 0; i < matrix.length - 1; i++) {
			for (int j = 0; j < matrix[i].length - 1; j++) {
				int sum = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];
				if (sum > bestSum) {
					bestSum = sum;
					resultRow = i;
					resultCol = j;
				}
			}
		}
		System.out.print(String.format("%d %d%n%d %d", matrix[resultRow][resultCol], matrix[resultRow][resultCol + 1],
				matrix[resultRow + 1][resultCol], matrix[resultRow + 1][resultCol + 1]));
		System.out.println();
		System.out.println(bestSum);
		scan.close();
	}

	private static int[][] createMatrix(Scanner scan, int rows, int cols) {
		int[][] matrix = new int[rows][cols];
		for (int i = 0; i < matrix.length; i++) {
			int[] arr = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
			matrix[i] = arr;
		}
		return matrix;
	}
}
