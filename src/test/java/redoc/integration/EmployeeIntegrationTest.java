package redoc.integration;
//Import necessary classespackage redoc.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import redoc.controller.EmployeeController;
import redoc.dto.EmployeePojo;

@SpringBootTest
class EmployeeIntegrationTest {
	
	
	@Autowired
	private EmployeeController controller;
	
	
//	@Test
//	void findBySalaryTest() {
//		Double salary=50000.00;
//		ResponseEntity<List<EmployeePojo>> list= controller.findBySalary(salary);
//		assertEquals(HttpStatus.OK, list.getStatusCode());
//		assertTrue(list.getBody().size()>0);
//	}
//	@Test
//	void findBySalaryEmptyListTest() {
//		Double salary=50000000000.00;
//		ResponseEntity<List<EmployeePojo>> list= controller.findBySalary(salary);
//		assertEquals(HttpStatus.BAD_REQUEST, list.getStatusCode());
//		assertTrue(list.getBody().size()==0);
//	}
}
