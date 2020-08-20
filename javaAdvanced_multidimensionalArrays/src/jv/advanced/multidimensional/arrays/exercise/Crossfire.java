package jv.advanced.multidimensional.arrays.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/**
 * You will receive two integers which represent the dimensions of a matrix.
 * Then, you must fill the matrix with increasing integers starting from 1, and
 * continuing on every row, like this: first row: 1, 2, 3, …, n second row: n +
 * 1, n + 2, n + 3, …, n + n third row: 2 * n + 1, 2 * n + 2, …, 2 * n + n You
 * will also receive several commands in the form of 3 integers separated by a
 * space. Those 3 integers will represent a row in the matrix, a column and a
 * radius. You must then destroy the cells which correspond to those arguments
 * cross-like. Destroying a cell means that, that cell becomes completely
 * nonexistent in the matrix. Destroying cells cross-like means that you form a
 * cross figure with center point - equal to the cell with coordinates – the
 * given row and column, and lines with length equal to the given radius. See
 * the examples for more info. The input ends when you receive the command “Nuke
 * it from orbit”. When that happens, you must print what has remained from the
 * initial matrix. Input On the first line you will receive the dimensions of
 * the matrix. You must then fill the matrix according to those dimensions On
 * the next several lines you will begin receiving 3 integers separated by a
 * single space, which represent the row, col and radius. You must then destroy
 * cells according to those coordinates When you receive the command “Nuke it
 * from orbit” the input ends Output The output is simple. You must print what
 * is left from the matrix Every row must be printed on a new line and every
 * column of a row - separated by a space
 * 
 * @author Ivelin Gavrailov
 * @since 20.08.2020
 *
 */
public class Crossfire {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] matrixSize = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		int rows = matrixSize[0];
		int cols = matrixSize[1];
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		fillMatrix(matrix,rows,cols);
		String input = scan.nextLine();
		while(!"Nuke it from orbit".equalsIgnoreCase(input)) {
			int[] tokens = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
			int row = tokens[0];
			int col = tokens[1];
			int rad = tokens[2];
			ArrayList<Integer> currentRow = matrix.get(row);
			
			for (int i = col - rad; i <= col + rad; i++) {
				if(row >= 0 && row < matrix.size() && i >= 0 && i < matrix.get(row).size()) {
				currentRow.set(i, -1);		
				} 
			}
			
			for (int i = row - rad; i <= row + rad; i++) {
				if(i >= 0 && i < matrix.size() && col >= 0 && col < matrix.get(i).size()) {
					matrix.get(i).set(col, -1);
				}
			}
			
			for (ArrayList<Integer> integers : matrix) {
				removeNegativeValues(integers);
			}
			
			matrix.removeIf(ArrayList::isEmpty);
					
			input = scan.nextLine();
		}
		
		printMatrix(matrix);
		scan.close();
	}

	private static void removeNegativeValues(ArrayList<Integer> currentRow) {
		while(currentRow.contains(-1)) {
			currentRow.remove(currentRow.indexOf(-1));
		}
		
	}

	private static void fillMatrix(ArrayList<ArrayList<Integer>> matrix, int rows, int cols) {
		int count = 1;
		for (int row = 0; row < rows; row++) {
			ArrayList<Integer> arrList = new ArrayList<>();
			for (int col = 0; col < cols; col++) {
				arrList.add(count++);
			}
			matrix.add(arrList);
		}
	}
	
	private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
		for (ArrayList<Integer> integers : matrix) {
			for (Integer integer : integers) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}
}
