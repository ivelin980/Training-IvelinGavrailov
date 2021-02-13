package jv.oop.interfaces.and.abstraction.lab.car.shop;

/**
 * Build hierarchy from classes and interfaces for this UML diagram <<inteface>>
 * <<Car>> +TIRES: Integer +getModel(): String +getColor(): String
 * +getHorsePower(): Integer +countryProduced(): String
 * 
 * Seat +toString(): String
 * 
 * @author Ivelin Gavrailov
 * @since 09.02.2021
 *
 */
public class Main {

	public static void main(String[] args) {
		try {
			Car seat = new Seat("Leon", "gray", 110, "Spain");
			System.out.println(String.format("%s is %s color and have %s horse power", seat.getModel(), seat.getColor(),
					seat.getHorsePower()));
			System.out.println(seat.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
