package com.kang.dao;

import java.util.List;

import com.kang.pojo.Pur_iifPoJo;
import com.kang.pojo.PurchaseOrder_itemInformation;

public interface PurchaseOrder_itemInformationMapper {
	//ɾ��һ������
    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseOrder_itemInformation record);

    int insertSelective(List<PurchaseOrder_itemInformation> list);

    PurchaseOrder_itemInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PurchaseOrder_itemInformation record);

    int updateByPrimaryKey(PurchaseOrder_itemInformation record);
    
    List<PurchaseOrder_itemInformation> selectPurchaseOrder_itemInformation();
    
    //���ݲɹ�����idΪ������ѯ�ɹ�����������
   	List<Pur_iifPoJo> selectByPurchaseOrderid(Integer purchaseorderid);
    
    //��ѯ�ɹ�����id����purchaseorderid
    PurchaseOrder_itemInformation selectid(Integer purchaseorderid);
}