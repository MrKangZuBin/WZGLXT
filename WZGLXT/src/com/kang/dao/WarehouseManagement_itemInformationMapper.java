package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.WarehouseManagement_itemInformation;

public interface WarehouseManagement_itemInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WarehouseManagement_itemInformation record);

    int insertSelective(WarehouseManagement_itemInformation record);

    WarehouseManagement_itemInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WarehouseManagement_itemInformation record);

    int updateByPrimaryKey(WarehouseManagement_itemInformation record);
    
    //����ѯ-��ͨ��ѯ
    List<WarehouseManagement_itemInformation> selectkucunone();
    Integer insertWarehouseManagementID(Map<String, Object> map);
}