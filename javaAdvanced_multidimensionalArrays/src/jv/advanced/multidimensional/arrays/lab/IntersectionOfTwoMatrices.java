package jv.advanced.multidimensional.arrays.lab;

import java.util.Scanner;

/**
 * Write a program that reads two char matrices (A[][] and B[][]) of the same
 * order M * N and prints third matrix C[][] which is filled with the
 * intersecting elements of A and B, otherwise set the element to '*'. On the
 * first two lines you receive M and N, then on 2 * M lines N characters – the
 * matrices elements. The matrix elements may be any ASCII char except '*'.
 * 
 * @author Ivelin Gavrailov
 * @since 11.08.2020
 *
 */
public class IntersectionOfTwoMatrices {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int rows = Integer.parseInt(scan.nextLine());
		int cols = Integer.parseInt(scan.nextLine());
		String[][] firstMatrix = createMatrix(scan, rows, cols);
		String[][] secondMatrix = createMatrix(scan, rows, cols);
		String[][] resultMatrix = new String[rows][cols];
		for (int i = 0; i < resultMatrix.length; i++) {
			String[] arr = firstMatrix[i];
			String[] arr2 = secondMatrix[i];
			for (int j = 0; j < arr.length; j++) {
				if (arr[j].equals(arr2[j])) {
					System.out.print(arr[j] + " ");
				} else {
					System.out.print("*" + " ");
				}
			}
			System.out.println();
		}
		scan.close();
	}

	private static String[][] createMatrix(Scanner scan, int rows, int cols) {
		String[][] matrix = new String[rows][cols];
		for (int i = 0; i < matrix.length; i++) {
			String[] arr = scan.nextLine().split("\\s+");
			matrix[i] = arr;
		}
		return matrix;
	}
}
