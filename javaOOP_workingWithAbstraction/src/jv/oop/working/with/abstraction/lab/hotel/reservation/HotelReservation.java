package jv.oop.working.with.abstraction.lab.hotel.reservation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * You are given a working project for a small Student System, but the code is
 * very poorly organized. Break up the code logically into smaller functional
 * units – methods and classes and don’t break the functionality. The program
 * supports the following commands: • “Create <studentName> <studentAge>
 * <studentGrade>” – creates a new student and adds them to the repository. •
 * “Show <studentName>” – prints on the console information about a student in
 * the format: “<studentName> is <studentAge> years old. <commentary>”, where
 * the commentary is based on the student’s grade. • “Exit” – closes the
 * program. Do not add any extra validation or functionality to the app!
 * 
 * @author Ivelin Gavrailov
 * @since 05.01.2021
 *
 */
public class HotelReservation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = Arrays.stream(scan.nextLine().split("\\s+")).toArray(String[]::new);
		double pricePerDay = Double.parseDouble(input[0]);
		int days = Integer.parseInt(input[1]);
		Seasons season = Seasons.valueOf(input[2].toUpperCase());
		DiscountType discount = DiscountType.valueOf(input[3].toUpperCase());
		PriceCalculator priceCalculator = new PriceCalculator(pricePerDay, days, season, discount);
		System.out.println(String.format("%.2f", priceCalculator.calculatePrice()));
		scan.close();
	}
}
