package com.kang.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.PurchaseRequisition_itemInformationMapper;
import com.kang.pojo.PurchaseRequisition_itemInformation;
import com.kang.service.purchaserequisition_iteminformationService;

@Service("purchaserequisition_iteminformationService")
public class purchaserequisition_iteminformationServiceImpl implements purchaserequisition_iteminformationService{
	@Resource
	private PurchaseRequisition_itemInformationMapper piif;
	@Override
	public int insert(List<PurchaseRequisition_itemInformation> list) {
		// TODO Auto-generated method stub
		return piif.insert(list);
	}

}
