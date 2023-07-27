package redoc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import redoc.dto.EmployeePojo;
import redoc.service.EmployeeService;

@RestController
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService empService;

// API to save employee details
	@PostMapping("/saveEmpDetails")
	public ResponseEntity<String> saveEmpDetails(@RequestBody EmployeePojo emp) {
		LOGGER.info("Received request to save employee details: {}", emp);

		empService.saveEmpDetails(emp);

		LOGGER.info("Employee details saved successfully");

		return ResponseEntity.status(HttpStatus.CREATED).body("Employee details saved successfully");

	}

	// API to save list of employee details
	@PostMapping("/saveListEmpDetails")
	public ResponseEntity<String> saveListEmpDetails(@RequestBody List<EmployeePojo> empList) {
		LOGGER.info("Received request to save a list of employee details");

		empService.saveListEmpDetails(empList);

		LOGGER.info("Employee details list saved successfully");

		return ResponseEntity.status(HttpStatus.CREATED).body("Employee details list saved successfully");

	}

	// API to fetch list of employees based on salary
	@GetMapping("/findEmployeesListBySalary")
	public ResponseEntity<List<EmployeePojo>> findBySalary(
			@RequestParam(value = "salary", defaultValue = "0") Double salary) {
		LOGGER.info("Received request to find employees with salary greater than : {}", salary);

		List<EmployeePojo> employeesListBySalary = empService.findEmpListBySalary(salary);

		LOGGER.info("Found {} employees with salary greater than: {}", employeesListBySalary.size(), salary);

		return new ResponseEntity<List<EmployeePojo>>(employeesListBySalary, HttpStatusCode.valueOf(200));
	}

// API to fetch list of employees by name
	@GetMapping("/findEmployeesByName")
	public ResponseEntity<List<EmployeePojo>> findByEmpName(@RequestParam(value = "name") String name) {
		LOGGER.info("Received request to find employees with name: {}", name);

		List<EmployeePojo> employeesListByName = empService.findEmpListByName(name);

		LOGGER.info("Found {} employees with name: {}", employeesListByName.size(), name);

		return new ResponseEntity<List<EmployeePojo>>(employeesListByName, HttpStatusCode.valueOf(200));

	}

	@GetMapping("/findEmployeesByLocation")
	public ResponseEntity<List<EmployeePojo>> findByLocation(@RequestParam(value = "location") String location) {
		LOGGER.info("Received request to find employees by location: {}", location);

		List<EmployeePojo> employeesByLocation = empService.findEmpListByLocation(location);

		LOGGER.info("Found {} employees in location: {}", employeesByLocation.size(), location);

		return new ResponseEntity<List<EmployeePojo>>(employeesByLocation, HttpStatusCode.valueOf(200));

	}

	@GetMapping("/findEmployeesByEmail")
	public ResponseEntity<List<EmployeePojo>> findByEmpEmail(@RequestParam(value = "email") String email) {
		LOGGER.info("Received request to find employees by email: {}", email);

		List<EmployeePojo> employeesByEmail = empService.findEmpListByEmail(email);

		LOGGER.info("Found {} employees with email: {}", employeesByEmail.size(), email);

		return ResponseEntity.ok(employeesByEmail);
	}

	@GetMapping("/getSalaryLessThan")
	public ResponseEntity<List<EmployeePojo>> findByEmpSalaryLessThan(@RequestParam(value = "salary") Double salary) {
		LOGGER.info("Received request to find employees with salary less than: {}", salary);

		List<EmployeePojo> employeesWithSalaryLessThan = empService.findByEmpSalaryLessThan(salary);

		LOGGER.info("Found {} employees with salary less than: {}", employeesWithSalaryLessThan.size(), salary);

		return ResponseEntity.ok(employeesWithSalaryLessThan);
	}

	@GetMapping("/getSalaryGreaterThan")
	public ResponseEntity<List<EmployeePojo>> findByEmpSalaryGreaterThan(
			@RequestParam(value = "salary") Double salary) {
		LOGGER.info("Received request to find employees with salary greater than: {}", salary);

		List<EmployeePojo> employeesWithSalaryGreaterThan = empService.findByEmpSalaryGreaterThan(salary);

		LOGGER.info("Found {} employees with salary greater than: {}", employeesWithSalaryGreaterThan.size(), salary);

		return ResponseEntity.ok(employeesWithSalaryGreaterThan);
	}

	@GetMapping("/getSalaryFromRange")
	public ResponseEntity<List<EmployeePojo>> findEmpFromSalaryRange(@RequestParam(value = "minValue") Double minValue,
			@RequestParam(value = "maxValue") Double maxValue) {
		LOGGER.info("Received request to find employees with salary between {} and {}", minValue, maxValue);

		List<EmployeePojo> employeesInSalaryRange = empService.findEmpListSalaryRange(minValue, maxValue);

		LOGGER.info("Found {} employees with salary between {} and {}", employeesInSalaryRange.size(), minValue,
				maxValue);

		return ResponseEntity.ok(employeesInSalaryRange);
	}

	@GetMapping("/findEmpByNameAndLocation")
	public ResponseEntity<List<EmployeePojo>> findEmpByNameAndLocation(@RequestParam(value = "name") String name,
			@RequestParam(value = "location") String location) {
		LOGGER.info("Received request to find employees by name: {} and location: {}", name, location);

		List<EmployeePojo> employeesByNameAndLocation = empService.findEmpByNameAndLocation(name, location);

		LOGGER.info("Found {} employees by name: {} and location: {}", employeesByNameAndLocation.size(), name,
				location);

		return ResponseEntity.ok(employeesByNameAndLocation);
	}

	@GetMapping("/findByEmpNameAndSalaryGreaterThan")
	public ResponseEntity<List<EmployeePojo>> findByEmpNameAndSalaryGreaterThan(
			@RequestParam(value = "name") String name, @RequestParam(value = "salary") Double salary) {
		LOGGER.info("Received request to find employees by name: {} and salary greater than: {}", name, salary);

		List<EmployeePojo> employeesByNameAndSalaryGreaterThan = empService.findByEmpNameAndSalaryGreaterThan(name,
				salary);

		LOGGER.info("Found {} employees by name: {} and salary greater than: {}",
				employeesByNameAndSalaryGreaterThan.size(), name, salary);

		return ResponseEntity.ok(employeesByNameAndSalaryGreaterThan);
	}

	@GetMapping("/findByEmpLocationAndSalaryLessThan")
	public ResponseEntity<List<EmployeePojo>> findByEmpLocationAndSalaryLessThan(
			@RequestParam(value = "location") String location, @RequestParam(value = "salary") Double salary) {
		LOGGER.info("Received request to find employees by location: {} and salary less than: {}", location, salary);

		List<EmployeePojo> employeesByLocationAndSalaryLessThan = empService
				.findByEmpLocationAndSalaryLessThan(location, salary);

		LOGGER.info("Found {} employees by location: {} and salary less than: {}",
				employeesByLocationAndSalaryLessThan.size(), location, salary);

		return ResponseEntity.ok(employeesByLocationAndSalaryLessThan);
	}

	@GetMapping("/findByEmpNameAndEmpLocationAndSalaryBetween")
	public ResponseEntity<List<EmployeePojo>> findByEmpNameAndEmpLocationAndSalaryBetween(
			@RequestParam(value = "name") String name, @RequestParam(value = "location") String location,
			@RequestParam(value = "minSal") Double minSal, @RequestParam(value = "maxSal") Double maxSal) {
		LOGGER.info("Received request to find employees by name: {}, location: {}, and salary between: {} and {}", name,
				location, minSal, maxSal);

		List<EmployeePojo> employeesByNameAndLocationAndSalaryBetween = empService
				.findByEmpNameAndEmpLocationAndSalaryBetween(name, location, minSal, maxSal);

		LOGGER.info("Found {} employees by name: {}, location: {}, and salary between: {} and {}",
				employeesByNameAndLocationAndSalaryBetween.size(), name, location, minSal, maxSal);

		return ResponseEntity.ok(employeesByNameAndLocationAndSalaryBetween);
	}

	// Custom method to find employees by name or location
	@GetMapping("/findByEmpNameOrEmpLocation")
	public ResponseEntity<List<EmployeePojo>> findByEmpNameOrEmpLocation(@RequestParam(value = "name") String name,
			@RequestParam(value = "location") String location) {
		LOGGER.info("Calling findByEmpNameOrEmpLocation with name: {} and location: {}", name, location);
		List<EmployeePojo> empList = empService.findByEmpNameOrEmpLocation(name, location);
		return ResponseEntity.ok(empList);
	}

	@GetMapping("/findByEmpNameIgnoreCase")
	public ResponseEntity<List<EmployeePojo>> findByEmpNameIgnoreCase(@RequestParam(value = "name") String name) {
		LOGGER.info("Calling findByEmpNameIgnoreCase with name: {}", name);
		List<EmployeePojo> empList = empService.findByEmpNameIgnoreCase(name);
		return ResponseEntity.ok(empList);
	}

	@GetMapping("/findByEmpLocationIgnoreCase")
	public ResponseEntity<List<EmployeePojo>> findByEmpLocationIgnoreCase(
			@RequestParam(value = "location") String location) {
		LOGGER.info("Calling findByEmpLocationIgnoreCase with location: {}", location);
		List<EmployeePojo> empList = empService.findByEmpLocationIgnoreCase(location);
		return ResponseEntity.ok(empList);
	}

	@GetMapping("/findByEmpEmailContaining")
	public ResponseEntity<List<EmployeePojo>> findByEmpEmailContaining(
			@RequestParam(value = "subString") String subString) {
		LOGGER.info("Calling findByEmpEmailContaining with subString: {}", subString);
		List<EmployeePojo> empList = empService.findByEmpEmailContaining(subString);
		return ResponseEntity.ok(empList);
	}

	@GetMapping("/findByEmpNameOrderBySalaryAsc")
	public ResponseEntity<List<EmployeePojo>> findByEmpNameOrderBySalaryAsc(@RequestParam(value = "name") String name) {
		LOGGER.info("Calling findByEmpNameOrderBySalaryAsc with name: {}", name);
		List<EmployeePojo> empList = empService.findByEmpNameOrderBySalaryAsc(name);
		return ResponseEntity.ok(empList);
	}

	@GetMapping("/findByEmpNameOrderBySalaryDesc")
	public ResponseEntity<List<EmployeePojo>> findByEmpNameOrderBySalaryDesc(
			@RequestParam(value = "name") String name) {
		LOGGER.info("Calling findByEmpNameOrderBySalaryDesc with name: {}", name);
		List<EmployeePojo> empList = empService.findByEmpNameOrderBySalaryDesc(name);
		return ResponseEntity.ok(empList);
	}

	@GetMapping("/findByEmpLocationOrderByEmpNameAsc")
	public ResponseEntity<List<EmployeePojo>> findByEmpLocationOrderByEmpNameAsc(
			@RequestParam(value = "location") String location) {
		LOGGER.info("Calling findByEmpLocationOrderByEmpNameAsc with location: {}", location);
		List<EmployeePojo> empList = empService.findByEmpLocationOrderByEmpNameAsc(location);
		return ResponseEntity.ok(empList);

	}

	@GetMapping("/findByEmpLocationOrderByEmpNameDesc")
	public ResponseEntity<List<EmployeePojo>> findByEmpLocationOrderByEmpNameDesc(
			@RequestParam(value = "location") String location) {
		LOGGER.info("Calling findByEmpLocationOrderByEmpNameDesc with location: {}", location);
		List<EmployeePojo> empList = empService.findByEmpLocationOrderByEmpNameDesc(location);
		return ResponseEntity.ok(empList);
	}

	@GetMapping("/findBySalaryGreaterThanEqual")
	public ResponseEntity<List<EmployeePojo>> findBySalaryGreaterThanEqual(
			@RequestParam(value = "salary") Double salary) {
		LOGGER.info("Calling findBySalaryGreaterThanEqual with salary: {}", salary);
		List<EmployeePojo> empList = empService.findBySalaryGreaterThanEqual(salary);
		return ResponseEntity.ok(empList);

	}

	@GetMapping("/findBySalaryLessThanEqual")
	public ResponseEntity<List<EmployeePojo>> findBySalaryLessThanEqual(@RequestParam(value = "salary") Double salary) {
		LOGGER.info("Calling findBySalaryLessThanEqual with salary: {}", salary);
		List<EmployeePojo> empList = empService.findBySalaryLessThanEqual(salary);
		return ResponseEntity.ok(empList);
	}

	@GetMapping("/findBySalaryNot")
	public ResponseEntity<List<EmployeePojo>> findBySalaryNot(@RequestParam(value = "salary") Double salary) {
		LOGGER.info("Calling findBySalaryNot with salary: {}", salary);
		List<EmployeePojo> empList = empService.findBySalaryNot(salary);
		return ResponseEntity.ok(empList);
	}

	@GetMapping("/findByEmpNameContaining")
	public ResponseEntity<List<EmployeePojo>> findByEmpNameContaining(
			@RequestParam(value = "subString") String subString) {
		LOGGER.info("Calling findByEmpNameContaining with subString: {}", subString);
		List<EmployeePojo> empList = empService.findByEmpNameContaining(subString);
		return ResponseEntity.ok(empList);
	}

	@GetMapping("/findByEmpLocationContaining")
	public ResponseEntity<List<EmployeePojo>> findByEmpLocationContaining(
			@RequestParam(value = "subString") String subString) {
		LOGGER.info("Calling findByEmpLocationContaining with subString: {}", subString);
		List<EmployeePojo> empList = empService.findByEmpLocationContaining(subString);
		return ResponseEntity.ok(empList);
	}

	@GetMapping("/findByEmpEmailEndingWith")
	public ResponseEntity<List<EmployeePojo>> findByEmpEmailEndingWith(@RequestParam(value = "domain") String domain) {
		LOGGER.info("Calling findByEmpEmailEndingWith with domain: {}", domain);
		List<EmployeePojo> empList = empService.findByEmpEmailEndingWith(domain);
		return ResponseEntity.ok(empList);
	}

	@GetMapping("/findByEmpEmailStartingWith")
	public ResponseEntity<List<EmployeePojo>> findByEmpEmailStartingWith(
			@RequestParam(value = "prefix") String prefix) {
		LOGGER.info("Calling findByEmpEmailStartingWith with prefix: {}", prefix);
		List<EmployeePojo> empList = empService.findByEmpEmailStartingWith(prefix);
		return ResponseEntity.ok(empList);
	}

	@GetMapping("/findBySalaryGreaterThanOrderByEmpNameAsc")
	public ResponseEntity<List<EmployeePojo>> findBySalaryGreaterThanOrderByEmpNameAsc(
			@RequestParam(value = "salary") Double salary) {
		LOGGER.info("Calling findBySalaryGreaterThanOrderByEmpNameAsc with salary: {}", salary);
		List<EmployeePojo> empList = empService.findBySalaryGreaterThanOrderByEmpNameAsc(salary);
		return ResponseEntity.ok(empList);
	}

	@GetMapping("/findBySalaryLessThanOrderByEmpNameAsc")
	public ResponseEntity<List<EmployeePojo>> findBySalaryLessThanOrderByEmpNameAsc(
			@RequestParam(value = "salary") Double salary) {
		LOGGER.info("Calling findBySalaryLessThanOrderByEmpNameAsc with salary: {}", salary);
		List<EmployeePojo> empList = empService.findBySalaryLessThanOrderByEmpNameAsc(salary);
		return ResponseEntity.ok(empList);
	}

	@GetMapping("/findByEmpLocationOrderBySalaryAsc")
	public ResponseEntity<List<EmployeePojo>> findByEmpLocationOrderBySalaryAsc(
			@RequestParam(value = "location") String location) {
		LOGGER.info("Calling findByEmpLocationOrderBySalaryAsc with location: {}", location);
		List<EmployeePojo> empList = empService.findByEmpLocationOrderBySalaryAsc(location);
		return ResponseEntity.ok(empList);
	}

	@GetMapping("/findByEmpEmailContainingOrderBySalaryDesc")
	public ResponseEntity<List<EmployeePojo>> findByEmpEmailContainingOrderBySalaryDesc(
			@RequestParam(value = "subString") String subString) {
		LOGGER.info("Calling findByEmpEmailContainingOrderBySalaryDesc with subString: {}", subString);
		List<EmployeePojo> empList = empService.findByEmpEmailContainingOrderBySalaryDesc(subString);
		return ResponseEntity.ok(empList);
	}

	@GetMapping("/findByEmpNameIgnoreCaseContaining")
	public ResponseEntity<List<EmployeePojo>> findByEmpNameIgnoreCaseContaining(
			@RequestParam(value = "subString") String subString) {
		LOGGER.info("Calling findByEmpNameIgnoreCaseContaining with subString: {}", subString);
		List<EmployeePojo> empList = empService.findByEmpNameIgnoreCaseContaining(subString);
		return ResponseEntity.ok(empList);
	}

	@GetMapping("/findByEmpLocationIgnoreCaseContaining")
	public ResponseEntity<List<EmployeePojo>> findByEmpLocationIgnoreCaseContaining(
			@RequestParam(value = "subString") String subString) {
		LOGGER.info("Calling findByEmpLocationIgnoreCaseContaining with subString: {}", subString);
		List<EmployeePojo> empList = empService.findByEmpLocationIgnoreCaseContaining(subString);
		return ResponseEntity.ok(empList);
	}

	@GetMapping("/findBySalaryGreaterThanAndEmpLocationContaining")
	public ResponseEntity<List<EmployeePojo>> findBySalaryGreaterThanAndEmpLocationContaining(
			@RequestParam(value = "salary") Double salary, @RequestParam(value = "subString") String subString) {
		LOGGER.info("Calling findBySalaryGreaterThanAndEmpLocationContaining with salary: {} and subString: {}", salary,
				subString);
		List<EmployeePojo> empList = empService.findBySalaryGreaterThanAndEmpLocationContaining(salary, subString);
		return ResponseEntity.ok(empList);
	}

	@GetMapping("/findByEmpNameContainingOrEmpEmailContaining")
	public ResponseEntity<List<EmployeePojo>> findByEmpNameContainingOrEmpEmailContaining(
			@RequestParam(value = "nameSubstring") String nameSubstring,
			@RequestParam(value = "emailSubstring") String emailSubstring) {
		LOGGER.info("Calling findByEmpNameContainingOrEmpEmailContaining with nameSubstring: {} and emailSubstring: {}",
				nameSubstring, emailSubstring);
		List<EmployeePojo> empList = empService.findByEmpNameContainingOrEmpEmailContaining(nameSubstring,
				emailSubstring);
		return ResponseEntity.ok(empList);
	}

	@GetMapping("/findByEmpNameContainingAndSalaryGreaterThan")
	public ResponseEntity<List<EmployeePojo>> findByEmpNameContainingAndSalaryGreaterThan(
			@RequestParam(value = "nameSubstring") String nameSubstring,
			@RequestParam(value = "salary") Double salary) {
		LOGGER.info("Calling findByEmpNameContainingAndSalaryGreaterThan with nameSubstring: {} and salary: {}",
				nameSubstring, salary);
		List<EmployeePojo> empList = empService.findByEmpNameContainingAndSalaryGreaterThan(nameSubstring, salary);
		return ResponseEntity.ok(empList);
	}

	public ResponseEntity<List<EmployeePojo>> findByEmpLocationContainingOrSalaryLessThan(
			@RequestParam(value = "locationSubstring") String locationSubstring,
			@RequestParam(value = "salary") Double salary) {
		LOGGER.info("Calling findByEmpLocationContainingOrSalaryLessThan with locationSubstring: {} and salary: {}",
				locationSubstring, salary);
		List<EmployeePojo> empList = empService.findByEmpLocationContainingOrSalaryLessThan(locationSubstring, salary);

		return ResponseEntity.ok(empList);
	}

	@GetMapping("/findByEmpNameContainingOrderBySalaryDesc")
	public ResponseEntity<List<EmployeePojo>> findByEmpNameContainingOrderBySalaryDesc(
			@RequestParam(value = "nameSubstring") String nameSubstring) {
		LOGGER.info("Calling findByEmpNameContainingOrderBySalaryDesc with nameSubstring: {}", nameSubstring);
		List<EmployeePojo> empList = empService.findByEmpNameContainingOrderBySalaryDesc(nameSubstring);
		return ResponseEntity.ok(empList);
	}

	@GetMapping("/findByEmpLocationContainingOrderBySalaryAsc")
	public ResponseEntity<List<EmployeePojo>> findByEmpLocationContainingOrderBySalaryAsc(
			@RequestParam(value = "locationSubstring") String locationSubstring) {
		LOGGER.info("Calling findByEmpLocationContainingOrderBySalaryAsc with locationSubstring: {}",
				locationSubstring);
		List<EmployeePojo> empList = empService.findByEmpLocationContainingOrderBySalaryAsc(locationSubstring);

		return ResponseEntity.ok(empList);
	}

}