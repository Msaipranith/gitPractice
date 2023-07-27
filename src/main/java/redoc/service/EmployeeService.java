package redoc.service;

import java.util.List;

import redoc.entity.Employee;

public interface EmployeeService {

	List<Employee> findEmpListBySalary(Double salary);

	void saveEmpDetails(Employee emp);

	List<Employee> findEmpListByName(String name);

	List<Employee> findEmpListByLocation(String location);

	List<Employee> findEmpListByEmail(String email);

	void saveListEmpDetails(List<Employee> emp);

	List<Employee> findEmpListSalaryRange(Double minValue, Double maxValue);

	List<Employee> findByEmpSalaryLessThan(Double salary);

	List<Employee> findByEmpSalaryGreaterThan(Double salary);

	List<Employee> findEmpByNameAndLocation(String name, String location);

	List<Employee> findByEmpNameAndSalaryGreaterThan(String name, Double salary);

	List<Employee> findByEmpLocationContainingOrSalaryLessThan(String location, Double salary);

	List<Employee> findByEmpNameAndEmpLocationAndSalaryBetween(String name, String location, Double minSal,
			Double maxSal);

	List<Employee> findByEmpNameOrEmpLocation(String name, String location);

	List<Employee> findByEmpNameIgnoreCase(String name);

	List<Employee> findByEmpLocationIgnoreCase(String location);

	List<Employee> findByEmpEmailContaining(String subString);

	List<Employee> findByEmpNameOrderBySalaryAsc(String name);

	List<Employee> findByEmpNameOrderBySalaryDesc(String name);

	List<Employee> findByEmpLocationOrderByEmpNameAsc(String location);

	List<Employee> findByEmpLocationOrderByEmpNameDesc(String location);

	List<Employee> findBySalaryGreaterThanEqual(Double salary);

	List<Employee> findBySalaryLessThanEqual(Double salary);

	List<Employee> findBySalaryNot(Double salary);

	List<Employee> findByEmpNameContaining(String subString);

	List<Employee> findByEmpLocationContaining(String subString);

	List<Employee> findByEmpEmailEndingWith(String domain);

	List<Employee> findByEmpEmailStartingWith(String prefix);

	List<Employee> findBySalaryGreaterThanOrderByEmpNameAsc(Double salary);

	List<Employee> findBySalaryLessThanOrderByEmpNameAsc(Double salary);

	List<Employee> findByEmpLocationOrderBySalaryAsc(String location);

	List<Employee> findByEmpEmailContainingOrderBySalaryDesc(String subString);

	List<Employee> findByEmpNameIgnoreCaseContaining(String subString);

	List<Employee> findByEmpLocationIgnoreCaseContaining(String subString);

	List<Employee> findBySalaryGreaterThanAndEmpLocationContaining(Double salary, String subString);

	List<Employee> findByEmpNameContainingOrEmpEmailContaining(String nameSubstring, String emailSubstring);

	List<Employee> findByEmpNameContainingAndSalaryGreaterThan(String nameSubstring, Double salary);

	List<Employee> findByEmpNameContainingOrderBySalaryDesc(String nameSubstring);

	List<Employee> findByEmpLocationContainingOrderBySalaryAsc(String locationSubstring);

	List<Employee> findByEmpLocationAndSalaryLessThan(String location, Double salary);

}
