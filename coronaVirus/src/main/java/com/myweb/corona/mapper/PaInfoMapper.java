package com.myweb.corona.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.myweb.corona.dto.PaInfo;
import com.myweb.corona.dto.PaRoute;

@Mapper
@Repository
public interface PaInfoMapper {
	
	List<PaInfo> getInfo()throws Exception;
	
	List<PaRoute> getRoute(int no)throws Exception;
	
	int addPatient(PaInfo paInfo)throws Exception;
	
	int addRoute(Map<String, List<PaRoute>> routeMap)throws Exception;
}
