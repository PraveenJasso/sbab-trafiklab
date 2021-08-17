package route.com.kc.dto;

public class RouteSatDTO {
	
	private String StopAreaNumber;
	private Long count;
	public String getStopAreaNumber() {
		return StopAreaNumber;
	}
	public void setStopAreaNumber(String stopAreaNumber) {
		StopAreaNumber = stopAreaNumber;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
}
