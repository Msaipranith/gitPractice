package redoc.integration;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import redoc.dto.EmployeePojo;
import redoc.entity.Employee;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerIntegrationTest  {

    @Autowired
    private TestRestTemplate restTemplate;

    // Insert a sample employee so that GET endpoints can return non-empty results.
    @BeforeEach
     void setup() {
        EmployeePojo emp = new EmployeePojo();
        emp.setEmpName("John");
        emp.setEmpLocation("NY");
        emp.setEmpEmail("john@example.com");
        emp.setSalary(50000.0);
        ResponseEntity<String> response = restTemplate.postForEntity("/employee/saveEmpDetails", emp, String.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    // 1. POST /employee/saveEmpDetails
    @Test
     void testSaveEmpDetails() {
        EmployeePojo emp = new EmployeePojo();
        emp.setEmpName("Alice");
        emp.setEmpLocation("LA");
        emp.setEmpEmail("alice@example.com");
        emp.setSalary(60000.0);
        ResponseEntity<String> response = restTemplate.postForEntity("/employee/saveEmpDetails", emp, String.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Employee details saved successfully", response.getBody());
    }

    // 2. POST /employee/saveListEmpDetails
    @Test
     void testSaveListEmpDetails() {
        EmployeePojo emp1 = new EmployeePojo();
        emp1.setEmpName("Bob");
        emp1.setEmpLocation("SF");
        emp1.setEmpEmail("bob@example.com");
        emp1.setSalary(55000.0);
        
        EmployeePojo emp2 = new EmployeePojo();
        emp2.setEmpName("Charlie");
        emp2.setEmpLocation("TX");
        emp2.setEmpEmail("charlie@example.com");
        emp2.setSalary(58000.0);
        
        List<EmployeePojo> empList = List.of(emp1, emp2);
        ResponseEntity<String> response = restTemplate.postForEntity("/employee/saveListEmpDetails", empList, String.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Employee details list saved successfully", response.getBody());
    }

    // 3. GET /employee/findEmployeesListBySalary
    @Test
     void testFindEmployeesListBySalary() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findEmployeesListBySalary?salary=50000",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 4. GET /employee/findEmployeesByName
    @Test
     void testFindEmployeesByName() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findEmployeesByName?name=John",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 5. GET /employee/findEmployeesByLocation
    @Test
     void testFindEmployeesByLocation() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findEmployeesByLocation?location=NY",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 6. GET /employee/findEmployeesByEmail
    @Test
     void testFindEmployeesByEmail() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findEmployeesByEmail?email=john@example.com",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 7. GET /employee/getSalaryLessThan
    @Test
     void testGetSalaryLessThan() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/getSalaryLessThan?salary=60000",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 8. GET /employee/getSalaryGreaterThan
    @Test
     void testGetSalaryGreaterThan() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/getSalaryGreaterThan?salary=40000",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 9. GET /employee/getSalaryFromRange
    @Test
     void testGetSalaryFromRange() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/getSalaryFromRange?minValue=40000&maxValue=60000",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 10. GET /employee/findEmpByNameAndLocation
    @Test
     void testFindEmpByNameAndLocation() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findEmpByNameAndLocation?name=John&location=NY",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 11. GET /employee/findByEmpNameAndSalaryGreaterThan
    @Test
     void testFindByEmpNameAndSalaryGreaterThan() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findByEmpNameAndSalaryGreaterThan?name=John&salary=40000",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 12. GET /employee/findByEmpLocationAndSalaryLessThan
    @Test
     void testFindByEmpLocationAndSalaryLessThan() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findByEmpLocationAndSalaryLessThan?location=NY&salary=60000",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 13. GET /employee/findByEmpNameAndEmpLocationAndSalaryBetween
    @Test
     void testFindByEmpNameAndEmpLocationAndSalaryBetween() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findByEmpNameAndEmpLocationAndSalaryBetween?name=John&location=NY&minSal=40000&maxSal=60000",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 14. GET /employee/findByEmpNameOrEmpLocation
    @Test
     void testFindByEmpNameOrEmpLocation() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findByEmpNameOrEmpLocation?name=John&location=LA",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    // 15. GET /employee/findByEmpNameIgnoreCase
    @Test
     void testFindByEmpNameIgnoreCase() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findByEmpNameIgnoreCase?name=john",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 16. GET /employee/findByEmpLocationIgnoreCase
    @Test
     void testFindByEmpLocationIgnoreCase() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findByEmpLocationIgnoreCase?location=ny",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 17. GET /employee/findByEmpEmailContaining
    @Test
     void testFindByEmpEmailContaining() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findByEmpEmailContaining?subString=example",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 18. GET /employee/findByEmpNameOrderBySalaryAsc
    @Test
     void testFindByEmpNameOrderBySalaryAsc() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findByEmpNameOrderBySalaryAsc?name=John",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 19. GET /employee/findByEmpNameOrderBySalaryDesc
    @Test
     void testFindByEmpNameOrderBySalaryDesc() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findByEmpNameOrderBySalaryDesc?name=John",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 20. GET /employee/findByEmpLocationOrderByEmpNameAsc
    @Test
     void testFindByEmpLocationOrderByEmpNameAsc() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findByEmpLocationOrderByEmpNameAsc?location=NY",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 21. GET /employee/findByEmpLocationOrderByEmpNameDesc
    @Test
     void testFindByEmpLocationOrderByEmpNameDesc() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findByEmpLocationOrderByEmpNameDesc?location=NY",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 22. GET /employee/findBySalaryGreaterThanEqual
    @Test
     void testFindBySalaryGreaterThanEqual() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findBySalaryGreaterThanEqual?salary=50000",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 23. GET /employee/findBySalaryLessThanEqual
    @Test
     void testFindBySalaryLessThanEqual() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findBySalaryLessThanEqual?salary=50000",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 24. GET /employee/findBySalaryNot
    @Test
     void testFindBySalaryNot() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findBySalaryNot?salary=50000",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        // We simply check that the response is OK
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    // 25. GET /employee/findByEmpNameContaining
    @Test
     void testFindByEmpNameContaining() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findByEmpNameContaining?subString=oh",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 26. GET /employee/findByEmpLocationContaining
    @Test
     void testFindByEmpLocationContaining() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findByEmpLocationContaining?subString=Y",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 27. GET /employee/findByEmpEmailEndingWith
    @Test
     void testFindByEmpEmailEndingWith() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findByEmpEmailEndingWith?domain=example.com",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 28. GET /employee/findByEmpEmailStartingWith
    @Test
     void testFindByEmpEmailStartingWith() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findByEmpEmailStartingWith?prefix=john",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 29. GET /employee/findBySalaryGreaterThanOrderByEmpNameAsc
    @Test
     void testFindBySalaryGreaterThanOrderByEmpNameAsc() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findBySalaryGreaterThanOrderByEmpNameAsc?salary=40000",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 30. GET /employee/findBySalaryLessThanOrderByEmpNameAsc
    @Test
     void testFindBySalaryLessThanOrderByEmpNameAsc() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findBySalaryLessThanOrderByEmpNameAsc?salary=60000",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 31. GET /employee/findByEmpLocationOrderBySalaryAsc
    @Test
     void testFindByEmpLocationOrderBySalaryAsc() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findByEmpLocationOrderBySalaryAsc?location=NY",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 32. GET /employee/findByEmpEmailContainingOrderBySalaryDesc
    @Test
     void testFindByEmpEmailContainingOrderBySalaryDesc() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findByEmpEmailContainingOrderBySalaryDesc?subString=example",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 33. GET /employee/findByEmpNameIgnoreCaseContaining
    @Test
     void testFindByEmpNameIgnoreCaseContaining() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findByEmpNameIgnoreCaseContaining?subString=jo",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 34. GET /employee/findByEmpLocationIgnoreCaseContaining
    @Test
     void testFindByEmpLocationIgnoreCaseContaining() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findByEmpLocationIgnoreCaseContaining?subString=ny",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 35. GET /employee/findBySalaryGreaterThanAndEmpLocationContaining
    @Test
     void testFindBySalaryGreaterThanAndEmpLocationContaining() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findBySalaryGreaterThanAndEmpLocationContaining?salary=40000&subString=N",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 36. GET /employee/findByEmpNameContainingOrEmpEmailContaining
    @Test
     void testFindByEmpNameContainingOrEmpEmailContaining() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findByEmpNameContainingOrEmpEmailContaining?nameSubstring=jo&emailSubstring=example",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 37. GET /employee/findByEmpNameContainingAndSalaryGreaterThan
    @Test
    void testFindByEmpNameContainingAndSalaryGreaterThan_ThrowsException() {
        // Using parameters that will cause no matching employee, triggering the exception.
        assertThrows(RestClientException.class, () ->
            restTemplate.exchange(
                "/employee/findByEmpNameContainingAndSalaryGreaterThan?nameSubstring=nonexistent&salary=40000",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<EmployeePojo>>() {}
            )
        );
    }

    // 38. GET /employee/findByEmpLocationContainingOrSalaryLessThan
    @Test
     void testFindByEmpLocationContainingOrSalaryLessThan() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findByEmpLocationContainingOrSalaryLessThan?locationSubstring=Y&salary=60000",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 39. GET /employee/findByEmpNameContainingOrderBySalaryDesc
//    @Test
//    void testFindByEmpNameContainingOrderBySalaryDesc() {
//        // Insert a test employee with a name containing "jo"
//        EmployeePojo testEmp = new EmployeePojo();
//        testEmp.setEmpName("Johnathan");
//        testEmp.setEmpLocation("NY");
//        testEmp.setEmpEmail("johnathan@example.com");
//        testEmp.setSalary(70000.0);
//        ResponseEntity<String> postResponse = restTemplate.postForEntity(
//            "/employee/saveEmpDetails", testEmp, String.class);
//        assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());
//
//        // Optionally, retrieve the raw JSON as a String and log it for debugging
//        ResponseEntity<String> rawResponse = restTemplate.getForEntity(
//            "/employee/findByEmpNameContainingOrderBySalaryDesc?nameSubstring=jo",
//            String.class
//        );
//        System.out.println("Raw JSON response: " + rawResponse.getBody());
//        assertEquals(HttpStatus.NOT_FOUND, rawResponse.getStatusCode());
//
//        // Now, deserialize the JSON into a List<EmployeePojo>
//        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
//            "/employee/findByEmpNameContainingOrderBySalaryDesc?nameSubstring=jo",
//            HttpMethod.GET,
//            null,
//            new ParameterizedTypeReference<List<EmployeePojo>>() {}
//        );
//        
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        List<EmployeePojo> employees = response.getBody();
//        assertNotNull(employees);
//        assertFalse(employees.isEmpty());
//    }



    // 40. GET /employee/findByEmpLocationContainingOrderBySalaryAsc
    @Test
     void testFindByEmpLocationContainingOrderBySalaryAsc() {
        ResponseEntity<List<EmployeePojo>> response = restTemplate.exchange(
            "/employee/findByEmpLocationContainingOrderBySalaryAsc?locationSubstring=NY",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<EmployeePojo>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 41. GET /employee/findAllEmp
    @Test
     void testFindAllEmp() {
        ResponseEntity<List<Employee>> response = restTemplate.exchange(
            "/employee/findAllEmp",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Employee>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    // 42. GET /employee/paginationEx
    @Test
     void testPaginationEx() {
        ResponseEntity<List<Employee>> response = restTemplate.exchange(
            "/employee/paginationEx",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Employee>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    // 43. GET /employee/sortingEx
    @Test
     void testSortingEx() {
        ResponseEntity<List<Employee>> response = restTemplate.exchange(
            "/employee/sortingEx",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Employee>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    // 44. GET /employee/paginationWithSortingEx
    @Test
     void testPaginationWithSortingEx() {
        ResponseEntity<List<Employee>> response = restTemplate.exchange(
            "/employee/paginationWithSortingEx",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Employee>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    // 45. GET /employee/cutsomAPI
    @Test
     void testCustomAPIMethod() {
        ResponseEntity<List<Employee>> response = restTemplate.exchange(
            "/employee/cutsomAPI?location=NY&salary=50000",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Employee>>() {}
        );
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    // 46. GET /employee/findEmpById
    @Test
     void testFindEmpById() {
        // First, create an employee
        EmployeePojo emp = new EmployeePojo();
        emp.setEmpName("TestId");
        emp.setEmpLocation("TestCity");
        emp.setEmpEmail("testid@example.com");
        emp.setSalary(70000.0);
        ResponseEntity<String> saveResponse = restTemplate.postForEntity("/employee/saveEmpDetails", emp, String.class);
        assertEquals(HttpStatus.CREATED, saveResponse.getStatusCode());
        
        // Retrieve all employees to obtain an ID
        ResponseEntity<List<Employee>> allResponse = restTemplate.exchange(
            "/employee/findAllEmp",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Employee>>() {}
        );
        List<Employee> allEmployees = allResponse.getBody();
        assertNotNull(allEmployees);
        assertTrue(allEmployees.size() > 0);
        
        // Get an ID from the newly created employee (assumed as last in list)
        Long id = allEmployees.get(allEmployees.size() - 1).getId();
        
        ResponseEntity<Employee> response = restTemplate.getForEntity("/employee/findEmpById?id=" + id, Employee.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Employee foundEmp = response.getBody();
        assertNotNull(foundEmp);
        assertEquals("TestId", foundEmp.getEmpName());
    }
}
