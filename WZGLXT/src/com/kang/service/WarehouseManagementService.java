package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.WarehouseManagement;

public interface WarehouseManagementService {
	//分页查询
	Map<String, Object> findPagingList(Map<String, Object> pramertes);
	
	int deleteByPrimaryKey(Integer warehousemanagementid);

    int insert(WarehouseManagement record);

    int insertSelective(WarehouseManagement record);

    WarehouseManagement selectByPrimaryKey(Integer warehousemanagementid);

    int updateByPrimaryKeySelective(WarehouseManagement record);

    int updateByPrimaryKey(WarehouseManagement record);
	
	//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷询
	WarehouseManagement selectById(int warehousemanagementid);
	//锟斤拷询全锟斤拷锟斤拷锟斤拷
	List<WarehouseManagement> selectAll();
	
	//锟斤拷姹拷锟�-锟津单诧拷询
	List<WarehouseManagement> selectbaosunone();
	
	//锟斤拷锟捷仓匡拷id锟斤拷询锟街匡拷锟斤拷锟斤拷
    WarehouseManagement selectbaosunById(Integer warehousemanagementid);
    //鏍规嵁鍚嶅瓧鏌d
    WarehouseManagement selById(Map<String, Object> map);
}
