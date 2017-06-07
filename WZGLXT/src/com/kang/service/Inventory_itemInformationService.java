package com.kang.service;

import java.util.List;

import com.kang.pojo.Inventory_itemInformation;

public interface Inventory_itemInformationService {

	//库存盘点-普通查询
	List<Inventory_itemInformation> selectpabdian();

	//根据id查询物品id
	Inventory_itemInformation selectpandian(Integer id);
	
	//修改库存盘点物品表
	int updatepandian(Inventory_itemInformation it);
	
	//添加数据
	int insert(Inventory_itemInformation itl);
	
}
