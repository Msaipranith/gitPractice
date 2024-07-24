package redoc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class EmployeePojo {
	private long id;
	private String empName;
	private String empLocation;
	private String empEmail;
	private Double salary;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public EmployeePojo() {
		super();
	}
	public EmployeePojo(long id, String empName, String empLocation, String empEmail, Double salary) {
		super();
		this.id = id;
		this.empName = empName;
		this.empLocation = empLocation;
		this.empEmail = empEmail;
		this.salary = salary;
	}
	
	
	
}
