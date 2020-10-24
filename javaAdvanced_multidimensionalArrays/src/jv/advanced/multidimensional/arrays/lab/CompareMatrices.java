package jv.advanced.multidimensional.arrays.lab;

import java.util.Arrays;
import java.util.Scanner;


/**
 * Write a program that reads two integer matrices (2D arrays) from the console
 * and compares them element by element. For better code reusability, you could
 * do the comparison in a method, which returns true if they are equal and false
 * if not. Each matrix definition on the console will contain a line with a
 * positive integer number R – the number of rows in the matrix and C – the
 * number of columns – followed by R lines containing the C numbers, separated
 * by spaces (each line will have an equal amount of numbers. The matrices will
 * have at most 10 rows and at most 10 columns. Print equal if the matrices
 * match, and not equal if they don’t match.
 * 
 * @author Ivelin Gavrailov
 * @since 11.08.2020
 *
 */
public class CompareMatrices {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] tokens = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		int rows = tokens[0];
		int cols = tokens[1];
		boolean isEqual = true;
		int[][] firstMatrix = createMatrix(scan, rows, cols);
		tokens = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		rows = tokens[0];
		cols = tokens[1];
		int[][] secondMatrix = createMatrix(scan, rows, cols);
		if(firstMatrix.length!=secondMatrix.length) {
			isEqual = false;
		} else {
			for (int i = 0; i < secondMatrix.length; i++) {
 				if(!Arrays.equals(firstMatrix, secondMatrix)) {
				isEqual = false;
				}
			}
		}
		if(isEqual) {
			System.out.println("equal");
		}
		else {System.out.println("not equal");}
		scan.close();
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
