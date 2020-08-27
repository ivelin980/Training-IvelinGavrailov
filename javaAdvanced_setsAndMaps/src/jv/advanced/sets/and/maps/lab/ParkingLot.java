package jv.advanced.sets.and.maps.lab;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Write program that: Record car number for every car that enter in parking lot
 * Remove car number when the car go out Input will be string in format
 * [direction, carNumber] input end with string "END" Print the output with all
 * car numbers which are in parking lot
 * 
 * @author Ivelin Gavrailov
 * @since 21.08.2020
 *
 */
public class ParkingLot {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		LinkedHashSet<String> parkingLot = new LinkedHashSet<>();
		while (!"End".equalsIgnoreCase(input)) {
			String move = input.substring(0, input.indexOf(','));
			String number = input.substring(input.indexOf(',') + 2, input.length());
			if ("IN".equalsIgnoreCase(move)) {
				parkingLot.add(number);
			} else if ("OUT".equalsIgnoreCase(move)) {
				parkingLot.remove(number);
			}
			input = scan.nextLine();
		}
		for (String number : parkingLot) {
			System.out.println(number);
		}
		if (parkingLot.isEmpty()) {
			System.out.println("Parking Lot is Empty");
		}
		scan.close();
	}

}
