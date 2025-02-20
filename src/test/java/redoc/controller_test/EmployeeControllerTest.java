package redoc.controller_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import redoc.UtilityTest.UtilityTest;
import redoc.controller.EmployeeController;
import redoc.dto.EmployeePojo;
import redoc.service.EmployeeService;

@ExtendWith(SpringExtension.class)
public class EmployeeControllerTest {
	@InjectMocks
	EmployeeController employeeController;

	@InjectMocks
	UtilityTest utilityTest;

	@Mock
	EmployeeService service;

	@Test
	@Order(1)
	public void findBySalary_test() {


		//List<EmployeePojo> empList = empService.findEmpListBySalary(salary);
		//  .thenReturn()                           Mockito.when()
		//method call in employeeController
		
		Mockito.when(service.findEmpListBySalary(utilityTest.getSalary())).thenReturn(UtilityTest.empList());
		
		assertEquals(UtilityTest.getResponse(), employeeController.findBySalary(utilityTest.getSalary()));
	 //                 byte expected         , byte actual

	};

	@Test
	@Order(2)
	public void findEmpListBySalary_empList_Null_test() {
		Mockito.when(service.findEmpListBySalary(utilityTest.getSalary())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(), employeeController.findBySalary(utilityTest.getSalary()));

	};

	@Test
	@Order(3)
	public void saveEmpDetails_test() {

		assertEquals(ResponseEntity.status(HttpStatus.CREATED).body("Employee details saved successfully"),
				employeeController.saveEmpDetails(UtilityTest.empPojo()));
	};

	@Test
	@Order(4)
	public void findEmpListByName_test() {
		Mockito.when(service.findEmpListByName(utilityTest.getEmpName())).thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(), employeeController.findByEmpName(utilityTest.getEmpName()));
		
	}
  
	@Test
	@Order(5)
	public void findEmpListByName_empList_Null_test() {
		Mockito.when(service.findEmpListByName(utilityTest.getEmpName())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(), employeeController.findByEmpName(utilityTest.getEmpName()));

	}

	@Test
	@Order(6)
	public void findEmpListByLocation_test() {
		Mockito.when(service.findEmpListByLocation(utilityTest.getEmpLocation())).thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(), employeeController.findByLocation(utilityTest.getEmpLocation()));
	}

	@Test
	@Order(7)
	public void findEmpListByLocation_empList_Null_test() {
		Mockito.when(service.findEmpListByLocation(utilityTest.getEmpLocation())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(), employeeController.findByLocation(utilityTest.getEmpLocation()));

	}

	@Test
	@Order(8)
	public void findEmpListByEmail_test() {
		Mockito.when(service.findEmpListByEmail(utilityTest.getEmpEmail())).thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(), employeeController.findByEmpEmail(utilityTest.getEmpEmail()));
	}

	@Test
	@Order(8)
	public void findEmpListByEmail_empList_Null_test() {
		Mockito.when(service.findEmpListByEmail(utilityTest.getEmpEmail())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(), employeeController.findByEmpEmail(utilityTest.getEmpEmail()));
	}

	@Test
	@Order(9)
	public void saveListEmpDetails_test() {
		assertEquals(ResponseEntity.status(HttpStatus.CREATED).body("Employee details list saved successfully"),
				employeeController.saveListEmpDetails(UtilityTest.empList()));
	}

	@Test
	@Order(10)
	public void findEmpListSalaryRange_test() {
		Mockito.when(service.findEmpListSalaryRange(utilityTest.getMinValue(), utilityTest.getMaxValue()))
				.thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(),
				employeeController.findEmpFromSalaryRange(utilityTest.getMinValue(), utilityTest.getMaxValue()));
	}

	@Test
	@Order(11)
	public void findEmpListSalaryRange_empList_Null_test() {
		Mockito.when(service.findEmpListSalaryRange(utilityTest.getMinValue(), utilityTest.getMaxValue()))
				.thenReturn(null);
		assertEquals(UtilityTest.getNResponse(),
				employeeController.findEmpFromSalaryRange(utilityTest.getMinValue(), utilityTest.getMaxValue()));
	}

	@Test
	@Order(12)
	public void findByEmpSalaryLessThan_test() {
		Mockito.when(service.findByEmpSalaryLessThan(utilityTest.getSalary())).thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(), employeeController.findByEmpSalaryLessThan(utilityTest.getSalary()));

	}

	@Test
	@Order(13)
	public void findByEmpSalaryLessThan_empList_Null_test() {
		Mockito.when(service.findByEmpSalaryLessThan(utilityTest.getSalary())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(), employeeController.findByEmpSalaryLessThan(utilityTest.getSalary()));

	}

	@Test
	@Order(14)
	public void findByEmpSalaryGreaterThan_test() {
		Mockito.when(service.findByEmpSalaryGreaterThan(utilityTest.getSalary())).thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(), employeeController.findByEmpSalaryGreaterThan(utilityTest.getSalary()));
	}

	@Test
	@Order(15)
	public void findByEmpSalaryGreaterThan_empList_Null_test() {
		Mockito.when(service.findByEmpSalaryGreaterThan(utilityTest.getSalary())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(),
				employeeController.findByEmpSalaryGreaterThan(utilityTest.getSalary()));
	}

	@Test
	@Order(16)
	public void findEmpByNameAndLocation_test() {
		Mockito.when(service.findEmpByNameAndLocation(utilityTest.getEmpName(), utilityTest.getEmpLocation()))
				.thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(),
				employeeController.findEmpByNameAndLocation(utilityTest.getEmpName(), utilityTest.getEmpLocation()));
	}

	@Test
	@Order(17)
	public void findEmpByNameAndLocation_empList_Null_test() {
		Mockito.when(service.findEmpByNameAndLocation(utilityTest.getEmpName(), utilityTest.getEmpLocation()))
				.thenReturn(null);
		assertEquals(UtilityTest.getNResponse(),
				employeeController.findEmpByNameAndLocation(utilityTest.getEmpName(), utilityTest.getEmpLocation()));
	}

	@Test
	@Order(18)
	public void findByEmpNameAndSalaryGreaterThan_test() {
		Mockito.when(service.findByEmpNameAndSalaryGreaterThan(utilityTest.getEmpName(), utilityTest.getSalary()))
				.thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(), employeeController
				.findByEmpNameAndSalaryGreaterThan(utilityTest.getEmpName(), utilityTest.getSalary()));

	}

	@Test
	@Order(19)
	public void findByEmpNameAndSalaryGreaterThan_empList_Null_test() {
		Mockito.when(service.findByEmpNameAndSalaryGreaterThan(utilityTest.getEmpName(), utilityTest.getSalary()))
				.thenReturn(null);
		assertEquals(UtilityTest.getNResponse(), employeeController
				.findByEmpNameAndSalaryGreaterThan(utilityTest.getEmpName(), utilityTest.getSalary()));

	}

	@Test
	@Order(20)
	public void findByEmpLocationContainingOrSalaryLessThan_test() {
		Mockito.when(service.findByEmpLocationContainingOrSalaryLessThan(utilityTest.getLocationSubstring(),
				utilityTest.getSalary())).thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(), employeeController.findByEmpLocationContainingOrSalaryLessThan(
				utilityTest.getLocationSubstring(), utilityTest.getSalary()));
	}

	@Test
	@Order(21)
	public void findByEmpLocationContainingOrSalaryLessThan_empList_Null_test() {
		Mockito.when(service.findByEmpLocationContainingOrSalaryLessThan(utilityTest.getLocationSubstring(),
				utilityTest.getSalary())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(), employeeController.findByEmpLocationContainingOrSalaryLessThan(
				utilityTest.getLocationSubstring(), utilityTest.getSalary()));
	}

	@Test
	@Order(22)
	public void findByEmpNameAndEmpLocationAndSalaryBetween_test() {
		Mockito.when(service.findByEmpNameAndEmpLocationAndSalaryBetween(utilityTest.getEmpName(),
				utilityTest.getEmpLocation(), utilityTest.getMinValue(), utilityTest.getMaxValue()))
				.thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(),
				employeeController.findByEmpNameAndEmpLocationAndSalaryBetween(utilityTest.getEmpName(),
						utilityTest.getEmpLocation(), utilityTest.getMinValue(), utilityTest.getMaxValue()));
	}

	@Test
	@Order(23)
	public void findByEmpNameAndEmpLocationAndSalaryBetween_empList_Null_test() {
		Mockito.when(service.findByEmpNameAndEmpLocationAndSalaryBetween(utilityTest.getEmpName(),
				utilityTest.getEmpLocation(), utilityTest.getMinValue(), utilityTest.getMaxValue())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(),
				employeeController.findByEmpNameAndEmpLocationAndSalaryBetween(utilityTest.getEmpName(),
						utilityTest.getEmpLocation(), utilityTest.getMinValue(), utilityTest.getMaxValue()));
	}

	@Test
	@Order(24)
	public void findByEmpNameOrEmpLocation_test() {
		Mockito.when(service.findByEmpNameOrEmpLocation(utilityTest.getEmpName(), utilityTest.getEmpLocation()))
				.thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(),
				employeeController.findByEmpNameOrEmpLocation(utilityTest.getEmpName(), utilityTest.getEmpLocation()));
	}

	@Test
	@Order(25)
	public void findByEmpNameOrEmpLocation_empList_Null_test() {
		Mockito.when(service.findByEmpNameOrEmpLocation(utilityTest.getEmpName(), utilityTest.getEmpLocation()))
				.thenReturn(null);
		assertEquals(UtilityTest.getNResponse(),
				employeeController.findByEmpNameOrEmpLocation(utilityTest.getEmpName(), utilityTest.getEmpLocation()));
	}

	@Test
	@Order(26)
	public void findByEmpNameIgnoreCase_test() {
		Mockito.when(service.findByEmpNameIgnoreCase(utilityTest.getEmpName())).thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(), employeeController.findByEmpNameIgnoreCase(utilityTest.getEmpName()));
	}

	@Test
	@Order(27)
	public void findByEmpNameIgnoreCase_empList_Null_test() {
		Mockito.when(service.findByEmpNameIgnoreCase(utilityTest.getEmpName())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(), employeeController.findByEmpNameIgnoreCase(utilityTest.getEmpName()));
	}

	@Test
	@Order(28)
	public void findByEmpLocationIgnoreCase_test() {
		Mockito.when(service.findByEmpLocationIgnoreCase(utilityTest.getEmpLocation()))
				.thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(),
				employeeController.findByEmpLocationIgnoreCase(utilityTest.getEmpLocation()));

	}

	@Test
	@Order(29)
	public void findByEmpLocationIgnoreCase_empList_Null_test() {
		Mockito.when(service.findByEmpLocationIgnoreCase(utilityTest.getEmpLocation())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(),
				employeeController.findByEmpLocationIgnoreCase(utilityTest.getEmpLocation()));

	}

	@Test
	@Order(30)
	public void findByEmpEmailContaining_test() {
		Mockito.when(service.findByEmpEmailContaining(utilityTest.getEmailsubstring()))
				.thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(),
				employeeController.findByEmpEmailContaining(utilityTest.getEmailsubstring()));
	}

	@Test
	@Order(31)
	public void findByEmpEmailContaining_empList_Null_test() {
		Mockito.when(service.findByEmpEmailContaining(utilityTest.getEmailsubstring())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(),
				employeeController.findByEmpEmailContaining(utilityTest.getEmailsubstring()));
	}

	@Test
	@Order(32)
	public void findByEmpNameOrderBySalaryAsc_test() {
		Mockito.when(service.findByEmpNameOrderBySalaryAsc(utilityTest.getEmpName())).thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(),
				employeeController.findByEmpNameOrderBySalaryAsc(utilityTest.getEmpName()));
	}

	@Test
	@Order(33)
	public void findByEmpNameOrderBySalaryAsc_empList_Null_test() {
		Mockito.when(service.findByEmpNameOrderBySalaryAsc(utilityTest.getEmpName())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(),
				employeeController.findByEmpNameOrderBySalaryAsc(utilityTest.getEmpName()));
	}

	@Test
	@Order(34)
	public void findByEmpNameOrderBySalaryDesc_test() {

		Mockito.when(service.findByEmpNameOrderBySalaryDesc(utilityTest.getEmpName()))
				.thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(),
				employeeController.findByEmpNameOrderBySalaryDesc(utilityTest.getEmpName()));
	}

	@Test
	@Order(35)
	public void findByEmpNameOrderBySalaryDesc_empList_Null_test() {

		Mockito.when(service.findByEmpNameOrderBySalaryDesc(utilityTest.getEmpName())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(),
				employeeController.findByEmpNameOrderBySalaryDesc(utilityTest.getEmpName()));
	}

	@Test
	@Order(36)
	public void findByEmpLocationOrderByEmpNameAsc_test() {
		Mockito.when(service.findByEmpLocationOrderByEmpNameAsc(utilityTest.getEmpLocation()))
				.thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(),
				employeeController.findByEmpLocationOrderByEmpNameAsc(utilityTest.getEmpLocation()));
	}

	@Test
	@Order(37)
	public void findByEmpLocationOrderByEmpNameAsc_empList_Null_test() {
		Mockito.when(service.findByEmpLocationOrderByEmpNameAsc(utilityTest.getEmpLocation())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(),
				employeeController.findByEmpLocationOrderByEmpNameAsc(utilityTest.getEmpLocation()));
	}

	@Test
	@Order(38)
	public void findByEmpLocationOrderByEmpNameDesc_test() {
		Mockito.when(service.findByEmpLocationOrderByEmpNameDesc(utilityTest.getEmpLocation()))
				.thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(),
				employeeController.findByEmpLocationOrderByEmpNameDesc(utilityTest.getEmpLocation()));
	}

	@Test
	@Order(39)
	public void findByEmpLocationOrderByEmpNameDesc_empList_Null_test() {
		Mockito.when(service.findByEmpLocationOrderByEmpNameDesc(utilityTest.getEmpLocation())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(),
				employeeController.findByEmpLocationOrderByEmpNameDesc(utilityTest.getEmpLocation()));
	}

	@Test
	@Order(40)
	public void findBySalaryGreaterThanEqual_test() {
		Mockito.when(service.findBySalaryGreaterThanEqual(utilityTest.getSalary())).thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(),
				employeeController.findBySalaryGreaterThanEqual(utilityTest.getSalary()));
	}

	@Test
	@Order(41)
	public void findBySalaryGreaterThanEqual_empList_Null_test() {
		Mockito.when(service.findBySalaryGreaterThanEqual(utilityTest.getSalary())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(),
				employeeController.findBySalaryGreaterThanEqual(utilityTest.getSalary()));
	}

	@Test
	@Order(42)
	public void findBySalaryLessThanEqual_test() {
		Mockito.when(service.findBySalaryLessThanEqual(utilityTest.getSalary())).thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(), employeeController.findBySalaryLessThanEqual(utilityTest.getSalary()));

	}

	@Test
	@Order(43)
	public void findBySalaryLessThanEqual_empList_Null_test() {
		Mockito.when(service.findBySalaryLessThanEqual(utilityTest.getSalary())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(), employeeController.findBySalaryLessThanEqual(utilityTest.getSalary()));

	}

	@Test
	@Order(44)
	public void findBySalaryNot_test() {
		Mockito.when(service.findBySalaryNot(utilityTest.getSalary())).thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(), employeeController.findBySalaryNot(utilityTest.getSalary()));
	}

	@Test
	@Order(45)
	public void findBySalaryNot_empList_Null_test() {
		Mockito.when(service.findBySalaryNot(utilityTest.getSalary())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(), employeeController.findBySalaryNot(utilityTest.getSalary()));
	}

	@Test
	@Order(46)
	public void findByEmpNameContaining_test() {
		Mockito.when(service.findByEmpNameContaining(utilityTest.getEmpName())).thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(), employeeController.findByEmpNameContaining(utilityTest.getEmpName()));

	}

	@Test
	@Order(47)
	public void findByEmpNameContaining_empList_Null_test() {
		Mockito.when(service.findByEmpNameContaining(utilityTest.getEmpName())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(), employeeController.findByEmpNameContaining(utilityTest.getEmpName()));

	}

	@Test
	@Order(48)
	public void findByEmpLocationContaining_test() {
		Mockito.when(service.findByEmpLocationContaining(utilityTest.getEmpLocation()))
				.thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(),
				employeeController.findByEmpLocationContaining(utilityTest.getEmpLocation()));

	}

	@Test
	@Order(49)
	public void findByEmpLocationContaining_empList_Null_test() {
		Mockito.when(service.findByEmpLocationContaining(utilityTest.getEmpLocation())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(),
				employeeController.findByEmpLocationContaining(utilityTest.getEmpLocation()));

	}

	@Test
	@Order(50)
	public void findByEmpEmailEndingWith_test() {
		Mockito.when(service.findByEmpEmailEndingWith(utilityTest.getDomain())).thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(), employeeController.findByEmpEmailEndingWith(utilityTest.getDomain()));

	}

	@Test
	@Order(51)
	public void findByEmpEmailEndingWith_empList_Null_test() {
		Mockito.when(service.findByEmpEmailEndingWith(utilityTest.getDomain())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(), employeeController.findByEmpEmailEndingWith(utilityTest.getDomain()));

	}

	@Test
	@Order(52)
	public void findByEmpEmailStartingWith_test() {

		Mockito.when(service.findByEmpEmailStartingWith(utilityTest.getPrefix())).thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(), employeeController.findByEmpEmailStartingWith(utilityTest.getPrefix()));

	}

	@Test
	@Order(53)
	public void findByEmpEmailStartingWith_empList_Null_test() {

		Mockito.when(service.findByEmpEmailStartingWith(utilityTest.getPrefix())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(),
				employeeController.findByEmpEmailStartingWith(utilityTest.getPrefix()));

	}

	@Test
	@Order(54)
	public void findBySalaryGreaterThanOrderByEmpNameAsc_test() {

		Mockito.when(service.findBySalaryGreaterThanOrderByEmpNameAsc(utilityTest.getSalary()))
				.thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(),
				employeeController.findBySalaryGreaterThanOrderByEmpNameAsc(utilityTest.getSalary()));

	}

	@Test
	@Order(55)
	public void findBySalaryGreaterThanOrderByEmpNameAsc_empList_Null_test() {

		Mockito.when(service.findBySalaryGreaterThanOrderByEmpNameAsc(utilityTest.getSalary())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(),
				employeeController.findBySalaryGreaterThanOrderByEmpNameAsc(utilityTest.getSalary()));

	}

	@Test
	@Order(56)
	public void findBySalaryLessThanOrderByEmpNameAsc_test() {

		Mockito.when(service.findBySalaryLessThanOrderByEmpNameAsc(utilityTest.getSalary()))
				.thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(),
				employeeController.findBySalaryLessThanOrderByEmpNameAsc(utilityTest.getSalary()));

	}

	@Test
	@Order(57)
	public void findBySalaryLessThanOrderByEmpNameAsc_empList_Null_test() {

		Mockito.when(service.findBySalaryLessThanOrderByEmpNameAsc(utilityTest.getSalary())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(),
				employeeController.findBySalaryLessThanOrderByEmpNameAsc(utilityTest.getSalary()));

	}

	@Test
	@Order(58)
	public void findByEmpLocationOrderBySalaryAsc_test() {

		Mockito.when(service.findByEmpLocationOrderBySalaryAsc(utilityTest.getEmpLocation()))
				.thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(),
				employeeController.findByEmpLocationOrderBySalaryAsc(utilityTest.getEmpLocation()));

	}

	@Test
	@Order(59)
	public void findByEmpLocationOrderBySalaryAsc_empList_Null_test() {

		Mockito.when(service.findByEmpLocationOrderBySalaryAsc(utilityTest.getEmpLocation())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(),
				employeeController.findByEmpLocationOrderBySalaryAsc(utilityTest.getEmpLocation()));

	}

	@Test
	@Order(60)
	public void findByEmpEmailContainingOrderBySalaryDesc_test() {

		Mockito.when(service.findByEmpEmailContainingOrderBySalaryDesc(utilityTest.getEmailsubstring()))
				.thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(),
				employeeController.findByEmpEmailContainingOrderBySalaryDesc(utilityTest.getEmailsubstring()));

	}

	@Test
	@Order(61)
	public void findByEmpEmailContainingOrderBySalaryDesc_empList_Null_test() {

		Mockito.when(service.findByEmpEmailContainingOrderBySalaryDesc(utilityTest.getEmailsubstring()))
				.thenReturn(null);
		assertEquals(UtilityTest.getNResponse(),
				employeeController.findByEmpEmailContainingOrderBySalaryDesc(utilityTest.getEmailsubstring()));

	}

	@Test
	@Order(62)
	public void findByEmpNameIgnoreCaseContaining_test() {

		Mockito.when(service.findByEmpNameIgnoreCaseContaining(utilityTest.getNameSubstring()))
				.thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(),
				employeeController.findByEmpNameIgnoreCaseContaining(utilityTest.getNameSubstring()));

	}

	@Test
	@Order(63)
	public void findByEmpNameIgnoreCaseContaining_empList_Null_test() {

		Mockito.when(service.findByEmpNameIgnoreCaseContaining(utilityTest.getNameSubstring())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(),
				employeeController.findByEmpNameIgnoreCaseContaining(utilityTest.getNameSubstring()));

	}

	@Test
	@Order(64)
	public void findByEmpLocationIgnoreCaseContaining_test() {

		Mockito.when(service.findByEmpLocationIgnoreCaseContaining(utilityTest.getLocationSubstring()))
				.thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(),
				employeeController.findByEmpLocationIgnoreCaseContaining(utilityTest.getLocationSubstring()));

	}

	@Test
	@Order(65)
	public void findByEmpLocationIgnoreCaseContaining_empList_Null_test() {

		Mockito.when(service.findByEmpLocationIgnoreCaseContaining(utilityTest.getLocationSubstring()))
				.thenReturn(null);
		assertEquals(UtilityTest.getNResponse(),
				employeeController.findByEmpLocationIgnoreCaseContaining(utilityTest.getLocationSubstring()));

	}

	@Test
	@Order(66)
	public void findBySalaryGreaterThanAndEmpLocationContaining_test() {

		Mockito.when(service.findBySalaryGreaterThanAndEmpLocationContaining(utilityTest.getSalary(),
				utilityTest.getLocationSubstring())).thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(), employeeController.findBySalaryGreaterThanAndEmpLocationContaining(
				utilityTest.getSalary(), utilityTest.getLocationSubstring()));

	}

	@Test
	@Order(67)
	public void findBySalaryGreaterThanAndEmpLocationContaining_empList_Null_test() {

		Mockito.when(service.findBySalaryGreaterThanAndEmpLocationContaining(utilityTest.getSalary(),
				utilityTest.getLocationSubstring())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(), employeeController.findBySalaryGreaterThanAndEmpLocationContaining(
				utilityTest.getSalary(), utilityTest.getLocationSubstring()));

	}

	@Test
	@Order(68)
	public void findByEmpNameContainingOrEmpEmailContaining_test() {

		Mockito.when(service.findByEmpNameContainingOrEmpEmailContaining(utilityTest.getNameSubstring(),
				utilityTest.getEmailsubstring())).thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(), employeeController.findByEmpNameContainingOrEmpEmailContaining(
				utilityTest.getNameSubstring(), utilityTest.getEmailsubstring()));

	}

	@Test
	@Order(69)
	public void findByEmpNameContainingOrEmpEmailContaining_empList_Null_test() {

		Mockito.when(service.findByEmpNameContainingOrEmpEmailContaining(utilityTest.getNameSubstring(),
				utilityTest.getEmailsubstring())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(), employeeController.findByEmpNameContainingOrEmpEmailContaining(
				utilityTest.getNameSubstring(), utilityTest.getEmailsubstring()));

	}

	@Test
	@Order(70)
	public void findByEmpNameContainingAndSalaryGreaterThan_test() {

		Mockito.when(service.findByEmpNameContainingAndSalaryGreaterThan(utilityTest.getNameSubstring(),
				utilityTest.getSalary())).thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(), employeeController
				.findByEmpNameContainingAndSalaryGreaterThan(utilityTest.getNameSubstring(), utilityTest.getSalary()));

	}

	@Test
	@Order(71)
	public void findByEmpNameContainingAndSalaryGreaterThan_empList_Null_test() {

		Mockito.when(service.findByEmpNameContainingAndSalaryGreaterThan(utilityTest.getNameSubstring(),
				utilityTest.getSalary())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(), employeeController
				.findByEmpNameContainingAndSalaryGreaterThan(utilityTest.getNameSubstring(), utilityTest.getSalary()));

	}

	@Test
	@Order(72)
	public void findByEmpNameContainingOrderBySalaryDesc_test() {

		Mockito.when(service.findByEmpNameContainingOrderBySalaryDesc(utilityTest.getNameSubstring()))
				.thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(),
				employeeController.findByEmpNameContainingOrderBySalaryDesc(utilityTest.getNameSubstring()));

	}

	@Test
	@Order(73)
	public void findByEmpNameContainingOrderBySalaryDesc_empList_Null_test() {

		Mockito.when(service.findByEmpNameContainingOrderBySalaryDesc(utilityTest.getNameSubstring())).thenReturn(null);
		assertEquals(UtilityTest.getNResponse(),
				employeeController.findByEmpNameContainingOrderBySalaryDesc(utilityTest.getNameSubstring()));

	}

	@Test
	@Order(74)
	public void findByEmpLocationContainingOrderBySalaryAsc_test() {

		Mockito.when(service.findByEmpLocationContainingOrderBySalaryAsc(utilityTest.getLocationSubstring()))
				.thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(),
				employeeController.findByEmpLocationContainingOrderBySalaryAsc(utilityTest.getLocationSubstring()));

	}

	@Test
	@Order(75)
	public void findByEmpLocationContainingOrderBySalaryAsc_empList_Null_test() {

		Mockito.when(service.findByEmpLocationContainingOrderBySalaryAsc(utilityTest.getLocationSubstring()))
				.thenReturn(null);
		assertEquals(UtilityTest.getNResponse(),
				employeeController.findByEmpLocationContainingOrderBySalaryAsc(utilityTest.getLocationSubstring()));

	}

	@Test
	@Order(76)
	public void findByEmpLocationAndSalaryLessThan_test() {

		Mockito.when(service.findByEmpLocationAndSalaryLessThan(utilityTest.getEmpLocation(), utilityTest.getSalary()))
				.thenReturn(UtilityTest.empList());
		assertEquals(UtilityTest.getResponse(), employeeController
				.findByEmpLocationAndSalaryLessThan(utilityTest.getEmpLocation(), utilityTest.getSalary()));

	}

	@Test
	@Order(77)
	public void findByEmpLocationAndSalaryLessThan_empList_Null_test() {

		Mockito.when(service.findByEmpLocationAndSalaryLessThan(utilityTest.getEmpLocation(), utilityTest.getSalary()))
				.thenReturn(null);
		assertEquals(UtilityTest.getNResponse(), employeeController
				.findByEmpLocationAndSalaryLessThan(utilityTest.getEmpLocation(), utilityTest.getSalary()));

	}

}