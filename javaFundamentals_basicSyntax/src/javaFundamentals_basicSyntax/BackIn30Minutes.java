package javaFundamentals_basicSyntax;

import java.util.Scanner;

public class BackIn30Minutes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int hours = Integer.parseInt(scan.nextLine());
		int minutes = Integer.parseInt(scan.nextLine());
		if (minutes > 29) {
			hours++;
			minutes -= 30;
		} else {
			minutes += 30;
		}
		if (hours == 24) {
			hours = 0;
		}
		if (minutes < 10) {
			System.out.print(String.format("%d:0%d", hours, minutes));
		} else {
			System.out.print(String.format("%d:%d", hours, minutes));
		}
	}

}
