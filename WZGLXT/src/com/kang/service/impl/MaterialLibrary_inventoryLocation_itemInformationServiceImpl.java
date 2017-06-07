package com.kang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.MaterialLibrary_inventoryLocation_itemInformationMapper;
import com.kang.pojo.MaterialLibrary_inventoryLocation_itemInformation;
import com.kang.service.Materiallibrary_inventorylocation_iteminformationService;
@Service
public class MaterialLibrary_inventoryLocation_itemInformationServiceImpl implements Materiallibrary_inventorylocation_iteminformationService{

	@Resource
	private MaterialLibrary_inventoryLocation_itemInformationMapper miim;
	
	@Override
	public List<MaterialLibrary_inventoryLocation_itemInformation> selectall() {
		// TODO Auto-generated method stub
		return miim.selectall();
	}

	@Override
	public MaterialLibrary_inventoryLocation_itemInformation selectById(Integer materiallibraryid) {
		// TODO Auto-generated method stub
		return miim.selectById(materiallibraryid);
	}

	@Override
	public int updatelingliao(MaterialLibrary_inventoryLocation_itemInformation mii) {
		// TODO Auto-generated method stub
		return miim.updateByPrimaryKeySelective(mii);
	}

	@Override
	public MaterialLibrary_inventoryLocation_itemInformation selectByKey(Integer id) {
		// TODO Auto-generated method stub
		return miim.selectByPrimaryKey(id);
	}

	@Override
	public int insertone(MaterialLibrary_inventoryLocation_itemInformation mii) {
		// TODO Auto-generated method stub
		return miim.insertSelective(mii);
	}

}
