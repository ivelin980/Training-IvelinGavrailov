package employees;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class EmployeeWorkingPair {
	private Employee first;
	private Employee second;
	private Set<Integer> mutualProjectsIDs;
	private long timeWorkingTogether;

	public EmployeeWorkingPair(Employee first, Employee second, Set<Integer> mutualProjectsIDs) {
		this.first = first;
		this.second = second;
		this.mutualProjectsIDs = mutualProjectsIDs;
		this.timeWorkingTogether = calculateTimeWorkingTogether();
	}

	public Employee getFirst() {
		return first;
	}

	public Employee getSecond() {
		return second;
	}

	public Set<Integer> getMutualProjectsIDs() {
		return mutualProjectsIDs;
	}

	public long getTimeWorkingTogether() {
		return timeWorkingTogether;
	}

	public long calculateTimeWorkingTogether() {
		long daysOverall = 0;
		for (Integer projectID : mutualProjectsIDs) {
			LocalDate firstEmployeeDateFrom = first.getProjectByID(projectID).getPeriodForEmployee().getDateFrom();
			LocalDate firstEmployeeDateTo = first.getProjectByID(projectID).getPeriodForEmployee().getDateTo();
			LocalDate secondEmployeeDateFrom = second.getProjectByID(projectID).getPeriodForEmployee().getDateFrom();
			LocalDate secondEmployeeDateTo = second.getProjectByID(projectID).getPeriodForEmployee().getDateTo();
			LocalDate workingTogetherFrom;
			LocalDate workingTogetherTo;
			int resultDateFrom = firstEmployeeDateFrom.compareTo(secondEmployeeDateFrom);
			if (resultDateFrom >= 0) {
				workingTogetherFrom = firstEmployeeDateFrom;
			} else {
				workingTogetherFrom = secondEmployeeDateFrom;
			}
			int resultDateTo = firstEmployeeDateTo.compareTo(secondEmployeeDateTo);
			if (resultDateTo <= 0) {
				workingTogetherTo = firstEmployeeDateTo;
			} else {
				workingTogetherTo = secondEmployeeDateTo;
			}
			daysOverall += (ChronoUnit.DAYS.between(workingTogetherFrom, workingTogetherTo) > 0)
					? ChronoUnit.DAYS.between(workingTogetherFrom, workingTogetherTo)
					: 0;
		}
		return daysOverall;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.first.getEmployeeID() == 0) ? 0 : Integer.hashCode(this.second.getEmployeeID()));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		EmployeeWorkingPair other = (EmployeeWorkingPair) obj;
		if (this.getFirst().equals(other.getFirst()) && this.getSecond().equals(other.getSecond())) {
			return true;
		}
		return this.getSecond().equals(other.getFirst()) && this.getFirst().equals(other.getFirst());
	}
}
