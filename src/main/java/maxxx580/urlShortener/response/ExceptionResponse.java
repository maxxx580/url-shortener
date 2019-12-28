package maxxx580.urlShortener.response;

import java.util.Date;

public class ExceptionResponse {
	
	private Date timestamp;
	private String message;
	private String detail;
	
	public ExceptionResponse(Date timestamp, String message, String detail) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [timestamp=" + timestamp + ", message=" + message + ", detail=" + detail + "]";
	} 
}
