package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.PurchaseOrder;
import com.kang.pojo.WareOrderReport;
import com.kang.pojo.WarehouseOrder;
import com.kang.pojo.WarehousePoJo;

public interface warehouseOrderService {

	//采购入库表全部数据查询分页
	List<WarehouseOrder> selectWarehouseOrder(Map<String, Integer> map);
	//查询入库表的总条数
	int selectcountWarehouseOrder();
	//根据id查询入库表
	WarehouseOrder selectonePurchaseOrder(int purchaseordereid);
	
	//添加一条数据
	int insertone(WarehouseOrder wo);
	
	//查询功能
	List<WarehousePoJo> selectByWheres(Map<String, Object> map);
	int selectByWherescount(Map<String, Object> map);
	//根据单号查询id
	WarehouseOrder selectoneid(String warehousenumber);
	
	//物品采购入库统计表
    List<WareOrderReport> selectwupingcaigoubaobiao(Map<String, Object> map);
    List<WareOrderReport> selectwupingcaigoubaobiaotwo(Map<String, Object> map);
    int selectwupingcaigoubaobiaocount(Map<String, Object> map);
    int selectwupingcaigoubaobiaotwocount(Map<String, Object> map);
}
