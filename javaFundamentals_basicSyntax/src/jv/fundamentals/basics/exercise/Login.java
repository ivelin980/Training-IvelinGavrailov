package jv.fundamentals.basics.exercise;

import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String username = scan.nextLine();
		String pass = "";
		int errors = 0;
		for (int i = username.length() - 1; i >= 0; i--) {
			pass += username.charAt(i);
		}
		String inputPass = scan.nextLine();
		if (inputPass.equals(pass)) {
			System.out.println(String.format("User %s logged in.", username));
		} else {
			while (!inputPass.equals(pass) && errors < 3) {
				System.out.println("Incorrect password. Try again.");
				errors++;
				inputPass = scan.nextLine();
			}
			if (!inputPass.equals(pass)) {
				System.out.println(String.format("User %s blocked!", username));
			} else {
				System.out.println(String.format("User %s logged in.", username));
			}
		}
		scan.close();
	}
}
