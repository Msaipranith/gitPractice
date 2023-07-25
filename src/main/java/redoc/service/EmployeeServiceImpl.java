package redoc.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redoc.entity.Employee;
import redoc.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	EmployeeRepo empRepo;

	@Override
	public List<Employee> findEmpListBySalary(BigDecimal salary) {
		// TODO Auto-generated method stub
		return empRepo.findBySalary(salary);
	}

	@Override
	public void saveEmpDetails(Employee emp) {
		// TODO Auto-generated method stub
		empRepo.save(emp);
	}

	

}
