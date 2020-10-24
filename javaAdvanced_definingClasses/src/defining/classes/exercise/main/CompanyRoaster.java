package defining.classes.exercise.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

import defining.classes.exercise.entities.Department;
import defining.classes.exercise.entities.Employee;

/**
 * Define a class Employee that holds the following information: name, salary,
 * position, department, email and age. The name, salary, position and
 * department are mandatory while the rest are optional. Your task is to write a
 * program which takes N lines of information about employees from the console
 * and calculates the department with the highest average salary and prints for
 * each employee in that department his name, salary, email and age - sorted by
 * salary in descending order. If an employee doesn’t have an email – in place
 * of that field you should print "n/a" instead, if he doesn’t have an age –
 * print "-1" instead. The salary should be printed to two decimal places after
 * the seperator. Hint: you can define a Department class that holds list of
 * employees.
 * 
 * @author Ivelin Gavrailov
 * @since 08.09.2020
 *
 */
public class CompanyRoaster {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = Integer.parseInt(scan.nextLine());
		ArrayList<Employee> employees = new ArrayList<>();
		HashMap<String, Department> departments = new HashMap<>();
		for (int i = 0; i < count; i++) {
			String[] tokens = scan.nextLine().split(" ");
			String name = tokens[0];
			double salary = Double.parseDouble(tokens[1]);
			String position = tokens[2];
			String department = tokens[3];
			String email = null;
			int age = 0;
			try {
				if (isNumeric(tokens[4])) {
					age = Integer.parseInt(tokens[4]);
					email = tokens[5];
				} else {
					email = tokens[4];
					age = Integer.parseInt(tokens[5]);
				}
			} catch (IndexOutOfBoundsException e) {
				e.printStackTrace();
			}		
			Employee employee = new Employee(name, salary, position, department, email, age);
			employees.add(employee);
			departments.putIfAbsent(department, new Department(department));
			departments.get(department).getEmployees().add(employee);
		}
		
		Department maxDepartment = departments.entrySet().stream()
				.max(Comparator.comparingDouble(f -> f.getValue().getAverageSalary())).get().getValue();
		System.out.println(String.format("Highest Average Salary: %s", maxDepartment.getName()));
		maxDepartment.getEmployees().stream().sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
				.forEach(e -> System.out.println(e.toString()));
		scan.close();
	}

	public static boolean isNumeric(String strNum) {
		for (int i = 0; i < strNum.length(); i++) {
			if (!Character.isDigit(strNum.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
