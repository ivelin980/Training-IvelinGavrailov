package employees;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
	private static final String FILE_PATH = "Employees.txt";

	public static void main(String[] args) {
		List<Employee> employees = readEmployeesFromFile();
		Set<EmployeeWorkingPair> pairs = createPairsOfEmployees(employees);
		System.out.println(getPairWorkingLongestTogether(pairs));

	}

	private static List<Employee> readEmployeesFromFile() {
		List<Employee> employees = new ArrayList<>();
		try (FileInputStream fis = new FileInputStream(FILE_PATH); Scanner scan = new Scanner(fis);) {
			while (scan.hasNextLine()) {
				String[] tokens = scan.nextLine().split(", ");
				int empID = Integer.parseInt(tokens[0]);
				int projectID = Integer.parseInt(tokens[1]);
				String dateFrom = tokens[2];
				String dateTo = tokens[3];
				Employee employee = new Employee(empID);
				if (!employees.contains(employee)) {
					employee.addProject(projectID, dateFrom, dateTo);
					employees.add(employee);
				} else {
					employees.stream().filter(e -> e.getEmployeeID() == employee.getEmployeeID())
							.forEach(e -> e.addProject(projectID, dateFrom, dateTo));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}

	private static Set<EmployeeWorkingPair> createPairsOfEmployees(List<Employee> employees) {
		Set<EmployeeWorkingPair> pairs = new HashSet<>();
		for (int i = 0; i < employees.size() - 1; i++) {
			Set<Project> currentEmployeeProjects = employees.get(i).getProjects();
			for (int j = i + 1; j < employees.size(); j++) {
				Set<Project> nextEmployeeProjects = employees.get(j).getProjects();
				Set<Integer> mutualIDs = nextEmployeeProjects.stream().filter(currentEmployeeProjects::contains)
						.map(Project::getProjectID).collect(Collectors.toSet());
				pairs.add(new EmployeeWorkingPair(employees.get(i), employees.get(j), mutualIDs));
			}
		}
		return pairs;
	}

	public static String getPairWorkingLongestTogether(Set<EmployeeWorkingPair> pairs) {
		if (pairs == null || pairs.isEmpty()) {
			throw new IllegalArgumentException("List is empty!");
		}
		Iterator<EmployeeWorkingPair> iterator = pairs.iterator();
		EmployeeWorkingPair workingLongestTogether = iterator.next();
		while (iterator.hasNext()) {
			EmployeeWorkingPair currentPair = iterator.next();
			if (workingLongestTogether.getTimeWorkingTogether() < currentPair.getTimeWorkingTogether()) {
				workingLongestTogether = currentPair;
			}
		}
		return String.format("Employee with ID %d and employee with ID %d are working togeher the longest - %d days",
				workingLongestTogether.getFirst().getEmployeeID(), workingLongestTogether.getSecond().getEmployeeID(),
				workingLongestTogether.getTimeWorkingTogether());
	}
}
