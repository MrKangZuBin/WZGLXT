package com.kang.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.InventoryMapper;
import com.kang.pojo.Inventory;
import com.kang.pojo.InventoryPoJo;
import com.kang.pojo.PandianReport;
import com.kang.service.InventoryService;
@Service
public class InventoryServiceImpl implements InventoryService{

	@Resource
	private InventoryMapper itm;
	
	@Override
	public List<Inventory> selectpandianone(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return itm.selectpandianone(map);
	}

	@Override
	public int countpandian() {
		// TODO Auto-generated method stub
		return itm.countpandian();
	}

	@Override
	public Inventory selectpandian(Integer inventoryid) {
		// TODO Auto-generated method stub
		return itm.selectpandian(inventoryid);
	}

	@Override
	public int updatepandian(Inventory it) {
		// TODO Auto-generated method stub
		return itm.updateByPrimaryKeySelective(it);
	}

	@Override
	public List<InventoryPoJo> selectByWheres(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return itm.selectByWheres(map);
	}

	@Override
	public Inventory selectByNumber(String inventorynumber) {
		// TODO Auto-generated method stub
		return itm.selectByNumber(inventorynumber);
	}

	@Override
	public int insert(Inventory invent) {
		// TODO Auto-generated method stub
		return itm.insertSelective(invent);
	}

	@Override
	public List<PandianReport> selectkucunpandianbaobiao(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return itm.selectkucunpandianbaobiao(map);
	}

	@Override
	public int selectkucunpandianbaobiaocount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return itm.selectkucunpandianbaobiaocount(map);
	}

	@Override
	public int selectByWherescount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return itm.selectByWherescount(map);
	}
	
	
	


}
