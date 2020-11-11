package genericswapmethodstrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Create a generic method that receives a list containing any type of data and
 * swaps the elements at two given indexes. As in the previous problems, read n
 * number of boxes of type String and add them to the list. On the next line,
 * however, you will receive a swap command consisting of two indexes. Use the
 * method you've created to swap the elements that correspond to the given
 * indexes and print each element in the list.
 * 
 * @author Ivelin Gavrailov
 * @since 08.11.2020
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int inputNumber = Integer.parseInt(scan.nextLine());
		List<Box<String>> boxes = new ArrayList<>();
		for (int i = 0; i < inputNumber; i++) {
			Box<String> box = new Box<>(scan.nextLine());
			boxes.add(box);
		}
		String[] indexes = scan.nextLine().split(" ");
		int firstIndex = Integer.parseInt(indexes[0]);
		int secondIndex = Integer.parseInt(indexes[1]);
		swap(boxes, firstIndex, secondIndex);
		for (Box<String> box : boxes) {
			System.out.println(box.toString());
		}
		scan.close();
	}

	public static <T> void swap(List<T> boxes, int firstIndex, int secondIndex) {
		T firstElement = boxes.get(firstIndex);
		boxes.set(firstIndex, boxes.get(secondIndex));
		boxes.set(secondIndex, firstElement);
	}
}
