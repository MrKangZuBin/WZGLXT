package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.dao.Warehouse_itemInformationMapper;
import com.kang.pojo.Warehouse_itemInformation;

public interface warehouseOrder_itemInformationService {
	// ��ѯ�ɹ���Ʒ��
	List<Warehouse_itemInformation> selectWarehouseOrder_itemInformation();

	// ��ѯ�ɹ���Ʒ����ݲɹ����id
	Warehouse_itemInformation selectByPurchaseOrderid(Integer purchaseorderid);

	// ���һ������
	int insertone(Warehouse_itemInformation record);
	
	 //��Ʒ�ɹ�ͳ��
    Warehouse_itemInformation selitemcaigoubaobiaothree(Map<String, Object> map);
}
