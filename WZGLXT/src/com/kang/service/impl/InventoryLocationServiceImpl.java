package com.kang.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.InventoryLocationMapper;
import com.kang.pojo.Category;
import com.kang.pojo.InventoryLocation;
import com.kang.pojo.InventoryLocationUser;
import com.kang.service.InventoryLocationService;

@Service
public class InventoryLocationServiceImpl implements InventoryLocationService{

	@Resource
	private InventoryLocationMapper itl;
	
	@Override
	public InventoryLocation selectById(Integer inventorylocationid) {
		// TODO Auto-generated method stub
		return itl.selectByPrimaryKeys(inventorylocationid);
	}

	@Override
	public List<InventoryLocation> selectInventoryLocationAll() {
		// TODO Auto-generated method stub
		return itl.selectInventoryLocationall();
	}

	@Override
	public List<InventoryLocation> selectkucunone() {
		// TODO Auto-generated method stub
		return itl.selectkucunone();
	}

	@Override
	public List<InventoryLocation> selectcaigou() {
		// TODO Auto-generated method stub
		return itl.selectcaigou();
	}

	@Override
	public Map<String, Object> findPagingList(Map<String, Object> pramertes) {
		// TODO Auto-generated method stub
		int pagecount = 7;
		int rowcount = 0;
		int currpage = 1;
		if (pramertes.get("pcurrpage") != null) {
			currpage = (int) pramertes.get("pcurrpage");
		}
		Map<String, Object> pramerte = new HashMap();
		pramerte.put("firstid", pramertes.get("firstid"));
		pramerte.put("secondid", pramertes.get("secondid"));
		rowcount = itl.selrow(pramerte);
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
		map.put("firstid", pramertes.get("firstid"));
		map.put("secondid", pramertes.get("secondid"));
		List<InventoryLocationUser> list = itl.findPagingList(map);
		maps.put("list", list);
		return maps;
	}

	@Override
	public int deletenext(Integer inventorylocationid) {
		// TODO Auto-generated method stub
		return itl.deletenext(inventorylocationid);
	}

	@Override
	public List<InventoryLocationUser> inventorylocationList() {
		// TODO Auto-generated method stub
		return itl.inventorylocationList();
	}

	@Override
	public List<InventoryLocation> selectid(Integer inventorylocationid) {
		// TODO Auto-generated method stub
		return itl.selectid(inventorylocationid);
	}

	@Override
	public int deleteByPrimaryKey(Integer inventorylocationid) {
		// TODO Auto-generated method stub
		return itl.deleteByPrimaryKey(inventorylocationid);
	}

	@Override
	public int insert(InventoryLocation record) {
		// TODO Auto-generated method stub
		return itl.insert(record);
	}

	@Override
	public int insertSelective(InventoryLocation record) {
		// TODO Auto-generated method stub
		return itl.insertSelective(record);
	}

	@Override
	public InventoryLocation selectByPrimaryKey(Integer inventorylocationid) {
		// TODO Auto-generated method stub
		return itl.selectByPrimaryKey(inventorylocationid);
	}

	@Override
	public int updateByPrimaryKeySelective(InventoryLocation record) {
		// TODO Auto-generated method stub
		return itl.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(InventoryLocation record) {
		// TODO Auto-generated method stub
		return itl.updateByPrimaryKey(record);
	}

	@Override
	public InventoryLocation selectInventoryLocationid(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return itl.selectInventoryLocationid(map);
	}

}
