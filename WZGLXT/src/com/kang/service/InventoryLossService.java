package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.InventoryLoss;
import com.kang.pojo.InventoryLossPoJo;

public interface InventoryLossService {
	
	//��汨��-�򵥲�ѯ
	List<InventoryLoss> selectbaosunone(Map<String, Integer> map);
	
	//��汨��-���ݵ�������
	int countbaosun();
	
	//��汨��-��������id��ѯ
    InventoryLoss selectbaosunById(Integer inventorylossid);
    
    //��汨��-�޸�
    int updatebaosun(InventoryLoss il);
    
  //��ѯ����
    List<InventoryLossPoJo> selectByWheres(Map<String, Object> map);
    int selectByWherescount(Map<String, Object> map);
    
  //���ݵ��Ų�ѯid
    InventoryLoss selectByNumber(String lossnumber);
    
    //�������
    int insert(InventoryLoss itl);
	
}
