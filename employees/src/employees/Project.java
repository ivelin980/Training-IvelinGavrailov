package employees;

public class Project {
	private int projectID;
	private Period periodForEmployee;

	public Project(int projectID, String dateFrom, String dateTo) {
		this.projectID = projectID;
		this.periodForEmployee = new Period(dateFrom, dateTo);
	}

	public int getProjectID() {
		return projectID;
	}

	public Period getPeriodForEmployee() {
		return periodForEmployee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((projectID == 0) ? 0 : Integer.hashCode(projectID));
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
		Project other = (Project) obj;
		if (projectID == 0) {
			if (other.projectID != 0) {
				return false;
			}
		} else if (projectID != other.projectID) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("%d %s %s", projectID, periodForEmployee.getDateFrom(), periodForEmployee.getDateTo());
	}

}
