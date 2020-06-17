package jv.fundamentals.variables.exercise;

import java.util.Scanner;

/**
 * Tony and Andi love playing in the snow and having snowball fights, but they
 * always argue which makes the best snowballs. Òhey have decided to involve you
 * in their fray, by making you write a program which calculates snowball data,
 * and outputs the best snowball value. You will receive N – an integer, the
 * number of snowballs being made by Tony and Andi. For each snowball you will
 * receive 3 input lines: • On the first line you will get the snowballSnow – an
 * integer. • On the second line you will get the snowballTime – an integer. •
 * On the third line you will get the snowballQuality – an integer. For each
 * snowball you must calculate its snowballValue by the following formula:
 * (snowballSnow / snowballTime) ^ snowballQuality At the end you must print the
 * highest calculated snowballValue. Input • On the first input line you will
 * receive N – the number of snowballs. • On the next N * 3 input lines you will
 * be receiving data about snowballs. Output • As output you must print the
 * highest calculated snowballValue, by the formula, specified above. • The
 * output format is: {snowballSnow} : {snowballTime} = {snowballValue}
 * ({snowballQuality}) Constraints • The number of snowballs (N) will be an
 * integer in range [0, 100]. • The snowballSnow is an integer in range [0,
 * 1000]. • The snowballTime is an integer in range [1, 500]. • The
 * snowballQuality is an integer in range [0, 100]. • Allowed working time /
 * memory: 100ms / 16MB.
 * 
 * @author Ivelin Gavrailov
 * @since 14.06.2020
 *
 */
public class Snowballs {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = Integer.parseInt(scan.nextLine());
		double bestSnowballValue = -1.0;
		int bestSnowballSnow = 0;
		int bestSnowballTime = 0;
		int bestSnowballQuality = 0;
		for (int i = 0; i < N; i++) {
			int snowballSnow = Integer.parseInt(scan.nextLine());
			int snowballTime = Integer.parseInt(scan.nextLine());
			int snowballQuality = Integer.parseInt(scan.nextLine());
			if (N >= 0 && N <= 100 && snowballSnow >= 0 && snowballSnow <= 1000 && snowballTime >= 1
					&& snowballTime <= 500 && snowballQuality >= 0 && snowballQuality <= 100) {
				double snowballValue = Math.pow((snowballSnow / snowballTime), snowballQuality);
				if (snowballValue > bestSnowballValue) {
					bestSnowballValue = snowballValue;
					bestSnowballSnow = snowballSnow;
					bestSnowballTime = snowballTime;
					bestSnowballQuality = snowballQuality;
				}
			}
		}
		if (bestSnowballQuality > -1.0) {
			System.out.println(String.format("%d : %d = %.0f (%d)", bestSnowballSnow, bestSnowballTime,
					bestSnowballValue, bestSnowballQuality));
		}
		scan.close();
	}
}
