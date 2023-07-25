package redoc.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import redoc.entity.Employee;
import redoc.service.EmployeeService;

@RestController
public class DemoController {

	@Autowired
	EmployeeService empService;
	
	
	@PostMapping("/saveEmpDetails")
	public String saveEmpDetails(@RequestBody Employee emp) {
		empService.saveEmpDetails(emp);
		return "saved";
	}

	@GetMapping("/helloWorld")
	public String helloWorld() {
		return "hello world";
	}

	@GetMapping("/findEmployeesBySalary")
	public List<Employee> findBySalary(@RequestParam(value = "salary", defaultValue = "0") BigDecimal salary) {
		return empService.findEmpListBySalary(salary);

	}

}
