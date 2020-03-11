package com.myweb.corona.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myweb.corona.dto.PaInfo;
import com.myweb.corona.dto.PaRoute;
import com.myweb.corona.service.PaInfoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class PatientController {
	
	@Autowired
	PaInfoService paInfoService;


	@RequestMapping("/getPatients")
	public Map<String, List<PaInfo>> getRoute(){
		List<PaInfo> infos = null;
		Map<String, List<PaInfo>> retulstMap = new HashMap<String, List<PaInfo>>();
		try {
			infos = paInfoService.getInfo();
			
			for(PaInfo pa : infos){
				List<PaRoute> routes = paInfoService.getRoute(pa.getNo());
				pa.setRoute(routes);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		retulstMap.put("data", infos);
		
		return retulstMap;
	}
	
	
	
	/*
	 * 자가격리자 현황
	 */
	@RequestMapping("/getIsolationStatus")
	@ResponseBody
	public Map<String, String> getIsolationStatus(){

		Map<String, String> statusTable = new HashMap<String,String>();
		
		try {
			Document doc = Jsoup.connect("https://www.anyang.go.kr/").get();
			
			
			Elements items = doc.select(".type2");
			
			// 전국 현황
			statusTable.put("total", items.get(0).getElementsByTag("tbody").toString());
			
			// 안양 현황
			statusTable.put("anyang", items.get(2).getElementsByTag("tbody").toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return statusTable;
	}

}
