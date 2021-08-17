package route.com.kc.service;

import java.util.List;

import route.com.kc.dto.RouteDTO;
import route.com.kc.dto.RouteSatDTO;

public interface RouteService {
	
	List<RouteDTO> getTrafficInformationByModel(String model);
	
	List<RouteSatDTO> getTopRoutes(String model);
	
	List<RouteDTO> listAllStopPoints(String model,String stopPointNumber);
}
