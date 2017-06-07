package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.Grouppojo;
import com.kang.pojo.PurOrderReport;
import com.kang.pojo.PurchaseOrder;

public interface PurchaseorderService {

	//采购入库表全部数据查询分页
	List<PurchaseOrder> selectPurchaseOrder(Map<String, Object> map);
	//查询入库表的总条数
	int selectcountPurchaseOrder();
	//根据id查询入库表
	PurchaseOrder selectonePurchaseOrder(int id);
	//采购订单列表
	List<PurchaseOrder> selPurchase(Map<String, Object> map);
	
	Map<String, Object> selPurchaseOrder(Map<String, Object> map);
	//查询数据为采购入库条件做条件
	PurchaseOrder selectcaigouinsert(Integer purchaseorderid);
	//异步查询相关数据--详情
	List<Grouppojo> selPurchaseOrders(Map<String, Object> map);
	//删除一条数据
	int deleteone(int id);
	//多表关联查询	
	List<Grouppojo> selgroup(Map<String, Object> map);
	//插入数据
	Integer insertPur(Grouppojo gpojo);
	Integer insertSelective(PurchaseOrder record);
	Integer waitMePlay(Map<String, Object> map);
	Integer Played(Integer id);
	//首页显示我的单据
    Integer MyDJ(Integer id);
    Integer notgMyDJ(Integer id);
	 //物品采购报表
    List<PurchaseOrder> selitemcaigoubaobiaoone(Map<String, Object> map);
    int selitemcaigoubaobiaoonecount(Map<String, Object> map);
    List<PurOrderReport> selitemcaigoubaobiaotwo(Map<String, Object> map);
    
    //得到采购订单表的条数
    Integer count(Map<String, Object> map);
    Integer selcount();
    //修改数据
    int updateone(PurchaseOrder pur);
    PurchaseOrder selectObject(String orderNumber);
}
