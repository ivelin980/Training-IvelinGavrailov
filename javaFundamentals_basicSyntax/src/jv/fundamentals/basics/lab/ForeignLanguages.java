package jv.fundamentals.basics.lab;

import java.util.Scanner;

public class ForeignLanguages {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String country = scan.nextLine();
		switch (country.toLowerCase()) {
		case "usa":
		case "england":
			System.out.println("English");
			break;
		case "argentina":
		case "spain":
		case "mexico":
			System.out.println("Spanish");
			break;
		default:
			System.out.println("unknown");
			break;
		}
		scan.close();
	}
}
