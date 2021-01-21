package jv.oop.encapsulation.lab.first.and.reserve.team;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jv.oop.encapsulation.lab.salary.increase.Worker;

/**
 * Create a Team class. Add to this team all person you read. All person younger
 * than 40 go in first team, others go in reverse team. At the end print first
 * and reserve team sizes. The class should have private fields for: • name:
 * String • firstTeam: List<Person> • reserveTeam: List<Person> The class should
 * have constructors: • Team(String name) The class should also have private
 * method for setName and public methods for: • getName(): String •
 * addPlayer(Person person): void • getFirstTeam(): List<Person>
 * (Collections.unmodifiableList) • getReserveTeam(): List<Person>
 * (Collections.unmodifiableList)
 * 
 * @author Ivelin Gavrailov
 * @since 13.01.2021
 *
 */
public class FirstAndReserveTeam {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		Team team = new Team("Black eagles");
		List<Worker> people = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String[] input = scan.nextLine().split(" ");
			people.add(new Worker(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3])));
		}
		for (Worker person : people) {
			team.addPlayer(person);
		}

		System.out.println("First team have " + team.getFirstTeam().size() + " players");
		System.out.println("Reserve team have " + team.getReserveTeam().size() + " players");

		scan.close();
	}
}
