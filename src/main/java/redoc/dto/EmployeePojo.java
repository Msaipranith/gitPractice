package redoc.dto;

public class EmployeePojo {
	private String empName;
	private String empLocation;
	private String empEmail;
	private Double salary;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpLocation() {
		return empLocation;
	}

	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public EmployeePojo(String empName, String empLocation, String empEmail, Double salary) {
		this.empName = empName;
		this.empLocation = empLocation;
		this.empEmail = empEmail;
		this.salary = salary;
	}

	public EmployeePojo() {
	}
}
