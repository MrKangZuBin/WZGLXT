package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.Category;
import com.kang.pojo.InventoryLocation;
import com.kang.pojo.InventoryLocationUser;

public interface InventoryLocationService {

	// 分页查询
	Map<String, Object> findPagingList(Map<String, Object> pramertes);

	// 级联删除
	int deletenext(Integer inventorylocationid);

	// 查询所有InventoryLocation
	List<InventoryLocationUser> inventorylocationList();
	
	//根据id查询下级所有InventoryLocation
	List<InventoryLocation> selectid(Integer inventorylocationid);

	int deleteByPrimaryKey(Integer inventorylocationid);

	int insert(InventoryLocation record);

	int insertSelective(InventoryLocation record);

	InventoryLocation selectByPrimaryKey(Integer inventorylocationid);

	int updateByPrimaryKeySelective(InventoryLocation record);

	int updateByPrimaryKey(InventoryLocation record);

	// 查询库位表所有数据
	List<InventoryLocation> selectInventoryLocationAll();

	// 根据id查询库位表数据
	InventoryLocation selectById(Integer inventorylocationid);

	// 库存查询-普通查询
	List<InventoryLocation> selectkucunone();

	List<InventoryLocation> selectcaigou();

	// 查询库位表的数据上级库位
	
	
	InventoryLocation selectInventoryLocationid(Map<String, Object> map);

}
