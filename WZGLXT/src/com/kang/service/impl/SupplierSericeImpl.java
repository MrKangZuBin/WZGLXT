package com.kang.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.SupplierMapper;
import com.kang.pojo.Supplier;
import com.kang.service.SupplierService;

@Service("SupplierService")
public class SupplierSericeImpl implements SupplierService{

	@Resource
	private SupplierMapper sl;
	
	@Override
	public List<Supplier> selectSupplier() {
		// TODO Auto-generated method stub
		return sl.selectSupplier();
	}

	@Override
	public Supplier selectByid(Integer supplierid) {
		// TODO Auto-generated method stub
		return sl.selectByPrimaryKey(supplierid);
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
				pramerte.put("suppliercode", pramertes.get("suppliercode"));
				pramerte.put("suppliername", pramertes.get("suppliername"));
				pramerte.put("supplierstatus", pramertes.get("supplierstatus"));
				rowcount = sl.selrow(pramerte);
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
				map.put("suppliercode", pramertes.get("suppliercode"));
				map.put("suppliername", pramertes.get("suppliername"));
				map.put("supplierstatus", pramertes.get("supplierstatus"));
				List<Supplier> list = sl.findPagingList(map);
				maps.put("list", list);
				return maps;
	}
	@Override
	public Supplier selectSup(String supplierName) {
		// TODO Auto-generated method stub
		return sl.selectSup(supplierName);
	}

	@Override
	public int deleteByPrimaryKey(Integer supplierid) {
		// TODO Auto-generated method stub
		return sl.deleteByPrimaryKey(supplierid);
	}

	@Override
	public int insert(Supplier record) {
		// TODO Auto-generated method stub
		return sl.insert(record);
	}

	@Override
	public int insertSelective(Supplier record) {
		// TODO Auto-generated method stub
		return sl.insertSelective(record);
	}

	@Override
	public Supplier selectByPrimaryKey(Integer supplierid) {
		// TODO Auto-generated method stub
		return sl.selectByPrimaryKey(supplierid);
	}

	@Override
	public int updateByPrimaryKeySelective(Supplier record) {
		// TODO Auto-generated method stub
		return sl.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Supplier record) {
		// TODO Auto-generated method stub
		return updateByPrimaryKey(record);
	}

}
