package com.kang.dao;


import com.kang.pojo.InventoryWarning;

public interface InventoryWarningMapper {
    int deleteByPrimaryKey(Integer inventorywarningid);

    int insert(InventoryWarning record);

    int insertSelective(InventoryWarning record);

    InventoryWarning selectByPrimaryKey(Integer inventorywarningid);

    int updateByPrimaryKeySelective(InventoryWarning record);

    int updateByPrimaryKey(InventoryWarning record);
    
    
    
}