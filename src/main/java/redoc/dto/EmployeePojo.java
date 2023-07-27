package redoc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePojo {
	private long id;
	private String empName;
	private String empLocation;
	private String empEmail;
	private Double salary;
}
