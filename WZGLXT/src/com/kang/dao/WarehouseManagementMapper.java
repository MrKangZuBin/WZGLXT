package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.WarehouseManagement;
import com.kang.pojo.WarehouseUser;

public interface WarehouseManagementMapper {
	//��ѯ��������
	Integer selrow(Map<String, Object> map);
	//��ҳ��ѯ
    List<WarehouseUser> findPagingList(Map<String, Object> map);
		
    int deleteByPrimaryKey(Integer warehousemanagementid);

    int insert(WarehouseManagement record);

    int insertSelective(WarehouseManagement record);

    WarehouseManagement selectByPrimaryKey(Integer warehousemanagementid);

    int updateByPrimaryKeySelective(WarehouseManagement record);

    int updateByPrimaryKey(WarehouseManagement record);
    
    //��ѯ�ֿ�����
    List<WarehouseManagement> selectall();
    
    //������-��ͨ��ѯ
    List<WarehouseManagement> selectbaosunone();
    
    //���ݲֿ�id��ѯ�ֿ�����
    WarehouseManagement selectbaosunById(Integer warehousemanagementid);
    
    //���ݲֿ����Ʋ�ѯid
    WarehouseManagement selbyid(Map<String, Object> map);
    
}