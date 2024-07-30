package redoc.service;

import java.util.List;

import redoc.dto.EmployeePojo;
import redoc.entity.Employee;

public interface EmployeeService {

	List<EmployeePojo> findEmpListBySalary(Double salary);

	void saveEmpDetails(EmployeePojo emp);

	List<EmployeePojo> findEmpListByName(String name);

	List<EmployeePojo> findEmpListByLocation(String location);

	List<EmployeePojo> findEmpListByEmail(String email);

	void saveListEmpDetails(List<EmployeePojo> emp);

	List<EmployeePojo> findEmpListSalaryRange(Double minValue, Double maxValue);

	List<EmployeePojo> findByEmpSalaryLessThan(Double salary);

	List<EmployeePojo> findByEmpSalaryGreaterThan(Double salary);

	List<EmployeePojo> findEmpByNameAndLocation(String name, String location);

	List<EmployeePojo> findByEmpNameAndSalaryGreaterThan(String name, Double salary);

	List<EmployeePojo> findByEmpLocationContainingOrSalaryLessThan(String location, Double salary);

	List<EmployeePojo> findByEmpNameAndEmpLocationAndSalaryBetween(String name, String location, Double minSal,
			Double maxSal);

	List<EmployeePojo> findByEmpNameOrEmpLocation(String name, String location);

	List<EmployeePojo> findByEmpNameIgnoreCase(String name);

	List<EmployeePojo> findByEmpLocationIgnoreCase(String location);

	List<EmployeePojo> findByEmpEmailContaining(String subString);

	List<EmployeePojo> findByEmpNameOrderBySalaryAsc(String name);

	List<EmployeePojo> findByEmpNameOrderBySalaryDesc(String name);

	List<EmployeePojo> findByEmpLocationOrderByEmpNameAsc(String location);

	List<EmployeePojo> findByEmpLocationOrderByEmpNameDesc(String location);

	List<EmployeePojo> findBySalaryGreaterThanEqual(Double salary);

	List<EmployeePojo> findBySalaryLessThanEqual(Double salary);

	List<EmployeePojo> findBySalaryNot(Double salary);

	List<EmployeePojo> findByEmpNameContaining(String subString);

	List<EmployeePojo> findByEmpLocationContaining(String subString);

	List<EmployeePojo> findByEmpEmailEndingWith(String domain);

	List<EmployeePojo> findByEmpEmailStartingWith(String prefix);

	List<EmployeePojo> findBySalaryGreaterThanOrderByEmpNameAsc(Double salary);

	List<EmployeePojo> findBySalaryLessThanOrderByEmpNameAsc(Double salary);

	List<EmployeePojo> findByEmpLocationOrderBySalaryAsc(String location);

	List<EmployeePojo> findByEmpEmailContainingOrderBySalaryDesc(String subString);

	List<EmployeePojo> findByEmpNameIgnoreCaseContaining(String subString);

	List<EmployeePojo> findByEmpLocationIgnoreCaseContaining(String subString);

	List<EmployeePojo> findBySalaryGreaterThanAndEmpLocationContaining(Double salary, String subString);

	List<EmployeePojo> findByEmpNameContainingOrEmpEmailContaining(String nameSubstring, String emailSubstring);

	List<EmployeePojo> findByEmpNameContainingAndSalaryGreaterThan(String nameSubstring, Double salary);

	List<EmployeePojo> findByEmpNameContainingOrderBySalaryDesc(String nameSubstring);

	List<EmployeePojo> findByEmpLocationContainingOrderBySalaryAsc(String locationSubstring);

	List<EmployeePojo> findByEmpLocationAndSalaryLessThan(String location, Double salary);

	List<Employee> paginationEx();

	List<Employee> sortingEx();

	List<Employee> paginationWithSortingEx();

	List<Employee> findAllEmp();

	List<Employee> customAPI(String location, String salary);

	Employee getEmpById(Long id);

}
