package redoc.UtilityTest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import redoc.dto.EmployeePojo;
import redoc.entity.Employee;

public class UtilityTest {

	private long id = 1;
	private String empName = "user-1";
	private String empLocation = "hyd";
	private String empEmail = "user@gmail.com";
	private Double salary = 50000.0;

	private Double minValue = 25000.0;
	private Double maxValue = 50000.0;
	private String nameSubstring = "user";
	private String locationSubstring = "hyd";
	private String emailsubstring = "@gmail";

	private String domain = ".com";
	private String prefix = "user";

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

	public Double getMinValue() {
		return minValue;
	}

	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}

	public Double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}

	public String getNameSubstring() {
		return nameSubstring;
	}

	public void setNameSubstring(String nameSubstring) {
		this.nameSubstring = nameSubstring;
	}

	public String getLocationSubstring() {
		return locationSubstring;
	}

	public void setLocationSubstring(String locationSubstring) {
		this.locationSubstring = locationSubstring;
	}

	public String getEmailsubstring() {
		return emailsubstring;
	}

	public void setEmailsubstring(String emailsubstring) {
		this.emailsubstring = emailsubstring;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public static List<EmployeePojo> empList() {
		// TODO Auto-generated method stub
		ArrayList<EmployeePojo> al = new ArrayList<>();
		al.add(new EmployeePojo(1l, "pranith", "hyd", "pranith@gmail.com", 25000.0));
		al.add(new EmployeePojo(2l, "sai", "chennai", "sai@gmail.com", 30000.0));

		return al;
	}

	@SuppressWarnings("rawtypes")
	public static ResponseEntity getResponse() {
		return new ResponseEntity<>(UtilityTest.empList(), HttpStatus.OK);
	}

	@SuppressWarnings("rawtypes")
	public static ResponseEntity getNResponse() {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}

	public static EmployeePojo empPojo() {

		return new EmployeePojo(1l, "user", "hyd", "user@gmail.com", 50000.0);
	}

	public static List<Employee> employeeList() {
		ArrayList<Employee> al = new ArrayList<>();
		al.add(new Employee(1l, "pranith", "hyd", "pranith@gmail.com", 25000.0));
		al.add(new Employee(2l, "sai", "chennai", "sai@gmail.com", 30000.0));
// TODO Auto-generated method stub
		return al;
	}

}
