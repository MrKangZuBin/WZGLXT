package com.kang.dao;

import java.util.List;

import com.kang.pojo.Pur_iifPoJo;
import com.kang.pojo.PurchaseOrder_itemInformation;

public interface PurchaseOrder_itemInformationMapper {
	//删除一条数据
    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseOrder_itemInformation record);

    int insertSelective(List<PurchaseOrder_itemInformation> list);

    PurchaseOrder_itemInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PurchaseOrder_itemInformation record);

    int updateByPrimaryKey(PurchaseOrder_itemInformation record);
    
    List<PurchaseOrder_itemInformation> selectPurchaseOrder_itemInformation();
    
    //根据采购订单id为条件查询采购订单表数据
   	List<Pur_iifPoJo> selectByPurchaseOrderid(Integer purchaseorderid);
    
    //查询采购订单id根据purchaseorderid
    PurchaseOrder_itemInformation selectid(Integer purchaseorderid);
}