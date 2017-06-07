package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.Grouppojo;
import com.kang.pojo.PurOrderReport;
import com.kang.pojo.PurchaseOrder;

public interface PurchaseOrderMapper {
	int deleteByPrimaryKey(Integer purchaseorderid);

	// 采购订单表添加数据
	int insert(Grouppojo gpojo);

	Integer insertSelective(PurchaseOrder record);

	// 根据id查出特定的采购订单数据
	PurchaseOrder selectByPrimaryKey(Integer purchaseorderid);
	PurchaseOrder selectObject(String ordernumber);

	int updateByPrimaryKeySelective(PurchaseOrder record);

	int updateByPrimaryKey(PurchaseOrder record);

	// 采购订单表数据查询分页
	List<PurchaseOrder> selPurchase(Map<String, Object> map);

	List<PurchaseOrder> selPurOrderList(Map<String, Object> map);

	List<PurchaseOrder> selectPurchaseOrder(Map<String, Object> map);

	// 查询订单表数据总条数
	int selectcountPurchaseOrder();

	int selectcount(Map<String, Object> map);

	// 查询数据为采购入库条件做条件
	PurchaseOrder selectcaigouinsert(Integer purchaseorderid);

	//异步提交传来的id查询采购订单的数据
	List<Grouppojo> selPurOrder(Map<String, Object> map);

	// 多表关联查询
	public List<Grouppojo> selgrou(Map<String, Object> map);
	
	// 物品采购报表
	List<PurchaseOrder> selitemcaigoubaobiaoone(Map<String, Object> map);
	int selitemcaigoubaobiaoonecount(Map<String, Object> map);
	List<PurOrderReport> selitemcaigoubaobiaotwo(Map<String, Object> map);

	// 得到采购订单表的条数
	Integer count(Map<String, Object> map);
	Integer selcount();
	Integer waitMePlay(Map<String, Object> map);
	Integer played(Integer id);
	Integer MyDJ(Integer id);
	Integer notgMyDJ(Integer id);
}