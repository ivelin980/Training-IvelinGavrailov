package employees;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String path = "Employees.txt";
		List<Employee> employees = new ArrayList<>();
		try (FileInputStream fis = new FileInputStream(path); Scanner scan = new Scanner(fis);) {
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
			return;
		}

		List<Pair> pairs = createPairsOfEmployees(employees);
		System.out.println(getPairWorkingLongestTogether(pairs));
	}
	
	private static List<Pair> createPairsOfEmployees(List<Employee> employees) {
		List<Pair> pairs = new ArrayList<>();
		for (int i = 0; i < employees.size()-1; i++) {
			List<Project> currentEmployeeProjects = employees.get(i).getProjects();
			for (int j = i+1; j < employees.size(); j++) {
				List<Project> nextEmployeeProjects = employees.get(j).getProjects();
				for (int k = 0; k < currentEmployeeProjects.size(); k++) {
					Project currentProjectOfCurrentEmployee = currentEmployeeProjects.get(k);
					for (int l = 0; l < nextEmployeeProjects.size(); l++) {
						if(currentProjectOfCurrentEmployee.getProjectID()==nextEmployeeProjects.get(l).getProjectID()) {
							Pair pair = new Pair(employees.get(i),employees.get(j));
							if(!pairs.contains(pair)) {
								pair.addMutualProject(currentProjectOfCurrentEmployee);
								pairs.add(pair);
							}
							else {
								pairs.stream().filter(p -> p.equals(pair)).forEach(p -> p.addMutualProject(currentProjectOfCurrentEmployee));
							}
						}
					}
				}
			}
		}
		return pairs;
	}

	public static String getPairWorkingLongestTogether(List<Pair> pairs) {
		if(pairs == null || pairs.isEmpty()) {
			throw new IllegalArgumentException("List is empty!");
		}
		Pair workingLongestTogether = pairs.get(0);
		for (Pair pair : pairs) {
			if(workingLongestTogether.getTimeWorkingTogether()<pair.getTimeWorkingTogether()) {
				workingLongestTogether = pair;
			}
		}	
		return String.format("Employee with ID %d and employee with ID %d are working togeher the longest - %d days",workingLongestTogether.getFirst().getEmployeeID(),workingLongestTogether.getSecond().getEmployeeID(),workingLongestTogether.getTimeWorkingTogether());
	}
}
