package genericswapmethodintegers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Use the description of the previous problem but now, test your list of
 * generic boxes with Integers.
 * 
 * @author Ivelin Gavrailov
 * @since 08.11.2020
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int inputNumber = Integer.parseInt(scan.nextLine());
		List<Box<Integer>> boxes = new ArrayList<>();
		for (int i = 0; i < inputNumber; i++) {
			Box<Integer> box = new Box<>(Integer.parseInt(scan.nextLine()));
			boxes.add(box);
		}
		String[] indexes = scan.nextLine().split(" ");
		int firstIndex = Integer.parseInt(indexes[0]);
		int secondIndex = Integer.parseInt(indexes[1]);
		swap(boxes, firstIndex, secondIndex);
		for (Box<Integer> box : boxes) {
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
