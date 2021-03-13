package employees;

public class Project {
	private int projectID;
	private Period periodForEmployee;
	
	public Project(int projectID,String dateFrom, String dateTo) {
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
	public String toString() {
		return String.format("%d %s %s", projectID, periodForEmployee.getDateFrom(),periodForEmployee.getDateTo());
	}
}
