package employees; 
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


public class Pair {
	private Employee first;
	private Employee second;
	private List<Project> mutualProjects;

	public Pair(Employee first, Employee second) {
		this.first = first;
		this.second = second;
		this.mutualProjects = new ArrayList<>();
	}
	
	public void addMutualProject(Project project) {
		this.mutualProjects.add(project);
	}

	public Employee getFirst() {
		return first;
	}

	public Employee getSecond() {
		return second;
	}

	public List<Project> getMutualProjects() {
		return mutualProjects;
	}

	public long getTimeWorkingTogether() {
		long daysOverall = 0;
		for (Project project : mutualProjects) {
			LocalDate firstEmployeeDateFrom = first.getProjectByID(project.getProjectID())
					.getPeriodForEmployee().getDateFrom();
			LocalDate firstEmployeeDateTo = first.getProjectByID(project.getProjectID())
					.getPeriodForEmployee().getDateTo();
			LocalDate secondEmployeeDateFrom = second.getProjectByID(project.getProjectID())
					.getPeriodForEmployee().getDateFrom();
			LocalDate secondEmployeeDateTo = second.getProjectByID(project.getProjectID())
					.getPeriodForEmployee().getDateTo();
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
			daysOverall+=(ChronoUnit.DAYS.between(workingTogetherFrom, workingTogetherTo) > 0)
					? ChronoUnit.DAYS.between(workingTogetherFrom, workingTogetherTo)
							: 0;
		}
		return daysOverall;
	}
	
	public int hashCode() {
		  final int prime = 31;
	      int result = 1;
	      result = prime * result + ((this.first.getEmployeeID() == 0) ? 0 : Integer.hashCode(this.second.getEmployeeID()));
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
		Pair other = (Pair) obj;
		if (this.getFirst().equals(other.getFirst()) && this.getSecond().equals(other.getSecond())) {
				return true;
		}
		return this.getSecond().equals(other.getFirst()) && this.getFirst().equals(other.getFirst());
	}
}
