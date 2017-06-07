package com.kang.dao;

import java.util.List;

import com.kang.pojo.MaterialLibrary_inventoryLocation_itemInformation;

public interface MaterialLibrary_inventoryLocation_itemInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MaterialLibrary_inventoryLocation_itemInformation record);

    int insertSelective(MaterialLibrary_inventoryLocation_itemInformation record);

    MaterialLibrary_inventoryLocation_itemInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MaterialLibrary_inventoryLocation_itemInformation record);

    int updateByPrimaryKey(MaterialLibrary_inventoryLocation_itemInformation record);
    
    //查询领料出库物品库位表
    List<MaterialLibrary_inventoryLocation_itemInformation> selectall();
    
    //根据领料出库表的id查询领料出库物品库位表数据
    MaterialLibrary_inventoryLocation_itemInformation selectById(Integer materiallibraryid);
}