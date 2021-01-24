package exercise.froggy;

import java.util.Scanner;

/**
 * Let's play a game. You have a tiny little Frog, and a Lake with numbers. The
 * Lake and its numbers, you will get by an input from the console. Imagine,
 * your Frog belongs to the Lake. The Frog jumps only when "END" command is
 * received. When the Frog starts jumping, print on the console each number the
 * Frog has stepped over. To calculate the jumps, use the guide lines: The jumps
 * start from the 0th index. And follows the pattern - first all even indexes in
 * ascending order(0->2->4->6 and so on) and then all odd indexes in ascending
 * order (1->3->5->7 and so on). Consider the 0th index as even. Long story
 * short: Create a Class "Lake", it should implement the interface - "Iterable".
 * Inside the Lake, create a Class - "Frog" and implement the interface
 * "Iterator". Keep in mind, you will be given integers only. Input The input
 * will consist of two lines. First line - the initial numbers of the lake,
 * separated by comma and a single space. Second line command is "END". Output
 * When you receive "END", the input is over. Foreach the collection of numbers
 * the Frog has jumped over and print each element. The output should be print
 * on a single line. Format: {number}, {second number}, {third number} …
 * Constraints • Lake's numbers will be valid integers in the range
 * [2-32…232-1]. • The command will always be valid - "END".
 * 
 * @author Ivelin Gavrailov
 * @since 25.11.2020
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(", ");
		int[] numbers = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			numbers[i] = Integer.parseInt(input[i]);
		}
		Lake lake = new Lake(numbers);
		lake.iterator();
		StringBuilder builder = new StringBuilder();
		for (Integer num : lake) {
			builder.append(num + ", ");
		}
		if ("END".equalsIgnoreCase(scan.nextLine())) {
			System.out.println(builder.toString().substring(0, builder.lastIndexOf(",")));
		}
		scan.close();
	}
}
