package genericboxofinteger;

import java.util.Scanner;

/**
 * Use the description of the previous problem but now, test your generic box
 * with Integers.
 * 
 * @author Ivelin Gavrailov
 * @since 07.11.2020
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int inputNumber = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < inputNumber; i++) {
			Box<Integer> box = new Box<>(Integer.parseInt(scan.nextLine()));
			System.out.println(box);
		}
		scan.close();
	}

}
