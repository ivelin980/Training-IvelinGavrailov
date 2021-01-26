package jv.oop.working.with.abstraction.exercise.jedi.galaxy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Pesho is Jedi and so he starts gathering stars to grow stronger. His galaxy
 * is represented as a two-dimensional array. Every cell in the matrix is a star
 * that has a value. Ivo starts at the given col and row. He can move only on
 * the diagonal from the lowest left to the upper right, and adds to his score
 * all the stars (values) from the cells he passes through. Unfortunately, there
 * is always an Evil power that tries to prevent his success. Evil power starts
 * at the given row and col and instantly destroys all stars on the opposite
 * diagonal – From lowest right to the upper left. Ivo adds the values only of
 * the stars that are not destroyed by the evil power. You will receive two
 * integers, separated by space, which represent the two dimensional array - the
 * first being the rows and the second being the columns. Then, you must fill
 * the two dimensional array with increasing integers starting from 0, and
 * continuing on every row, like this: first row: 0, 1, 2… m second row: n+1,
 * n+2, n+3… n + n.
 * 
 * @author Ivelin Gavrailov
 * @since 08.01.2021
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] dimestions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int x = dimestions[0];
		int y = dimestions[1];

		int[][] matrix = fillMatrix(x, y);

		String command = scanner.nextLine();
		long sum = 0;
		while (!command.equals("Let the Force be with you")) {
			int[] jediCoordinates = getCoordinates(command);
			int[] sethCoordinates = getCoordinates(scanner.nextLine());
			int sethRow = sethCoordinates[0];
			int sethCol = sethCoordinates[1];
			int jediRow = jediCoordinates[0];
			int jediCol = jediCoordinates[1];

			setSethDiagonalToZero(matrix, sethRow, sethCol);

			getSumForJedi(matrix, jediRow, jediCol);

			command = scanner.nextLine();
		}
		System.out.println(sum);
		scanner.close();
	}

	private static int getSumForJedi(int[][] matrix, int jediRow, int jediCol) {
		int sum = 0;
		while (jediRow >= 0 && jediCol < matrix[1].length) {
			if (jediRow < matrix.length && jediCol < matrix[0].length) {
				sum += matrix[jediRow][jediCol];
			}

			jediCol++;
			jediRow--;
		}
		return sum;
	}

	private static int[] getCoordinates(String command) {
		return Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
	}

	private static void setSethDiagonalToZero(int[][] matrix, int sethRow, int sethCol) {
		while (sethRow >= 0 && sethCol >= 0) {
			if (sethRow < matrix.length && sethCol < matrix[0].length) {
				matrix[sethRow][sethCol] = 0;
			}
			sethRow--;
			sethCol--;
		}
	}

	private static int[][] fillMatrix(int x, int y) {
		int[][] matrix = new int[x][y];
		int value = 0;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				matrix[i][j] = value++;
			}
		}
		return matrix;
	}
}
