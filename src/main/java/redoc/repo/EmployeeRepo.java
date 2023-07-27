package redoc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import redoc.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	List<Employee> findBySalary(Double salary);

	List<Employee> findByEmpName(String name);

	List<Employee> findByEmpLocation(String location);

	List<Employee> findByEmpEmail(String email);

	List<Employee> findBySalaryBetween(Double minValue, Double maxValue);

	List<Employee> findBySalaryLessThan(Double salary);

	List<Employee> findBySalaryGreaterThan(Double salary);

	List<Employee> findEmpByEmpNameAndEmpLocation(String name, String location);

	List<Employee> findByEmpNameAndSalaryGreaterThan(String name, Double salary);

	List<Employee> findByEmpLocationAndSalaryLessThan(String location, Double salary);

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

	List<Employee> findByEmpLocationContainingOrSalaryLessThan(String location, Double salary);

}
