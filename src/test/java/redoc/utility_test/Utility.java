//package redoc.utility_test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//
//import lombok.Data;
//import redoc.dto.EmployeePojo;
//import redoc.entity.Employee;
//
//@Component
//@Data
//public class Utility {
//
//	private long id = 1;
//	private String empName = "user-1";
//	private String empLocation = "hyd";
//	private String empEmail = "user@gmail.com";
//	private Double salary = 50000.0;
//
//	private Double minValue = 25000.0;
//	private Double maxValue = 50000.0;
//	private String nameSubstring = "user";
//	private String locationSubstring = "hyd";
//	private String emailsubstring = "@gmail";
//
//	private String domain = ".com";
//	private String prefix = "user";
//
//	public List<EmployeePojo> empList() {
//
//		List<EmployeePojo> al = new ArrayList<>();
//		al.add(new EmployeePojo(1l, "pranith", "hyd", "pranith@gmail.com", 25000.0));
//		al.add(new EmployeePojo(2l, "sai", "chennai", "sai@gmail.com", 30000.0));
//
//		return al;
//	}
//
//	public ResponseEntity<List<EmployeePojo>> getResponse() {
//
//		List<EmployeePojo> al = new ArrayList<>();
//		al.add(new EmployeePojo(1l, "pranith", "hyd", "pranith@gmail.com", 25000.0));
//		al.add(new EmployeePojo(2l, "sai", "chennai", "sai@gmail.com", 30000.0));
//
//		return new ResponseEntity<>(al, HttpStatus.OK);
//	}
//
//	@SuppressWarnings("rawtypes")
//	public ResponseEntity getNResponse() {
//
//		return new ResponseEntity<>(null, HttpStatus.OK);
//	}
//
//	public EmployeePojo empPojo() {
//
//		return new EmployeePojo(1l, "user", "hyd", "user@gmail.com", 50000.0);
//	}
//
//	public List<Employee> employeeList() {
//		ArrayList<Employee> al = new ArrayList<>();
//		al.add(new Employee(1l, "pranith", "hyd", "pranith@gmail.com", 25000.0));
//		al.add(new Employee(2l, "sai", "chennai", "sai@gmail.com", 30000.0));
//
//		return al;
//	}
//
//}
