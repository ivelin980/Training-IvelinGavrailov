package jv.oop.encapsulation.lab.salary.increase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Read person with their names, age and salary. Read percent bonus to every
 * person salary. People younger than 30 get half bonus. Expand Person from
 * previous task. Add salary field and getter and setter with proper access. New
 * fields and methods • salary: double • increaseSalary(double bonus) You should
 * be able to use the class like this:
 * 
 * @author Ivelin Gavrailov
 * @since 12.01.2021
 *
 */
public class SalaryIncrease {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		List<Worker> people = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String[] input = reader.readLine().split(" ");
			try {
				people.add(new Worker(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3])));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return;
			}
		}
		double bonus = Double.parseDouble(reader.readLine());
		for (Worker person : people) {
			person.increaseSalary(bonus);
			System.out.println(person.toString());
		}
	}
}
