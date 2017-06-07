package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.Shop;
import com.kang.pojo.Shop_user;

public interface ShopMapper {
	//分页查询
  	List<Shop_user> findPagingList(Map<String, Object> pramertes);
  	//查询数据数量
  	int selrow(Map<String, Object> pramertes);
  	
    int deleteByPrimaryKey(Integer shopid);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop_user selectByPrimaryKey(Integer shopid);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);
}