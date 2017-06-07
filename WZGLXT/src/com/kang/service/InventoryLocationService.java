package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.Category;
import com.kang.pojo.InventoryLocation;
import com.kang.pojo.InventoryLocationUser;

public interface InventoryLocationService {

	// ��ҳ��ѯ
	Map<String, Object> findPagingList(Map<String, Object> pramertes);

	// ����ɾ��
	int deletenext(Integer inventorylocationid);

	// ��ѯ����InventoryLocation
	List<InventoryLocationUser> inventorylocationList();
	
	//����id��ѯ�¼�����InventoryLocation
	List<InventoryLocation> selectid(Integer inventorylocationid);

	int deleteByPrimaryKey(Integer inventorylocationid);

	int insert(InventoryLocation record);

	int insertSelective(InventoryLocation record);

	InventoryLocation selectByPrimaryKey(Integer inventorylocationid);

	int updateByPrimaryKeySelective(InventoryLocation record);

	int updateByPrimaryKey(InventoryLocation record);

	// ��ѯ��λ����������
	List<InventoryLocation> selectInventoryLocationAll();

	// ����id��ѯ��λ������
	InventoryLocation selectById(Integer inventorylocationid);

	// ����ѯ-��ͨ��ѯ
	List<InventoryLocation> selectkucunone();

	List<InventoryLocation> selectcaigou();

	// ��ѯ��λ��������ϼ���λ
	
	
	InventoryLocation selectInventoryLocationid(Map<String, Object> map);

}
