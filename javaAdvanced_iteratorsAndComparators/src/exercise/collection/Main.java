package exercise.collection;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Using the ListyIterator from the last problem, extend it by implementing the
 * "Iterable" interface, implement all methods desired by the interface
 * manually. Add a new method to the class PrintAll(), the method should foreach
 * the collection and print all elements on a single line separated by a space.
 * Input Input will come from the console as lines of commands. The first line
 * will always be the Create command in the input. The last command received
 * will always be the END command. Output For every command from the input (with
 * the exception of the END and Create commands) print the result of that
 * command on the console, each on a new line. In case of Move or HasNext
 * commands print the returned value of the method, in case of a Print command
 * you don’t have to do anything additional as the method itself should already
 * print on the console. In case of a PrintAll command you should print all
 * elements on a single line separated by spaces. Your program should catch any
 * exceptions thrown because of validations and print their messages instead.
 * Constraints • Do not use the built in iterators! • There will always be only
 * one Create command and it will always be the first command passed. • The
 * number of commands received will be between [1…100]. • The last command will
 * always be the END command.
 * 
 * @author iveli
 * @since 22.11.2020
 */
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		if ("create".equalsIgnoreCase(input[0]) && input.length > 1) {
			String[] array = Arrays.copyOfRange(input, 1, input.length);
			ListyIterator<String> list = new ListyIterator<>(array);
			input = scan.nextLine().split(" ");
			while (!"end".equalsIgnoreCase(input[0])) {
				switch (input[0].toLowerCase()) {
				case "move":
					System.out.println(list.move());
					break;
				case "print":
					list.print();
					break;
				case "printall":
					list.printAll();
					break;
				case "hasnext":
					System.out.println(list.hasNext());
					break;
				case "end":
					break;
				default:
					System.out.println("Invalid Operation!");
					break;
				}
				input = scan.nextLine().split(" ");
			}
		} else {
			System.out.println("Invalid Operation!");
		}
		scan.close();
	}
}
