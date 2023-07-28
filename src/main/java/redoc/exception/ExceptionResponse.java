package redoc.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
	private LocalDateTime timestamp;
    private HttpStatusCode status;
   // private String error;
    private String message;
    private String path;
	
}
