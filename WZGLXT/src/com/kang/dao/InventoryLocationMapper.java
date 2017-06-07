package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.InventoryLocation;
import com.kang.pojo.InventoryLocationUser;

public interface InventoryLocationMapper {

	// ����ɾ��
	int deletenext(Integer inventorylocationid);
	//����id��ѯ�¼�����InventoryLocation
	List<InventoryLocation> selectid(Integer inventorylocationid);

	// ��ҳ��ѯ
	List<InventoryLocationUser> findPagingList(Map<String, Object> pramertes);

	// ��ѯ����InventoryLocation
	List<InventoryLocationUser> inventorylocationList();

	// ��ѯ��������
	int selrow(Map<String, Object> pramertes);

	int deleteByPrimaryKey(Integer inventorylocationid);

	int insert(InventoryLocation record);

	int insertSelective(InventoryLocation record);

	InventoryLocation selectByPrimaryKey(Integer inventorylocationid);
	
	InventoryLocation selectByPrimaryKeys(Integer inventorylocationid);
	int updateByPrimaryKeySelective(InventoryLocation record);

	int updateByPrimaryKey(InventoryLocation record);

	// ��ѯid�Ϳ�λ����
	List<InventoryLocation> selectInventoryLocationall();

	// ����ѯ-��ͨ��ѯ
	List<InventoryLocation> selectkucunone();

	// ��ѯ��λ��������ϼ���λ
	List<InventoryLocation> selectcaigou();
	
	InventoryLocation selectInventoryLocationid(Map<String, Object> map);
	
}