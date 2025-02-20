package redoc.controller_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import redoc.controller.EmployeeController;
import redoc.service.EmployeeService;
import redoc.utility.UtilityTest;

@ExtendWith(SpringExtension.class)
 class EmployeeControllerTest {
	@InjectMocks
	EmployeeController employeeController;

	@InjectMocks
	UtilityTest utilityTest;

	@Mock
	EmployeeService service;

	@Test
	@Order(1)
	 void findBySalary_test() {

		// List<EmployeePojo> empList = empService.findEmpListBySalary(salary);
		// .thenReturn() Mockito.when()
		// method call in employeeController

		Mockito.when(service.findEmpListBySalary(utilityTest.getSalary())).thenReturn(utilityTest.empList());

		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findBySalary(utilityTest.getSalary()).getStatusCode());
		// byte expected , byte actual

	};

	@Test
	@Order(2)
	 void findEmpListBySalary_empList_Null_test() {
		Mockito.when(service.findEmpListBySalary(utilityTest.getSalary())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController.findBySalary(utilityTest.getSalary()).getStatusCode());

	};

	@Test
	@Order(3)
	 void saveEmpDetails_test() {

		assertEquals(ResponseEntity.status(HttpStatus.CREATED).body("Employee details saved successfully"),
				employeeController.saveEmpDetails(utilityTest.empPojo()));
	};

	@Test
	@Order(4)
	 void findEmpListByName_test() {
		Mockito.when(service.findEmpListByName(utilityTest.getEmpName())).thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findByEmpName(utilityTest.getEmpName()).getStatusCode());
	}

	@Test
	@Order(5)
	 void findEmpListByName_empList_Null_test() {
		Mockito.when(service.findEmpListByName(utilityTest.getEmpName())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController.findByEmpName(utilityTest.getEmpName()).getStatusCode());

	}

	@Test
	@Order(6)
	 void findEmpListByLocation_test() {
		Mockito.when(service.findEmpListByLocation(utilityTest.getEmpLocation())).thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findByLocation(utilityTest.getEmpLocation()).getStatusCode());
	}

	@Test
	@Order(7)
	 void findEmpListByLocation_empList_Null_test() {
		Mockito.when(service.findEmpListByLocation(utilityTest.getEmpLocation())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController.findByLocation(utilityTest.getEmpLocation()).getStatusCode());

	}

	@Test
	@Order(8)
	 void findEmpListByEmail_test() {
		Mockito.when(service.findEmpListByEmail(utilityTest.getEmpEmail())).thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findByEmpEmail(utilityTest.getEmpEmail()).getStatusCode());
	}

	@Test
	@Order(8)
	 void findEmpListByEmail_empList_Null_test() {
		Mockito.when(service.findEmpListByEmail(utilityTest.getEmpEmail())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController.findByEmpEmail(utilityTest.getEmpEmail()).getStatusCode());
	}

	@Test
	@Order(9)
	 void saveListEmpDetails_test() {
		assertEquals(ResponseEntity.status(HttpStatus.CREATED).body("Employee details list saved successfully"),
				employeeController.saveListEmpDetails(utilityTest.empList()));
	}

	@Test
	@Order(10)
	 void findEmpListSalaryRange_test() {
		Mockito.when(service.findEmpListSalaryRange(utilityTest.getMinValue(), utilityTest.getMaxValue()))
				.thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(), employeeController
				.findEmpFromSalaryRange(utilityTest.getMinValue(), utilityTest.getMaxValue()).getStatusCode());
	}

	@Test
	@Order(11)
	 void findEmpListSalaryRange_empList_Null_test() {
		Mockito.when(service.findEmpListSalaryRange(utilityTest.getMinValue(), utilityTest.getMaxValue()))
				.thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(), employeeController
				.findEmpFromSalaryRange(utilityTest.getMinValue(), utilityTest.getMaxValue()).getStatusCode());
	}

	@Test
	@Order(12)
	 void findByEmpSalaryLessThan_test() {
		Mockito.when(service.findByEmpSalaryLessThan(utilityTest.getSalary())).thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findByEmpSalaryLessThan(utilityTest.getSalary()).getStatusCode());

	}

	@Test
	@Order(13)
	 void findByEmpSalaryLessThan_empList_Null_test() {
		Mockito.when(service.findByEmpSalaryLessThan(utilityTest.getSalary())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController.findByEmpSalaryLessThan(utilityTest.getSalary()).getStatusCode());

	}

	@Test
	@Order(14)
	 void findByEmpSalaryGreaterThan_test() {
		Mockito.when(service.findByEmpSalaryGreaterThan(utilityTest.getSalary())).thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findByEmpSalaryGreaterThan(utilityTest.getSalary()).getStatusCode());
	}

	@Test
	@Order(15)
	 void findByEmpSalaryGreaterThan_empList_Null_test() {
		Mockito.when(service.findByEmpSalaryGreaterThan(utilityTest.getSalary())).thenReturn(null);
		assertEquals(utilityTest.getNResponse(),
				employeeController.findByEmpSalaryGreaterThan(utilityTest.getSalary()));
	}

	@Test
	@Order(16)
	 void findEmpByNameAndLocation_test() {
		Mockito.when(service.findEmpByNameAndLocation(utilityTest.getEmpName(), utilityTest.getEmpLocation()))
				.thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(), employeeController
				.findEmpByNameAndLocation(utilityTest.getEmpName(), utilityTest.getEmpLocation()).getStatusCode());
	}

	@Test
	@Order(17)
	 void findEmpByNameAndLocation_empList_Null_test() {
		Mockito.when(service.findEmpByNameAndLocation(utilityTest.getEmpName(), utilityTest.getEmpLocation()))
				.thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(), employeeController
				.findEmpByNameAndLocation(utilityTest.getEmpName(), utilityTest.getEmpLocation()).getStatusCode());
	}

	@Test
	@Order(18)
	 void findByEmpNameAndSalaryGreaterThan_test() {
		Mockito.when(service.findByEmpNameAndSalaryGreaterThan(utilityTest.getEmpName(), utilityTest.getSalary()))
				.thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(), employeeController
				.findByEmpNameAndSalaryGreaterThan(utilityTest.getEmpName(), utilityTest.getSalary()).getStatusCode());

	}

	@Test
	@Order(19)
	 void findByEmpNameAndSalaryGreaterThan_empList_Null_test() {
		Mockito.when(service.findByEmpNameAndSalaryGreaterThan(utilityTest.getEmpName(), utilityTest.getSalary()))
				.thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(), employeeController
				.findByEmpNameAndSalaryGreaterThan(utilityTest.getEmpName(), utilityTest.getSalary()).getStatusCode());

	}

	@Test
	@Order(20)
	 void findByEmpLocationContainingOrSalaryLessThan_test() {
		Mockito.when(service.findByEmpLocationContainingOrSalaryLessThan(utilityTest.getLocationSubstring(),
				utilityTest.getSalary())).thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findByEmpLocationContainingOrSalaryLessThan(utilityTest.getLocationSubstring(),
						utilityTest.getSalary()).getStatusCode());
	}

	@Test
	@Order(21)
	 void findByEmpLocationContainingOrSalaryLessThan_empList_Null_test() {
		Mockito.when(service.findByEmpLocationContainingOrSalaryLessThan(utilityTest.getLocationSubstring(),
				utilityTest.getSalary())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController.findByEmpLocationContainingOrSalaryLessThan(utilityTest.getLocationSubstring(),
						utilityTest.getSalary()).getStatusCode());
	}

	@Test
	@Order(22)
	 void findByEmpNameAndEmpLocationAndSalaryBetween_test() {
		Mockito.when(service.findByEmpNameAndEmpLocationAndSalaryBetween(utilityTest.getEmpName(),
				utilityTest.getEmpLocation(), utilityTest.getMinValue(), utilityTest.getMaxValue()))
				.thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController
						.findByEmpNameAndEmpLocationAndSalaryBetween(utilityTest.getEmpName(),
								utilityTest.getEmpLocation(), utilityTest.getMinValue(), utilityTest.getMaxValue())
						.getStatusCode());
	}

	@Test
	@Order(23)
	 void findByEmpNameAndEmpLocationAndSalaryBetween_empList_Null_test() {
		Mockito.when(service.findByEmpNameAndEmpLocationAndSalaryBetween(utilityTest.getEmpName(),
				utilityTest.getEmpLocation(), utilityTest.getMinValue(), utilityTest.getMaxValue())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController
						.findByEmpNameAndEmpLocationAndSalaryBetween(utilityTest.getEmpName(),
								utilityTest.getEmpLocation(), utilityTest.getMinValue(), utilityTest.getMaxValue())
						.getStatusCode());
	}

	@Test
	@Order(24)
	 void findByEmpNameOrEmpLocation_test() {
		Mockito.when(service.findByEmpNameOrEmpLocation(utilityTest.getEmpName(), utilityTest.getEmpLocation()))
				.thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(), employeeController
				.findByEmpNameOrEmpLocation(utilityTest.getEmpName(), utilityTest.getEmpLocation()).getStatusCode());
	}

	@Test
	@Order(25)
	 void findByEmpNameOrEmpLocation_empList_Null_test() {
		Mockito.when(service.findByEmpNameOrEmpLocation(utilityTest.getEmpName(), utilityTest.getEmpLocation()))
				.thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(), employeeController
				.findByEmpNameOrEmpLocation(utilityTest.getEmpName(), utilityTest.getEmpLocation()).getStatusCode());
	}

	@Test
	@Order(26)
	 void findByEmpNameIgnoreCase_test() {
		Mockito.when(service.findByEmpNameIgnoreCase(utilityTest.getEmpName())).thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findByEmpNameIgnoreCase(utilityTest.getEmpName()).getStatusCode());
	}

	@Test
	@Order(27)
	 void findByEmpNameIgnoreCase_empList_Null_test() {
		Mockito.when(service.findByEmpNameIgnoreCase(utilityTest.getEmpName())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController.findByEmpNameIgnoreCase(utilityTest.getEmpName()).getStatusCode());
	}

	@Test
	@Order(28)
	 void findByEmpLocationIgnoreCase_test() {
		Mockito.when(service.findByEmpLocationIgnoreCase(utilityTest.getEmpLocation()))
				.thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findByEmpLocationIgnoreCase(utilityTest.getEmpLocation()).getStatusCode());

	}

	@Test
	@Order(29)
	 void findByEmpLocationIgnoreCase_empList_Null_test() {
		Mockito.when(service.findByEmpLocationIgnoreCase(utilityTest.getEmpLocation())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController.findByEmpLocationIgnoreCase(utilityTest.getEmpLocation()).getStatusCode());

	}

	@Test
	@Order(30)
	 void findByEmpEmailContaining_test() {
		Mockito.when(service.findByEmpEmailContaining(utilityTest.getEmailsubstring()))
				.thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findByEmpEmailContaining(utilityTest.getEmailsubstring()).getStatusCode());
	}

	@Test
	@Order(31)
	 void findByEmpEmailContaining_empList_Null_test() {
		Mockito.when(service.findByEmpEmailContaining(utilityTest.getEmailsubstring())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController.findByEmpEmailContaining(utilityTest.getEmailsubstring()).getStatusCode());
	}

	@Test
	@Order(32)
	 void findByEmpNameOrderBySalaryAsc_test() {
		Mockito.when(service.findByEmpNameOrderBySalaryAsc(utilityTest.getEmpName())).thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findByEmpNameOrderBySalaryAsc(utilityTest.getEmpName()).getStatusCode());
	}

	@Test
	@Order(33)
	 void findByEmpNameOrderBySalaryAsc_empList_Null_test() {
		Mockito.when(service.findByEmpNameOrderBySalaryAsc(utilityTest.getEmpName())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController.findByEmpNameOrderBySalaryAsc(utilityTest.getEmpName()).getStatusCode());
	}

	@Test
	@Order(34)
	 void findByEmpNameOrderBySalaryDesc_test() {

		Mockito.when(service.findByEmpNameOrderBySalaryDesc(utilityTest.getEmpName()))
				.thenReturn(utilityTest.empList());

		utilityTest.getResponse().getStatusCode();
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findByEmpNameOrderBySalaryDesc(utilityTest.getEmpName()).getStatusCode());
	}

	@Test
	@Order(35)
	 void findByEmpNameOrderBySalaryDesc_empList_Null_test() {

		Mockito.when(service.findByEmpNameOrderBySalaryDesc(utilityTest.getEmpName())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController.findByEmpNameOrderBySalaryDesc(utilityTest.getEmpName()).getStatusCode());
	}

	@Test
	@Order(36)
	 void findByEmpLocationOrderByEmpNameAsc_test() {
		Mockito.when(service.findByEmpLocationOrderByEmpNameAsc(utilityTest.getEmpLocation()))
				.thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findByEmpLocationOrderByEmpNameAsc(utilityTest.getEmpLocation()).getStatusCode());
	}

	@Test
	@Order(37)
	 void findByEmpLocationOrderByEmpNameAsc_empList_Null_test() {
		Mockito.when(service.findByEmpLocationOrderByEmpNameAsc(utilityTest.getEmpLocation())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController.findByEmpLocationOrderByEmpNameAsc(utilityTest.getEmpLocation()).getStatusCode());
	}

	@Test
	@Order(38)
	 void findByEmpLocationOrderByEmpNameDesc_test() {
		Mockito.when(service.findByEmpLocationOrderByEmpNameDesc(utilityTest.getEmpLocation()))
				.thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findByEmpLocationOrderByEmpNameDesc(utilityTest.getEmpLocation()).getStatusCode());
	}

	@Test
	@Order(39)
	 void findByEmpLocationOrderByEmpNameDesc_empList_Null_test() {
		Mockito.when(service.findByEmpLocationOrderByEmpNameDesc(utilityTest.getEmpLocation())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController.findByEmpLocationOrderByEmpNameDesc(utilityTest.getEmpLocation()).getStatusCode());
	}

	@Test
	@Order(40)
	 void findBySalaryGreaterThanEqual_test() {
		Mockito.when(service.findBySalaryGreaterThanEqual(utilityTest.getSalary())).thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findBySalaryGreaterThanEqual(utilityTest.getSalary()).getStatusCode());
	}

	@Test
	@Order(41)
	 void findBySalaryGreaterThanEqual_empList_Null_test() {
		Mockito.when(service.findBySalaryGreaterThanEqual(utilityTest.getSalary())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController.findBySalaryGreaterThanEqual(utilityTest.getSalary()).getStatusCode());
	}

	@Test
	@Order(42)
	 void findBySalaryLessThanEqual_test() {
		Mockito.when(service.findBySalaryLessThanEqual(utilityTest.getSalary())).thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findBySalaryLessThanEqual(utilityTest.getSalary()).getStatusCode());

	}

	@Test
	@Order(43)
	 void findBySalaryLessThanEqual_empList_Null_test() {
		Mockito.when(service.findBySalaryLessThanEqual(utilityTest.getSalary())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController.findBySalaryLessThanEqual(utilityTest.getSalary()).getStatusCode());

	}

	@Test
	@Order(44)
	 void findBySalaryNot_test() {
		Mockito.when(service.findBySalaryNot(utilityTest.getSalary())).thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findBySalaryNot(utilityTest.getSalary()).getStatusCode());
	}

	@Test
	@Order(45)
	 void findBySalaryNot_empList_Null_test() {
		Mockito.when(service.findBySalaryNot(utilityTest.getSalary())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController.findBySalaryNot(utilityTest.getSalary()).getStatusCode());
	}

	@Test
	@Order(46)
	 void findByEmpNameContaining_test() {
		Mockito.when(service.findByEmpNameContaining(utilityTest.getEmpName())).thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findByEmpNameContaining(utilityTest.getEmpName()).getStatusCode());

	}

	@Test
	@Order(47)
	 void findByEmpNameContaining_empList_Null_test() {
		Mockito.when(service.findByEmpNameContaining(utilityTest.getEmpName())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController.findByEmpNameContaining(utilityTest.getEmpName()).getStatusCode());

	}

	@Test
	@Order(48)
	 void findByEmpLocationContaining_test() {
		Mockito.when(service.findByEmpLocationContaining(utilityTest.getEmpLocation()))
				.thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findByEmpLocationContaining(utilityTest.getEmpLocation()).getStatusCode());

	}

	@Test
	@Order(49)
	 void findByEmpLocationContaining_empList_Null_test() {
		Mockito.when(service.findByEmpLocationContaining(utilityTest.getEmpLocation())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController.findByEmpLocationContaining(utilityTest.getEmpLocation()).getStatusCode());

	}

	@Test
	@Order(50)
	 void findByEmpEmailEndingWith_test() {
		Mockito.when(service.findByEmpEmailEndingWith(utilityTest.getDomain())).thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findByEmpEmailEndingWith(utilityTest.getDomain()).getStatusCode());

	}

	@Test
	@Order(51)
	 void findByEmpEmailEndingWith_empList_Null_test() {
		Mockito.when(service.findByEmpEmailEndingWith(utilityTest.getDomain())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController.findByEmpEmailEndingWith(utilityTest.getDomain()).getStatusCode());

	}

	@Test
	@Order(52)
	 void findByEmpEmailStartingWith_test() {

		Mockito.when(service.findByEmpEmailStartingWith(utilityTest.getPrefix())).thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findByEmpEmailStartingWith(utilityTest.getPrefix()).getStatusCode());

	}

	@Test
	@Order(53)
	 void findByEmpEmailStartingWith_empList_Null_test() {

		Mockito.when(service.findByEmpEmailStartingWith(utilityTest.getPrefix())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController.findByEmpEmailStartingWith(utilityTest.getPrefix()).getStatusCode());

	}

	@Test
	@Order(54)
	 void findBySalaryGreaterThanOrderByEmpNameAsc_test() {

		Mockito.when(service.findBySalaryGreaterThanOrderByEmpNameAsc(utilityTest.getSalary()))
				.thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findBySalaryGreaterThanOrderByEmpNameAsc(utilityTest.getSalary()).getStatusCode());

	}

	@Test
	@Order(55)
	 void findBySalaryGreaterThanOrderByEmpNameAsc_empList_Null_test() {

		Mockito.when(service.findBySalaryGreaterThanOrderByEmpNameAsc(utilityTest.getSalary())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController.findBySalaryGreaterThanOrderByEmpNameAsc(utilityTest.getSalary()).getStatusCode());

	}

	@Test
	@Order(56)
	 void findBySalaryLessThanOrderByEmpNameAsc_test() {

		Mockito.when(service.findBySalaryLessThanOrderByEmpNameAsc(utilityTest.getSalary()))
				.thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findBySalaryLessThanOrderByEmpNameAsc(utilityTest.getSalary()).getStatusCode());

	}

	@Test
	@Order(57)
	 void findBySalaryLessThanOrderByEmpNameAsc_empList_Null_test() {

		Mockito.when(service.findBySalaryLessThanOrderByEmpNameAsc(utilityTest.getSalary())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController.findBySalaryLessThanOrderByEmpNameAsc(utilityTest.getSalary()).getStatusCode());

	}

	@Test
	@Order(58)
	 void findByEmpLocationOrderBySalaryAsc_test() {

		Mockito.when(service.findByEmpLocationOrderBySalaryAsc(utilityTest.getEmpLocation()))
				.thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findByEmpLocationOrderBySalaryAsc(utilityTest.getEmpLocation()).getStatusCode());

	}

	@Test
	@Order(59)
	 void findByEmpLocationOrderBySalaryAsc_empList_Null_test() {

		Mockito.when(service.findByEmpLocationOrderBySalaryAsc(utilityTest.getEmpLocation())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController.findByEmpLocationOrderBySalaryAsc(utilityTest.getEmpLocation()).getStatusCode());

	}

	@Test
	@Order(60)
	 void findByEmpEmailContainingOrderBySalaryDesc_test() {

		Mockito.when(service.findByEmpEmailContainingOrderBySalaryDesc(utilityTest.getEmailsubstring()))
				.thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(), employeeController
				.findByEmpEmailContainingOrderBySalaryDesc(utilityTest.getEmailsubstring()).getStatusCode());

	}

	@Test
	@Order(61)
	 void findByEmpEmailContainingOrderBySalaryDesc_empList_Null_test() {

		Mockito.when(service.findByEmpEmailContainingOrderBySalaryDesc(utilityTest.getEmailsubstring()))
				.thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(), employeeController
				.findByEmpEmailContainingOrderBySalaryDesc(utilityTest.getEmailsubstring()).getStatusCode());

	}

	@Test
	@Order(62)
	 void findByEmpNameIgnoreCaseContaining_test() {

		Mockito.when(service.findByEmpNameIgnoreCaseContaining(utilityTest.getNameSubstring()))
				.thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findByEmpNameIgnoreCaseContaining(utilityTest.getNameSubstring()).getStatusCode());

	}

	@Test
	@Order(63)
	 void findByEmpNameIgnoreCaseContaining_empList_Null_test() {

		Mockito.when(service.findByEmpNameIgnoreCaseContaining(utilityTest.getNameSubstring())).thenReturn(null);
		assertEquals(utilityTest.getNResponse(),
				employeeController.findByEmpNameIgnoreCaseContaining(utilityTest.getNameSubstring()));

	}

	@Test
	@Order(64)
	 void findByEmpLocationIgnoreCaseContaining_test() {

		Mockito.when(service.findByEmpLocationIgnoreCaseContaining(utilityTest.getLocationSubstring()))
				.thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(), employeeController
				.findByEmpLocationIgnoreCaseContaining(utilityTest.getLocationSubstring()).getStatusCode());

	}

	@Test
	@Order(65)
	 void findByEmpLocationIgnoreCaseContaining_empList_Null_test() {

		Mockito.when(service.findByEmpLocationIgnoreCaseContaining(utilityTest.getLocationSubstring()))
				.thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(), employeeController
				.findByEmpLocationIgnoreCaseContaining(utilityTest.getLocationSubstring()).getStatusCode());

	}

	@Test
	@Order(66)
	 void findBySalaryGreaterThanAndEmpLocationContaining_test() {

		Mockito.when(service.findBySalaryGreaterThanAndEmpLocationContaining(utilityTest.getSalary(),
				utilityTest.getLocationSubstring())).thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findBySalaryGreaterThanAndEmpLocationContaining(utilityTest.getSalary(),
						utilityTest.getLocationSubstring()).getStatusCode());

	}

	@Test
	@Order(67)
	 void findBySalaryGreaterThanAndEmpLocationContaining_empList_Null_test() {

		Mockito.when(service.findBySalaryGreaterThanAndEmpLocationContaining(utilityTest.getSalary(),
				utilityTest.getLocationSubstring())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController.findBySalaryGreaterThanAndEmpLocationContaining(utilityTest.getSalary(),
						utilityTest.getLocationSubstring()).getStatusCode());

	}

	@Test
	@Order(68)
	 void findByEmpNameContainingOrEmpEmailContaining_test() {

		Mockito.when(service.findByEmpNameContainingOrEmpEmailContaining(utilityTest.getNameSubstring(),
				utilityTest.getEmailsubstring())).thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController.findByEmpNameContainingOrEmpEmailContaining(utilityTest.getNameSubstring(),
						utilityTest.getEmailsubstring()).getStatusCode());

	}

	@Test
	@Order(69)
	 void findByEmpNameContainingOrEmpEmailContaining_empList_Null_test() {

		Mockito.when(service.findByEmpNameContainingOrEmpEmailContaining(utilityTest.getNameSubstring(),
				utilityTest.getEmailsubstring())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController.findByEmpNameContainingOrEmpEmailContaining(utilityTest.getNameSubstring(),
						utilityTest.getEmailsubstring()).getStatusCode());

	}

	@Test
	@Order(70)
	 void findByEmpNameContainingAndSalaryGreaterThan_test() {

		Mockito.when(service.findByEmpNameContainingAndSalaryGreaterThan(utilityTest.getNameSubstring(),
				utilityTest.getSalary())).thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(), employeeController
				.findByEmpNameContainingAndSalaryGreaterThan(utilityTest.getNameSubstring(), utilityTest.getSalary())
				.getStatusCode());

	}

	@Test
	@Order(71)
	 void findByEmpNameContainingAndSalaryGreaterThan_empList_Null_test() {

		Mockito.when(service.findByEmpNameContainingAndSalaryGreaterThan(utilityTest.getNameSubstring(),
				utilityTest.getSalary())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(), employeeController
				.findByEmpNameContainingAndSalaryGreaterThan(utilityTest.getNameSubstring(), utilityTest.getSalary())
				.getStatusCode());

	}

	@Test
	@Order(72)
	 void findByEmpNameContainingOrderBySalaryDesc_test() {

		Mockito.when(service.findByEmpNameContainingOrderBySalaryDesc(utilityTest.getNameSubstring()))
				.thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(), employeeController
				.findByEmpNameContainingOrderBySalaryDesc(utilityTest.getNameSubstring()).getStatusCode());

	}

	@Test
	@Order(73)
	 void findByEmpNameContainingOrderBySalaryDesc_empList_Null_test() {

		Mockito.when(service.findByEmpNameContainingOrderBySalaryDesc(utilityTest.getNameSubstring())).thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(), employeeController
				.findByEmpNameContainingOrderBySalaryDesc(utilityTest.getNameSubstring()).getStatusCode());

	}

	@Test
	@Order(74)
	 void findByEmpLocationContainingOrderBySalaryAsc_test() {

		Mockito.when(service.findByEmpLocationContainingOrderBySalaryAsc(utilityTest.getLocationSubstring()))
				.thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(), employeeController
				.findByEmpLocationContainingOrderBySalaryAsc(utilityTest.getLocationSubstring()).getStatusCode());

	}

	@Test
	@Order(75)
	 void findByEmpLocationContainingOrderBySalaryAsc_empList_Null_test() {

		Mockito.when(service.findByEmpLocationContainingOrderBySalaryAsc(utilityTest.getLocationSubstring()))
				.thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(), employeeController
				.findByEmpLocationContainingOrderBySalaryAsc(utilityTest.getLocationSubstring()).getStatusCode());

	}

	@Test
	@Order(76)
	 void findByEmpLocationAndSalaryLessThan_test() {

		Mockito.when(service.findByEmpLocationAndSalaryLessThan(utilityTest.getEmpLocation(), utilityTest.getSalary()))
				.thenReturn(utilityTest.empList());
		assertEquals(utilityTest.getResponse().getStatusCode(),
				employeeController
						.findByEmpLocationAndSalaryLessThan(utilityTest.getEmpLocation(), utilityTest.getSalary())
						.getStatusCode());

	}

	@Test
	@Order(77)
	 void findByEmpLocationAndSalaryLessThan_empList_Null_test() {

		Mockito.when(service.findByEmpLocationAndSalaryLessThan(utilityTest.getEmpLocation(), utilityTest.getSalary()))
				.thenReturn(null);
		assertEquals(utilityTest.getNResponse().getStatusCode(),
				employeeController
						.findByEmpLocationAndSalaryLessThan(utilityTest.getEmpLocation(), utilityTest.getSalary())
						.getStatusCode());

	}

}