package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.Grouppojo;
import com.kang.pojo.PurOrderReport;
import com.kang.pojo.PurchaseOrder;

public interface PurchaseOrderMapper {
	int deleteByPrimaryKey(Integer purchaseorderid);

	// �ɹ��������������
	int insert(Grouppojo gpojo);

	Integer insertSelective(PurchaseOrder record);

	// ����id����ض��Ĳɹ���������
	PurchaseOrder selectByPrimaryKey(Integer purchaseorderid);
	PurchaseOrder selectObject(String ordernumber);

	int updateByPrimaryKeySelective(PurchaseOrder record);

	int updateByPrimaryKey(PurchaseOrder record);

	// �ɹ����������ݲ�ѯ��ҳ
	List<PurchaseOrder> selPurchase(Map<String, Object> map);

	List<PurchaseOrder> selPurOrderList(Map<String, Object> map);

	List<PurchaseOrder> selectPurchaseOrder(Map<String, Object> map);

	// ��ѯ����������������
	int selectcountPurchaseOrder();

	int selectcount(Map<String, Object> map);

	// ��ѯ����Ϊ�ɹ��������������
	PurchaseOrder selectcaigouinsert(Integer purchaseorderid);

	//�첽�ύ������id��ѯ�ɹ�����������
	List<Grouppojo> selPurOrder(Map<String, Object> map);

	// ��������ѯ
	public List<Grouppojo> selgrou(Map<String, Object> map);
	
	// ��Ʒ�ɹ�����
	List<PurchaseOrder> selitemcaigoubaobiaoone(Map<String, Object> map);
	int selitemcaigoubaobiaoonecount(Map<String, Object> map);
	List<PurOrderReport> selitemcaigoubaobiaotwo(Map<String, Object> map);

	// �õ��ɹ������������
	Integer count(Map<String, Object> map);
	Integer selcount();
	Integer waitMePlay(Map<String, Object> map);
	Integer played(Integer id);
	Integer MyDJ(Integer id);
	Integer notgMyDJ(Integer id);
}