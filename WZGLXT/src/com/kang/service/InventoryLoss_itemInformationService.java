package com.kang.service;

import java.util.List;

import com.kang.pojo.InventoryLoss_itemInformation;

public interface InventoryLoss_itemInformationService {

	// ��汨��-�򵥲�ѯ
	List<InventoryLoss_itemInformation> selectbaosunone();

	// ��������id��ѯ��Ʒid
	InventoryLoss_itemInformation selectBybaosun(Integer id);
	
	//��汨���޸�
	int updatebaosun(InventoryLoss_itemInformation il_if);
	
	//�������
	int insert(InventoryLoss_itemInformation itl_if);
	
}
