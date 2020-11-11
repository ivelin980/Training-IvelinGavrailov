package customlistsorter;

import java.util.Scanner;

/**
 * Extend the previous problem by creating an additional Sorter class. It should
 * have a single static method sort() which can sort objects of type CustomList
 * containing any type that can be compared. Extend the command list to support
 * one additional command Sort: • Sort - Sort the elements in the list in
 * ascending order.
 * 
 * @author Ivelin Gavrailov
 * @since 11.11.2020
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		CustomList<String> list = new CustomList<>();
		String[] input = scan.nextLine().split(" ");
		while (!"end".equalsIgnoreCase(input[0])) {
			switch (input[0].toLowerCase()) {
			case "add": {
				String element = input[1];
				list.add(element);
				break;
			}
			case "remove":
				int index = Integer.parseInt(input[1]);
				list.remove(index);
				break;
			case "contains": {
				String element = input[1];
				System.out.println(list.contains(element));
				break;
			}
			case "swap":
				int firstIndex = Integer.parseInt(input[1]);
				int secondIndex = Integer.parseInt(input[2]);
				list.swap(firstIndex, secondIndex);
				break;
			case "greater":
				String element = input[1];
				System.out.println(list.countGreaterThan(element));
				break;
			case "max":
				System.out.println(list.getMax());
				break;
			case "min":
				System.out.println(list.getMin());
				break;
			case "sort":
				list.sort();
				break;
			case "print":
				System.out.println(list.toString());
				break;
			default:
				break;
			}
			input = scan.nextLine().split(" ");
		}
		scan.close();
	}

}
