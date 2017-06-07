package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.Warehouse_itemInformation;

public interface Warehouse_itemInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Warehouse_itemInformation record);

    int insertSelective(Warehouse_itemInformation record);

    Warehouse_itemInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Warehouse_itemInformation record);

    int updateByPrimaryKey(Warehouse_itemInformation record);
    
    List<Warehouse_itemInformation> selectWarehouse_itemInformation();
    
  //根据采购入库id为条件查询采购入库物品表数据
    Warehouse_itemInformation selectByPurchaseOrderid(Integer purchaseorderid);
    
    //物品采购统计
    Warehouse_itemInformation selitemcaigoubaobiaothree(Map<String, Object> map);
    
}