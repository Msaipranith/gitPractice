package redoc.controller;

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

	@PostMapping("/saveListEmpDetails")
	public String saveListEmpDetails(@RequestBody List<Employee> emp) {
		empService.saveListEmpDetails(emp);
		return "saved";
	}

	@GetMapping("/helloWorld")
	public String helloWorld() {
		return "hello world";
	}

	@GetMapping("/findEmployeesBySalary")
	public List<Employee> findBySalary(@RequestParam(value = "salary", defaultValue = "0") Double salary) {
		return empService.findEmpListBySalary(salary);
	}

	@GetMapping("/findEmployeesByName")
	public List<Employee> findByEmpName(@RequestParam(value = "name") String name) {
		return empService.findEmpListByName(name);
	}

	@GetMapping("/findEmployeesByLocation")
	public List<Employee> findByLocation(@RequestParam(value = "location") String location) {
		return empService.findEmpListByLocation(location);
	}

	@GetMapping("/findEmployeesByEmail")
	public List<Employee> findByEmpEmail(@RequestParam(value = "email") String email) {
		return empService.findEmpListByEmail(email);
	}

	// Custom method to find employees by their salary less than a specified amount
	@GetMapping("/getSalaryLessThan")
	public List<Employee> findByEmpSalaryLessThan(@RequestParam(value = "salary") Double salary) {
		return empService.findByEmpSalaryLessThan(salary);
	}

	// Custom method to find employees by their salary greater than a specified
	// amount
	@GetMapping("/getSalaryGreaterThan")
	public List<Employee> findByEmpSalaryGreaterThan(@RequestParam(value = "salary") Double salary) {
		return empService.findByEmpSalaryGreaterThan(salary);
	}

	// Custom method to find employees by their salary within a specific range
	@GetMapping("/getSalaryFromRange")
	public List<Employee> findEmpFromSalaryRange(@RequestParam(value = "minValue") Double minValue,
			@RequestParam(value = "maxValue") Double maxValue) {
		return empService.findEmpListSalaryRange(minValue, maxValue);
	}

	// Custom method to find employees by name and location
	@GetMapping("/findEmpByNameAndLocation")
	public List<Employee> findEmpByNameAndLocation(@RequestParam(value = "name") String name,
			@RequestParam(value = "location") String location) {
		return empService.findEmpByNameAndLocation(name, location);
	}

	// Custom method to find employees by name and salary greater than a specified
	// amount
	@GetMapping("/findByEmpNameAndSalaryGreaterThan")
	public List<Employee> findByEmpNameAndSalaryGreaterThan(@RequestParam(value = "name") String name,
			@RequestParam(value = "salary") Double salary) {
		return empService.findByEmpNameAndSalaryGreaterThan(name, salary);
	}

	// Custom method to find employees by location and salary less than a specified
	// amount
	@GetMapping("/findByEmpLocationAndSalaryLessThan")
	public List<Employee> findByEmpLocationAndSalaryLessThan(@RequestParam(value = "location") String location,
			@RequestParam(value = "salary") Double salary) {
		return empService.findByEmpLocationAndSalaryLessThan(location, salary);
	}

	// Custom method to find employees by name, location, and salary within a
	// specific range
	@GetMapping("/findByEmpNameAndEmpLocationAndSalaryBetween")
	public List<Employee> findByEmpNameAndEmpLocationAndSalaryBetween(@RequestParam(value = "name") String name,
			@RequestParam(value = "location") String location, @RequestParam(value = "minSal") Double minSal,
			@RequestParam(value = "maxSal") Double maxSal) {
		return empService.findByEmpNameAndEmpLocationAndSalaryBetween(name, location, minSal, maxSal);
	}

	// Custom method to find employees by name or location
	@GetMapping("/findByEmpNameOrEmpLocation")
	public List<Employee> findByEmpNameOrEmpLocation(@RequestParam(value = "name") String name,
			@RequestParam(value = "location") String location) {
		return empService.findByEmpNameOrEmpLocation(name, location);
	}

	// Custom method to find employees by name ignoring case sensitivity
	@GetMapping("/findByEmpNameIgnoreCase")
	public List<Employee> findByEmpNameIgnoreCase(@RequestParam(value = "name") String name) {
		return empService.findByEmpNameIgnoreCase(name);
	}

	// Custom method to find employees by location ignoring case sensitivity
	@GetMapping("/findByEmpLocationIgnoreCase")
	public List<Employee> findByEmpLocationIgnoreCase(@RequestParam(value = "location") String location) {
		return empService.findByEmpLocationIgnoreCase(location);
	}

	// Custom method to find employees by email containing a specific substring
	@GetMapping("/findByEmpEmailContaining")
	public List<Employee> findByEmpEmailContaining(@RequestParam(value = "subString") String subString) {
		return empService.findByEmpEmailContaining(subString);
	}

	// Custom method to find employees by name and order the results by salary in
	// ascending order
	@GetMapping("/findByEmpNameOrderBySalaryAsc")
	public List<Employee> findByEmpNameOrderBySalaryAsc(@RequestParam(value = "name") String name) {
		return empService.findByEmpNameOrderBySalaryAsc(name);
	}

	// Custom method to find employees by name and order the results by salary in
	// descending order
	@GetMapping("/findByEmpNameOrderBySalaryDesc")
	public List<Employee> findByEmpNameOrderBySalaryDesc(@RequestParam(value = "name") String name) {
		return empService.findByEmpNameOrderBySalaryDesc(name);
	}

	// Custom method to find employees by location and order the results by name in
	// ascending order
	@GetMapping("/findByEmpLocationOrderByEmpNameAsc")
	public List<Employee> findByEmpLocationOrderByEmpNameAsc(@RequestParam(value = "location") String location) {
		return empService.findByEmpLocationOrderByEmpNameAsc(location);
	}

	// Custom method to find employees by location and order the results by name in
	// descending order
	@GetMapping("/findByEmpLocationOrderByEmpNameDesc")
	public List<Employee> findByEmpLocationOrderByEmpNameDesc(@RequestParam(value = "location") String location) {
		return empService.findByEmpLocationOrderByEmpNameDesc(location);
	}

	// Custom method to find employees with a salary greater than or equal to a
	// specified amount
	@GetMapping("/findBySalaryGreaterThanEqual")
	public List<Employee> findBySalaryGreaterThanEqual(@RequestParam(value = "salary") Double salary) {
		return empService.findBySalaryGreaterThanEqual(salary);
	}

	// Custom method to find employees with a salary less than or equal to a
	// specified amount
	@GetMapping("/findBySalaryLessThanEqual")
	public List<Employee> findBySalaryLessThanEqual(@RequestParam(value = "salary") Double salary) {
		return empService.findBySalaryLessThanEqual(salary);
	}

	// Custom method to find employees with a salary not equal to a specified amount
	@GetMapping("/findBySalaryNot")
	public List<Employee> findBySalaryNot(@RequestParam(value = "salary") Double salary) {
		return empService.findBySalaryNot(salary);
	}

	// Custom method to find employees with a name containing a specific substring
	@GetMapping("/findByEmpNameContaining")
	public List<Employee> findByEmpNameContaining(@RequestParam(value = "subString") String subString) {
		return empService.findByEmpNameContaining(subString);
	}

	// Custom method to find employees with a location containing a specific
	// substring
	@GetMapping("/findByEmpLocationContaining")
	public List<Employee> findByEmpLocationContaining(@RequestParam(value = "subString") String subString) {
		return empService.findByEmpLocationContaining(subString);
	}

	// Custom method to find employees with an email ending with a specific domain
	@GetMapping("/findByEmpEmailEndingWith")
	public List<Employee> findByEmpEmailEndingWith(@RequestParam(value = "domain") String domain) {
		return empService.findByEmpEmailEndingWith(domain);
	}

//=================================================================
	// Custom method to find employees with an email starting with a specific prefix
	@GetMapping("/findByEmpEmailStartingWith")
	public List<Employee> findByEmpEmailStartingWith(@RequestParam(value = "prefix") String prefix) {
		return empService.findByEmpEmailStartingWith(prefix);
	}

	// Custom method to find employees with a salary greater than a specified amount
	// and ordered by name
	@GetMapping("/findBySalaryGreaterThanOrderByEmpNameAsc")
	public List<Employee> findBySalaryGreaterThanOrderByEmpNameAsc(@RequestParam(value = "salary") Double salary) {
		return empService.findBySalaryGreaterThanOrderByEmpNameAsc(salary);
	}

	// Custom method to find employees with a salary less than a specified amount
	// and ordered by name
	@GetMapping("/findBySalaryLessThanOrderByEmpNameAsc")
	public List<Employee> findBySalaryLessThanOrderByEmpNameAsc(@RequestParam(value = "salary") Double salary) {
		return empService.findBySalaryLessThanOrderByEmpNameAsc(salary);
	}

	// Custom method to find employees with a location and ordered by salary in
	// ascending order
	@GetMapping("/findByEmpLocationOrderBySalaryAsc")
	public List<Employee> findByEmpLocationOrderBySalaryAsc(@RequestParam(value = "location") String location) {
		return empService.findByEmpLocationOrderBySalaryAsc(location);
	}

	// Custom method to find employees with an email containing a specific substring
	// and ordered by salary in descending order
	@GetMapping("/findByEmpEmailContainingOrderBySalaryDesc")
	public List<Employee> findByEmpEmailContainingOrderBySalaryDesc(
			@RequestParam(value = "subString") String subString) {
		return empService.findByEmpEmailContainingOrderBySalaryDesc(subString);
	}

	// Custom method to find employees with a name containing a specific substring
	// ignoring case sensitivity
	@GetMapping("/findByEmpNameIgnoreCaseContaining")
	public List<Employee> findByEmpNameIgnoreCaseContaining(@RequestParam(value = "subString") String subString) {
		return empService.findByEmpNameIgnoreCaseContaining(subString);
	}

	// Custom method to find employees with a location containing a specific
	// substring ignoring case sensitivity
	@GetMapping("/findByEmpLocationIgnoreCaseContaining")
	public List<Employee> findByEmpLocationIgnoreCaseContaining(@RequestParam(value = "subString") String subString) {
		return empService.findByEmpLocationIgnoreCaseContaining(subString);
	}

	// Custom method to find employees with a salary greater than a specified amount
	// and a location containing a specific substring
	@GetMapping("/findBySalaryGreaterThanAndEmpLocationContaining")
	public List<Employee> findBySalaryGreaterThanAndEmpLocationContaining(@RequestParam(value = "salary") Double salary,
			@RequestParam(value = "subString") String subString) {
		return empService.findBySalaryGreaterThanAndEmpLocationContaining(salary, subString);
	}

	// Custom method to find employees with a name containing a specific substring
	// or an email containing another substring
	@GetMapping("/findByEmpNameContainingOrEmpEmailContaining")
	public List<Employee> findByEmpNameContainingOrEmpEmailContaining(
			@RequestParam(value = "nameSubstring") String nameSubstring,
			@RequestParam(value = "emailSubstring") String emailSubstring) {
		return empService.findByEmpNameContainingOrEmpEmailContaining(nameSubstring, emailSubstring);
	}

	// Custom method to find employees with a name containing a specific substring
	// and a salary greater than a specified amount
	@GetMapping("/findByEmpNameContainingAndSalaryGreaterThan")
	public List<Employee> findByEmpNameContainingAndSalaryGreaterThan(
			@RequestParam(value = "nameSubstring") String nameSubstring,
			@RequestParam(value = "salary") Double salary) {
		return empService.findByEmpNameContainingAndSalaryGreaterThan(nameSubstring, salary);
	}

	// Custom method to find employees with a location containing a specific
	// substring or a salary less than a specified amount
	@GetMapping("/findByEmpLocationContainingOrSalaryLessThan")
	public List<Employee> findByEmpLocationContainingOrSalaryLessThan(
			@RequestParam(value = "locationSubstring") String locationSubstring,
			@RequestParam(value = "salary") Double salary) {
		return empService.findByEmpLocationContainingOrSalaryLessThan(locationSubstring, salary);
	}

	// Custom method to find employees with a name containing a specific substring
	// and order the results by salary in descending order
	@GetMapping("/findByEmpNameContainingOrderBySalaryDesc")
	public List<Employee> findByEmpNameContainingOrderBySalaryDesc(
			@RequestParam(value = "nameSubstringe") String nameSubstring) {
		return empService.findByEmpNameContainingOrderBySalaryDesc(nameSubstring);
	}

	// Custom method to find employees with a location containing a specific
	// substring and order the results by salary in ascending order
	@GetMapping("/findByEmpLocationContainingOrderBySalaryAsc")
	public List<Employee> findByEmpLocationContainingOrderBySalaryAsc(
			@RequestParam(value = "locationSubstring") String locationSubstring) {
		return empService.findByEmpLocationContainingOrderBySalaryAsc(locationSubstring);
	}
}
