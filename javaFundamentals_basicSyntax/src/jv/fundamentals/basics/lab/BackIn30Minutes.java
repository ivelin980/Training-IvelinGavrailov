package jv.fundamentals.basics.lab;

import java.util.Scanner;

/**
 * Every time Stamat tries to pay his bills he sees on the cash desk the sign:
 * &quot;I will be back in 30 minutes&quot;. One day Stamat was sick of waiting
 * and decided he needs a program, which prints the time after 30 minutes. That
 * way he won’t have to wait on the desk and come at the appropriate time. He
 * gave the assignment to you, so you have to do it.
 * <p>
 * Input The input will be on two lines. On the first line, you will receive the
 * hours and on the second you will receive the minutes.
 * <p>
 * Output Print on the console the time after 30 minutes. The result should be
 * in format &quot;hh:mm&quot;. The hours have one or two numbers and the
 * minutes have always two numbers (with leading zero).
 * 
 * @author Ivelin.Gavrailov
 * @since 09.06.2020
 */
public class BackIn30Minutes {

	public static void main(String[] args) {
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
		scan.close();
	}

}
