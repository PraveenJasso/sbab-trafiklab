package route.com.kc.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import route.com.kc.dto.RouteDTO;
import route.com.kc.dto.RouteSatDTO;

@Slf4j
@Service
public class RouteServiceImpl implements RouteService {

	@Value("${route.api.url}")
	private String routeAPIURL;
	
	@Value("${max.top.result.size}")
	private int topResultSize;
	
	@Autowired
	private final RestTemplate restTemplate;
	
	public RouteServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@Override
	public List<RouteDTO> getTrafficInformationByModel(String model){
		List<RouteDTO> res = makeCallToRouteAPI(routeAPIURL,model);
		return res;
	}

	private List<RouteDTO> makeCallToRouteAPI(String url,String model) {
		ResponseEntity<Map> res = restTemplate
				.getForEntity(url+"&model="+model, Map.class);
		List<RouteDTO> routes = new ArrayList<RouteDTO>();
		if(Objects.nonNull(res)) {
			Map<String, Object> responseData =(Map<String, Object>) res.getBody().get("ResponseData");
			if(Objects.nonNull(responseData)) {
				ModelMapper modelMapper = new ModelMapper();
				Type typeOf = new TypeToken<List<RouteDTO>>() {}.getType();
				routes = modelMapper.map(responseData.get("Result"),typeOf );
			}
		}
		return routes;
	}

	@Override
	@Transactional
	public List<RouteSatDTO> getTopRoutes(String model) {
		List<RouteDTO> res = makeCallToRouteAPI(routeAPIURL, model);
		if (null != res) {
			Map<String, Long> multipleFieldsMap = res.stream()
					.collect(Collectors.groupingBy(RouteDTO::getStopAreaNumber, Collectors.counting()));

			List<RouteSatDTO> result = new ArrayList<RouteSatDTO>();

			multipleFieldsMap.forEach((k, v) -> {
				RouteSatDTO value = new RouteSatDTO();
				value.setCount(v);
				value.setStopAreaNumber(k);
				result.add(value);
			});

			List<RouteSatDTO> finalRes = result.stream()
					.sorted(Comparator.comparingLong(RouteSatDTO::getCount).reversed()).collect(Collectors.toList());

			return finalRes.stream().limit(topResultSize).collect(Collectors.toList());
		}
		return null;
	}
	
	@Override
	public List<RouteDTO> listAllStopPoints(String model, String stopPointNumber) {
		String url = routeAPIURL + "&StopAreaNumber="+stopPointNumber;
		List<RouteDTO> res = makeCallToRouteAPI(url,model);
		return res;
	}
}
