package com.kang.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.ShopMapper;
import com.kang.pojo.Shop;
import com.kang.pojo.Shop_user;
import com.kang.service.ShopService;
@Service
public class ShopServiceImpl implements ShopService {

	@Resource
	private ShopMapper sm;

	@Override
	public Map<String, Object> findPagingList(Map<String, Object> pramertes) {
		// TODO Auto-generated method stub
				int pagecount = 7;
				int rowcount = 0;
				int currpage = 1;
				if (pramertes.get("currpage") != null) {
					currpage = (int) pramertes.get("currpage");
				}
				Map<String, Object> pramerte = new HashMap();
				pramerte.put("storecode", pramertes.get("storecode"));
				pramerte.put("annexname", pramertes.get("annexname"));
				pramerte.put("annexpath", pramertes.get("annexpath"));
				rowcount = sm.selrow(pramerte);
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
				map.put("storecode", pramertes.get("storecode"));
				map.put("annexname", pramertes.get("annexname"));
				map.put("annexpath", pramertes.get("annexpath"));
				List<Shop_user> list = sm.findPagingList(map);
				maps.put("list", list);
				return maps;
	}

	@Override
	public int deleteByPrimaryKey(Integer shopid) {
		// TODO Auto-generated method stub
		return sm.deleteByPrimaryKey(shopid);
	}

	@Override
	public int insert(Shop record) {
		// TODO Auto-generated method stub
		return sm.insert(record);
	}

	@Override
	public int insertSelective(Shop record) {
		// TODO Auto-generated method stub
		return sm.insertSelective(record);
	}

	@Override
	public Shop_user selectByPrimaryKey(Integer shopid) {
		// TODO Auto-generated method stub
		return sm.selectByPrimaryKey(shopid);
	}

	@Override
	public int updateByPrimaryKeySelective(Shop record) {
		// TODO Auto-generated method stub
		return sm.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Shop record) {
		// TODO Auto-generated method stub
		return sm.updateByPrimaryKey(record);
	}
	
}
