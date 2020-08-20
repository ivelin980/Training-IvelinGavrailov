package jv.advanced.multidimensional.arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Write a program which reads a string matrix from the console and performs
 * certain operations with its elements. User input is provided in a similar way
 * like in the problems above – first you read the dimensions and then the data.
 * Your program should then receive commands in format: "swap row1 col1 row2c
 * col2" where row1, row2, col1, col2 are coordinates in the matrix. In order
 * for a command to be valid, it should start with the "swap" keyword along with
 * four valid coordinates (no more, no less). You should swap the values at the
 * given coordinates (cell [row1, col1] with cell [row2, col2]) and print the
 * matrix at each step (thus you'll be able to check if the operation was
 * performed correctly). If the command is not valid (doesn't contain the
 * keyword "swap", has fewer or more coordinates entered or the given
 * coordinates do not exist), print "Invalid input!" and move on to the next
 * command. Your program should finish when the string "END" is entered.
 * 
 * @author Ivelin Gavrailov
 * @since 16.08.2020
 * 
 */
public class MatrixShuffling {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] tokens = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		int rows = tokens[0];
		int cols = tokens[1];
		String[][] matrix = new String[rows][cols];
		fillMatrix(scan, matrix);
		String[] manipulation = scan.nextLine().split("\\s+");
		while (!"END".equalsIgnoreCase(manipulation[0])) {
			try {
				if(!"swap".equalsIgnoreCase(manipulation[0]) || manipulation.length != 5) {
					throw new IllegalStateException();
				}
				int row1 = Integer.parseInt(manipulation[1]);
				int col1 = Integer.parseInt(manipulation[2]);
				int row2 = Integer.parseInt(manipulation[3]);
				int col2 = Integer.parseInt(manipulation[4]);					
				swapElementsOfMatrix(matrix, row1, col1, row2, col2);
				printMatrix(matrix);
				}
			catch(IndexOutOfBoundsException | IllegalStateException ex) {   
				System.out.println("Invalid input!");
			}
			manipulation = scan.nextLine().split("\\s+");
		}
	}

	private static void swapElementsOfMatrix(String[][] matrix, int row1, int col1, int row2, int col2) {
		String buff = "";
		buff = matrix[row1][col1];
		matrix[row1][col1] = matrix[row2][col2];
		matrix[row2][col2] = buff;
	}

	private static void fillMatrix(Scanner scan, String[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			String[] arr = scan.nextLine().split("\\s+");
			for (int col = 0; col < arr.length; col++) {
				matrix[row] = arr;
			}
		}
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
