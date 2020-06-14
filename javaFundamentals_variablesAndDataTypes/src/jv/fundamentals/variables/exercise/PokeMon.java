package jv.fundamentals.variables.exercise;

import java.util.Scanner;

/**
 * A Poke Mon is a special type of pokemon which likes to Poke others. But at
 * the end of the day, the Poke Mon wants to keeps statistics, about how many
 * pokes it has managed to make. The Poke Mon pokes his target, and then
 * proceeds to poke another target. The distance between his targets reduces his
 * poke power. You will be given the poke power the Poke Mon has, N � an
 * integer. Then you will be given the distance between the poke targets, M � an
 * integer. Then you will be given the exhaustionFactor Y � an integer. Your
 * task is to start subtracting M from N until N becomes less than M, i.e. the
 * Poke Mon does not have enough power to reach the next target. Every time you
 * subtract M from N that means you�ve reached a target and poked it
 * successfully. COUNT how many targets you�ve poked � you�ll need that count.
 * The Poke Mon becomes gradually more exhausted. IF N becomes equal to EXACTLY
 * 50 % of its original value, you must divide N by Y, if it is POSSIBLE. This
 * DIVISION is between integers. If a division is not possible, you should NOT
 * do it. Instead, you should continue subtracting. After dividing, you should
 * continue subtracting from N, until it becomes less than M. When N becomes
 * less than M, you must take what has remained of N and the count of targets
 * you�ve poked, and print them as output.
 * 
 * NOTE: When you are calculating percentages, you should be PRECISE at maximum.
 * Example: 505 is NOT EXACTLY 50 % from 1000, its 50.5 %. Input � The input
 * consists of 3 lines. � On the first line you will receive N � an integer. �
 * On the second line you will receive M � an integer. � On the third line you
 * will receive Y � an integer. Output � The output consists of 2 lines. � On
 * the first line print what has remained of N, after subtracting from it. � On
 * the second line print the count of targets, you�ve managed to poke.
 * Constrains � The integer N will be in the range [1, 2.000.000.000]. � The
 * integer M will be in the range [1, 1.000.000]. � The integer Y will be in the
 * range [0, 9]. � Allowed time / memory: 16 MB / 100ms.
 * 
 * @author Ivelin Gavrailov
 * @since 14.06.2020
 *
 */
public class PokeMon {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int pokePower = Integer.parseInt(scan.nextLine());
		int distance = Integer.parseInt(scan.nextLine());
		int exhaustionFactor = Integer.parseInt(scan.nextLine());
		int count = 0;
		int originalPower = pokePower;
		if (pokePower >= 1 && pokePower <= 2E9 && distance >= 1 && distance <= 1E6
				&& exhaustionFactor >= 0 && exhaustionFactor <= 9) {
			while (pokePower > distance) {
				pokePower -= distance;
				count++;
				if (originalPower * 0.5 == pokePower) {
					pokePower /= exhaustionFactor;
				}
			}
		}
		System.out.println(pokePower);
		System.out.println(count);
		scan.close();
	}
}
