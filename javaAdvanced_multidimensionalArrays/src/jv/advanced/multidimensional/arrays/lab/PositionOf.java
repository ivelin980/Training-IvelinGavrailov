package jv.advanced.multidimensional.arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Write a program that reads a matrix of integers from the console, then a
 * number and prints all the positions at which that number appears in the
 * matrix. The matrix definition on the console will contain a line with two
 * positive integer numbers R and C – the number of rows and columns in the
 * matrix – followed by R lines, each containing C numbers (separated by
 * spaces), representing each row of the matrix. The number you will need to
 * find the positions of will be entered on a single line, after the matrix. You
 * should print each position on a single line – first print the row, then the
 * column at which the number appears. If the number does not appear in the
 * matrix, print not found
 * 
 * @author Ivelin Gavrailov
 * @since 11.08.2020
 *
 */
public class PositionOf {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] tokens = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		int rows = tokens[0];
		int cols = tokens[1];
		int[][] matrix = createMatrix(scan, rows, cols);
		int number = Integer.parseInt(scan.nextLine());
		searchInMatrixForSpecificNumber(matrix, number);
	}

	private static void searchInMatrixForSpecificNumber(int[][] matrix, int number) {
		boolean isNumberFound = false;
		for (int i = 0; i < matrix.length; i++) {
			int[] arr = matrix[i];
			for (int j = 0; j < arr.length; j++) {
				if (number == arr[j]) {
					System.out.println(i + " " + j);
					isNumberFound = true;
				}
			}
		}
		if (!isNumberFound) {
			System.out.println("not found");
		}
	}

	private static int[][] createMatrix(Scanner scan, int rows, int cols) {
		int[][] matrix = new int[rows][cols];
		for (int i = 0; i < matrix.length; i++) {
			int[] arr = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			matrix[i] = arr;
		}
		return matrix;
	}
}
