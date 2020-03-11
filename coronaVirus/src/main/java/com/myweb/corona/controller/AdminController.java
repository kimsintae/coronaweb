package com.myweb.corona.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myweb.corona.dto.PaInfo;
import com.myweb.corona.dto.PaRoute;
import com.myweb.corona.service.PaInfoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	PaInfoService paInfoService;
	
	@PostMapping("/insertData")
	public Map<String, String> insertData(PaInfo paInfo){
		List<PaRoute> routes = paInfo.getRoute();
		Map<String, String> message = new HashMap<String, String>();
		Map<String, List<PaRoute>> routeMap = new HashMap<String, List<PaRoute>>();
		
		int addInfoResult;
		int addRouteResult;
		try {
			addInfoResult = paInfoService.addPatient(paInfo);
			
			
			if(addInfoResult>0){
				
				
				for(PaRoute route : routes){
					//확진자 추가시 생성된 no 값을 셋팅
					route.setPaNo(paInfo.getNo());				
				}
				
				routeMap.put("routes", routes);
				
				addRouteResult = paInfoService.addRoute(routeMap);
				
				if(addRouteResult>0){
					message.put("success", "확진자 정보가 추가 되었습니다.");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return message;
	}
	
}
