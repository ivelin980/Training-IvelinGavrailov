package genericcountmethoddoubles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Use the description of the previous problem but now, test your list of
 * generic boxes with Doubles.
 * 
 * @author Ivelin Gavrailov
 * @since 09.11.2020
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Box<Double>> boxes = new ArrayList<>();
		int inputNumber = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < inputNumber; i++) {
			Box<Double> box = new Box<>(Double.parseDouble(scan.nextLine()));
			boxes.add(box);
		}
		Double element = Double.parseDouble(scan.nextLine());
		int count = 0;
		for (Box<Double> box : boxes) {
			if (box.getInput().compareTo(element) > 0) {
				count++;
			}
		}
		System.out.println(count);
		scan.close();
	}
}
