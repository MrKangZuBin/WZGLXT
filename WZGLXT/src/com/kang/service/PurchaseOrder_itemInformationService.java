package com.kang.service;

import java.util.List;

import com.kang.pojo.Pur_iifPoJo;
import com.kang.pojo.PurchaseOrder_itemInformation;


public interface PurchaseOrder_itemInformationService {
	//查询采购物品表
	List<PurchaseOrder_itemInformation> selectPurchaseOrder_itemInformation();
	//查询采购物品表根据采购入库id
	List<Pur_iifPoJo> selectByPurchaseOrderid(Integer purchaseorderid);
	//查询采购订单id根据purchaseorderid
	PurchaseOrder_itemInformation selectid(Integer purchaseorderid);
	//修改訂單物品表数据
	int updateByPrimaryKeySelective(PurchaseOrder_itemInformation pcos);
	int insertSelective(List<PurchaseOrder_itemInformation> list);
	//删除某一条数据
	int delectone(Integer id);
}
