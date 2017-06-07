package com.kang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.PurchaseOrder_itemInformationMapper;
import com.kang.pojo.Pur_iifPoJo;
import com.kang.pojo.PurchaseOrder_itemInformation;
import com.kang.service.PurchaseOrder_itemInformationService;

@Service
public class PurchaseOrder_itemInformationServiceImpl  implements PurchaseOrder_itemInformationService{

	@Resource
	private PurchaseOrder_itemInformationMapper pro_iif;
	
	//��ѯ�ɹ���Ʒ��
	@Override
	public List<PurchaseOrder_itemInformation> selectPurchaseOrder_itemInformation() {
		// TODO Auto-generated method stub
		return pro_iif.selectPurchaseOrder_itemInformation();
	}

	@Override
	public List<Pur_iifPoJo> selectByPurchaseOrderid(Integer purchaseorderid) {
		// TODO Auto-generated method stub
		return pro_iif.selectByPurchaseOrderid(purchaseorderid);
	}

	@Override
	public PurchaseOrder_itemInformation selectid(Integer purchaseorderid) {
		// TODO Auto-generated method stub
		return pro_iif.selectid(purchaseorderid);
	}

	@Override
	public int updateByPrimaryKeySelective(PurchaseOrder_itemInformation pcos) {
		// TODO Auto-generated method stub
		return pro_iif.updateByPrimaryKeySelective(pcos);
	}

	@Override
	public int delectone(Integer id) {
		// TODO Auto-generated method stub
		return pro_iif.deleteByPrimaryKey(id);
	}

	@Override
	public int insertSelective(List<PurchaseOrder_itemInformation> list) {
		// TODO Auto-generated method stub
		return pro_iif.insertSelective(list);
	}
}
