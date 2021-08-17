package route.com.kc.dto;

import java.util.Map;

public class RouteResponse {
	
	private int StatusCode;
	private String Message;
	private int ExecutionTime;
	private Map ResponseData;
	public int getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(int statusCode) {
		StatusCode = statusCode;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public int getExecutionTime() {
		return ExecutionTime;
	}
	public void setExecutionTime(int executionTime) {
		ExecutionTime = executionTime;
	}
	public Map getResponseData() {
		return ResponseData;
	}
	public void setResponseData(Map responseData) {
		ResponseData = responseData;
	}
	
	
}
