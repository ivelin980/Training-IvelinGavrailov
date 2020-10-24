package jv.advanced.multidimensional.arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Write a program that reads a matrix from the console. Then print the
 * diagonals. The matrix will always be square. On the first line you read a
 * single integer N the matrix size. Then on each line N elements. The first
 * diagonal should always start with the element at the first row and col, the
 * second diagonal should start with the element at the last row and first col.
 * 
 * @author Ivelin Gavrailov
 * @since 12.08.2020
 *
 */
public class PrintDiagonalsOfSquareMatrix {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = Integer.parseInt(scan.nextLine());
		int[][] matrix = createSquareMatrix(scan, size);
		printDiagonalsOfSquareMatrix(matrix);
		scan.close();
	}

	private static int[][] createSquareMatrix(Scanner scan, int size) {
		int[][] matrix = new int[size][size];
		for (int i = 0; i < matrix.length; i++) {
			int[] arr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			matrix[i] = arr;
		}
		return matrix;
	}

	private static void printDiagonalsOfSquareMatrix(int[][] matrix) {
		int col = 0;
		for (int row = 0; row < matrix.length; row++) {
			System.out.print(matrix[row][col++] + " ");
		}
		System.out.println();
		col = 0;
		for (int row = matrix.length - 1; row >= 0; row--) {
			System.out.print(matrix[row][col++] + " ");
		}
	}
}
