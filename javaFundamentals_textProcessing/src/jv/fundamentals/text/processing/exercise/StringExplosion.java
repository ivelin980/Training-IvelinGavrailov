package jv.fundamentals.text.processing.exercise;

import java.util.Scanner;

/**
 * Explosions are marked with ‘>’. Immediately after the mark, there will be an
 * integer, which signifies the strength of the explosion. You should remove x
 * characters (where x is the strength of the explosion), starting after the
 * punch character (‘>’). If you find another explosion mark (‘>’) while you’re
 * deleting characters, you should add the strength to your previous explosion.
 * When all characters are processed, print the string without the deleted
 * characters. You should not delete the explosion character – ‘>’, but you
 * should delete the integers, which represent the strength. Input You will
 * receive single line with the string. Output Print what is left from the
 * string after explosions. Constraints • You will always receive a strength for
 * the punches • The path will consist only of letters from the Latin alphabet,
 * integers and the char ‘>’ • The strength of the punches will be in the
 * interval [0…9]
 * 
 * @author Ivelin Gavrailov
 * @since 14.07.2020
 *
 */
public class StringExplosion {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		StringBuilder result = new StringBuilder();
		int power = 0;
		for (int i = 0; i < input.length(); i++) {
			char symbol = input.charAt(i);
			if (symbol == '>') {
				result.append('>');
				power += Integer.parseInt(String.valueOf(input.charAt(i + 1)));
			} else if (power == 0) {
				result.append(symbol);
			} else {
				power--;
			}
		}
		System.out.println(result);
		scan.close();
	}
}
