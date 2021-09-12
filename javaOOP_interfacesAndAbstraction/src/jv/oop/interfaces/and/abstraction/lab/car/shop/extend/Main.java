package jv.oop.interfaces.and.abstraction.lab.car.shop.extend;

/**
 * Extend previous problem:
 * 
 * CarImpl +CarImpl(model, color, horsePower, countryProduced) +toString():
 * String
 * 
 * <<Rentable>> +getMinRentDay(): Integer +getPricePerDay(): Double
 * 
 * <<Sellable>> +getPrice(): Double
 * 
 * Audi (is rentable) -minRentDay: Integer -pricePerDay: Double +toString():
 * String
 * 
 * Seat (is sellable) -price: Double +toString(): String
 * 
 * 
 * @author Ivelin Gavrailov
 * @since 09.02.2021
 *
 */
public class Main {

	public static void main(String[] args) {
		try {
			Car seat = new Seat("Leon", "Gray", 110, "Spain", 11111.1);
			Car audi = new Audi("A4", "Gray", 110, "Germany", 3, 99.9);
			printCarInfo(seat);
			printCarInfo(audi);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void printCarInfo(Car car) {
		System.out.println(String.format("%s is %s color and have %s horse power", car.getModel(), car.getColor(),
				car.getHorsePower()));
		System.out.println(car.toString());
	}
}
