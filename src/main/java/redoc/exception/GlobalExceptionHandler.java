package redoc.exception;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import redoc.controller.CustomerController;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

//	@ExceptionHandler(EmployeeCommonException.class)
//	public ResponseEntity<ExceptionResponse> handleEmployeeCommonException(EmployeeCommonException ex,
//			HttpServletRequest request) {
//
//		ExceptionResponse er = new ExceptionResponse();
//		er.setTimestamp(LocalDateTime.now());
//		er.setStatus(HttpStatusCode.valueOf(404));
//		//er.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
//		er.setMessage(ex.getMessage());
//		er.setPath(request.getRequestURI());
//
//		return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
//	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ExceptionResponse> handleRunTimeException(RuntimeException ex,
																		   HttpServletRequest request) {

		ExceptionResponse er = new ExceptionResponse();
		er.setTimestamp(LocalDateTime.now());
		er.setStatus(HttpStatusCode.valueOf(500));
		//er.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
		er.setMessage(ex.getMessage());
		er.setPath(request.getRequestURI());
		try {
			return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			LOGGER.warn(e.getMessage());
		}

        return null;
    }


}
