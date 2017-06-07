package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.dao.Warehouse_itemInformationMapper;
import com.kang.pojo.Warehouse_itemInformation;

public interface warehouseOrder_itemInformationService {
	// 查询采购物品表
	List<Warehouse_itemInformation> selectWarehouseOrder_itemInformation();

	// 查询采购物品表根据采购入库id
	Warehouse_itemInformation selectByPurchaseOrderid(Integer purchaseorderid);

	// 添加一条数据
	int insertone(Warehouse_itemInformation record);
	
	 //物品采购统计
    Warehouse_itemInformation selitemcaigoubaobiaothree(Map<String, Object> map);
}
