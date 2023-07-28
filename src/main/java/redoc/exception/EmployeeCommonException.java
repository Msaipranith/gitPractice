package redoc.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
public class EmployeeCommonException extends RuntimeException {
	private String message;

	public EmployeeCommonException(String mess) {
		super();
		this.message = mess;
	}

}
