package com.kang.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.SupplyAgreementMapper;
import com.kang.dao.SupplyAgreement_itemInformationMapper;
import com.kang.pojo.Supplier;
import com.kang.pojo.SupplyAgreement;
import com.kang.pojo.SupplyAgreement_itemInformation;
import com.kang.pojo.SupplyAgreement_user;
import com.kang.service.SupplyAgreementService;
@Service
public class SupplyAgreementServiceImpl implements SupplyAgreementService {

	@Resource
	private SupplyAgreementMapper sa;
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
		pramerte.put("protocolcode", pramertes.get("protocolcode"));
		//pramerte.put("companyid", pramertes.get("companyid"));
		pramerte.put("protocolexplain", pramertes.get("protocolexplain"));
		pramerte.put("suppliercode", pramertes.get("suppliercode"));
		pramerte.put("protocostatus", pramertes.get("protocostatus"));
		pramerte.put("suppliername", pramertes.get("suppliername"));
		pramerte.put("starttime1", pramertes.get("starttime1"));
		pramerte.put("starttime2", pramertes.get("starttime2"));
		pramerte.put("endtime1", pramertes.get("endtime1"));
		pramerte.put("endtime2", pramertes.get("endtime2"));
		rowcount = sa.selrow(pramerte);
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
		map.put("protocolcode", pramertes.get("protocolcode"));
		//map.put("companyid", pramertes.get("companyid"));
		map.put("protocolexplain", pramertes.get("protocolexplain"));
		map.put("suppliercode", pramertes.get("suppliercode"));
		map.put("protocostatus", pramertes.get("protocostatus"));
		map.put("suppliername", pramertes.get("suppliername"));
		map.put("starttime1", pramertes.get("starttime1"));
		map.put("starttime2", pramertes.get("starttime2"));
		map.put("endtime1", pramertes.get("endtime1"));
		map.put("endtime2", pramertes.get("endtime2"));
		List<SupplyAgreement_user> list = sa.findPagingList(map);
		maps.put("list", list);
		return maps;
	}

	@Override
	public int deleteByPrimaryKey(Integer supplyagreementid) {
		// TODO Auto-generated method stub
		return sa.deleteByPrimaryKey(supplyagreementid);
	}

	@Override
	public int insert(SupplyAgreement record) {
		// TODO Auto-generated method stub
		return sa.insert(record);
	}

	@Override
	public int insertSelective(SupplyAgreement record) {
		// TODO Auto-generated method stub
		return sa.insertSelective(record);
	}

	@Override
	public SupplyAgreement_user selectByPrimaryKey(Integer supplyagreementid) {
		// TODO Auto-generated method stub
		return sa.selectByPrimaryKey(supplyagreementid);
	}

	@Override
	public int updateByPrimaryKeySelective(SupplyAgreement record) {
		// TODO Auto-generated method stub
		return sa.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SupplyAgreement record) {
		// TODO Auto-generated method stub
		return sa.updateByPrimaryKey(record);
	}

}
