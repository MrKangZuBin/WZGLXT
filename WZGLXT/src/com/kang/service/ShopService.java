package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.Shop;
import com.kang.pojo.Shop_user;


public interface ShopService {
	//∑÷“≥≤È—Ø
	Map<String, Object> findPagingList(Map<String, Object> pramertes);
  	
    int deleteByPrimaryKey(Integer shopid);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop_user selectByPrimaryKey(Integer shopid);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);
}
