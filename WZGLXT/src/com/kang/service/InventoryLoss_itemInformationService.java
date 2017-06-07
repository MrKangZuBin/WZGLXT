package com.kang.service;

import java.util.List;

import com.kang.pojo.InventoryLoss_itemInformation;

public interface InventoryLoss_itemInformationService {

	// 库存报损-简单查询
	List<InventoryLoss_itemInformation> selectbaosunone();

	// 根据主键id查询物品id
	InventoryLoss_itemInformation selectBybaosun(Integer id);
	
	//库存报损修改
	int updatebaosun(InventoryLoss_itemInformation il_if);
	
	//添加数据
	int insert(InventoryLoss_itemInformation itl_if);
	
}
