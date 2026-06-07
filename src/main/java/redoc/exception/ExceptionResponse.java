package redoc.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatusCode;

public class ExceptionResponse {
	
	private LocalDateTime timestamp;
    private HttpStatusCode status;
   // private String error;
    private String message;
    private String path;
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public HttpStatusCode getStatus() {
		return status;
	}
	public void setStatus(HttpStatusCode status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public ExceptionResponse() {
		super();
	}
	public ExceptionResponse(LocalDateTime timestamp, HttpStatusCode status, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
		this.path = path;
	}
    
    
    
	
}
