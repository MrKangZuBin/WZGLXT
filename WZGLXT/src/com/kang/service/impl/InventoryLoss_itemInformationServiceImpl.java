package com.kang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.InventoryLoss_itemInformationMapper;
import com.kang.pojo.InventoryLoss_itemInformation;
import com.kang.service.InventoryLoss_itemInformationService;
@Service
public class InventoryLoss_itemInformationServiceImpl implements InventoryLoss_itemInformationService{

	@Resource
	private InventoryLoss_itemInformationMapper il_ifm;
	
	@Override
	public List<InventoryLoss_itemInformation> selectbaosunone() {
		// TODO Auto-generated method stub
		return il_ifm.selectbaosunone();
	}

	@Override
	public InventoryLoss_itemInformation selectBybaosun(Integer id) {
		// TODO Auto-generated method stub
		return il_ifm.selectBybaosun(id);
	}

	@Override
	public int updatebaosun(InventoryLoss_itemInformation il_if) {
		// TODO Auto-generated method stub
		return il_ifm.updateByPrimaryKeySelective(il_if);
	}

	@Override
	public int insert(InventoryLoss_itemInformation itl_if) {
		// TODO Auto-generated method stub
		return il_ifm.insertSelective(itl_if);
	}

}
