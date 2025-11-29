//package redoc.controller_test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import redoc.controller.EmployeeController;
//import redoc.service.EmployeeService;
//import redoc.utility_test.Utility;
//
//
//@ExtendWith(SpringExtension.class)
// class EmployeeControllerTest {
//	@InjectMocks
//	EmployeeController employeeController;
//
//	@InjectMocks
//	Utility utility;
//
//	@Mock
//	EmployeeService service;
//
//	@Test
//	@Order(1)
//	 void findBySalary_test() {
//
//		// List<EmployeePojo> empList = empService.findEmpListBySalary(salary);
//		// .thenReturn() Mockito.when()
//		// method call in employeeController
//
//		Mockito.when(service.findEmpListBySalary(utility.getSalary())).thenReturn(utility.empList());
//
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findBySalary(utility.getSalary()).getStatusCode());
//		// byte expected , byte actual
//
//	}
//
//	@Test
//	@Order(2)
//	 void findEmpListBySalary_empList_Null_test() {
//		Mockito.when(service.findEmpListBySalary(utility.getSalary())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findBySalary(utility.getSalary()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(3)
//	 void saveEmpDetails_test() {
//
//		assertEquals(ResponseEntity.status(HttpStatus.CREATED).body("Employee details saved successfully"),
//				employeeController.saveEmpDetails(utility.empPojo()));
//	}
//
//	@Test
//	@Order(4)
//	 void findEmpListByName_test() {
//		Mockito.when(service.findEmpListByName(utility.getEmpName())).thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findByEmpName(utility.getEmpName()).getStatusCode());
//	}
//
//	@Test
//	@Order(5)
//	 void findEmpListByName_empList_Null_test() {
//		Mockito.when(service.findEmpListByName(utility.getEmpName())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findByEmpName(utility.getEmpName()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(6)
//	 void findEmpListByLocation_test() {
//		Mockito.when(service.findEmpListByLocation(utility.getEmpLocation())).thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findByLocation(utility.getEmpLocation()).getStatusCode());
//	}
//
//	@Test
//	@Order(7)
//	 void findEmpListByLocation_empList_Null_test() {
//		Mockito.when(service.findEmpListByLocation(utility.getEmpLocation())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findByLocation(utility.getEmpLocation()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(8)
//	 void findEmpListByEmail_test() {
//		Mockito.when(service.findEmpListByEmail(utility.getEmpEmail())).thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findByEmpEmail(utility.getEmpEmail()).getStatusCode());
//	}
//
//	@Test
//	@Order(8)
//	 void findEmpListByEmail_empList_Null_test() {
//		Mockito.when(service.findEmpListByEmail(utility.getEmpEmail())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findByEmpEmail(utility.getEmpEmail()).getStatusCode());
//	}
//
//	@Test
//	@Order(9)
//	 void saveListEmpDetails_test() {
//		assertEquals(ResponseEntity.status(HttpStatus.CREATED).body("Employee details list saved successfully"),
//				employeeController.saveListEmpDetails(utility.empList()));
//	}
//
//	@Test
//	@Order(10)
//	 void findEmpListSalaryRange_test() {
//		Mockito.when(service.findEmpListSalaryRange(utility.getMinValue(), utility.getMaxValue()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(), employeeController
//				.findEmpFromSalaryRange(utility.getMinValue(), utility.getMaxValue()).getStatusCode());
//	}
//
//	@Test
//	@Order(11)
//	 void findEmpListSalaryRange_empList_Null_test() {
//		Mockito.when(service.findEmpListSalaryRange(utility.getMinValue(), utility.getMaxValue()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(), employeeController
//				.findEmpFromSalaryRange(utility.getMinValue(), utility.getMaxValue()).getStatusCode());
//	}
//
//	@Test
//	@Order(12)
//	 void findByEmpSalaryLessThan_test() {
//		Mockito.when(service.findByEmpSalaryLessThan(utility.getSalary())).thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findByEmpSalaryLessThan(utility.getSalary()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(13)
//	 void findByEmpSalaryLessThan_empList_Null_test() {
//		Mockito.when(service.findByEmpSalaryLessThan(utility.getSalary())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findByEmpSalaryLessThan(utility.getSalary()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(14)
//	 void findByEmpSalaryGreaterThan_test() {
//		Mockito.when(service.findByEmpSalaryGreaterThan(utility.getSalary())).thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findByEmpSalaryGreaterThan(utility.getSalary()).getStatusCode());
//	}
//
//	@Test
//	@Order(15)
//	 void findByEmpSalaryGreaterThan_empList_Null_test() {
//		Mockito.when(service.findByEmpSalaryGreaterThan(utility.getSalary())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findByEmpSalaryGreaterThan(utility.getSalary()).getStatusCode());
//	}
//
//	@Test
//	@Order(16)
//	 void findEmpByNameAndLocation_test() {
//		Mockito.when(service.findEmpByNameAndLocation(utility.getEmpName(), utility.getEmpLocation()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(), employeeController
//				.findEmpByNameAndLocation(utility.getEmpName(), utility.getEmpLocation()).getStatusCode());
//	}
//
//	@Test
//	@Order(17)
//	 void findEmpByNameAndLocation_empList_Null_test() {
//		Mockito.when(service.findEmpByNameAndLocation(utility.getEmpName(), utility.getEmpLocation()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(), employeeController
//				.findEmpByNameAndLocation(utility.getEmpName(), utility.getEmpLocation()).getStatusCode());
//	}
//
//	@Test
//	@Order(18)
//	 void findByEmpNameAndSalaryGreaterThan_test() {
//		Mockito.when(service.findByEmpNameAndSalaryGreaterThan(utility.getEmpName(), utility.getSalary()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(), employeeController
//				.findByEmpNameAndSalaryGreaterThan(utility.getEmpName(), utility.getSalary()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(19)
//	 void findByEmpNameAndSalaryGreaterThan_empList_Null_test() {
//		Mockito.when(service.findByEmpNameAndSalaryGreaterThan(utility.getEmpName(), utility.getSalary()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(), employeeController
//				.findByEmpNameAndSalaryGreaterThan(utility.getEmpName(), utility.getSalary()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(20)
//	 void findByEmpLocationContainingOrSalaryLessThan_test() {
//		Mockito.when(service.findByEmpLocationContainingOrSalaryLessThan(utility.getLocationSubstring(),
//				utility.getSalary())).thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findByEmpLocationContainingOrSalaryLessThan(utility.getLocationSubstring(),
//						utility.getSalary()).getStatusCode());
//	}
//
//	@Test
//	@Order(21)
//	 void findByEmpLocationContainingOrSalaryLessThan_empList_Null_test() {
//		Mockito.when(service.findByEmpLocationContainingOrSalaryLessThan(utility.getLocationSubstring(),
//				utility.getSalary())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findByEmpLocationContainingOrSalaryLessThan(utility.getLocationSubstring(),
//						utility.getSalary()).getStatusCode());
//	}
//
//	@Test
//	@Order(22)
//	 void findByEmpNameAndEmpLocationAndSalaryBetween_test() {
//		Mockito.when(service.findByEmpNameAndEmpLocationAndSalaryBetween(utility.getEmpName(),
//				utility.getEmpLocation(), utility.getMinValue(), utility.getMaxValue()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController
//						.findByEmpNameAndEmpLocationAndSalaryBetween(utility.getEmpName(),
//								utility.getEmpLocation(), utility.getMinValue(), utility.getMaxValue())
//						.getStatusCode());
//	}
//
//	@Test
//	@Order(23)
//	 void findByEmpNameAndEmpLocationAndSalaryBetween_empList_Null_test() {
//		Mockito.when(service.findByEmpNameAndEmpLocationAndSalaryBetween(utility.getEmpName(),
//				utility.getEmpLocation(), utility.getMinValue(), utility.getMaxValue())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController
//						.findByEmpNameAndEmpLocationAndSalaryBetween(utility.getEmpName(),
//								utility.getEmpLocation(), utility.getMinValue(), utility.getMaxValue())
//						.getStatusCode());
//	}
//
//	@Test
//	@Order(24)
//	 void findByEmpNameOrEmpLocation_test() {
//		Mockito.when(service.findByEmpNameOrEmpLocation(utility.getEmpName(), utility.getEmpLocation()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(), employeeController
//				.findByEmpNameOrEmpLocation(utility.getEmpName(), utility.getEmpLocation()).getStatusCode());
//	}
//
//	@Test
//	@Order(25)
//	 void findByEmpNameOrEmpLocation_empList_Null_test() {
//		Mockito.when(service.findByEmpNameOrEmpLocation(utility.getEmpName(), utility.getEmpLocation()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(), employeeController
//				.findByEmpNameOrEmpLocation(utility.getEmpName(), utility.getEmpLocation()).getStatusCode());
//	}
//
//	@Test
//	@Order(26)
//	 void findByEmpNameIgnoreCase_test() {
//		Mockito.when(service.findByEmpNameIgnoreCase(utility.getEmpName())).thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findByEmpNameIgnoreCase(utility.getEmpName()).getStatusCode());
//	}
//
//	@Test
//	@Order(27)
//	 void findByEmpNameIgnoreCase_empList_Null_test() {
//		Mockito.when(service.findByEmpNameIgnoreCase(utility.getEmpName())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findByEmpNameIgnoreCase(utility.getEmpName()).getStatusCode());
//	}
//
//	@Test
//	@Order(28)
//	 void findByEmpLocationIgnoreCase_test() {
//		Mockito.when(service.findByEmpLocationIgnoreCase(utility.getEmpLocation()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findByEmpLocationIgnoreCase(utility.getEmpLocation()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(29)
//	 void findByEmpLocationIgnoreCase_empList_Null_test() {
//		Mockito.when(service.findByEmpLocationIgnoreCase(utility.getEmpLocation())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findByEmpLocationIgnoreCase(utility.getEmpLocation()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(30)
//	 void findByEmpEmailContaining_test() {
//		Mockito.when(service.findByEmpEmailContaining(utility.getEmailsubstring()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findByEmpEmailContaining(utility.getEmailsubstring()).getStatusCode());
//	}
//
//	@Test
//	@Order(31)
//	 void findByEmpEmailContaining_empList_Null_test() {
//		Mockito.when(service.findByEmpEmailContaining(utility.getEmailsubstring())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findByEmpEmailContaining(utility.getEmailsubstring()).getStatusCode());
//	}
//
//	@Test
//	@Order(32)
//	 void findByEmpNameOrderBySalaryAsc_test() {
//		Mockito.when(service.findByEmpNameOrderBySalaryAsc(utility.getEmpName())).thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findByEmpNameOrderBySalaryAsc(utility.getEmpName()).getStatusCode());
//	}
//
//	@Test
//	@Order(33)
//	 void findByEmpNameOrderBySalaryAsc_empList_Null_test() {
//		Mockito.when(service.findByEmpNameOrderBySalaryAsc(utility.getEmpName())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findByEmpNameOrderBySalaryAsc(utility.getEmpName()).getStatusCode());
//	}
//
//	@Test
//	@Order(34)
//	 void findByEmpNameOrderBySalaryDesc_test() {
//
//		Mockito.when(service.findByEmpNameOrderBySalaryDesc(utility.getEmpName()))
//				.thenReturn(utility.empList());
//
//		utility.getResponse().getStatusCode();
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findByEmpNameOrderBySalaryDesc(utility.getEmpName()).getStatusCode());
//	}
//
//	@Test
//	@Order(35)
//	 void findByEmpNameOrderBySalaryDesc_empList_Null_test() {
//
//		Mockito.when(service.findByEmpNameOrderBySalaryDesc(utility.getEmpName())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findByEmpNameOrderBySalaryDesc(utility.getEmpName()).getStatusCode());
//	}
//
//	@Test
//	@Order(36)
//	 void findByEmpLocationOrderByEmpNameAsc_test() {
//		Mockito.when(service.findByEmpLocationOrderByEmpNameAsc(utility.getEmpLocation()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findByEmpLocationOrderByEmpNameAsc(utility.getEmpLocation()).getStatusCode());
//	}
//
//	@Test
//	@Order(37)
//	 void findByEmpLocationOrderByEmpNameAsc_empList_Null_test() {
//		Mockito.when(service.findByEmpLocationOrderByEmpNameAsc(utility.getEmpLocation())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findByEmpLocationOrderByEmpNameAsc(utility.getEmpLocation()).getStatusCode());
//	}
//
//	@Test
//	@Order(38)
//	 void findByEmpLocationOrderByEmpNameDesc_test() {
//		Mockito.when(service.findByEmpLocationOrderByEmpNameDesc(utility.getEmpLocation()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findByEmpLocationOrderByEmpNameDesc(utility.getEmpLocation()).getStatusCode());
//	}
//
//	@Test
//	@Order(39)
//	 void findByEmpLocationOrderByEmpNameDesc_empList_Null_test() {
//		Mockito.when(service.findByEmpLocationOrderByEmpNameDesc(utility.getEmpLocation())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findByEmpLocationOrderByEmpNameDesc(utility.getEmpLocation()).getStatusCode());
//	}
//
//	@Test
//	@Order(40)
//	 void findBySalaryGreaterThanEqual_test() {
//		Mockito.when(service.findBySalaryGreaterThanEqual(utility.getSalary())).thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findBySalaryGreaterThanEqual(utility.getSalary()).getStatusCode());
//	}
//
//	@Test
//	@Order(41)
//	 void findBySalaryGreaterThanEqual_empList_Null_test() {
//		Mockito.when(service.findBySalaryGreaterThanEqual(utility.getSalary())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findBySalaryGreaterThanEqual(utility.getSalary()).getStatusCode());
//	}
//
//	@Test
//	@Order(42)
//	 void findBySalaryLessThanEqual_test() {
//		Mockito.when(service.findBySalaryLessThanEqual(utility.getSalary())).thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findBySalaryLessThanEqual(utility.getSalary()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(43)
//	 void findBySalaryLessThanEqual_empList_Null_test() {
//		Mockito.when(service.findBySalaryLessThanEqual(utility.getSalary())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findBySalaryLessThanEqual(utility.getSalary()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(44)
//	 void findBySalaryNot_test() {
//		Mockito.when(service.findBySalaryNot(utility.getSalary())).thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findBySalaryNot(utility.getSalary()).getStatusCode());
//	}
//
//	@Test
//	@Order(45)
//	 void findBySalaryNot_empList_Null_test() {
//		Mockito.when(service.findBySalaryNot(utility.getSalary())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findBySalaryNot(utility.getSalary()).getStatusCode());
//	}
//
//	@Test
//	@Order(46)
//	 void findByEmpNameContaining_test() {
//		Mockito.when(service.findByEmpNameContaining(utility.getEmpName())).thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findByEmpNameContaining(utility.getEmpName()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(47)
//	 void findByEmpNameContaining_empList_Null_test() {
//		Mockito.when(service.findByEmpNameContaining(utility.getEmpName())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findByEmpNameContaining(utility.getEmpName()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(48)
//	 void findByEmpLocationContaining_test() {
//		Mockito.when(service.findByEmpLocationContaining(utility.getEmpLocation()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findByEmpLocationContaining(utility.getEmpLocation()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(49)
//	 void findByEmpLocationContaining_empList_Null_test() {
//		Mockito.when(service.findByEmpLocationContaining(utility.getEmpLocation())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findByEmpLocationContaining(utility.getEmpLocation()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(50)
//	 void findByEmpEmailEndingWith_test() {
//		Mockito.when(service.findByEmpEmailEndingWith(utility.getDomain())).thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findByEmpEmailEndingWith(utility.getDomain()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(51)
//	 void findByEmpEmailEndingWith_empList_Null_test() {
//		Mockito.when(service.findByEmpEmailEndingWith(utility.getDomain())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findByEmpEmailEndingWith(utility.getDomain()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(52)
//	 void findByEmpEmailStartingWith_test() {
//
//		Mockito.when(service.findByEmpEmailStartingWith(utility.getPrefix())).thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findByEmpEmailStartingWith(utility.getPrefix()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(53)
//	 void findByEmpEmailStartingWith_empList_Null_test() {
//
//		Mockito.when(service.findByEmpEmailStartingWith(utility.getPrefix())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findByEmpEmailStartingWith(utility.getPrefix()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(54)
//	 void findBySalaryGreaterThanOrderByEmpNameAsc_test() {
//
//		Mockito.when(service.findBySalaryGreaterThanOrderByEmpNameAsc(utility.getSalary()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findBySalaryGreaterThanOrderByEmpNameAsc(utility.getSalary()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(55)
//	 void findBySalaryGreaterThanOrderByEmpNameAsc_empList_Null_test() {
//
//		Mockito.when(service.findBySalaryGreaterThanOrderByEmpNameAsc(utility.getSalary())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findBySalaryGreaterThanOrderByEmpNameAsc(utility.getSalary()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(56)
//	 void findBySalaryLessThanOrderByEmpNameAsc_test() {
//
//		Mockito.when(service.findBySalaryLessThanOrderByEmpNameAsc(utility.getSalary()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findBySalaryLessThanOrderByEmpNameAsc(utility.getSalary()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(57)
//	 void findBySalaryLessThanOrderByEmpNameAsc_empList_Null_test() {
//
//		Mockito.when(service.findBySalaryLessThanOrderByEmpNameAsc(utility.getSalary())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findBySalaryLessThanOrderByEmpNameAsc(utility.getSalary()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(58)
//	 void findByEmpLocationOrderBySalaryAsc_test() {
//
//		Mockito.when(service.findByEmpLocationOrderBySalaryAsc(utility.getEmpLocation()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findByEmpLocationOrderBySalaryAsc(utility.getEmpLocation()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(59)
//	 void findByEmpLocationOrderBySalaryAsc_empList_Null_test() {
//
//		Mockito.when(service.findByEmpLocationOrderBySalaryAsc(utility.getEmpLocation())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findByEmpLocationOrderBySalaryAsc(utility.getEmpLocation()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(60)
//	 void findByEmpEmailContainingOrderBySalaryDesc_test() {
//
//		Mockito.when(service.findByEmpEmailContainingOrderBySalaryDesc(utility.getEmailsubstring()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(), employeeController
//				.findByEmpEmailContainingOrderBySalaryDesc(utility.getEmailsubstring()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(61)
//	 void findByEmpEmailContainingOrderBySalaryDesc_empList_Null_test() {
//
//		Mockito.when(service.findByEmpEmailContainingOrderBySalaryDesc(utility.getEmailsubstring()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(), employeeController
//				.findByEmpEmailContainingOrderBySalaryDesc(utility.getEmailsubstring()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(62)
//	 void findByEmpNameIgnoreCaseContaining_test() {
//
//		Mockito.when(service.findByEmpNameIgnoreCaseContaining(utility.getNameSubstring()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findByEmpNameIgnoreCaseContaining(utility.getNameSubstring()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(63)
//	 void findByEmpNameIgnoreCaseContaining_empList_Null_test() {
//
//		Mockito.when(service.findByEmpNameIgnoreCaseContaining(utility.getNameSubstring())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findByEmpNameIgnoreCaseContaining(utility.getNameSubstring()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(64)
//	 void findByEmpLocationIgnoreCaseContaining_test() {
//
//		Mockito.when(service.findByEmpLocationIgnoreCaseContaining(utility.getLocationSubstring()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(), employeeController
//				.findByEmpLocationIgnoreCaseContaining(utility.getLocationSubstring()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(65)
//	 void findByEmpLocationIgnoreCaseContaining_empList_Null_test() {
//
//		Mockito.when(service.findByEmpLocationIgnoreCaseContaining(utility.getLocationSubstring()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(), employeeController
//				.findByEmpLocationIgnoreCaseContaining(utility.getLocationSubstring()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(66)
//	 void findBySalaryGreaterThanAndEmpLocationContaining_test() {
//
//		Mockito.when(service.findBySalaryGreaterThanAndEmpLocationContaining(utility.getSalary(),
//				utility.getLocationSubstring())).thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findBySalaryGreaterThanAndEmpLocationContaining(utility.getSalary(),
//						utility.getLocationSubstring()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(67)
//	 void findBySalaryGreaterThanAndEmpLocationContaining_empList_Null_test() {
//
//		Mockito.when(service.findBySalaryGreaterThanAndEmpLocationContaining(utility.getSalary(),
//				utility.getLocationSubstring())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findBySalaryGreaterThanAndEmpLocationContaining(utility.getSalary(),
//						utility.getLocationSubstring()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(68)
//	 void findByEmpNameContainingOrEmpEmailContaining_test() {
//
//		Mockito.when(service.findByEmpNameContainingOrEmpEmailContaining(utility.getNameSubstring(),
//				utility.getEmailsubstring())).thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController.findByEmpNameContainingOrEmpEmailContaining(utility.getNameSubstring(),
//						utility.getEmailsubstring()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(69)
//	 void findByEmpNameContainingOrEmpEmailContaining_empList_Null_test() {
//
//		Mockito.when(service.findByEmpNameContainingOrEmpEmailContaining(utility.getNameSubstring(),
//				utility.getEmailsubstring())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController.findByEmpNameContainingOrEmpEmailContaining(utility.getNameSubstring(),
//						utility.getEmailsubstring()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(70)
//	 void findByEmpNameContainingAndSalaryGreaterThan_test() {
//
//		Mockito.when(service.findByEmpNameContainingAndSalaryGreaterThan(utility.getNameSubstring(),
//				utility.getSalary())).thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(), employeeController
//				.findByEmpNameContainingAndSalaryGreaterThan(utility.getNameSubstring(), utility.getSalary())
//				.getStatusCode());
//
//	}
//
//	@Test
//	@Order(71)
//	 void findByEmpNameContainingAndSalaryGreaterThan_empList_Null_test() {
//
//		Mockito.when(service.findByEmpNameContainingAndSalaryGreaterThan(utility.getNameSubstring(),
//				utility.getSalary())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(), employeeController
//				.findByEmpNameContainingAndSalaryGreaterThan(utility.getNameSubstring(), utility.getSalary())
//				.getStatusCode());
//
//	}
//
//	@Test
//	@Order(72)
//	 void findByEmpNameContainingOrderBySalaryDesc_test() {
//
//		Mockito.when(service.findByEmpNameContainingOrderBySalaryDesc(utility.getNameSubstring()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(), employeeController
//				.findByEmpNameContainingOrderBySalaryDesc(utility.getNameSubstring()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(73)
//	 void findByEmpNameContainingOrderBySalaryDesc_empList_Null_test() {
//
//		Mockito.when(service.findByEmpNameContainingOrderBySalaryDesc(utility.getNameSubstring())).thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(), employeeController
//				.findByEmpNameContainingOrderBySalaryDesc(utility.getNameSubstring()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(74)
//	 void findByEmpLocationContainingOrderBySalaryAsc_test() {
//
//		Mockito.when(service.findByEmpLocationContainingOrderBySalaryAsc(utility.getLocationSubstring()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(), employeeController
//				.findByEmpLocationContainingOrderBySalaryAsc(utility.getLocationSubstring()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(75)
//	 void findByEmpLocationContainingOrderBySalaryAsc_empList_Null_test() {
//
//		Mockito.when(service.findByEmpLocationContainingOrderBySalaryAsc(utility.getLocationSubstring()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(), employeeController
//				.findByEmpLocationContainingOrderBySalaryAsc(utility.getLocationSubstring()).getStatusCode());
//
//	}
//
//	@Test
//	@Order(76)
//	 void findByEmpLocationAndSalaryLessThan_test() {
//
//		Mockito.when(service.findByEmpLocationAndSalaryLessThan(utility.getEmpLocation(), utility.getSalary()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getResponse().getStatusCode(),
//				employeeController
//						.findByEmpLocationAndSalaryLessThan(utility.getEmpLocation(), utility.getSalary())
//						.getStatusCode());
//
//	}
//
//	@Test
//	@Order(77)
//	 void findByEmpLocationAndSalaryLessThan_empList_Null_test() {
//
//		Mockito.when(service.findByEmpLocationAndSalaryLessThan(utility.getEmpLocation(), utility.getSalary()))
//				.thenReturn(utility.empList());
//		assertEquals(utility.getNResponse().getStatusCode(),
//				employeeController
//						.findByEmpLocationAndSalaryLessThan(utility.getEmpLocation(), utility.getSalary())
//						.getStatusCode());
//
//	}
//
//}