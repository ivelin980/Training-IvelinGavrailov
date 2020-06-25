package jv.fundamentals.methods.exercise;

import java.util.Scanner;

/**
 * Write a program that checks if a given password is valid. Password rules are:
 * • 6 – 10 characters (inclusive) • Consists only of letters and digits • Have
 * at least 2 digits If a password is valid print “Password is valid”. If it is
 * not valid, for every unfulfilled rule print a message: • "Password must be
 * between 6 and 10 characters" • "Password must consist only of letters and
 * digits" • "Password must have at least 2 digits"
 * 
 * @author Ivelin Gavrailov
 * @since 17.06.2020
 *
 */
public class PasswordValidator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String password = scan.nextLine();
		boolean validPass = isPasswordCorrect(password);
		if (validPass) {
			System.out.println("Password is valid");
		}
		scan.close();
	}

	private static boolean isPasswordCorrect(String password) {
		return isPasswordLongEnough(password) & isPasswordWithValidCharacters(password)
				& isPasswordWithEnoughDigits(password);
	}

	private static boolean isPasswordLongEnough(String password) {
		if (password.length() < 6 || password.length() > 10) {
			System.out.println("Password must be between 6 and 10 characters");
			return false;
		}
		return true;
	}

	private static boolean isPasswordWithValidCharacters(String password) {
		password = password.toLowerCase();
		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) < 48 || (password.charAt(i) > 57 && password.charAt(i) < 97)) {
				System.out.println("Password must consist only of letters and digits");
				return false;
			}
		}
		return true;
	}

	private static boolean isPasswordWithEnoughDigits(String password) {
		int sumDigits = 0;
		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i))) {
				sumDigits++;
			}
		}
		if (sumDigits < 2) {
			System.out.println("Password must have at least 2 digits");
			return false;
		}
		return true;
	}
}
