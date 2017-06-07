package com.kang.service;

import java.util.List;

import com.kang.pojo.ShopBusinessScope_itemInfo;
import com.kang.pojo.ShopBusinessScope_itemInformation;

public interface ShopBusinessScope_itemInformationService {
	// 根据Shopid查询列表
	List<ShopBusinessScope_itemInfo> s_iteminfo(Integer shopid);

	int deleteByPrimaryKey(Integer id);

	int insert(ShopBusinessScope_itemInformation record);

	int insertSelective(ShopBusinessScope_itemInformation record);

	ShopBusinessScope_itemInformation selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(ShopBusinessScope_itemInformation record);

	int updateByPrimaryKey(ShopBusinessScope_itemInformation record);

	// 库存查询-普通查询
	List<ShopBusinessScope_itemInformation> selectkucunone();

}
