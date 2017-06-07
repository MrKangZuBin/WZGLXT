package com.kang.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.kang.dao.ProvinceCityMapper;
import com.kang.pojo.ProvinceCity;
import com.kang.service.AreasService;
@Service
public class AreasServiceImpl implements AreasService{
	
	@Resource
	private ProvinceCityMapper areasDao;

	@Override
	public List<ProvinceCity> queryAreas(Integer pid) {
		// TODO Auto-generated method stub
		return areasDao.queryAreas(pid);
	}
	
}
