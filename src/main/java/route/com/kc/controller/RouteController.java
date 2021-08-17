package route.com.kc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import route.com.kc.dto.RouteDTO;
import route.com.kc.dto.RouteSatDTO;
import route.com.kc.service.RouteService;

@RestController
@RequestMapping("/v1/routes")
public class RouteController {
	
	@Autowired
	private final RouteService routeService;
	
	public RouteController(RouteService routeService) {	
		this.routeService = routeService;
	}
	
	@GetMapping
	public ResponseEntity<List<RouteDTO>> getTrafficInformationByModel(@RequestParam String model) {
		List<RouteDTO> res = this.routeService.getTrafficInformationByModel(model);
		if (CollectionUtils.isEmpty(res)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@GetMapping("/toproutes")
	public ResponseEntity<List<RouteSatDTO>> getTopRoutesByModel(@RequestParam String model) {
		List<RouteSatDTO> res = this.routeService.getTopRoutes(model);
		if (CollectionUtils.isEmpty(res)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@GetMapping("/{stopAreaNumber}/liststoppoints")
	public ResponseEntity<List<RouteDTO>> listAllStopPoints(@RequestParam String model, @PathVariable String stopAreaNumber) {
		List<RouteDTO> res = this.routeService.listAllStopPoints(model, stopAreaNumber);
		if (CollectionUtils.isEmpty(res)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}
