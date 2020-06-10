package jv.fundamentals.basics.lab;

import java.util.Scanner;

public class MultiplicationTable2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = Integer.parseInt(scan.nextLine());
		int mult = Integer.parseInt(scan.nextLine());
		if (mult <= 10) {
			for (int i = mult; i <= 10; i++) {
				System.out.println(String.format("%d X %d = %d", input, i, input * i));
			}
		} else {
			System.out.println(String.format("%d X %d = %d", input, mult, input * mult));
		}
		scan.close();
	}

}
