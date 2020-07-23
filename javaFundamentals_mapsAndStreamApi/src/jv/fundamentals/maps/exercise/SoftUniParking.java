package jv.fundamentals.maps.exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * SoftUni just got a new parking lot. It’s so fancy, it even has online parking
 * validation. Except, the online service doesn’t work. It can only receive
 * users’ data, but doesn’t know what to do with it. Good thing you’re on the
 * dev team and know how to fix it, right? Write a program, which validates
 * parking for an online service. Users can register to park and unregister to
 * leave. The program receives 2 commands: • "register {username}
 * {licensePlateNumber}": o The system only supports one car per user at the
 * moment, so if a user tries to register another license plate, using the same
 * username, the system should print: "ERROR: already registered with plate
 * number {licensePlateNumber}" o If the aforementioned checks pass
 * successfully, the plate can be registered, so the system should print:
 * "{username} registered {licensePlateNumber} successfully" • "unregister
 * {username}": o If the user is not present in the database, the system should
 * print: "ERROR: user {username} not found" o If the aforementioned check
 * passes successfully, the system should print: "{username} unregistered
 * successfully" After you execute all of the commands, print all the currently
 * registered users and their license plates in the format: • "{username} =>
 * {licensePlateNumber}" Input • First line: n – number of commands – integer •
 * Next n lines: commands in one of two possible formats: o Register: "register
 * {username} {licensePlateNumber}" o Unregister: "unregister {username}" The
 * input will always be valid and you do not need to check it explicitly.
 * 
 * @author Ivelin Gavrailov
 * @since 08.07.2020
 *
 */
public class SoftUniParking {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		LinkedHashMap<String, String> users = new LinkedHashMap<>();
		for (int i = 0; i < n; i++) {
			String[] tokens = scan.nextLine().split("\\s+");
			String username = tokens[1];
			if ("register".equalsIgnoreCase(tokens[0])) {
				String licensePlateNumber = tokens[2];
				if (users.containsKey(username)) {
					System.out.println(
							String.format("ERROR: already registered with plate number %s", users.get(username)));
				} else {
					users.put(username, licensePlateNumber);
					System.out.println(String.format("%s registered %s successfully", username, licensePlateNumber));
				}
			} else {
				if (!users.containsKey(username)) {
					System.out.println(String.format("ERROR: user %s not found", username));
				} else {
					users.remove(username);
					System.out.println(String.format("%s unregistered successfully", username));
				}
			}
		}
		users.entrySet().stream().forEach(u -> System.out.println(String.format("%s => %s", u.getKey(), u.getValue())));
		scan.close();
	}
}
