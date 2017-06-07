package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.Category;

public interface CategoryDao {
	//级联删除
	int deletenext(Integer categoryid);
	List<Category> selectid(Integer categoryid);
	//分页查询
	List<Category> findPagingList(Map<String, Object> pramertes);
	//查询所有Category
	List<Category> categoryList();
	//查询数据数量
	int selrow(Map<String, Object> pramertes);
	
    int deleteByPrimaryKey(Integer categoryid);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer categoryid);
    
    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}