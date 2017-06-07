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
    
  //���ݲɹ����idΪ������ѯ�ɹ������Ʒ������
    Warehouse_itemInformation selectByPurchaseOrderid(Integer purchaseorderid);
    
    //��Ʒ�ɹ�ͳ��
    Warehouse_itemInformation selitemcaigoubaobiaothree(Map<String, Object> map);
    
}