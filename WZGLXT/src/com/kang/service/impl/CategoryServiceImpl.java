package com.kang.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.CategoryDao;
import com.kang.pojo.Category;
import com.kang.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Resource
	private CategoryDao dao;
	//根据id删除
	@Override
	public int deleteByPrimaryKey(Integer categoryid) {
		// TODO Auto-generated method stub
		return dao.deleteByPrimaryKey(categoryid);
	}
	//新增
	@Override
	public int insert(Category record) {
		// TODO Auto-generated method stub
		return dao.insert(record);
	}
	//选择性新增数据
	@Override
	public int insertSelective(Category record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}
	//根据id获取对象
	@Override
	public Category selectByPrimaryKey(Integer categoryid) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(categoryid);
	}
	//选择性根据id更新
	@Override
	public int updateByPrimaryKeySelective(Category record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKeySelective(record);
	}
	//根据id更新
	@Override
	public int updateByPrimaryKey(Category record) {
		// TODO Auto-generated method stub
		return dao.updateByPrimaryKey(record);
	}
	//分页查询
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
		rowcount = dao.selrow(pramerte);
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
		List<Category> list = dao.findPagingList(map);
		maps.put("list", list);
		return maps;
	}
	@Override
	public int deletenext(Integer categoryid) {
		return dao.deletenext(categoryid);
	}
	@Override
	public List<Category> selectid(Integer categoryid) {
		return dao.selectid(categoryid);
	}
	@Override
	public List<Category> categoryList() {
		// TODO Auto-generated method stub
		return dao.categoryList();
	}
	

}
