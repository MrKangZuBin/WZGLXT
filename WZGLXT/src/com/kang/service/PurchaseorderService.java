package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.Grouppojo;
import com.kang.pojo.PurOrderReport;
import com.kang.pojo.PurchaseOrder;

public interface PurchaseorderService {

	//�ɹ�����ȫ�����ݲ�ѯ��ҳ
	List<PurchaseOrder> selectPurchaseOrder(Map<String, Object> map);
	//��ѯ�����������
	int selectcountPurchaseOrder();
	//����id��ѯ����
	PurchaseOrder selectonePurchaseOrder(int id);
	//�ɹ������б�
	List<PurchaseOrder> selPurchase(Map<String, Object> map);
	
	Map<String, Object> selPurchaseOrder(Map<String, Object> map);
	//��ѯ����Ϊ�ɹ��������������
	PurchaseOrder selectcaigouinsert(Integer purchaseorderid);
	//�첽��ѯ�������--����
	List<Grouppojo> selPurchaseOrders(Map<String, Object> map);
	//ɾ��һ������
	int deleteone(int id);
	//��������ѯ	
	List<Grouppojo> selgroup(Map<String, Object> map);
	//��������
	Integer insertPur(Grouppojo gpojo);
	Integer insertSelective(PurchaseOrder record);
	Integer waitMePlay(Map<String, Object> map);
	Integer Played(Integer id);
	//��ҳ��ʾ�ҵĵ���
    Integer MyDJ(Integer id);
    Integer notgMyDJ(Integer id);
	 //��Ʒ�ɹ�����
    List<PurchaseOrder> selitemcaigoubaobiaoone(Map<String, Object> map);
    int selitemcaigoubaobiaoonecount(Map<String, Object> map);
    List<PurOrderReport> selitemcaigoubaobiaotwo(Map<String, Object> map);
    
    //�õ��ɹ������������
    Integer count(Map<String, Object> map);
    Integer selcount();
    //�޸�����
    int updateone(PurchaseOrder pur);
    PurchaseOrder selectObject(String orderNumber);
}
