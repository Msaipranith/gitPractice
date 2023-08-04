package redoc.service_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import redoc.UtilityTest.UtilityTest;
import redoc.dto.EmployeePojo;
import redoc.exception.EmployeeCommonException;
import redoc.repo.EmployeeRepo;
import redoc.service.EmployeeServiceImpl;

@ExtendWith(SpringExtension.class)
public class EmployeeServiceImplTest {

	@InjectMocks
	EmployeeServiceImpl employeeServiceImpl;

	@Mock
	EmployeeRepo empRepo;

	@InjectMocks
	UtilityTest utilityTest;

	@Test
	@Order(1)
	public void findEmpListBySalaryTest() {

		Mockito.when(empRepo.findBySalary(utilityTest.getSalary())).thenReturn(UtilityTest.employeeList());
		assertEquals(UtilityTest.empList(), employeeServiceImpl.findEmpListBySalary(utilityTest.getSalary()));

	}

	@Test
	@Order(2)
	public void findEmpListBySalaryTest_empPojoList_isEmpty() {
		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findEmpListBySalary(utilityTest.getSalary());
		});
		when(empRepo.findBySalary(utilityTest.getSalary())).thenReturn(Collections.emptyList());
		assertEquals("No employees found with salary: " + utilityTest.getSalary(), exception.getMessage());
	}

	@Test
	@Order(3)
	public void findEmpListByNameTest() {
		String nameToSearch = "John"; // Replace with the actual name value

		when(empRepo.findByEmpName(nameToSearch)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findEmpListByName(nameToSearch);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(4)
	public void findEmpListByNameTest_empPojoList_isEmpty() {
		String nameToSearch = "NonExistentName"; // Replace with a name that doesn't exist

		when(empRepo.findByEmpName(nameToSearch)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findEmpListByName(nameToSearch);
		});

		String expectedMessage = "No employees found with name: " + nameToSearch;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(5)
	public void findEmpListByLocationTest() {
		String locationToSearch = "New York"; // Replace with the actual location value

		when(empRepo.findByEmpLocation(locationToSearch)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findEmpListByLocation(locationToSearch);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(6)
	public void findEmpListByLocationTest_empPojoList_isEmpty() {
		String locationToSearch = "NonExistentLocation"; // Replace with a location that doesn't exist

		when(empRepo.findByEmpLocation(locationToSearch)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findEmpListByLocation(locationToSearch);
		});

		String expectedMessage = "No employees found with location: " + locationToSearch;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(7)
	public void findEmpListByEmailTest() {
		String emailToSearch = "john@example.com"; // Replace with the actual email value

		when(empRepo.findByEmpEmail(emailToSearch)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findEmpListByEmail(emailToSearch);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(8)
	public void findEmpListByEmailTest_empPojoList_isEmpty() {
		String emailToSearch = "nonexistent@example.com"; // Replace with a nonexistent email

		when(empRepo.findByEmpEmail(emailToSearch)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findEmpListByEmail(emailToSearch);
		});

		String expectedMessage = "No employees found with email: " + emailToSearch;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(10)
	public void findEmpListSalaryRangeTest() {
		Double minSalary = 2000.0; // Replace with actual values
		Double maxSalary = 5000.0;

		when(empRepo.findBySalaryBetween(minSalary, maxSalary)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findEmpListSalaryRange(minSalary, maxSalary);

		assertEquals(expectedList, actualList);
	}

	
	@Test
	@Order(11)
	public void findEmpListSalaryRangeTest_empPojoList_isEmpty() {
	    Double minSalary = 25000.0; // Replace with values that would result in an empty list
	    Double maxSalary = 50000.0;

	    when(empRepo.findBySalaryBetween(minSalary, maxSalary)).thenReturn(Collections.emptyList());

	    Exception exception = assertThrows(EmployeeCommonException.class, () -> {
	        employeeServiceImpl.findEmpListSalaryRange(minSalary, maxSalary);
	    });

	    String expectedMessage = "No employees found with salary range:  minSal " + minSalary + " maxSal " + maxSalary;
	    String actualMessage = exception.getMessage().trim(); // Trim to remove any leading/trailing spaces

	    assertEquals(expectedMessage, actualMessage);
	}



	@Test
	@Order(12)
	public void findByEmpSalaryLessThanTest() {
		Double salary = 5000.0; // Replace with the actual salary value

		when(empRepo.findBySalaryLessThan(salary)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findByEmpSalaryLessThan(salary);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(13)
	public void findByEmpSalaryLessThanTest_empPojoList_isEmpty() {
		Double salary = 1000.0; // Replace with a value that would result in an empty list

		when(empRepo.findBySalaryLessThan(salary)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpSalaryLessThan(salary);
		});

		String expectedMessage = "No employees found with salary less than: " + salary;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(14)
	public void findByEmpSalaryGreaterThanTest() {
		Double salary = 5000.0; // Replace with the actual salary value

		when(empRepo.findBySalaryGreaterThan(salary)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findByEmpSalaryGreaterThan(salary);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(15)
	public void findByEmpSalaryGreaterThanTest_empPojoList_isEmpty() {
		Double salary = 10000.0; // Replace with a value that would result in an empty list

		when(empRepo.findBySalaryGreaterThan(salary)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpSalaryGreaterThan(salary);
		});

		String expectedMessage = "No employees found with salary greater than: " + salary;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(16)
	public void findEmpByNameAndLocationTest() {
		String name = "John"; // Replace with actual name and location values
		String location = "New York";

		when(empRepo.findEmpByEmpNameAndEmpLocation(name, location)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findEmpByNameAndLocation(name, location);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(17)
	public void findEmpByNameAndLocationTest_empPojoList_isEmpty() {
		String name = "NonExistentName"; // Replace with a nonexistent name and location
		String location = "NonExistentLocation";

		when(empRepo.findEmpByEmpNameAndEmpLocation(name, location)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findEmpByNameAndLocation(name, location);
		});

		String expectedMessage = "No employees found with name:" + name + " location " + location;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(18)
	public void findByEmpNameAndSalaryGreaterThanTest() {
		String name = "John"; // Replace with actual name value
		Double salary = 5000.0; // Replace with actual salary value

		when(empRepo.findByEmpNameAndSalaryGreaterThan(name, salary)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findByEmpNameAndSalaryGreaterThan(name, salary);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(19)
	public void findByEmpNameAndSalaryGreaterThanTest_empPojoList_isEmpty() {
		String name = "NonExistentName"; // Replace with a nonexistent name
		Double salary = 10000.0; // Replace with a value that would result in an empty list

		when(empRepo.findByEmpNameAndSalaryGreaterThan(name, salary)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpNameAndSalaryGreaterThan(name, salary);
		});

		String expectedMessage = "No employees found with EmpName And Salary Greater Than: " + " name " + name
				+ " salary " + salary;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(20)
	public void findByEmpLocationContainingOrSalaryLessThanTest() {
		String location = "New"; // Replace with actual location value
		Double salary = 5000.0; // Replace with actual salary value

		when(empRepo.findByEmpLocationContainingOrSalaryLessThan(location, salary))
				.thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findByEmpLocationContainingOrSalaryLessThan(location,
				salary);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(21)
	public void findByEmpLocationContainingOrSalaryLessThanTest_empPojoList_isEmpty() {
		String location = "NonExistentLocation"; // Replace with a nonexistent location
		Double salary = 1000.0; // Replace with a value that would result in an empty list

		when(empRepo.findByEmpLocationContainingOrSalaryLessThan(location, salary)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpLocationContainingOrSalaryLessThan(location, salary);
		});

		String expectedMessage = "No employees found with EmpLocation Containing Or Salary Less Than: " + " location "
				+ location + " salary " + salary;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(22)
	public void findByEmpNameAndEmpLocationAndSalaryBetweenTest() {
		String name = "John"; // Replace with actual name and location values
		String location = "New York";
		Double minSalary = 2000.0; // Replace with actual min and max salary values
		Double maxSalary = 5000.0;

		when(empRepo.findByEmpNameAndEmpLocationAndSalaryBetween(name, location, minSalary, maxSalary))
				.thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findByEmpNameAndEmpLocationAndSalaryBetween(name, location,
				minSalary, maxSalary);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(23)
	public void findByEmpNameAndEmpLocationAndSalaryBetweenTest_empPojoList_isEmpty() {
		String name = "NonExistentName"; // Replace with a nonexistent name and location
		String location = "NonExistentLocation";
		Double minSalary = 10000.0; // Replace with values that would result in an empty list
		Double maxSalary = 15000.0;

		when(empRepo.findByEmpNameAndEmpLocationAndSalaryBetween(name, location, minSalary, maxSalary))
				.thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpNameAndEmpLocationAndSalaryBetween(name, location, minSalary, maxSalary);
		});

		String expectedMessage = "No employees found with EmpName And EmpLocation And Salary Between: " + " name "
				+ name + " location  " + location + " minSal " + minSalary + " maxSal " + maxSalary;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(24)
	public void findByEmpNameOrEmpLocationTest() {
		String name = "John"; // Replace with actual name and location values
		String location = "New York";

		when(empRepo.findByEmpNameOrEmpLocation(name, location)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findByEmpNameOrEmpLocation(name, location);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(25)
	public void findByEmpNameOrEmpLocationTest_empPojoList_isEmpty() {
		String name = "NonExistentName"; // Replace with a nonexistent name and location
		String location = "NonExistentLocation";

		when(empRepo.findByEmpNameOrEmpLocation(name, location)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpNameOrEmpLocation(name, location);
		});

		String expectedMessage = "No employees found with EmpName Or EmpLocation: " + " name " + name + " location "
				+ location;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(26)
	public void findByEmpNameIgnoreCaseTest() {
		String name = "John"; // Replace with actual name value

		when(empRepo.findByEmpNameIgnoreCase(name)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findByEmpNameIgnoreCase(name);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(27)
	public void findByEmpNameIgnoreCaseTest_empPojoList_isEmpty() {
		String name = "NonExistentName"; // Replace with a nonexistent name

		when(empRepo.findByEmpNameIgnoreCase(name)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpNameIgnoreCase(name);
		});

		String expectedMessage = "No employees found with EmpName Ignoring Case: " + " name " + name;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(28)
	public void findByEmpLocationIgnoreCaseTest() {
		String location = "New York"; // Replace with actual location value

		when(empRepo.findByEmpLocationIgnoreCase(location)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findByEmpLocationIgnoreCase(location);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(29)
	public void findByEmpLocationIgnoreCaseTest_empPojoList_isEmpty() {
		String location = "NonExistentLocation"; // Replace with a nonexistent location

		when(empRepo.findByEmpLocationIgnoreCase(location)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpLocationIgnoreCase(location);
		});

		String expectedMessage = "No employees found with EmpLocation Ignoring Case: " + " location " + location;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(30)
	public void findByEmpEmailContainingTest() {
		String subString = "example"; // Replace with actual substring value

		when(empRepo.findByEmpEmailContaining(subString)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findByEmpEmailContaining(subString);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(31)
	public void findByEmpEmailContainingTest_empPojoList_isEmpty() {
		String subString = "nonexistent"; // Replace with a nonexistent substring

		when(empRepo.findByEmpEmailContaining(subString)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpEmailContaining(subString);
		});

		String expectedMessage = "No employees found with EmpEmail Containing: " + " subString " + subString;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(32)
	public void findByEmpNameOrderBySalaryAscTest() {
		String name = "John"; // Replace with actual name value

		when(empRepo.findByEmpNameOrderBySalaryAsc(name)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findByEmpNameOrderBySalaryAsc(name);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(33)
	public void findByEmpNameOrderBySalaryAscTest_empPojoList_isEmpty() {
		String name = "NonExistentName"; // Replace with a nonexistent name

		when(empRepo.findByEmpNameOrderBySalaryAsc(name)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpNameOrderBySalaryAsc(name);
		});

		String expectedMessage = "No employees found with EmpName OrderBy Salary Asc: " + " name " + name;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(34)
	public void findByEmpNameOrderBySalaryDescTest() {
		String name = "John"; // Replace with actual name value

		when(empRepo.findByEmpNameOrderBySalaryDesc(name)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findByEmpNameOrderBySalaryDesc(name);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(35)
	public void findByEmpNameOrderBySalaryDescTest_empPojoList_isEmpty() {
		String name = "NonExistentName"; // Replace with a nonexistent name

		when(empRepo.findByEmpNameOrderBySalaryDesc(name)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpNameOrderBySalaryDesc(name);
		});

		String expectedMessage = "No employees found with EmpName OrderBy Salary Desc: " + " name " + name;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(36)
	public void findByEmpLocationOrderByEmpNameAscTest() {
		String location = "New York"; // Replace with actual location value

		when(empRepo.findByEmpLocationOrderByEmpNameAsc(location)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findByEmpLocationOrderByEmpNameAsc(location);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(37)
	public void findByEmpLocationOrderByEmpNameAscTest_empPojoList_isEmpty() {
		String location = "NonExistentLocation"; // Replace with a nonexistent location

		when(empRepo.findByEmpLocationOrderByEmpNameAsc(location)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpLocationOrderByEmpNameAsc(location);
		});

		String expectedMessage = "No employees found with EmpLocation OrderBy EmpNameAsc: " + " location " + location;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(38)
	public void findByEmpLocationOrderByEmpNameDescTest() {
		String location = "New York"; // Replace with actual location value

		when(empRepo.findByEmpLocationOrderByEmpNameDesc(location)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findByEmpLocationOrderByEmpNameDesc(location);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(39)
	public void findByEmpLocationOrderByEmpNameDescTest_empPojoList_isEmpty() {
		String location = "NonExistentLocation"; // Replace with a nonexistent location

		when(empRepo.findByEmpLocationOrderByEmpNameDesc(location)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpLocationOrderByEmpNameDesc(location);
		});

		String expectedMessage = "No employees found with EmpLocation OrderBy EmpNameDesc: " + " location " + location;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(40)
	public void findBySalaryGreaterThanEqualTest() {
		Double salary = 5000.0; // Replace with actual salary value

		when(empRepo.findBySalaryGreaterThanEqual(salary)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findBySalaryGreaterThanEqual(salary);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(41)
	public void findBySalaryGreaterThanEqualTest_empPojoList_isEmpty() {
		Double salary = 10000.0; // Replace with a value that would result in an empty list

		when(empRepo.findBySalaryGreaterThanEqual(salary)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findBySalaryGreaterThanEqual(salary);
		});

		String expectedMessage = "No employees found with Salary GreaterThan Or Equal: " + " salary " + salary;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(42)
	public void findBySalaryLessThanEqualTest() {
		Double salary = 5000.0; // Replace with actual salary value

		when(empRepo.findBySalaryLessThanEqual(salary)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findBySalaryLessThanEqual(salary);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(43)
	public void findBySalaryLessThanEqualTest_empPojoList_isEmpty() {
		Double salary = 1000.0; // Replace with a value that would result in an empty list

		when(empRepo.findBySalaryLessThanEqual(salary)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findBySalaryLessThanEqual(salary);
		});

		String expectedMessage = "No employees found with Salary Less Than Or Equal: " + salary;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(44)
	public void findBySalaryNotTest() {
		Double salary = 5000.0; // Replace with actual salary value

		when(empRepo.findBySalaryNot(salary)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findBySalaryNot(salary);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(45)
	public void findBySalaryNotTest_empPojoList_isEmpty() {
		Double salary = 1000.0; // Replace with a value that would result in an empty list

		when(empRepo.findBySalaryNot(salary)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findBySalaryNot(salary);
		});

		String expectedMessage = "No employees found with salary not equal to: " + salary;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(46)
	public void findByEmpNameContainingTest() {
		String subString = "John"; // Replace with actual substring value

		when(empRepo.findByEmpNameContaining(subString)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findByEmpNameContaining(subString);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(47)
	public void findByEmpNameContainingTest_empPojoList_isEmpty() {
		String subString = "NonExistentSubString"; // Replace with a nonexistent substring

		when(empRepo.findByEmpNameContaining(subString)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpNameContaining(subString);
		});

		String expectedMessage = "No employees found with EmpName Containing: " + " subString " + subString;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(48)
	public void findByEmpLocationContainingTest() {
		String subString = "New York"; // Replace with actual substring value

		when(empRepo.findByEmpLocationContaining(subString)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findByEmpLocationContaining(subString);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(49)
	public void findByEmpLocationContainingTest_empPojoList_isEmpty() {
		String subString = "NonExistentSubString"; // Replace with a nonexistent substring

		when(empRepo.findByEmpLocationContaining(subString)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpLocationContaining(subString);
		});

		String expectedMessage = "No employees found with EmpLocation Containing: " + " subString " + subString;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(50)
	public void findByEmpEmailEndingWithTest() {
		String domain = "example.com"; // Replace with actual domain value

		when(empRepo.findByEmpEmailEndingWith(domain)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findByEmpEmailEndingWith(domain);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(51)
	public void findByEmpEmailEndingWithTest_empPojoList_isEmpty() {
		String domain = "nonexistent.com"; // Replace with a nonexistent domain

		when(empRepo.findByEmpEmailEndingWith(domain)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpEmailEndingWith(domain);
		});

		String expectedMessage = "No employees found with EmpEmail Ending With: " + " domain " + domain;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(52)
	public void findByEmpEmailStartingWithTest() {
		String prefix = "john"; // Replace with actual prefix value

		when(empRepo.findByEmpEmailStartingWith(prefix)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findByEmpEmailStartingWith(prefix);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(53)
	public void findByEmpEmailStartingWithTest_empPojoList_isEmpty() {
		String prefix = "nonexistent"; // Replace with a nonexistent prefix

		when(empRepo.findByEmpEmailStartingWith(prefix)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpEmailStartingWith(prefix);
		});

		String expectedMessage = "No employees found with EmpEmail Starting With: " + " prefix " + prefix;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(54)
	public void findBySalaryGreaterThanOrderByEmpNameAscTest() {
		Double salary = 5000.0; // Replace with actual salary value

		when(empRepo.findBySalaryGreaterThanOrderByEmpNameAsc(salary)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findBySalaryGreaterThanOrderByEmpNameAsc(salary);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(55)
	public void findBySalaryGreaterThanOrderByEmpNameAscTest_empPojoList_isEmpty() {
		Double salary = 10000.0; // Replace with a value that would result in an empty list

		when(empRepo.findBySalaryGreaterThanOrderByEmpNameAsc(salary)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findBySalaryGreaterThanOrderByEmpNameAsc(salary);
		});

		String expectedMessage = "No employees found with Salary Greater than " + salary + " OrderBy EmpNameAsc: ";
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(56)
	public void findBySalaryLessThanOrderByEmpNameAscTest() {
		Double salary = 5000.0; // Replace with actual salary value

		when(empRepo.findBySalaryLessThanOrderByEmpNameAsc(salary)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findBySalaryLessThanOrderByEmpNameAsc(salary);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(57)
	public void findBySalaryLessThanOrderByEmpNameAscTest_empPojoList_isEmpty() {
		Double salary = 10000.0; // Replace with a value that would result in an empty list

		when(empRepo.findBySalaryLessThanOrderByEmpNameAsc(salary)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findBySalaryLessThanOrderByEmpNameAsc(salary);
		});

		String expectedMessage = "No employees found with Salary Less Than " + salary + " OrderBy EmpNameAsc: ";
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(58)
	public void findByEmpLocationOrderBySalaryAscTest() {
		String location = "New York"; // Replace with actual location value

		when(empRepo.findByEmpLocationOrderBySalaryAsc(location)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findByEmpLocationOrderBySalaryAsc(location);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(59)
	public void findByEmpLocationOrderBySalaryAscTest_empPojoList_isEmpty() {
		String location = "NonExistentLocation"; // Replace with a nonexistent location

		when(empRepo.findByEmpLocationOrderBySalaryAsc(location)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpLocationOrderBySalaryAsc(location);
		});

		String expectedMessage = "No employees found with EmpLocation OrderBy SalaryAsc: " + " location " + location;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(60)
	public void findByEmpEmailContainingOrderBySalaryDescTest() {
		String subString = "example.com"; // Replace with actual substring value

		when(empRepo.findByEmpEmailContainingOrderBySalaryDesc(subString)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findByEmpEmailContainingOrderBySalaryDesc(subString);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(61)
	public void findByEmpEmailContainingOrderBySalaryDescTest_empPojoList_isEmpty() {
		String subString = "nonexistent.com"; // Replace with a nonexistent substring

		when(empRepo.findByEmpEmailContainingOrderBySalaryDesc(subString)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpEmailContainingOrderBySalaryDesc(subString);
		});

		String expectedMessage = "No employees found with EmpEmail Containing OrderBy Salary Desc: " + " subString "
				+ subString;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(62)
	public void findByEmpNameIgnoreCaseContainingTest() {
		String subString = "John"; // Replace with actual substring value

		when(empRepo.findByEmpNameIgnoreCaseContaining(subString)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findByEmpNameIgnoreCaseContaining(subString);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(63)
	public void findByEmpNameIgnoreCaseContainingTest_empPojoList_isEmpty() {
		String subString = "nonexistent"; // Replace with a nonexistent substring

		when(empRepo.findByEmpNameIgnoreCaseContaining(subString)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpNameIgnoreCaseContaining(subString);
		});

		String expectedMessage = "No employees found with EmpName Ignoring Case Containing: " + " subString "
				+ subString;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(64)
	public void findByEmpLocationIgnoreCaseContainingTest() {
		String subString = "New York"; // Replace with actual substring value

		when(empRepo.findByEmpLocationIgnoreCaseContaining(subString)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findByEmpLocationIgnoreCaseContaining(subString);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(65)
	public void findByEmpLocationIgnoreCaseContainingTest_empPojoList_isEmpty() {
		String subString = "nonexistent"; // Replace with a nonexistent substring

		when(empRepo.findByEmpLocationIgnoreCaseContaining(subString)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpLocationIgnoreCaseContaining(subString);
		});

		String expectedMessage = "No employees found with EmpLocation Ignoring Case Containing: " + " subString "
				+ subString;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(66)
	public void findBySalaryGreaterThanAndEmpLocationContainingTest() {
		Double salary = 5000.0; // Replace with actual salary value
		String subString = "New York"; // Replace with actual subString value

		when(empRepo.findBySalaryGreaterThanAndEmpLocationContaining(salary, subString))
				.thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findBySalaryGreaterThanAndEmpLocationContaining(salary,
				subString);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(67)
	public void findBySalaryGreaterThanAndEmpLocationContainingTest_empPojoList_isEmpty() {
		Double salary = 10000.0; // Replace with a value that would result in an empty list
		String subString = "NonExistentLocation"; // Replace with a nonexistent subString

		when(empRepo.findBySalaryGreaterThanAndEmpLocationContaining(salary, subString))
				.thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findBySalaryGreaterThanAndEmpLocationContaining(salary, subString);
		});

		String expectedMessage = "No employees found with Salary GreaterThan And EmpLocation Containing: " + " salary "
				+ salary + " subString " + subString;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(68)
	public void findByEmpNameContainingOrEmpEmailContainingTest() {
		String nameSubstring = "John"; // Replace with actual nameSubstring value
		String emailSubstring = "example.com"; // Replace with actual emailSubstring value

		when(empRepo.findByEmpNameContainingOrEmpEmailContaining(nameSubstring, emailSubstring))
				.thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findByEmpNameContainingOrEmpEmailContaining(nameSubstring,
				emailSubstring);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(69)
	public void findByEmpNameContainingOrEmpEmailContainingTest_empPojoList_isEmpty() {
		String nameSubstring = "nonexistent"; // Replace with a nonexistent nameSubstring
		String emailSubstring = "nonexistent.com"; // Replace with a nonexistent emailSubstring

		when(empRepo.findByEmpNameContainingOrEmpEmailContaining(nameSubstring, emailSubstring))
				.thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpNameContainingOrEmpEmailContaining(nameSubstring, emailSubstring);
		});

		String expectedMessage = "No employees found with EmpName Containing Or EmpEmail Containing: "
				+ " nameSubstring " + nameSubstring + " emailSubstring " + emailSubstring;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(70)
	public void findByEmpNameContainingAndSalaryGreaterThanTest() {
		String nameSubstring = "John"; // Replace with actual nameSubstring value
		Double salary = 5000.0; // Replace with actual salary value

		when(empRepo.findByEmpNameContainingAndSalaryGreaterThan(nameSubstring, salary))
				.thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findByEmpNameContainingAndSalaryGreaterThan(nameSubstring,
				salary);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(71)
	public void findByEmpNameContainingAndSalaryGreaterThanTest_empPojoList_isEmpty() {
		String nameSubstring = "nonexistent"; // Replace with a nonexistent nameSubstring
		Double salary = 10000.0; // Replace with a value that would result in an empty list

		when(empRepo.findByEmpNameContainingAndSalaryGreaterThan(nameSubstring, salary))
				.thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpNameContainingAndSalaryGreaterThan(nameSubstring, salary);
		});

		String expectedMessage = "No employees found with EmpName Containing And Salary GreaterThan: "
				+ " nameSubstring " + nameSubstring + " salary " + salary;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(72)
	public void findByEmpNameContainingOrderBySalaryDescTest() {
		String nameSubstring = "John"; // Replace with actual nameSubstring value

		when(empRepo.findByEmpNameContainingOrderBySalaryDesc(nameSubstring)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findByEmpNameContainingOrderBySalaryDesc(nameSubstring);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(73)
	public void findByEmpNameContainingOrderBySalaryDescTest_empPojoList_isEmpty() {
		String nameSubstring = "nonexistent"; // Replace with a nonexistent nameSubstring

		when(empRepo.findByEmpNameContainingOrderBySalaryDesc(nameSubstring)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpNameContainingOrderBySalaryDesc(nameSubstring);
		});

		String expectedMessage = "No employees found with EmpName Containing OrderBy SalaryDesc: " + " nameSubstring "
				+ nameSubstring;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(74)
	public void findByEmpLocationContainingOrderBySalaryAscTest() {
		String locationSubstring = "New York"; // Replace with actual locationSubstring value

		when(empRepo.findByEmpLocationContainingOrderBySalaryAsc(locationSubstring))
				.thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl
				.findByEmpLocationContainingOrderBySalaryAsc(locationSubstring);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(75)
	public void findByEmpLocationContainingOrderBySalaryAscTest_empPojoList_isEmpty() {
		String locationSubstring = "nonexistent"; // Replace with a nonexistent locationSubstring

		when(empRepo.findByEmpLocationContainingOrderBySalaryAsc(locationSubstring))
				.thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpLocationContainingOrderBySalaryAsc(locationSubstring);
		});

		String expectedMessage = "No employees found with EmpLocation Containing OrderBy SalaryAsc: "
				+ " locationSubstring " + locationSubstring;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	@Order(76)
	public void findByEmpLocationAndSalaryLessThanTest() {
		String location = "New York"; // Replace with actual location value
		Double salary = 5000.0; // Replace with actual salary value

		when(empRepo.findByEmpLocationAndSalaryLessThan(location, salary)).thenReturn(UtilityTest.employeeList());

		List<EmployeePojo> expectedList = UtilityTest.empList();
		List<EmployeePojo> actualList = employeeServiceImpl.findByEmpLocationAndSalaryLessThan(location, salary);

		assertEquals(expectedList, actualList);
	}

	@Test
	@Order(77)
	public void findByEmpLocationAndSalaryLessThanTest_empPojoList_isEmpty() {
		String location = "nonexistent"; // Replace with a nonexistent location
		Double salary = 10000.0; // Replace with a value that would result in an empty list

		when(empRepo.findByEmpLocationAndSalaryLessThan(location, salary)).thenReturn(Collections.emptyList());

		Exception exception = assertThrows(EmployeeCommonException.class, () -> {
			employeeServiceImpl.findByEmpLocationAndSalaryLessThan(location, salary);
		});

		String expectedMessage = "No employees found with EmpLocation And Salary LessThan: " + " location " + location
				+ " salary " + salary;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}
}
