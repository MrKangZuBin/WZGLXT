package com.kang.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.InventoryLossMapper;
import com.kang.pojo.InventoryLoss;
import com.kang.pojo.InventoryLossPoJo;
import com.kang.service.InventoryLossService;
@Service
public class InventoryLossServiceImpl implements InventoryLossService{

	@Resource
	private InventoryLossMapper ilm;
	
	@Override
	public List<InventoryLoss> selectbaosunone(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return ilm.selectbaosunone(map);
	}

	@Override
	public int countbaosun() {
		// TODO Auto-generated method stub
		return ilm.countbaosun();
	}

	@Override
	public InventoryLoss selectbaosunById(Integer inventorylossid) {
		// TODO Auto-generated method stub
		return ilm.selectbaosunById(inventorylossid);
	}

	@Override
	public int updatebaosun(InventoryLoss il) {
		// TODO Auto-generated method stub
		return ilm.updateByPrimaryKeySelective(il);
	}

	@Override
	public List<InventoryLossPoJo> selectByWheres(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ilm.selectByWheres(map);
	}

	@Override
	public int insert(InventoryLoss itl) {
		// TODO Auto-generated method stub
		return ilm.insertSelective(itl);
	}

	@Override
	public InventoryLoss selectByNumber(String lossnumber) {
		// TODO Auto-generated method stub
		return ilm.selectByNumber(lossnumber);
	}

	@Override
	public int selectByWherescount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ilm.selectByWherescount(map);
	}

}
