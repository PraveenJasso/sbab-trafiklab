package route.com.kc.dto;

import java.util.List;

public class ResponseData {
	
	private String Version;
	private String Type;
	private List<RouteDTO> Result;
	
	public String getVersion() {
		return Version;
	}
	public void setVersion(String version) {
		Version = version;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public List<RouteDTO> getResult() {
		return Result;
	}
	public void setResult(List<RouteDTO> result) {
		Result = result;
	}
	
	
}
