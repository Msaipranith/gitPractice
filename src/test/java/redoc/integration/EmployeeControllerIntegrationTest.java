package redoc.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import redoc.entity.Employee;
import redoc.repo.EmployeeRepo;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class EmployeeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepo employeeRepo;

    @BeforeEach
    void setup() {

        Employee employee = new Employee();

        employee.setEmpName("Sai");
        employee.setEmpLocation("Hyderabad");
        employee.setEmpEmail("sai@gmail.com");
        employee.setSalary(50000.0);
        employee.setCreatedAt(LocalDate.now());
        employee.setUpdatedAt(LocalDate.now());

        employeeRepo.save(employee);
    }

    @Test
    @DisplayName("Should return employees by location")
    void shouldReturnEmployeesByLocation() throws Exception {

        mockMvc.perform(get("/employee/findEmployeesByLocation")
                        .param("location", "Hyderabad")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].empName").value("Sai"))
                .andExpect(jsonPath("$[0].empLocation").value("Hyderabad"));
    }
}