package redoc.regression;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import redoc.controller.EmployeeController;
import redoc.dto.EmployeePojo;
import redoc.service.EmployeeService;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerRegressionTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    @DisplayName("Existing API contract should not break")
    void existingApiShouldStillWork() throws Exception {

        EmployeePojo employee = new EmployeePojo();
        employee.setEmpName("Sai");
        employee.setEmpLocation("Hyderabad");

        when(employeeService.findEmpListByLocation("Hyderabad"))
                .thenReturn(List.of(employee));

        mockMvc.perform(get("/employee/findEmployeesByLocation")
                        .param("location", "Hyderabad")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].empName").value("Sai"))
                .andExpect(jsonPath("$[0].empLocation").value("Hyderabad"));
    }
}