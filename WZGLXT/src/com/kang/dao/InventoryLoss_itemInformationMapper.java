package com.kang.dao;

import java.util.List;

import com.kang.pojo.InventoryLoss_itemInformation;

public interface InventoryLoss_itemInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InventoryLoss_itemInformation record);

    int insertSelective(InventoryLoss_itemInformation record);

    InventoryLoss_itemInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InventoryLoss_itemInformation record);

    int updateByPrimaryKey(InventoryLoss_itemInformation record);
    
    //库存报损-简单查询
    List<InventoryLoss_itemInformation> selectbaosunone();
    
    //根据主键id查询物品id
    InventoryLoss_itemInformation selectBybaosun(Integer id);
    
}