package com.kang.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.PurchaseOrderMapper;
import com.kang.dao.WarehouseOrderMapper;
import com.kang.pojo.PurchaseOrder;
import com.kang.pojo.WareOrderReport;
import com.kang.pojo.WarehouseOrder;
import com.kang.pojo.WarehousePoJo;
import com.kang.service.PurchaseorderService;
import com.kang.service.warehouseOrderService;

@Service
public class warehouseOrderServiceImpl implements warehouseOrderService{

	@Resource
	private WarehouseOrderMapper who;

	@Override
	public List<WarehouseOrder> selectWarehouseOrder(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return who.selectWarehouseOrder(map);
	}

	@Override
	public int selectcountWarehouseOrder() {
		// TODO Auto-generated method stub
		return who.selectcountWarehouseOrder();
	}

	@Override
	public WarehouseOrder selectonePurchaseOrder(int purchaseordereid) {
		// TODO Auto-generated method stub
		return who.selectByPrimaryKey(purchaseordereid);
	}

	@Override
	public int insertone(WarehouseOrder wo) {
		// TODO Auto-generated method stub
		return who.insertSelective(wo);
	}

	@Override
	public WarehouseOrder selectoneid(String warehousenumber) {
		// TODO Auto-generated method stub
		return who.selectoneid(warehousenumber);
	}
	
	@Override
	public List<WarehousePoJo> selectByWheres(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return who.selectByWheres(map);
	}

	@Override
	public List<WareOrderReport> selectwupingcaigoubaobiao(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return who.selectwupingcaigoubaobiao(map);
	}

	@Override
	public List<WareOrderReport> selectwupingcaigoubaobiaotwo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return who.selectwupingcaigoubaobiaotwo(map);
	}

	@Override
	public int selectwupingcaigoubaobiaocount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return who.selectwupingcaigoubaobiaocount(map);
	}

	@Override
	public int selectwupingcaigoubaobiaotwocount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return who.selectwupingcaigoubaobiaotwocount(map);
	}

	@Override
	public int selectByWherescount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return who.selectByWherescount(map);
	}
	
	
	
}
