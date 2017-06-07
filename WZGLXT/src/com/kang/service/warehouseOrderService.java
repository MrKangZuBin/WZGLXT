package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.PurchaseOrder;
import com.kang.pojo.WareOrderReport;
import com.kang.pojo.WarehouseOrder;
import com.kang.pojo.WarehousePoJo;

public interface warehouseOrderService {

	//�ɹ�����ȫ�����ݲ�ѯ��ҳ
	List<WarehouseOrder> selectWarehouseOrder(Map<String, Integer> map);
	//��ѯ�����������
	int selectcountWarehouseOrder();
	//����id��ѯ����
	WarehouseOrder selectonePurchaseOrder(int purchaseordereid);
	
	//���һ������
	int insertone(WarehouseOrder wo);
	
	//��ѯ����
	List<WarehousePoJo> selectByWheres(Map<String, Object> map);
	int selectByWherescount(Map<String, Object> map);
	//���ݵ��Ų�ѯid
	WarehouseOrder selectoneid(String warehousenumber);
	
	//��Ʒ�ɹ����ͳ�Ʊ�
    List<WareOrderReport> selectwupingcaigoubaobiao(Map<String, Object> map);
    List<WareOrderReport> selectwupingcaigoubaobiaotwo(Map<String, Object> map);
    int selectwupingcaigoubaobiaocount(Map<String, Object> map);
    int selectwupingcaigoubaobiaotwocount(Map<String, Object> map);
}
