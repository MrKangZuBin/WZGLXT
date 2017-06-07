package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.InventoryLocation;
import com.kang.pojo.InventoryLocationUser;

public interface InventoryLocationMapper {

	// 级联删除
	int deletenext(Integer inventorylocationid);
	//根据id查询下级所有InventoryLocation
	List<InventoryLocation> selectid(Integer inventorylocationid);

	// 分页查询
	List<InventoryLocationUser> findPagingList(Map<String, Object> pramertes);

	// 查询所有InventoryLocation
	List<InventoryLocationUser> inventorylocationList();

	// 查询数据数量
	int selrow(Map<String, Object> pramertes);

	int deleteByPrimaryKey(Integer inventorylocationid);

	int insert(InventoryLocation record);

	int insertSelective(InventoryLocation record);

	InventoryLocation selectByPrimaryKey(Integer inventorylocationid);
	
	InventoryLocation selectByPrimaryKeys(Integer inventorylocationid);
	int updateByPrimaryKeySelective(InventoryLocation record);

	int updateByPrimaryKey(InventoryLocation record);

	// 查询id和库位名称
	List<InventoryLocation> selectInventoryLocationall();

	// 库存查询-普通查询
	List<InventoryLocation> selectkucunone();

	// 查询库位表的数据上级库位
	List<InventoryLocation> selectcaigou();
	
	InventoryLocation selectInventoryLocationid(Map<String, Object> map);
	
}