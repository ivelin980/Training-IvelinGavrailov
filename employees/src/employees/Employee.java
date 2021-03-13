package employees;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	 private int employeeID;
	 private List<Project> projects; 
	
	public Employee(int employeeID) {
		this.employeeID = employeeID;
		projects = new ArrayList<>();
	} 
	
	  @Override
	    public int hashCode() {
	      final int prime = 31;
	      int result = 1;
	      result = prime * result + ((employeeID == 0) ? 0 : Integer.hashCode(employeeID));
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
	        Employee other = (Employee) obj;
	        if (employeeID == 0) {
	          if (other.employeeID != 0) {
	            return false;
	          }
	        } else if (employeeID != other.employeeID) {
	          return false;
	        }
	        return true;
	      }
	
	public void addProject(int projectID, String dateFrom, String dateTo) {
		projects.add(new Project(projectID, dateFrom, dateTo));
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public List<Project> getProjects() {
		return projects;
	}
	
	public Project getProjectByID(int projectID) {
		for (Project project : projects) {
			if(projectID == project.getProjectID()) {
				return project;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s", employeeID,projects.toString());
	}
	
}
