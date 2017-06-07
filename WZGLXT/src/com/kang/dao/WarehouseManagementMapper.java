package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.WarehouseManagement;
import com.kang.pojo.WarehouseUser;

public interface WarehouseManagementMapper {
	//查询数据数量
	Integer selrow(Map<String, Object> map);
	//分页查询
    List<WarehouseUser> findPagingList(Map<String, Object> map);
		
    int deleteByPrimaryKey(Integer warehousemanagementid);

    int insert(WarehouseManagement record);

    int insertSelective(WarehouseManagement record);

    WarehouseManagement selectByPrimaryKey(Integer warehousemanagementid);

    int updateByPrimaryKeySelective(WarehouseManagement record);

    int updateByPrimaryKey(WarehouseManagement record);
    
    //查询仓库名称
    List<WarehouseManagement> selectall();
    
    //库存管理-普通查询
    List<WarehouseManagement> selectbaosunone();
    
    //根据仓库id查询仓库名称
    WarehouseManagement selectbaosunById(Integer warehousemanagementid);
    
    //根据仓库名称查询id
    WarehouseManagement selbyid(Map<String, Object> map);
    
}