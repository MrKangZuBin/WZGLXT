package com.kang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.Inventory_itemInformationMapper;
import com.kang.pojo.Inventory_itemInformation;
import com.kang.service.Inventory_itemInformationService;
@Service
public class Inventory_itemInformationServiceImpl implements Inventory_itemInformationService{
	@Resource
	private Inventory_itemInformationMapper it_ifm;
	
	@Override
	public List<Inventory_itemInformation> selectpabdian() {
		// TODO Auto-generated method stub
		return it_ifm.selectpabdianone();
	}

	@Override
	public Inventory_itemInformation selectpandian(Integer id) {
		// TODO Auto-generated method stub
		return it_ifm.selectpandian(id);
	}

	@Override
	public int updatepandian(Inventory_itemInformation it) {
		// TODO Auto-generated method stub
		return it_ifm.updateByPrimaryKeySelective(it);
	}

	@Override
	public int insert(Inventory_itemInformation itl) {
		// TODO Auto-generated method stub
		return it_ifm.insertSelective(itl);
	}

}
