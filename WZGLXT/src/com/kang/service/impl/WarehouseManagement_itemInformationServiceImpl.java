package com.kang.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.WarehouseManagement_itemInformationMapper;
import com.kang.pojo.WarehouseManagement_itemInformation;
import com.kang.service.WarehouseManagement_itemInformationService;
@Service
public class WarehouseManagement_itemInformationServiceImpl implements WarehouseManagement_itemInformationService{

	@Resource
	private WarehouseManagement_itemInformationMapper wm_ifm;
	
	@Override
	public List<WarehouseManagement_itemInformation> selectkucunone() {
		// TODO Auto-generated method stub
		return wm_ifm.selectkucunone();
	}

	@Override
	public Integer insertWarehouseManagementID(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return wm_ifm.insertWarehouseManagementID(map);
	}

}
