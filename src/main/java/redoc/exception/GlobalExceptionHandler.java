package redoc.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeCommonException.class)
	public ResponseEntity<ExceptionResponse> handleEmployeeCommonException(EmployeeCommonException ex,
			HttpServletRequest request) {

		ExceptionResponse er = new ExceptionResponse();
		er.setTimestamp(LocalDateTime.now());
		er.setStatus(HttpStatusCode.valueOf(404));
		//er.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
		er.setMessage(ex.getMessage());
		er.setPath(request.getRequestURI());

		return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
	}
}
