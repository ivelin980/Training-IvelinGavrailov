package jv.advanced.multidimensional.arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Write a program that reads a rectangular integer matrix of size N x M and
 * finds in it the square 3 x 3 that has maximal sum of its elements. Input • On
 * the first line, you will receive the rows N and columns M. • On the next N
 * lines you will receive each row with its elements. Print the elements of the
 * 3 x 3 square as a matrix, along with their sum. See the format of the output
 * below:
 * 
 * @author Ivelin Gavrailov
 * @since 15.08.2020
 *
 */
public class MaximalSum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] tokens = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		int rows = tokens[0];
		int cols = tokens[1];
		int maxSum = 0;
		int resultRow = 0;
		int resultCol = 0;
		int sum = 0;
		int[][] matrix = new int[rows][cols];
		fillMatrix(scan, matrix);
		for (int row = 0; row < matrix.length - 2; row++) {
			for (int col = 0; col < matrix[row].length - 2; col++) {
				sum = matrix[row][col] + matrix[row + 1][col] + matrix[row + 2][col] + matrix[row][col + 1]
						+ matrix[row + 1][col + 1] + matrix[row + 2][col + 1] + matrix[row][col + 2]
						+ matrix[row + 1][col + 2] + matrix[row + 2][col + 2];
				if (maxSum < sum) {
					maxSum = sum;
					resultRow = row;
					resultCol = col;
				}
			}
		}
		System.out.println(String.format("Sum = %d", maxSum));
		for (int row = resultRow; row <= resultRow + 2; row++) {
			for (int col = resultCol; col <= resultCol + 2; col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}
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
}
