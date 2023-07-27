package redoc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import redoc.dto.EmployeePojo;
import redoc.service.EmployeeService;

@RestController
public class DemoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

	@Autowired
	EmployeeService empService;

// API to save employee details
	 @PostMapping("/saveEmpDetails")
	    public String saveEmpDetails(@RequestBody EmployeePojo emp) {
	        LOGGER.info("Received request to save employee details: {}", emp);

	        empService.saveEmpDetails(emp);

	        LOGGER.info("Employee details saved successfully");

	        return "saved";
	    }

	// API to save list of employee details
	 @PostMapping("/saveListEmpDetails")
	    public String saveListEmpDetails(@RequestBody List<EmployeePojo> empList) {
	        LOGGER.info("Received request to save a list of employee details");

	        empService.saveListEmpDetails(empList);

	        LOGGER.info("Employee details list saved successfully");

	        return "saved";
	    }
	// API to fetch list of employees based on salary
	 @GetMapping("/findEmployeesListBySalary")
	    public List<EmployeePojo> findBySalary(@RequestParam(value = "salary", defaultValue = "0") Double salary) {
	        LOGGER.info("Received request to find employees with salary greater than : {}", salary);

	        List<EmployeePojo> employeesListBySalary = empService.findEmpListBySalary(salary);

	        LOGGER.info("Found {} employees with salary greater than: {}", employeesListBySalary.size(), salary);

	        return employeesListBySalary;
	    }

// API to fetch list of employees by name
	 @GetMapping("/findEmployeesByName")
	    public List<EmployeePojo> findByEmpName(@RequestParam(value = "name") String name) {
	        LOGGER.info("Received request to find employees with name: {}", name);

	        List<EmployeePojo> employeesListByName = empService.findEmpListByName(name);

	        LOGGER.info("Found {} employees with name: {}", employeesListByName.size(), name);

	        return employeesListByName;
	    }
	 @GetMapping("/findEmployeesByLocation")
	    public List<EmployeePojo> findByLocation(@RequestParam(value = "location") String location) {
	        LOGGER.info("Received request to find employees by location: {}", location);

	        List<EmployeePojo> employeesByLocation = empService.findEmpListByLocation(location);

	        LOGGER.info("Found {} employees in location: {}", employeesByLocation.size(), location);

	        return employeesByLocation;
	    }

	    @GetMapping("/findEmployeesByEmail")
	    public List<EmployeePojo> findByEmpEmail(@RequestParam(value = "email") String email) {
	        LOGGER.info("Received request to find employees by email: {}", email);

	        List<EmployeePojo> employeesByEmail = empService.findEmpListByEmail(email);

	        LOGGER.info("Found {} employees with email: {}", employeesByEmail.size(), email);

	        return employeesByEmail;
	    }

	    @GetMapping("/getSalaryLessThan")
	    public List<EmployeePojo> findByEmpSalaryLessThan(@RequestParam(value = "salary") Double salary) {
	        LOGGER.info("Received request to find employees with salary less than: {}", salary);

	        List<EmployeePojo> employeesWithSalaryLessThan = empService.findByEmpSalaryLessThan(salary);

	        LOGGER.info("Found {} employees with salary less than: {}", employeesWithSalaryLessThan.size(), salary);

	        return employeesWithSalaryLessThan;
	    }

	    @GetMapping("/getSalaryGreaterThan")
	    public List<EmployeePojo> findByEmpSalaryGreaterThan(@RequestParam(value = "salary") Double salary) {
	        LOGGER.info("Received request to find employees with salary greater than: {}", salary);

	        List<EmployeePojo> employeesWithSalaryGreaterThan = empService.findByEmpSalaryGreaterThan(salary);

	        LOGGER.info("Found {} employees with salary greater than: {}", employeesWithSalaryGreaterThan.size(), salary);

	        return employeesWithSalaryGreaterThan;
	    }

	    @GetMapping("/getSalaryFromRange")
	    public List<EmployeePojo> findEmpFromSalaryRange(@RequestParam(value = "minValue") Double minValue,
	            @RequestParam(value = "maxValue") Double maxValue) {
	        LOGGER.info("Received request to find employees with salary between {} and {}", minValue, maxValue);

	        List<EmployeePojo> employeesInSalaryRange = empService.findEmpListSalaryRange(minValue, maxValue);

	        LOGGER.info("Found {} employees with salary between {} and {}", employeesInSalaryRange.size(), minValue, maxValue);

	        return employeesInSalaryRange;
	    }

	    @GetMapping("/findEmpByNameAndLocation")
	    public List<EmployeePojo> findEmpByNameAndLocation(@RequestParam(value = "name") String name,
	            @RequestParam(value = "location") String location) {
	        LOGGER.info("Received request to find employees by name: {} and location: {}", name, location);

	        List<EmployeePojo> employeesByNameAndLocation = empService.findEmpByNameAndLocation(name, location);

	        LOGGER.info("Found {} employees by name: {} and location: {}", employeesByNameAndLocation.size(), name, location);

	        return employeesByNameAndLocation;
	    }

	    @GetMapping("/findByEmpNameAndSalaryGreaterThan")
	    public List<EmployeePojo> findByEmpNameAndSalaryGreaterThan(@RequestParam(value = "name") String name,
	            @RequestParam(value = "salary") Double salary) {
	        LOGGER.info("Received request to find employees by name: {} and salary greater than: {}", name, salary);

	        List<EmployeePojo> employeesByNameAndSalaryGreaterThan = empService.findByEmpNameAndSalaryGreaterThan(name, salary);

	        LOGGER.info("Found {} employees by name: {} and salary greater than: {}", employeesByNameAndSalaryGreaterThan.size(), name, salary);

	        return employeesByNameAndSalaryGreaterThan;
	    }

	    @GetMapping("/findByEmpLocationAndSalaryLessThan")
	    public List<EmployeePojo> findByEmpLocationAndSalaryLessThan(@RequestParam(value = "location") String location,
	            @RequestParam(value = "salary") Double salary) {
	        LOGGER.info("Received request to find employees by location: {} and salary less than: {}", location, salary);

	        List<EmployeePojo> employeesByLocationAndSalaryLessThan = empService.findByEmpLocationAndSalaryLessThan(location, salary);

	        LOGGER.info("Found {} employees by location: {} and salary less than: {}", employeesByLocationAndSalaryLessThan.size(), location, salary);

	        return employeesByLocationAndSalaryLessThan;
	    }

	    @GetMapping("/findByEmpNameAndEmpLocationAndSalaryBetween")
	    public List<EmployeePojo> findByEmpNameAndEmpLocationAndSalaryBetween(@RequestParam(value = "name") String name,
	            @RequestParam(value = "location") String location, @RequestParam(value = "minSal") Double minSal,
	            @RequestParam(value = "maxSal") Double maxSal) {
	        LOGGER.info("Received request to find employees by name: {}, location: {}, and salary between: {} and {}", name, location, minSal, maxSal);

	        List<EmployeePojo> employeesByNameAndLocationAndSalaryBetween = empService.findByEmpNameAndEmpLocationAndSalaryBetween(name, location, minSal, maxSal);

	        LOGGER.info("Found {} employees by name: {}, location: {}, and salary between: {} and {}", employeesByNameAndLocationAndSalaryBetween.size(), name, location, minSal, maxSal);

	        return employeesByNameAndLocationAndSalaryBetween;
	    }
	

	// Custom method to find employees by name or location
	    @GetMapping("/findByEmpNameOrEmpLocation")
	    public List<EmployeePojo> findByEmpNameOrEmpLocation(@RequestParam(value = "name") String name,
	                                                          @RequestParam(value = "location") String location) {
	    	LOGGER.info("Calling findByEmpNameOrEmpLocation with name: {} and location: {}", name, location);
	        return empService.findByEmpNameOrEmpLocation(name, location);
	    }

	    @GetMapping("/findByEmpNameIgnoreCase")
	    public List<EmployeePojo> findByEmpNameIgnoreCase(@RequestParam(value = "name") String name) {
	    	LOGGER.info("Calling findByEmpNameIgnoreCase with name: {}", name);
	        return empService.findByEmpNameIgnoreCase(name);
	    }

	    @GetMapping("/findByEmpLocationIgnoreCase")
	    public List<EmployeePojo> findByEmpLocationIgnoreCase(@RequestParam(value = "location") String location) {
	    	LOGGER.info("Calling findByEmpLocationIgnoreCase with location: {}", location);
	        return empService.findByEmpLocationIgnoreCase(location);
	    }

	    @GetMapping("/findByEmpEmailContaining")
	    public List<EmployeePojo> findByEmpEmailContaining(@RequestParam(value = "subString") String subString) {
	    	LOGGER.info("Calling findByEmpEmailContaining with subString: {}", subString);
	        return empService.findByEmpEmailContaining(subString);
	    }

	    @GetMapping("/findByEmpNameOrderBySalaryAsc")
	    public List<EmployeePojo> findByEmpNameOrderBySalaryAsc(@RequestParam(value = "name") String name) {
	    	LOGGER.info("Calling findByEmpNameOrderBySalaryAsc with name: {}", name);
	        return empService.findByEmpNameOrderBySalaryAsc(name);
	    }

	    @GetMapping("/findByEmpNameOrderBySalaryDesc")
	    public List<EmployeePojo> findByEmpNameOrderBySalaryDesc(@RequestParam(value = "name") String name) {
	        LOGGER.info("Calling findByEmpNameOrderBySalaryDesc with name: {}", name);
	        return empService.findByEmpNameOrderBySalaryDesc(name);
	    }

	    @GetMapping("/findByEmpLocationOrderByEmpNameAsc")
	    public List<EmployeePojo> findByEmpLocationOrderByEmpNameAsc(@RequestParam(value = "location") String location) {
	        LOGGER.info("Calling findByEmpLocationOrderByEmpNameAsc with location: {}", location);
	        return empService.findByEmpLocationOrderByEmpNameAsc(location);
	    }

	    @GetMapping("/findByEmpLocationOrderByEmpNameDesc")
	    public List<EmployeePojo> findByEmpLocationOrderByEmpNameDesc(@RequestParam(value = "location") String location) {
	        LOGGER.info("Calling findByEmpLocationOrderByEmpNameDesc with location: {}", location);
	        return empService.findByEmpLocationOrderByEmpNameDesc(location);
	    }

	    @GetMapping("/findBySalaryGreaterThanEqual")
	    public List<EmployeePojo> findBySalaryGreaterThanEqual(@RequestParam(value = "salary") Double salary) {
	        LOGGER.info("Calling findBySalaryGreaterThanEqual with salary: {}", salary);
	        return empService.findBySalaryGreaterThanEqual(salary);
	    }

	    @GetMapping("/findBySalaryLessThanEqual")
	    public List<EmployeePojo> findBySalaryLessThanEqual(@RequestParam(value = "salary") Double salary) {
	        LOGGER.info("Calling findBySalaryLessThanEqual with salary: {}", salary);
	        return empService.findBySalaryLessThanEqual(salary);
	    }

	    @GetMapping("/findBySalaryNot")
	    public List<EmployeePojo> findBySalaryNot(@RequestParam(value = "salary") Double salary) {
	        LOGGER.info("Calling findBySalaryNot with salary: {}", salary);
	        return empService.findBySalaryNot(salary);
	    }

	    @GetMapping("/findByEmpNameContaining")
	    public List<EmployeePojo> findByEmpNameContaining(@RequestParam(value = "subString") String subString) {
	        LOGGER.info("Calling findByEmpNameContaining with subString: {}", subString);
	        return empService.findByEmpNameContaining(subString);
	    }

	    @GetMapping("/findByEmpLocationContaining")
	    public List<EmployeePojo> findByEmpLocationContaining(@RequestParam(value = "subString") String subString) {
	        LOGGER.info("Calling findByEmpLocationContaining with subString: {}", subString);
	        return empService.findByEmpLocationContaining(subString);
	    }

	    @GetMapping("/findByEmpEmailEndingWith")
	    public List<EmployeePojo> findByEmpEmailEndingWith(@RequestParam(value = "domain") String domain) {
	        LOGGER.info("Calling findByEmpEmailEndingWith with domain: {}", domain);
	        return empService.findByEmpEmailEndingWith(domain);
	    }


	    @GetMapping("/findByEmpEmailStartingWith")
	    public List<EmployeePojo> findByEmpEmailStartingWith(@RequestParam(value = "prefix") String prefix) {
	        LOGGER.info("Calling findByEmpEmailStartingWith with prefix: {}", prefix);
	        return empService.findByEmpEmailStartingWith(prefix);
	    }

	    @GetMapping("/findBySalaryGreaterThanOrderByEmpNameAsc")
	    public List<EmployeePojo> findBySalaryGreaterThanOrderByEmpNameAsc(@RequestParam(value = "salary") Double salary) {
	        LOGGER.info("Calling findBySalaryGreaterThanOrderByEmpNameAsc with salary: {}", salary);
	        return empService.findBySalaryGreaterThanOrderByEmpNameAsc(salary);
	    }

	    @GetMapping("/findBySalaryLessThanOrderByEmpNameAsc")
	    public List<EmployeePojo> findBySalaryLessThanOrderByEmpNameAsc(@RequestParam(value = "salary") Double salary) {
	        LOGGER.info("Calling findBySalaryLessThanOrderByEmpNameAsc with salary: {}", salary);
	        return empService.findBySalaryLessThanOrderByEmpNameAsc(salary);
	    }

	    @GetMapping("/findByEmpLocationOrderBySalaryAsc")
	    public List<EmployeePojo> findByEmpLocationOrderBySalaryAsc(@RequestParam(value = "location") String location) {
	        LOGGER.info("Calling findByEmpLocationOrderBySalaryAsc with location: {}", location);
	        return empService.findByEmpLocationOrderBySalaryAsc(location);
	    }

	    @GetMapping("/findByEmpEmailContainingOrderBySalaryDesc")
	    public List<EmployeePojo> findByEmpEmailContainingOrderBySalaryDesc(@RequestParam(value = "subString") String subString) {
	        LOGGER.info("Calling findByEmpEmailContainingOrderBySalaryDesc with subString: {}", subString);
	        return empService.findByEmpEmailContainingOrderBySalaryDesc(subString);
	    }

	    @GetMapping("/findByEmpNameIgnoreCaseContaining")
	    public List<EmployeePojo> findByEmpNameIgnoreCaseContaining(@RequestParam(value = "subString") String subString) {
	        LOGGER.info("Calling findByEmpNameIgnoreCaseContaining with subString: {}", subString);
	        return empService.findByEmpNameIgnoreCaseContaining(subString);
	    }

	    @GetMapping("/findByEmpLocationIgnoreCaseContaining")
	    public List<EmployeePojo> findByEmpLocationIgnoreCaseContaining(@RequestParam(value = "subString") String subString) {
	        LOGGER.info("Calling findByEmpLocationIgnoreCaseContaining with subString: {}", subString);
	        return empService.findByEmpLocationIgnoreCaseContaining(subString);
	    }

	    @GetMapping("/findBySalaryGreaterThanAndEmpLocationContaining")
	    public List<EmployeePojo> findBySalaryGreaterThanAndEmpLocationContaining(
	            @RequestParam(value = "salary") Double salary, @RequestParam(value = "subString") String subString) {
	        LOGGER.info("Calling findBySalaryGreaterThanAndEmpLocationContaining with salary: {} and subString: {}", salary, subString);
	        return empService.findBySalaryGreaterThanAndEmpLocationContaining(salary, subString);
	    }

	    @GetMapping("/findByEmpNameContainingOrEmpEmailContaining")
	    public List<EmployeePojo> findByEmpNameContainingOrEmpEmailContaining(
	            @RequestParam(value = "nameSubstring") String nameSubstring,
	            @RequestParam(value = "emailSubstring") String emailSubstring) {
	        LOGGER.info("Calling findByEmpNameContainingOrEmpEmailContaining with nameSubstring: {} and emailSubstring: {}", nameSubstring, emailSubstring);
	        return empService.findByEmpNameContainingOrEmpEmailContaining(nameSubstring, emailSubstring);
	    }

	    @GetMapping("/findByEmpNameContainingAndSalaryGreaterThan")
	    public List<EmployeePojo> findByEmpNameContainingAndSalaryGreaterThan(
	            @RequestParam(value = "nameSubstring") String nameSubstring,
	            @RequestParam(value = "salary") Double salary) {
	        LOGGER.info("Calling findByEmpNameContainingAndSalaryGreaterThan with nameSubstring: {} and salary: {}", nameSubstring, salary);
	        return empService.findByEmpNameContainingAndSalaryGreaterThan(nameSubstring, salary);
	    }
	    public List<EmployeePojo> findByEmpLocationContainingOrSalaryLessThan(
	            @RequestParam(value = "locationSubstring") String locationSubstring,
	            @RequestParam(value = "salary") Double salary) {
	        LOGGER.info("Calling findByEmpLocationContainingOrSalaryLessThan with locationSubstring: {} and salary: {}", locationSubstring, salary);
	        return empService.findByEmpLocationContainingOrSalaryLessThan(locationSubstring, salary);
	    }

	    @GetMapping("/findByEmpNameContainingOrderBySalaryDesc")
	    public List<EmployeePojo> findByEmpNameContainingOrderBySalaryDesc(
	            @RequestParam(value = "nameSubstring") String nameSubstring) {
	        LOGGER.info("Calling findByEmpNameContainingOrderBySalaryDesc with nameSubstring: {}", nameSubstring);
	        return empService.findByEmpNameContainingOrderBySalaryDesc(nameSubstring);
	    }

	    @GetMapping("/findByEmpLocationContainingOrderBySalaryAsc")
	    public List<EmployeePojo> findByEmpLocationContainingOrderBySalaryAsc(
	            @RequestParam(value = "locationSubstring") String locationSubstring) {
	        LOGGER.info("Calling findByEmpLocationContainingOrderBySalaryAsc with locationSubstring: {}", locationSubstring);
	        return empService.findByEmpLocationContainingOrderBySalaryAsc(locationSubstring);
	    }

}
