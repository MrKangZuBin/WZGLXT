package com.kang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.PurchaseRequisitionMapper;
import com.kang.dao.PurchaseRequisition_itemInformationMapper;
import com.kang.pojo.PurchaseRequisition_itemInformation;
import com.kang.service.PriService;

@Service("PriService")
public class PriServiceImpl implements PriService{
	@Resource
	private PurchaseRequisition_itemInformationMapper prim;

	@Override
	public List<PurchaseRequisition_itemInformation> selectPriList() {
		// TODO Auto-generated method stub
		return prim.selListPri();
	}

	@Override
	public PurchaseRequisition_itemInformation selPrif(Integer prid) {
		// TODO Auto-generated method stub
		return prim.selectByPrimaryKey(prid);
	}
	
}	
