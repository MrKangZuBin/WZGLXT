package com.kang.service;

import java.util.List;

import com.kang.pojo.Inventory_itemInformation;

public interface Inventory_itemInformationService {

	//����̵�-��ͨ��ѯ
	List<Inventory_itemInformation> selectpabdian();

	//����id��ѯ��Ʒid
	Inventory_itemInformation selectpandian(Integer id);
	
	//�޸Ŀ���̵���Ʒ��
	int updatepandian(Inventory_itemInformation it);
	
	//�������
	int insert(Inventory_itemInformation itl);
	
}
