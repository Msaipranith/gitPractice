package redoc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Employee {  

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
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
	public Employee(long id, String empName, String empLocation, String empEmail, Double salary) {
		super();
		this.id = id;
		this.empName = empName;
		this.empLocation = empLocation;
		this.empEmail = empEmail;
		this.salary = salary;
	}
	public Employee() {
		super();
	}
	
	
	
//	
//	"empName":"user",
//	"empLocation":"hyd",
//	"empEmail":"user-1@gmail.com",
//	"salary":50000

}
