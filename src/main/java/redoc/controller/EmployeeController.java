package redoc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import redoc.dto.EmployeePojo;
import redoc.entity.Employee;
import redoc.exception.EmployeeCommonException;
import redoc.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	// logger
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
			@RequestParam(value = "salary", defaultValue = "0") Double salary) throws EmployeeCommonException {
		LOGGER.info("Received request to find employees with salary: {}", salary);

		List<EmployeePojo> empList = empService.findEmpListBySalary(salary);

		if (empList == null) {

			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with salary: {}", empList.size(), salary);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	}

// API to fetch list of employees by name
	@GetMapping("/findEmployeesByName")
	public ResponseEntity<List<EmployeePojo>> findByEmpName(@RequestParam(value = "name") String name) {
		LOGGER.info("Received request to find employees with name: {}", name);

		List<EmployeePojo> employeesListByName = empService.findEmpListByName(name);
		if (employeesListByName == null) {
			return new ResponseEntity<>(employeesListByName, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with name: {}", employeesListByName.size(), name);

			return new ResponseEntity<List<EmployeePojo>>(employeesListByName, HttpStatusCode.valueOf(200));

		}
	}

	@GetMapping("/findEmployeesByLocation")
	public ResponseEntity<List<EmployeePojo>> findByLocation(@RequestParam(value = "location") String location) {
		LOGGER.info("Received request to find employees by location: {}", location);

		List<EmployeePojo> employeesByLocation = empService.findEmpListByLocation(location);

		if (employeesByLocation == null) {
			return new ResponseEntity<>(employeesByLocation, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees in location: {}", employeesByLocation.size(), location);

			return new ResponseEntity<List<EmployeePojo>>(employeesByLocation, HttpStatusCode.valueOf(200));
		}
	}

	@GetMapping("/findEmployeesByEmail")
	public ResponseEntity<List<EmployeePojo>> findByEmpEmail(@RequestParam(value = "email") String email) {
		LOGGER.info("Received request to find employees by email: {}", email);

		List<EmployeePojo> employeesByEmail = empService.findEmpListByEmail(email);

		if (employeesByEmail == null) {
			return new ResponseEntity<>(employeesByEmail, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with email: {}", employeesByEmail.size(), email);

			return new ResponseEntity<>(employeesByEmail, HttpStatus.OK);
		}
	}

	@GetMapping("/getSalaryLessThan")
	public ResponseEntity<List<EmployeePojo>> findByEmpSalaryLessThan(@RequestParam(value = "salary") Double salary) {
		LOGGER.info("Received request to find employees with salary less than: {}", salary);

		List<EmployeePojo> employeesWithSalaryLessThan = empService.findByEmpSalaryLessThan(salary);

		if (employeesWithSalaryLessThan == null) {
			return new ResponseEntity<>(employeesWithSalaryLessThan, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with salary less than: {}", employeesWithSalaryLessThan.size(), salary);

			return new ResponseEntity<>(employeesWithSalaryLessThan, HttpStatus.OK);
		}
	}

	@GetMapping("/getSalaryGreaterThan")
	public ResponseEntity<List<EmployeePojo>> findByEmpSalaryGreaterThan(
			@RequestParam(value = "salary") Double salary) {
		LOGGER.info("Received request to find employees with salary greater than: {}", salary);

		List<EmployeePojo> employeesWithSalaryGreaterThan = empService.findByEmpSalaryGreaterThan(salary);

		if (employeesWithSalaryGreaterThan == null) {
			return new ResponseEntity<>(employeesWithSalaryGreaterThan, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with salary greater than: {}", employeesWithSalaryGreaterThan.size(),
					salary);

			return new ResponseEntity<>(employeesWithSalaryGreaterThan, HttpStatus.OK);
		}
	}

	@GetMapping("/getSalaryFromRange")
	public ResponseEntity<List<EmployeePojo>> findEmpFromSalaryRange(@RequestParam(value = "minValue") Double minValue,
			@RequestParam(value = "maxValue") Double maxValue) {
		LOGGER.info("Received request to find employees with salary between {} and {}", minValue, maxValue);

		List<EmployeePojo> employeesInSalaryRange = empService.findEmpListSalaryRange(minValue, maxValue);

		if (employeesInSalaryRange == null) {
			return new ResponseEntity<>(employeesInSalaryRange, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with salary between {} and {}", employeesInSalaryRange.size(), minValue,
					maxValue);

			return new ResponseEntity<>(employeesInSalaryRange, HttpStatus.OK);
		}
	}

	@GetMapping("/findEmpByNameAndLocation")
	public ResponseEntity<List<EmployeePojo>> findEmpByNameAndLocation(@RequestParam(value = "name") String name,
			@RequestParam(value = "location") String location) {
		LOGGER.info("Received request to find employees by name: {} and location: {}", name, location);

		List<EmployeePojo> employeesByNameAndLocation = empService.findEmpByNameAndLocation(name, location);

		if (employeesByNameAndLocation == null) {
			return new ResponseEntity<>(employeesByNameAndLocation, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with name: {} and location: {}", employeesByNameAndLocation.size(), name,
					location);

			return new ResponseEntity<>(employeesByNameAndLocation, HttpStatus.OK);
		}
	}

	@GetMapping("/findByEmpNameAndSalaryGreaterThan")
	public ResponseEntity<List<EmployeePojo>> findByEmpNameAndSalaryGreaterThan(
			@RequestParam(value = "name") String name, @RequestParam(value = "salary") Double salary) {
		LOGGER.info("Received request to find employees by name: {} and salary greater than: {}", name, salary);

		List<EmployeePojo> employeesByNameAndSalaryGreaterThan = empService.findByEmpNameAndSalaryGreaterThan(name,
				salary);

		if (employeesByNameAndSalaryGreaterThan == null) {
			return new ResponseEntity<>(employeesByNameAndSalaryGreaterThan, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with name: {} and salary greater than: {}",
					employeesByNameAndSalaryGreaterThan.size(), name, salary);

			return new ResponseEntity<>(employeesByNameAndSalaryGreaterThan, HttpStatus.OK);
		}
	}

	@GetMapping("/findByEmpLocationAndSalaryLessThan")
	public ResponseEntity<List<EmployeePojo>> findByEmpLocationAndSalaryLessThan(
			@RequestParam(value = "location") String location, @RequestParam(value = "salary") Double salary) {
		LOGGER.info("Received request to find employees by location: {} and salary less than: {}", location, salary);

		List<EmployeePojo> employeesByLocationAndSalaryLessThan = empService
				.findByEmpLocationAndSalaryLessThan(location, salary);
		if (employeesByLocationAndSalaryLessThan == null) {
			return new ResponseEntity<>(employeesByLocationAndSalaryLessThan, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees by location: {} and salary less than: {}",
					employeesByLocationAndSalaryLessThan.size(), location, salary);

			return new ResponseEntity<>(employeesByLocationAndSalaryLessThan, HttpStatus.OK);
		}
	}

	@GetMapping("/findByEmpNameAndEmpLocationAndSalaryBetween")
	public ResponseEntity<List<EmployeePojo>> findByEmpNameAndEmpLocationAndSalaryBetween(
			@RequestParam(value = "name") String name, @RequestParam(value = "location") String location,
			@RequestParam(value = "minSal") Double minSal, @RequestParam(value = "maxSal") Double maxSal) {
		LOGGER.info("Received request to find employees by name: {}, location: {}, and salary between: {} and {}", name,
				location, minSal, maxSal);

		List<EmployeePojo> employeesByNameAndLocationAndSalaryBetween = empService
				.findByEmpNameAndEmpLocationAndSalaryBetween(name, location, minSal, maxSal);

		if (employeesByNameAndLocationAndSalaryBetween == null) {
			return new ResponseEntity<>(employeesByNameAndLocationAndSalaryBetween, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees by name: {}, location: {}, and salary between: {} and {}",
					employeesByNameAndLocationAndSalaryBetween.size(), name, location, minSal, maxSal);

			return new ResponseEntity<>(employeesByNameAndLocationAndSalaryBetween, HttpStatus.OK);
		}
	}

	// Custom method to find employees by name or location
	@GetMapping("/findByEmpNameOrEmpLocation")
	public ResponseEntity<List<EmployeePojo>> findByEmpNameOrEmpLocation(@RequestParam(value = "name") String name,
			@RequestParam(value = "location") String location) {
		LOGGER.info("Calling findByEmpNameOrEmpLocation with name: {} and location: {}", name, location);
		List<EmployeePojo> empList = empService.findByEmpNameOrEmpLocation(name, location);

		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}

	@GetMapping("/findByEmpNameIgnoreCase")
	public ResponseEntity<List<EmployeePojo>> findByEmpNameIgnoreCase(@RequestParam(value = "name") String name) {
		LOGGER.info("Calling findByEmpNameIgnoreCase with name: {}", name);
		List<EmployeePojo> empList = empService.findByEmpNameIgnoreCase(name);

		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with EmpNameIgnoreCase: {}", empList.size(), name);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	}

	@GetMapping("/findByEmpLocationIgnoreCase")
	public ResponseEntity<List<EmployeePojo>> findByEmpLocationIgnoreCase(
			@RequestParam(value = "location") String location) {
		LOGGER.info("Calling findByEmpLocationIgnoreCase with location: {}", location);
		List<EmployeePojo> empList = empService.findByEmpLocationIgnoreCase(location);

		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with EmpLocationIgnoreCase: {}", empList.size(), location);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	}

	@GetMapping("/findByEmpEmailContaining")
	public ResponseEntity<List<EmployeePojo>> findByEmpEmailContaining(
			@RequestParam(value = "subString") String subString) {
		LOGGER.info("Calling findByEmpEmailContaining with subString: {}", subString);
		List<EmployeePojo> empList = empService.findByEmpEmailContaining(subString);
		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with EmpEmailContaining: {}", empList.size(), subString);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	}

	@GetMapping("/findByEmpNameOrderBySalaryAsc")
	public ResponseEntity<List<EmployeePojo>> findByEmpNameOrderBySalaryAsc(@RequestParam(value = "name") String name) {
		LOGGER.info("Calling findByEmpNameOrderBySalaryAsc with name: {}", name);
		List<EmployeePojo> empList = empService.findByEmpNameOrderBySalaryAsc(name);

		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with EmpNameOrderBySalaryAsc: {}", empList.size(), name);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	}

	@GetMapping("/findByEmpNameOrderBySalaryDesc")
	public ResponseEntity<List<EmployeePojo>> findByEmpNameOrderBySalaryDesc(
			@RequestParam(value = "name") String name) {
		LOGGER.info("Calling findByEmpNameOrderBySalaryDesc with name: {}", name);
		List<EmployeePojo> empList = empService.findByEmpNameOrderBySalaryDesc(name);

		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with EmpNameOrderBySalaryDesc: {}", empList.size(), name);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	}

	@GetMapping("/findByEmpLocationOrderByEmpNameAsc")
	public ResponseEntity<List<EmployeePojo>> findByEmpLocationOrderByEmpNameAsc(
			@RequestParam(value = "location") String location) {
		LOGGER.info("Calling findByEmpLocationOrderByEmpNameAsc with location: {}", location);
		List<EmployeePojo> empList = empService.findByEmpLocationOrderByEmpNameAsc(location);

		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with EmpLocationOrderByEmpNameAsc: {}", empList.size(), location);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}

	}

	@GetMapping("/findByEmpLocationOrderByEmpNameDesc")
	public ResponseEntity<List<EmployeePojo>> findByEmpLocationOrderByEmpNameDesc(
			@RequestParam(value = "location") String location) {
		LOGGER.info("Calling findByEmpLocationOrderByEmpNameDesc with location: {}", location);
		List<EmployeePojo> empList = empService.findByEmpLocationOrderByEmpNameDesc(location);

		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with EmpLocationOrderByEmpNameDesc: {}", empList.size(), location);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	}

	@GetMapping("/findBySalaryGreaterThanEqual")
	public ResponseEntity<List<EmployeePojo>> findBySalaryGreaterThanEqual(
			@RequestParam(value = "salary") Double salary) {
		LOGGER.info("Calling findBySalaryGreaterThanEqual with salary: {}", salary);
		List<EmployeePojo> empList = empService.findBySalaryGreaterThanEqual(salary);

		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with SalaryGreaterThanEqual: {}", empList.size(), salary);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}

	}

	@GetMapping("/findBySalaryLessThanEqual")
	public ResponseEntity<List<EmployeePojo>> findBySalaryLessThanEqual(@RequestParam(value = "salary") Double salary) {
		LOGGER.info("Calling findBySalaryLessThanEqual with salary: {}", salary);
		List<EmployeePojo> empList = empService.findBySalaryLessThanEqual(salary);

		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with Salary Less Than Equal: {}", empList.size(), salary);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	}

	@GetMapping("/findBySalaryNot")
	public ResponseEntity<List<EmployeePojo>> findBySalaryNot(@RequestParam(value = "salary") Double salary) {
		LOGGER.info("Calling findBySalaryNot with salary: {}", salary);
		List<EmployeePojo> empList = empService.findBySalaryNot(salary);

		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with SalaryNot: {}", empList.size(), salary);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	}

	@GetMapping("/findByEmpNameContaining")
	public ResponseEntity<List<EmployeePojo>> findByEmpNameContaining(
			@RequestParam(value = "subString") String subString) {
		LOGGER.info("Calling findByEmpNameContaining with subString: {}", subString);
		List<EmployeePojo> empList = empService.findByEmpNameContaining(subString);

		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with EmpNameContaining: {}", empList.size(), subString);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	}

	@GetMapping("/findByEmpLocationContaining")
	public ResponseEntity<List<EmployeePojo>> findByEmpLocationContaining(
			@RequestParam(value = "subString") String subString) {
		LOGGER.info("Calling findByEmpLocationContaining with subString: {}", subString);
		List<EmployeePojo> empList = empService.findByEmpLocationContaining(subString);

		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with EmpLocationContaining: {}", empList.size(), subString);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	}

	@GetMapping("/findByEmpEmailEndingWith")
	public ResponseEntity<List<EmployeePojo>> findByEmpEmailEndingWith(@RequestParam(value = "domain") String domain) {
		LOGGER.info("Calling findByEmpEmailEndingWith with domain: {}", domain);
		List<EmployeePojo> empList = empService.findByEmpEmailEndingWith(domain);

		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with EmpEmailEndingWith: {}", empList.size(), domain);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	}

	@GetMapping("/findByEmpEmailStartingWith")
	public ResponseEntity<List<EmployeePojo>> findByEmpEmailStartingWith(
			@RequestParam(value = "prefix") String prefix) {
		LOGGER.info("Calling findByEmpEmailStartingWith with prefix: {}", prefix);
		List<EmployeePojo> empList = empService.findByEmpEmailStartingWith(prefix);

		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with EmpEmailStartingWith: {}", empList.size(), prefix);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	}

	@GetMapping("/findBySalaryGreaterThanOrderByEmpNameAsc")
	public ResponseEntity<List<EmployeePojo>> findBySalaryGreaterThanOrderByEmpNameAsc(
			@RequestParam(value = "salary") Double salary) {
		LOGGER.info("Calling findBySalaryGreaterThanOrderByEmpNameAsc with salary: {}", salary);
		List<EmployeePojo> empList = empService.findBySalaryGreaterThanOrderByEmpNameAsc(salary);

		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with SalaryGreaterThanOrderByEmpNameAsc: {}", empList.size(), salary);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	}

	@GetMapping("/findBySalaryLessThanOrderByEmpNameAsc")
	public ResponseEntity<List<EmployeePojo>> findBySalaryLessThanOrderByEmpNameAsc(
			@RequestParam(value = "salary") Double salary) {
		LOGGER.info("Calling findBySalaryLessThanOrderByEmpNameAsc with salary: {}", salary);
		List<EmployeePojo> empList = empService.findBySalaryLessThanOrderByEmpNameAsc(salary);

		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with SalaryLessThanOrderByEmpNameAsc: {}", empList.size(), salary);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	}

	@GetMapping("/findByEmpLocationOrderBySalaryAsc")
	public ResponseEntity<List<EmployeePojo>> findByEmpLocationOrderBySalaryAsc(
			@RequestParam(value = "location") String location) {
		LOGGER.info("Calling findByEmpLocationOrderBySalaryAsc with location: {}", location);

		List<EmployeePojo> empList = empService.findByEmpLocationOrderBySalaryAsc(location);

		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with EmpLocationOrderBySalaryAsc: {}", empList.size(), location);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	}

	@GetMapping("/findByEmpEmailContainingOrderBySalaryDesc")
	public ResponseEntity<List<EmployeePojo>> findByEmpEmailContainingOrderBySalaryDesc(
			@RequestParam(value = "subString") String subString) {
		LOGGER.info("Calling findByEmpEmailContainingOrderBySalaryDesc with subString: {}", subString);
		List<EmployeePojo> empList = empService.findByEmpEmailContainingOrderBySalaryDesc(subString);

		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with SEmpEmailContainingOrderBySalaryDesc: {}", empList.size(), subString);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	}

	@GetMapping("/findByEmpNameIgnoreCaseContaining")
	public ResponseEntity<List<EmployeePojo>> findByEmpNameIgnoreCaseContaining(
			@RequestParam(value = "subString") String subString) {
		LOGGER.info("Calling findByEmpNameIgnoreCaseContaining with subString: {}", subString);
		List<EmployeePojo> empList = empService.findByEmpNameIgnoreCaseContaining(subString);

		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with EmpNameIgnoreCaseContaining: {}", empList.size(), subString);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	}

	@GetMapping("/findByEmpLocationIgnoreCaseContaining")
	public ResponseEntity<List<EmployeePojo>> findByEmpLocationIgnoreCaseContaining(
			@RequestParam(value = "subString") String subString) {
		LOGGER.info("Calling findByEmpLocationIgnoreCaseContaining with subString: {}", subString);
		List<EmployeePojo> empList = empService.findByEmpLocationIgnoreCaseContaining(subString);

		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with EmpLocationIgnoreCaseContaining: {}", empList.size(), subString);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	}

	@GetMapping("/findBySalaryGreaterThanAndEmpLocationContaining")
	public ResponseEntity<List<EmployeePojo>> findBySalaryGreaterThanAndEmpLocationContaining(
			@RequestParam(value = "salary") Double salary, @RequestParam(value = "subString") String subString) {
		LOGGER.info("Calling findBySalaryGreaterThanAndEmpLocationContaining with salary: {} and subString: {}", salary,
				subString);
		List<EmployeePojo> empList = empService.findBySalaryGreaterThanAndEmpLocationContaining(salary, subString);

		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with SalaryGreaterThan: {} And EmpLocation Containing:  , {}",
					empList.size(), salary, subString);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	}

	@GetMapping("/findByEmpNameContainingOrEmpEmailContaining")
	public ResponseEntity<List<EmployeePojo>> findByEmpNameContainingOrEmpEmailContaining(
			@RequestParam(value = "nameSubstring") String nameSubstring,
			@RequestParam(value = "emailSubstring") String emailSubstring) {
		LOGGER.info("Calling findByEmpNameContainingOrEmpEmailContaining with nameSubstring: {} and emailSubstring: {}",
				nameSubstring, emailSubstring);
		List<EmployeePojo> empList = empService.findByEmpNameContainingOrEmpEmailContaining(nameSubstring,
				emailSubstring);

		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with EmpNameContaining: {} Or EmpEmailContaining: {}", empList.size(),
					nameSubstring, emailSubstring);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	}

	@GetMapping("/findByEmpNameContainingAndSalaryGreaterThan")
	public ResponseEntity<List<EmployeePojo>> findByEmpNameContainingAndSalaryGreaterThan(
			@RequestParam(value = "nameSubstring") String nameSubstring,
			@RequestParam(value = "salary") Double salary) {
		LOGGER.info("Calling findByEmpNameContainingAndSalaryGreaterThan with nameSubstring: {} and salary: {}",
				nameSubstring, salary);
		List<EmployeePojo> empList = empService.findByEmpNameContainingAndSalaryGreaterThan(nameSubstring, salary);
		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with EmpNameContaining: {} And SalaryGreaterThan: {}", empList.size(),
					nameSubstring, salary);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	}

	@GetMapping("/findByEmpLocationContainingOrSalaryLessThan")
	public ResponseEntity<List<EmployeePojo>> findByEmpLocationContainingOrSalaryLessThan(
			@RequestParam(value = "locationSubstring") String locationSubstring,
			@RequestParam(value = "salary") Double salary) {
		LOGGER.info("Calling findByEmpLocationContainingOrSalaryLessThan with locationSubstring: {} and salary: {}",
				locationSubstring, salary);
		List<EmployeePojo> empList = empService.findByEmpLocationContainingOrSalaryLessThan(locationSubstring, salary);

		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with EmpLocationContaining {} Or SalaryLessThan: {}", empList.size(),
					locationSubstring, salary);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	}

	@GetMapping("/findByEmpNameContainingOrderBySalaryDesc")
	public ResponseEntity<List<EmployeePojo>> findByEmpNameContainingOrderBySalaryDesc(
			@RequestParam(value = "nameSubstring") String nameSubstring) {
		LOGGER.info("Calling findByEmpNameContainingOrderBySalaryDesc with nameSubstring: {}", nameSubstring);
		List<EmployeePojo> empList = empService.findByEmpNameContainingOrderBySalaryDesc(nameSubstring);

		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with EmpNameContainingOrderBySalaryDesc: {}", empList.size(),
					nameSubstring);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	}

	@GetMapping("/findByEmpLocationContainingOrderBySalaryAsc")
	public ResponseEntity<List<EmployeePojo>> findByEmpLocationContainingOrderBySalaryAsc(
			@RequestParam(value = "locationSubstring") String locationSubstring) {
		LOGGER.info("Calling findByEmpLocationContainingOrderBySalaryAsc with locationSubstring: {}",
				locationSubstring);
		List<EmployeePojo> empList = empService.findByEmpLocationContainingOrderBySalaryAsc(locationSubstring);

		if (empList == null) {
			return new ResponseEntity<>(empList, HttpStatus.BAD_REQUEST);
		} else {
			LOGGER.info("Found {} employees with EmpLocationContaining {} OrderBySalaryAsc: {}", empList.size(),
					locationSubstring);

			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
	}

	@GetMapping("/findAllEmp")
	public List<Employee> findAllEmp() {
		return empService.findAllEmp();
	}

	@GetMapping("/paginationEx")
	public List<Employee> paginationEx() {
		return empService.paginationEx();
	}

	@GetMapping("/sortingEx")
	public List<Employee> sortingEx() {
		return empService.sortingEx();
	}

	@GetMapping("/paginationWithSortingEx")
	public List<Employee> paginationWithSortingEx() {
		return empService.paginationWithSortingEx();
	}

	// with path variable
//	@GetMapping("/cutsomAPI/{location}/{salary}")
//	public List<Employee> customAPIMethod(@PathVariable String location, @PathVariable String salary) {
//		return empService.customAPI(location, salary);
//		
//	}

	// with request param
	// url http://localhost:2222/employee/cutsomAPI?location=pune&salary=2500
	@GetMapping("/cutsomAPI")
	public List<Employee> customAPIMethod(@RequestParam String location, @RequestParam String salary) {
		return empService.customAPI(location, salary);

	}

	@GetMapping("/findEmpById")
	public Employee findEmpById(@RequestParam Long id) {
		return empService.getEmpById(id);
	}

}
