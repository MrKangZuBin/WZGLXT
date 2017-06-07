package com.kang.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.Warehouse_itemInformationMapper;
import com.kang.pojo.Warehouse_itemInformation;
import com.kang.service.warehouseOrder_itemInformationService;

@Service
public class warehouseOrder_itemInformationServiceImpl  implements warehouseOrder_itemInformationService{

	@Resource
	private Warehouse_itemInformationMapper who_iif;
	
	@Override
	public List<Warehouse_itemInformation> selectWarehouseOrder_itemInformation() {
		// TODO Auto-generated method stub
		return who_iif.selectWarehouse_itemInformation();
	}

	@Override
	public Warehouse_itemInformation selectByPurchaseOrderid(Integer purchaseorderid) {
		// TODO Auto-generated method stub
		return who_iif.selectByPurchaseOrderid(purchaseorderid);
	}

	@Override
	public int insertone(Warehouse_itemInformation record) {
		// TODO Auto-generated method stub
		return who_iif.insertSelective(record);
	}

	@Override
	public Warehouse_itemInformation selitemcaigoubaobiaothree(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return who_iif.selitemcaigoubaobiaothree(map);
	}

	
	
}
