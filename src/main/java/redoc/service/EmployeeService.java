package redoc.service;

import java.math.BigDecimal;
import java.util.List;

import redoc.entity.Employee;

public interface EmployeeService {

	List<Employee> findEmpListBySalary(BigDecimal salary);

	void saveEmpDetails(Employee emp);

}
