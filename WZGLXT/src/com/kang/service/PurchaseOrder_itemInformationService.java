package com.kang.service;

import java.util.List;

import com.kang.pojo.Pur_iifPoJo;
import com.kang.pojo.PurchaseOrder_itemInformation;


public interface PurchaseOrder_itemInformationService {
	//��ѯ�ɹ���Ʒ��
	List<PurchaseOrder_itemInformation> selectPurchaseOrder_itemInformation();
	//��ѯ�ɹ���Ʒ����ݲɹ����id
	List<Pur_iifPoJo> selectByPurchaseOrderid(Integer purchaseorderid);
	//��ѯ�ɹ�����id����purchaseorderid
	PurchaseOrder_itemInformation selectid(Integer purchaseorderid);
	//�޸�ӆ����Ʒ������
	int updateByPrimaryKeySelective(PurchaseOrder_itemInformation pcos);
	int insertSelective(List<PurchaseOrder_itemInformation> list);
	//ɾ��ĳһ������
	int delectone(Integer id);
}
