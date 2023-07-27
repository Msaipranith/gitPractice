package redoc.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redoc.dto.EmployeePojo;
import redoc.entity.Employee;
import redoc.repo.EmployeeRepo;
import redoc.utility.Utility;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeRepo empRepo;

	@Override
	public List<EmployeePojo> findEmpListBySalary(Double salary) {
		LOGGER.info("Calling findEmpListBySalary with salary: {}", salary);
		List<Employee> empList = empRepo.findBySalary(salary);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public void saveEmpDetails(EmployeePojo empPojo) {
		LOGGER.info("Calling saveEmpDetails with empPojo: {}", empPojo);
		Employee emp = new Employee();
		BeanUtils.copyProperties(empPojo, emp);
		empRepo.save(emp);
	}

	@Override
	public List<EmployeePojo> findEmpListByName(String name) {
		LOGGER.info("Calling findEmpListByName with name: {}", name);
		List<Employee> empList = empRepo.findByEmpName(name);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findEmpListByLocation(String location) {
		LOGGER.info("Calling findEmpListByLocation with location: {}", location);
		List<Employee> empList = empRepo.findByEmpName(location);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findEmpListByEmail(String email) {
		LOGGER.info("Calling findEmpListByEmail with email: {}", email);
		List<Employee> empList = empRepo.findByEmpEmail(email);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public void saveListEmpDetails(List<EmployeePojo> empPojo) {
		LOGGER.info("Calling saveListEmpDetails with empPojo list of size: {}", empPojo.size());

		ArrayList<Employee> empList = new ArrayList<>();

		for (EmployeePojo employeePojo : empPojo) {
			Employee employee = new Employee();
			BeanUtils.copyProperties(employeePojo, employee);
			empList.add(employee);
		}

		empRepo.saveAll(empList);
	}

	@Override
	public List<EmployeePojo> findEmpListSalaryRange(Double minSal, Double maxSal) {
		LOGGER.info("Calling findEmpListSalaryRange with minSal: {} and maxSal: {}", minSal, maxSal);
		List<Employee> empList = empRepo.findBySalaryBetween(minSal, maxSal);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpSalaryLessThan(Double salary) {
		LOGGER.info("Calling findByEmpSalaryLessThan with salary: {}", salary);
		List<Employee> empList = empRepo.findBySalaryLessThan(salary);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpSalaryGreaterThan(Double salary) {
		LOGGER.info("Calling findByEmpSalaryGreaterThan with salary: {}", salary);
		List<Employee> empList = empRepo.findBySalaryGreaterThan(salary);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findEmpByNameAndLocation(String name, String location) {
		LOGGER.info("Calling findEmpByNameAndLocation with name: {} and location: {}", name, location);
		List<Employee> empList = empRepo.findEmpByEmpNameAndEmpLocation(name, location);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpNameAndSalaryGreaterThan(String name, Double salary) {
		LOGGER.info("Calling findByEmpNameAndSalaryGreaterThan with name: {} and salary: {}", name, salary);
		List<Employee> empList = empRepo.findByEmpNameAndSalaryGreaterThan(name, salary);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpLocationContainingOrSalaryLessThan(String location, Double salary) {
		LOGGER.info("Calling findByEmpLocationContainingOrSalaryLessThan with location: {} and salary: {}", location,
				salary);
		List<Employee> empList = empRepo.findByEmpLocationContainingOrSalaryLessThan(location, salary);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpNameAndEmpLocationAndSalaryBetween(String name, String location, Double minSal,
			Double maxSal) {
		LOGGER.info(
				"Calling findByEmpNameAndEmpLocationAndSalaryBetween with name: {}, location: {}, minSal: {}, maxSal: {}",
				name, location, minSal, maxSal);
		List<Employee> empList = empRepo.findByEmpNameAndEmpLocationAndSalaryBetween(name, location, minSal, maxSal);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpNameOrEmpLocation(String name, String location) {
		LOGGER.info("Calling findByEmpNameOrEmpLocation with name: {} and location: {}", name, location);
		List<Employee> empList = empRepo.findByEmpNameOrEmpLocation(name, location);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpNameIgnoreCase(String name) {
		LOGGER.info("Calling findByEmpNameIgnoreCase with name: {}", name);
		List<Employee> empList = empRepo.findByEmpNameIgnoreCase(name);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpLocationIgnoreCase(String location) {
		LOGGER.info("Calling findByEmpLocationIgnoreCase with location: {}", location);
		List<Employee> empList = empRepo.findByEmpLocationIgnoreCase(location);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpEmailContaining(String subString) {
		LOGGER.info("Calling findByEmpEmailContaining with subString: {}", subString);
		List<Employee> empList = empRepo.findByEmpEmailContaining(subString);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpNameOrderBySalaryAsc(String name) {
		LOGGER.info("Calling findByEmpNameOrderBySalaryAsc with name: {}", name);
		List<Employee> empList = empRepo.findByEmpNameOrderBySalaryAsc(name);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpNameOrderBySalaryDesc(String name) {
		LOGGER.info("Calling findByEmpNameOrderBySalaryDesc with name: {}", name);
		List<Employee> empList = empRepo.findByEmpNameOrderBySalaryDesc(name);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpLocationOrderByEmpNameAsc(String location) {
		LOGGER.info("Calling findByEmpLocationOrderByEmpNameAsc with location: {}", location);
		List<Employee> empList = empRepo.findByEmpLocationOrderByEmpNameAsc(location);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpLocationOrderByEmpNameDesc(String location) {
		LOGGER.info("Calling findByEmpLocationOrderByEmpNameDesc with location: {}", location);
		List<Employee> empList = empRepo.findByEmpLocationOrderByEmpNameDesc(location);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findBySalaryGreaterThanEqual(Double salary) {
		LOGGER.info("Calling findBySalaryGreaterThanEqual with salary: {}", salary);
		List<Employee> empList = empRepo.findBySalaryGreaterThanEqual(salary);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findBySalaryLessThanEqual(Double salary) {
		LOGGER.info("Calling findBySalaryLessThanEqual with salary: {}", salary);
		List<Employee> empList = empRepo.findBySalaryLessThanEqual(salary);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findBySalaryNot(Double salary) {
		LOGGER.info("Calling findBySalaryNot with salary: {}", salary);
		List<Employee> empList = empRepo.findBySalaryNot(salary);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpNameContaining(String subString) {
		LOGGER.info("Calling findByEmpNameContaining with subString: {}", subString);
		List<Employee> empList = empRepo.findByEmpNameContaining(subString);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpLocationContaining(String subString) {
		LOGGER.info("Calling findByEmpLocationContaining with subString: {}", subString);
		List<Employee> empList = empRepo.findByEmpLocationContaining(subString);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpEmailEndingWith(String domain) {
		LOGGER.info("Calling findByEmpEmailEndingWith with domain: {}", domain);
		List<Employee> empList = empRepo.findByEmpEmailEndingWith(domain);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpEmailStartingWith(String prefix) {
		LOGGER.info("Calling findByEmpEmailStartingWith with prefix: {}", prefix);
		List<Employee> empList = empRepo.findByEmpEmailStartingWith(prefix);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findBySalaryGreaterThanOrderByEmpNameAsc(Double salary) {
		LOGGER.info("Calling findBySalaryGreaterThanOrderByEmpNameAsc with salary: {}", salary);
		List<Employee> empList = empRepo.findBySalaryGreaterThanOrderByEmpNameAsc(salary);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findBySalaryLessThanOrderByEmpNameAsc(Double salary) {
		LOGGER.info("Calling findBySalaryLessThanOrderByEmpNameAsc with salary: {}", salary);
		List<Employee> empList = empRepo.findBySalaryLessThanOrderByEmpNameAsc(salary);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpLocationOrderBySalaryAsc(String location) {
		LOGGER.info("Calling findByEmpLocationOrderBySalaryAsc with location: {}", location);
		List<Employee> empList = empRepo.findByEmpLocationOrderBySalaryAsc(location);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpEmailContainingOrderBySalaryDesc(String subString) {
		LOGGER.info("Calling findByEmpEmailContainingOrderBySalaryDesc with subString: {}", subString);
		List<Employee> empList = empRepo.findByEmpEmailContainingOrderBySalaryDesc(subString);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpNameIgnoreCaseContaining(String subString) {
		LOGGER.info("Calling findByEmpNameIgnoreCaseContaining with subString: {}", subString);
		List<Employee> empList = empRepo.findByEmpNameIgnoreCaseContaining(subString);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpLocationIgnoreCaseContaining(String subString) {
		LOGGER.info("Calling findByEmpLocationIgnoreCaseContaining with subString: {}", subString);
		List<Employee> empList = empRepo.findByEmpLocationIgnoreCaseContaining(subString);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findBySalaryGreaterThanAndEmpLocationContaining(Double salary, String subString) {
		LOGGER.info("Calling findBySalaryGreaterThanAndEmpLocationContaining with salary: {}, subString: {}", salary,
				subString);
		List<Employee> empList = empRepo.findBySalaryGreaterThanAndEmpLocationContaining(salary, subString);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpNameContainingOrEmpEmailContaining(String nameSubstring, String emailSubstring) {
		LOGGER.info("Calling findByEmpNameContainingOrEmpEmailContaining with nameSubstring: {}, emailSubstring: {}",
				nameSubstring, emailSubstring);
		List<Employee> empList = empRepo.findByEmpNameContainingOrEmpEmailContaining(nameSubstring, emailSubstring);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpNameContainingAndSalaryGreaterThan(String nameSubstring, Double salary) {
		LOGGER.info("Calling findByEmpNameContainingAndSalaryGreaterThan with nameSubstring: {}, salary: {}",
				nameSubstring, salary);
		List<Employee> empList = empRepo.findByEmpNameContainingAndSalaryGreaterThan(nameSubstring, salary);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpNameContainingOrderBySalaryDesc(String nameSubstring) {
		LOGGER.info("Calling findByEmpNameContainingOrderBySalaryDesc with nameSubstring: {}", nameSubstring);
		List<Employee> empList = empRepo.findByEmpNameContainingOrderBySalaryDesc(nameSubstring);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpLocationContainingOrderBySalaryAsc(String locationSubstring) {
		LOGGER.info("Calling findByEmpLocationContainingOrderBySalaryAsc with locationSubstring: {}",
				locationSubstring);
		List<Employee> empList = empRepo.findByEmpLocationContainingOrderBySalaryAsc(locationSubstring);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

	@Override
	public List<EmployeePojo> findByEmpLocationAndSalaryLessThan(String location, Double salary) {
		LOGGER.info("Calling findByEmpLocationAndSalaryLessThan with location: {}, salary: {}", location, salary);
		List<Employee> empList = empRepo.findByEmpLocationAndSalaryLessThan(location, salary);
		List<EmployeePojo> empPojoList = Utility.mapToPojoList(empList);
		return empPojoList;
	}

}
