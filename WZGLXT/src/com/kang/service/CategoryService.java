package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.Category;

public interface CategoryService {
	//分页查询
	Map<String, Object> findPagingList(Map<String, Object> pramertes);
	//级联删除
	int deletenext(Integer categoryid);
	//查询所有Category
	List<Category> categoryList();
	
	List<Category> selectid(Integer categoryid);
	
	int deleteByPrimaryKey(Integer categoryid);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer categoryid);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}
