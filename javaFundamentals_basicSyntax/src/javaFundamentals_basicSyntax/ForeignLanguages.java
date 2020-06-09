package javaFundamentals_basicSyntax;

import java.util.Scanner;

public class ForeignLanguages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String country = scan.nextLine();
		switch (country) {
		case "USA":
		case "England":
			System.out.println("English");
			break;
		case "Argentina":
		case "Spain":
		case "Mexico":
			System.out.println("Spanish");
			break;
		default:
			System.out.println("unknown");
			break;
		}

	}
}
