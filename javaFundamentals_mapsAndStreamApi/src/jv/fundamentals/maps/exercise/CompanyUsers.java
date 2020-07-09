package jv.fundamentals.maps.exercise;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Write a program which keeps information about companies and their employees.
 * You will receive company name and employee's id, until you receive the
 * command "End". Add each employee to the given company. Keep in mind that a
 * company cannot have two employees with the same id. When you finish reading
 * data, order the companies by the name in ascending order. Print the company
 * name and each employee's id in the following format: {companyName} -- {id1}
 * -- {id2} -- {idN} Input / Constraints • Until you receive "End", the input
 * come in the format: "{companyName} -> {employeeId}". • The input always will
 * be valid.
 * 
 * @author Ivelin Gavrailov
 * @since 08.07.2020
 *
 */
public class CompanyUsers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] tokens = scan.nextLine().split(" -> ");
		TreeMap<String, ArrayList<String>> users = new TreeMap<>();
		while (!"End".equalsIgnoreCase(tokens[0])) {
			String name = tokens[0];
			String id = tokens[1];
			users.putIfAbsent(name, new ArrayList<>());
			if (!users.get(name).contains(id)) {
				users.get(name).add(id);
			}
			tokens = scan.nextLine().split(" -> ");
		}
		users.entrySet().stream().forEach(
				c -> System.out.print(String.format("%s%n-- %s%n", c.getKey(), String.join("\n-- ", c.getValue()))));
		scan.close();
	}
}
