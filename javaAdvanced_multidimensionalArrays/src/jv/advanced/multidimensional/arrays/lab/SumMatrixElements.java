package jv.advanced.multidimensional.arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Write a program that reads a matrix from the console and prints: The count of
 * rows The count of columns The sum of all matrix’s elements On the first line
 * you will get the dimensions of the matrix in format {rows, columns}. On the
 * next lines you will get the elements for each row separated with a coma.
 * 
 * @author Ivelin Gavrailov
 * @since 11.08.2020
 *
 */
public class SumMatrixElements {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] tokens = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
		int rows = tokens[0];
		int cols = tokens[1];
		int[][] matrix = createMatrix(scan, rows, cols);
		System.out.println(rows);
		System.out.println(cols);
		System.out.println(getSumOfMatrixElements(matrix));
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

	private static int getSumOfMatrixElements(int[][] matrix) {
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			int[] arr = matrix[i];
			for (int j = 0; j < arr.length; j++) {
				sum += arr[j];
			}
		}
		return sum;
	}
}
