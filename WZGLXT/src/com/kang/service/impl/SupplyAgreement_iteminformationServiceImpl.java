package com.kang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.SupplyAgreement_itemInformationMapper;
import com.kang.pojo.SupplyAgreement_itemInfo;
import com.kang.pojo.SupplyAgreement_itemInformation;
import com.kang.service.SupplyAgreement_iteminformationService;
@Service
public class SupplyAgreement_iteminformationServiceImpl implements SupplyAgreement_iteminformationService {

	@Resource
	private SupplyAgreement_itemInformationMapper s_item ;

	@Override
	public List<SupplyAgreement_itemInfo> s_iteminfo(Integer supplyagreementid) {
		// TODO Auto-generated method stub
		return s_item.s_iteminfo(supplyagreementid);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return s_item.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SupplyAgreement_itemInformation record) {
		// TODO Auto-generated method stub
		return s_item.insert(record);
	}

	@Override
	public int insertSelective(SupplyAgreement_itemInformation record) {
		// TODO Auto-generated method stub
		return s_item.insertSelective(record);
	}

	@Override
	public SupplyAgreement_itemInformation selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return s_item.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SupplyAgreement_itemInformation record) {
		// TODO Auto-generated method stub
		return s_item.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SupplyAgreement_itemInformation record) {
		// TODO Auto-generated method stub
		return s_item.updateByPrimaryKey(record);
	}
	
}
