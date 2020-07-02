package objects_and_classes.lab.main;

import java.util.Random;
import java.util.Scanner;

/**
 * You are given a list of words in one line. Randomize their order and print
 * each word at a separate line.
 * 
 * @author Ivelin Gavrailov
 * @since 29.06.2020
 *
 */
public class RandomizeWordsMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split("\\s+");
		Random random = new Random();
		for (int i = 0; i < input.length; i++) {
			int swapIndex = random.nextInt(input.length);
			String tmp = input[i];
			input[i] = input[swapIndex];
			input[swapIndex] = tmp;

		}
		for (String element : input) {
			System.out.println(element);
		}
		scan.close();
	}
}
