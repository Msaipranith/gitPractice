package redoc.service;

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
	public List<Employee> findEmpListBySalary(Double salary) {
		// TODO Auto-generated method stub
		return empRepo.findBySalary(salary);
	}

	@Override
	public void saveEmpDetails(Employee emp) {
		// TODO Auto-generated method stub
		empRepo.save(emp);
	}

	@Override
	public List<Employee> findEmpListByName(String name) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpName(name);
	}

	@Override
	public List<Employee> findEmpListByLocation(String location) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpLocation(location);
	}

	@Override
	public List<Employee> findEmpListByEmail(String email) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpEmail(email);
	}

	@Override
	public void saveListEmpDetails(List<Employee> emp) {
		// TODO Auto-generated method stub
		empRepo.saveAll(emp);
	}

	@Override
	public List<Employee> findEmpListSalaryRange(Double minValue, Double maxValue) {
		// TODO Auto-generated method stub
		return empRepo.findBySalaryBetween(minValue, maxValue);
	}

	@Override
	public List<Employee> findByEmpSalaryLessThan(Double salary) {
		// TODO Auto-generated method stub
		return empRepo.findBySalaryLessThan(salary);
	}

	@Override
	public List<Employee> findByEmpSalaryGreaterThan(Double salary) {
		// TODO Auto-generated method stub
		return empRepo.findBySalaryGreaterThan(salary);
	}

	@Override
	public List<Employee> findEmpByNameAndLocation(String name, String location) {
		// TODO Auto-generated method stub
		return empRepo.findEmpByEmpNameAndEmpLocation(name, location);
	}

	@Override
	public List<Employee> findByEmpNameAndSalaryGreaterThan(String name, Double salary) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpNameAndSalaryGreaterThan(name, salary);
	}

	@Override
	public List<Employee> findByEmpLocationContainingOrSalaryLessThan(String location, Double salary) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpLocationContainingOrSalaryLessThan(location, salary);
	}

	@Override
	public List<Employee> findByEmpNameAndEmpLocationAndSalaryBetween(String name, String location, Double minSal,
			Double maxSal) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpNameAndEmpLocationAndSalaryBetween(name, location, minSal, maxSal);
	}

	@Override
	public List<Employee> findByEmpNameOrEmpLocation(String name, String location) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpNameOrEmpLocation(name, location);
	}

	@Override
	public List<Employee> findByEmpNameIgnoreCase(String name) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpNameIgnoreCase(name);
	}

	@Override
	public List<Employee> findByEmpLocationIgnoreCase(String location) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpLocationIgnoreCase(location);
	}

	@Override
	public List<Employee> findByEmpEmailContaining(String subString) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpEmailContaining(subString);
	}

	@Override
	public List<Employee> findByEmpNameOrderBySalaryAsc(String name) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpNameOrderBySalaryAsc(name);
	}

	@Override
	public List<Employee> findByEmpNameOrderBySalaryDesc(String name) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpNameOrderBySalaryDesc(name);
	}

	@Override
	public List<Employee> findByEmpLocationOrderByEmpNameAsc(String location) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpLocationOrderByEmpNameAsc(location);
	}

	@Override
	public List<Employee> findByEmpLocationOrderByEmpNameDesc(String location) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpLocationOrderByEmpNameDesc(location);
	}

	@Override
	public List<Employee> findBySalaryGreaterThanEqual(Double salary) {
		// TODO Auto-generated method stub
		return empRepo.findBySalaryGreaterThanEqual(salary);
	}

	@Override
	public List<Employee> findBySalaryLessThanEqual(Double salary) {
		// TODO Auto-generated method stub
		return empRepo.findBySalaryLessThanEqual(salary);
	}

	@Override
	public List<Employee> findBySalaryNot(Double salary) {
		// TODO Auto-generated method stub
		return empRepo.findBySalaryNot(salary);
	}

	@Override
	public List<Employee> findByEmpNameContaining(String subString) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpNameContaining(subString);
	}

	@Override
	public List<Employee> findByEmpLocationContaining(String subString) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpLocationContaining(subString);
	}

	@Override
	public List<Employee> findByEmpEmailEndingWith(String domain) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpEmailEndingWith(domain);
	}

	@Override
	public List<Employee> findByEmpEmailStartingWith(String prefix) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpEmailStartingWith(prefix);
	}

	@Override
	public List<Employee> findBySalaryGreaterThanOrderByEmpNameAsc(Double salary) {
		// TODO Auto-generated method stub
		return empRepo.findBySalaryGreaterThanOrderByEmpNameAsc(salary);
	}

	@Override
	public List<Employee> findBySalaryLessThanOrderByEmpNameAsc(Double salary) {
		// TODO Auto-generated method stub
		return empRepo.findBySalaryLessThanOrderByEmpNameAsc(salary);
	}

	@Override
	public List<Employee> findByEmpLocationOrderBySalaryAsc(String location) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpLocationOrderBySalaryAsc(location);
	}

	@Override
	public List<Employee> findByEmpEmailContainingOrderBySalaryDesc(String subString) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpEmailContainingOrderBySalaryDesc(subString);
	}

	@Override
	public List<Employee> findByEmpNameIgnoreCaseContaining(String subString) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpNameIgnoreCaseContaining(subString);
	}

	@Override
	public List<Employee> findByEmpLocationIgnoreCaseContaining(String subString) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpLocationIgnoreCaseContaining(subString);
	}

	@Override
	public List<Employee> findBySalaryGreaterThanAndEmpLocationContaining(Double salary, String subString) {
		// TODO Auto-generated method stub
		return empRepo.findBySalaryGreaterThanAndEmpLocationContaining(salary, subString);
	}

	@Override
	public List<Employee> findByEmpNameContainingOrEmpEmailContaining(String nameSubstring, String emailSubstring) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpNameContainingOrEmpEmailContaining(nameSubstring, emailSubstring);
	}

	@Override
	public List<Employee> findByEmpNameContainingAndSalaryGreaterThan(String nameSubstring, Double salary) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpNameContainingAndSalaryGreaterThan(nameSubstring, salary);
	}

	@Override
	public List<Employee> findByEmpNameContainingOrderBySalaryDesc(String nameSubstring) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpNameContainingOrderBySalaryDesc(nameSubstring);
	}

	@Override
	public List<Employee> findByEmpLocationContainingOrderBySalaryAsc(String locationSubstring) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpLocationContainingOrderBySalaryAsc(locationSubstring);
	}

	@Override
	public List<Employee> findByEmpLocationAndSalaryLessThan(String location, Double salary) {
		// TODO Auto-generated method stub
		return empRepo.findByEmpLocationAndSalaryLessThan(location,salary);
	}

}
