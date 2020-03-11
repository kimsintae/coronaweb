package com.myweb.corona.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.corona.dto.PaInfo;
import com.myweb.corona.dto.PaRoute;
import com.myweb.corona.mapper.PaInfoMapper;

@Service
public class PaInfoService {
	
	@Autowired
	private PaInfoMapper paInfoMapper;
	
	
	public List<PaInfo> getInfo() throws Exception{
		return paInfoMapper.getInfo();
	}
	
	public List<PaRoute> getRoute(int no) throws Exception{
		return paInfoMapper.getRoute(no);
	}
	
	public int addPatient(PaInfo paInfo)throws Exception{
		return paInfoMapper.addPatient(paInfo);
	}
	
	public int addRoute(Map<String, List<PaRoute>> routeMap)throws Exception{
		return paInfoMapper.addRoute(routeMap);
	}
}
