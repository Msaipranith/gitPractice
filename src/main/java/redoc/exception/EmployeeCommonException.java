package redoc.exception;

@SuppressWarnings("serial")
public class EmployeeCommonException extends RuntimeException {
	private String message;

	public EmployeeCommonException(String mess) {
		super();
		this.message = mess;
	}

	
	
	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public EmployeeCommonException() {
		super();
	}

	
}
