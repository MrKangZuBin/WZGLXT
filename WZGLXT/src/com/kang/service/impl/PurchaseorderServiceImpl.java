package com.kang.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.PurchaseOrderMapper;
import com.kang.pojo.Grouppojo;
import com.kang.pojo.PurOrderReport;
import com.kang.pojo.PurchaseOrder;
import com.kang.service.PurchaseorderService;

@Service("PurchaseorderService")
public class PurchaseorderServiceImpl implements PurchaseorderService{

	@Resource
	private PurchaseOrderMapper pco;
	
	
	@Override
	public List<PurchaseOrder> selectPurchaseOrder(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return pco.selectPurchaseOrder(map);
	}


	@Override
	public int selectcountPurchaseOrder() {
		// TODO Auto-generated method stub
		return pco.selectcountPurchaseOrder();
	}


	@Override
	public PurchaseOrder selectonePurchaseOrder(int id) {
		// TODO Auto-generated method stub
		return pco.selectByPrimaryKey(id);
	}


	@Override
	public PurchaseOrder selectcaigouinsert(Integer purchaseorderid) {
		// TODO Auto-generated method stub
		return pco.selectcaigouinsert(purchaseorderid);
	}


	@Override
	public int deleteone(int id) {
		// TODO Auto-generated method stub
		return pco.deleteByPrimaryKey(id);
	}


	@Override
	public List<PurchaseOrder> selPurchase(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return pco.selPurchase(map);
	}


	@Override
	public List<Grouppojo> selPurchaseOrders(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return pco.selPurOrder(map);
	}


	@Override
	public Map<String, Object> selPurchaseOrder(Map<String, Object> map) {
		int pagecount = 5;
		int rowcount = 0;
		int currpage = 1;
		if (map.get("currpage") != null) {
			currpage = (int) map.get("currpage");
		}
		Map<String, Object> pramerte = new HashMap();
		pramerte.put("orderNumber", map.get("orderNumber"));
		pramerte.put("orderDes", map.get("orderDes"));
		pramerte.put("orderStatus", map.get("orderStatus"));
		pramerte.put("postName", map.get("postName"));
		pramerte.put("fristTime", map.get("fristTime"));
		pramerte.put("secondTime", map.get("secondTime"));
		pramerte.put("supplierNumber", map.get("supplierNumber"));
		pramerte.put("supplierName", map.get("supplierName"));
		pramerte.put("bigC", map.get("bigC"));
		rowcount = pco.selectcount(pramerte);
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
		Map<String, Object> tmap = new HashMap();
		tmap.put("currpage", (currpage - 1) * pagecount);
		tmap.put("pagecount", pagecount);
		tmap.put("orderNumber", map.get("orderNumber"));
		tmap.put("orderDes", map.get("orderDes"));
		tmap.put("orderStatus", map.get("orderStatus"));
		tmap.put("postName", map.get("postName"));
		tmap.put("fristTime", map.get("fristTime"));
		tmap.put("secondTime", map.get("secondTime"));
		tmap.put("supplierNumber", map.get("supplierNumber"));
		tmap.put("supplierName", map.get("supplierName"));
		tmap.put("bigC", map.get("bigC"));
		List<PurchaseOrder> po =pco.selPurOrderList(tmap) ;
		maps.put("po", po);
		return maps;
	}

	@Override
	public List<Grouppojo> selgroup(Map<String, Object> map) {
		return pco.selgrou(map);
	}
	@Override
	public Integer insertPur(Grouppojo gpojo) {
		// TODO Auto-generated method stub
		//pur.getOrdernumber();
		return pco.insert(gpojo);
	}
	@Override
	public List<PurchaseOrder> selitemcaigoubaobiaoone(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return pco.selitemcaigoubaobiaoone(map);
	}
	@Override
	public List<PurOrderReport> selitemcaigoubaobiaotwo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return pco.selitemcaigoubaobiaotwo(map);
	}
	@Override
	public Integer count(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return pco.count(map);
	}
	@Override
	public int selitemcaigoubaobiaoonecount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return pco.selitemcaigoubaobiaoonecount(map);
	}
	@Override
	public int updateone(PurchaseOrder pur) {
		// TODO Auto-generated method stub
		return pco.updateByPrimaryKeySelective(pur);
	}


	@Override
	public Integer selcount() {
		// TODO Auto-generated method stub
		return pco.selcount();
	}


	@Override
	public Integer waitMePlay(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return pco.waitMePlay(map);
	}


	@Override
	public Integer Played(Integer id) {
		// TODO Auto-generated method stub
		return pco.played(id);
	}


	@Override
	public Integer MyDJ(Integer id) {
		// TODO Auto-generated method stub
		return pco.MyDJ(id);
	}


	@Override
	public Integer notgMyDJ(Integer id) {
		// TODO Auto-generated method stub
		return pco.notgMyDJ(id);
	}


	@Override
	public Integer insertSelective(PurchaseOrder record) {
		// TODO Auto-generated method stub
		return pco.insertSelective(record);
	}


	@Override
	public PurchaseOrder selectObject(String ordernumber) {
		// TODO Auto-generated method stub
		return pco.selectObject(ordernumber);
	}
}
