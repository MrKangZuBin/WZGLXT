package com.kang.dao;

import java.util.List;

import com.kang.pojo.Inventory_itemInformation;

public interface Inventory_itemInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Inventory_itemInformation record);

    int insertSelective(Inventory_itemInformation record);

    Inventory_itemInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Inventory_itemInformation record);

    int updateByPrimaryKey(Inventory_itemInformation record);
    
  //����̵�-��ͨ��ѯ��Ϣ
    List<Inventory_itemInformation> selectpabdianone();
    
    //��������id��ѯ��Ʒid
    Inventory_itemInformation selectpandian(Integer id);
    
  
    
    
}