package com.kang.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.IntemInformationMapper;
import com.kang.pojo.AddItem;
import com.kang.pojo.Grouppojo;
import com.kang.pojo.IntemInformation;
import com.kang.pojo.InventoryIteminfo;
import com.kang.pojo.Purrequisition;
import com.kang.pojo.StockPoJo;
import com.kang.service.IntemInformationService;

@Service("IntemInformationService")
public class IntemInformationServiceImpl implements IntemInformationService {

	@Resource
	private IntemInformationMapper iif;

	@Override
	public List<IntemInformation> selectIntemInformation() {
		// TODO Auto-generated method stub
		return iif.selectIntemInformation();
	}

	@Override
	public IntemInformation selectByID(Integer inteminformationid) {
		// TODO Auto-generated method stub
		return iif.selectByID(inteminformationid);
	}
	@Override
	public List<IntemInformation> selListIIf() {
		// TODO Auto-generated method stub
		return iif.selInf();
	}
	@Override
	public int insert(IntemInformation record) {
		// TODO Auto-generated method stub
		return iif.insert(record);
	}

	@Override
	public int insertSelective(IntemInformation record) {
		// TODO Auto-generated method stub
		return iif.insertSelective(record);
	}

	@Override
	public List<IntemInformation> selectByPrimaryKey(Integer inteminformationid) {
		// TODO Auto-generated method stub
		return iif.selectByPrimaryKey(inteminformationid);
	}

	@Override
	public int updateByPrimaryKeySelective(IntemInformation record) {
		// TODO Auto-generated method stub
		return iif.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(IntemInformation record) {
		// TODO Auto-generated method stub
		return iif.updateByPrimaryKey(record);
	}

	@Override
	public Map<String, Object> findPagingList(Map<String, Object> pramertes) {
		// TODO Auto-generated method stub
		int pagecount = 5;
		int rowcount = 0;
		int currpage = 1;
		if (pramertes.get("currpage") != null) {
			currpage = (int) pramertes.get("currpage");
		}
		Map<String, Object> pramerte = new HashMap();
		pramerte.put("itemcode", pramertes.get("itemcode"));
		pramerte.put("itemname", pramertes.get("itemname"));
		pramerte.put("itemstatus", pramertes.get("itemstatus"));
		pramerte.put("itemmaterial", pramertes.get("itemmaterial"));
		rowcount = iif.selrow(pramerte);
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
		map.put("itemcode", pramertes.get("itemcode"));
		map.put("itemname", pramertes.get("itemname"));
		map.put("itemstatus", pramertes.get("itemstatus"));
		map.put("itemmaterial", pramertes.get("itemmaterial"));
		List<IntemInformation> list = iif.findPagingList(map);
		maps.put("list", list);
		return maps;
	}

	@Override
	public int deleteByPrimaryKey(Integer inteminformationid) {
		// TODO Auto-generated method stub
		return iif.deleteByPrimaryKey(inteminformationid);
	}

	@Override
	public List<IntemInformation> selectkucunone(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return iif.selectStock(map);
	}

	@Override
	public int countkucun() {
		// TODO Auto-generated method stub
		return iif.countkucun();
	}

	@Override
	public List<IntemInformation> selectdai_request() {
		// TODO Auto-generated method stub
		return iif.selectdai_request();
	}

	@Override
	public IntemInformation selectcaigou(Integer inteminformationid) {
		// TODO Auto-generated method stub
		return iif.selectcaigou(inteminformationid);
	}

	@Override
	public List<IntemInformation> sellist() {
		// TODO Auto-generated method stub
		return iif.sellist();
	}

	@Override
	public int updatereturngood(IntemInformation inf) {
		// TODO Auto-generated method stub
		return iif.updateByPrimaryKeySelective(inf);
	}

	@Override
	public int insertItem(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return iif.insertItem(map);
	}

	@Override
	public List<StockPoJo> selectByWheres(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return iif.selectByWheres(map);
	}

	@Override
	public List<IntemInformation> selectByItemname(String chinesename) {
		// TODO Auto-generated method stub
		return iif.selectByItemname(chinesename);
	}
	
	@Override
	public int selectByWherescount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return iif.selectByWherescount(map);
	}

	@Override
	public List<InventoryIteminfo> inventoryIteminfo(Map<String, Object> pramertes) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap();
		map.put("itemcode", pramertes.get("itemcode"));
		map.put("itemname", pramertes.get("itemname"));
		map.put("warningtype", pramertes.get("warningtype"));
		map.put("itemmaterial", pramertes.get("itemmaterial"));
		List<InventoryIteminfo> list = iif.inventoryIteminfo(map);
		return list;
	}

	@Override
	public List<AddItem> selAddItem() {
		// TODO Auto-generated method stub
		return iif.selectAddItem();
	}

	@Override
	public List<Grouppojo> selReturnItem(Integer returnID) {
		// TODO Auto-generated method stub
		return iif.selreturnItem(returnID);
	}

	@Override
	public List<IntemInformation> selectItem(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return iif.selectItem(map);
	}

	@Override
	public List<IntemInformation> selpurjson(List<IntemInformation> list) {
		// TODO Auto-generated method stub
		return iif.selpurjson(list);
	}
}
