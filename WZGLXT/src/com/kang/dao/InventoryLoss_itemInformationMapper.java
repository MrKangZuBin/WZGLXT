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
    
    //��汨��-�򵥲�ѯ
    List<InventoryLoss_itemInformation> selectbaosunone();
    
    //��������id��ѯ��Ʒid
    InventoryLoss_itemInformation selectBybaosun(Integer id);
    
}