package com.kang.service;

import java.util.List;

import com.kang.pojo.MaterialLibrary_inventoryLocation_itemInformation;

public interface Materiallibrary_inventorylocation_iteminformationService {

	 //查询领料出库物品库位表
    List<MaterialLibrary_inventoryLocation_itemInformation> selectall();
    
    //根据领料出库表的id查询领料出库物品库位表数据
    MaterialLibrary_inventoryLocation_itemInformation selectById(Integer materiallibraryid);
	
    //修改信息
    int updatelingliao(MaterialLibrary_inventoryLocation_itemInformation mii);
    
    //根据id查询数据
    MaterialLibrary_inventoryLocation_itemInformation selectByKey(Integer id);
    
    //添加数据
    int insertone(MaterialLibrary_inventoryLocation_itemInformation mii);
}
