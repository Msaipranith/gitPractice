package redoc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeePojo {
	private long id;
	private String empName;
	private String empLocation;
	private String empEmail;
	private Double salary;
	private LocalDate createdAt;
	private  LocalDate updatedAt;
	
	
	
}
