package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.Inventory;
import com.kang.pojo.InventoryPoJo;
import com.kang.pojo.PandianReport;

public interface InventoryService {

	//����̵�-��ͨ��ѯ
	List<Inventory> selectpandianone(Map<String, Integer> map);
	
	//��ѯ����̵�������������
	int countpandian();
	
	//����̵�-�༭��ѯ
	Inventory selectpandian(Integer inventoryid);
	
	//�޸Ŀ���̵���Ϣ
	int updatepandian(Inventory it);
	  //��ѯ����
    List<InventoryPoJo> selectByWheres(Map<String, Object> map);
    int selectByWherescount(Map<String, Object> map);
    
  //���ݵ��Ų�ѯid
    Inventory selectByNumber(String inventorynumber);
    
    //���һ������
    int insert(Inventory invent);
    
  //����̵�ͳ��
    List<PandianReport> selectkucunpandianbaobiao(Map<String, Object> map);
    int selectkucunpandianbaobiaocount(Map<String, Object> map);
    
}
