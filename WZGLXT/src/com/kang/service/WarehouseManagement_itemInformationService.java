package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.WarehouseManagement_itemInformation;

public interface WarehouseManagement_itemInformationService {

	//����ѯ-��ͨ��ѯ
	List<WarehouseManagement_itemInformation> selectkucunone();
	Integer insertWarehouseManagementID(Map<String, Object> map);
}
