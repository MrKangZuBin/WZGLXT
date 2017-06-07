package com.kang.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.WarehouseManagementMapper;
import com.kang.pojo.Shop_user;
import com.kang.pojo.WarehouseManagement;
import com.kang.pojo.WarehouseUser;
import com.kang.service.WarehouseManagementService;

@Service
public class WarehouseManagementServiceImpl implements WarehouseManagementService{

	@Resource
	private WarehouseManagementMapper whm;
	
	@Override
	public WarehouseManagement selectById(int warehousemanagementid) {
		// TODO Auto-generated method stub
		return whm.selectByPrimaryKey(warehousemanagementid);
	}

	@Override
	public List<WarehouseManagement> selectAll() {
		// TODO Auto-generated method stub
		return whm.selectall();
	}

	@Override
	public List<WarehouseManagement> selectbaosunone() {
		// TODO Auto-generated method stub
		return whm.selectbaosunone();
	}

	@Override
	public WarehouseManagement selectbaosunById(Integer warehousemanagementid) {
		// TODO Auto-generated method stub
		return whm.selectbaosunById(warehousemanagementid);
	}

	@Override
	public WarehouseManagement selById(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return whm.selbyid(map);
	}

	@Override
	public Map<String, Object> findPagingList(Map<String, Object> pramertes) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int pagecount = 7;
		int rowcount = 0;
		int currpage = 1;
		if (pramertes.get("currpage") != null) {
			currpage = (int) pramertes.get("currpage");
		}
		Map<String, Object> pramerte = new HashMap();
		pramerte.put("warehousecode", pramertes.get("warehousecode"));
		pramerte.put("warehousename", pramertes.get("warehousename"));
		pramerte.put("status", pramertes.get("status"));
		rowcount = whm.selrow(pramerte);
		int totalpage = (rowcount - 1 + pagecount) / pagecount;
		if (currpage > totalpage) {
			currpage = totalpage;
		}
		if (currpage < 1) {
			currpage = 1;
		}
		Map<String, Object> maps = new HashMap();
		maps.put("totalpage", totalpage);
		maps.put("rowcount", rowcount);
		maps.put("currpage", currpage);
		maps.put("pagecount", pagecount);
		Map<String, Object> map = new HashMap();
		map.put("currpage", (currpage - 1) * pagecount);
		map.put("pagecount", pagecount);
		map.put("warehousecode", pramertes.get("warehousecode"));
		map.put("warehousename", pramertes.get("warehousename"));
		map.put("status", pramertes.get("status"));
		List<WarehouseUser> list = whm.findPagingList(map);
		maps.put("list", list);
		return maps;
	}

	@Override
	public int deleteByPrimaryKey(Integer warehousemanagementid) {
		// TODO Auto-generated method stub
		return whm.deleteByPrimaryKey(warehousemanagementid);
	}

	@Override
	public int insert(WarehouseManagement record) {
		// TODO Auto-generated method stub
		return whm.insert(record);
	}

	@Override
	public int insertSelective(WarehouseManagement record) {
		// TODO Auto-generated method stub
		return whm.insertSelective(record);
	}

	@Override
	public WarehouseManagement selectByPrimaryKey(Integer warehousemanagementid) {
		// TODO Auto-generated method stub
		return whm.selectByPrimaryKey(warehousemanagementid);
	}

	@Override
	public int updateByPrimaryKeySelective(WarehouseManagement record) {
		// TODO Auto-generated method stub
		return whm.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(WarehouseManagement record) {
		// TODO Auto-generated method stub
		return whm.updateByPrimaryKey(record);
	}

}
