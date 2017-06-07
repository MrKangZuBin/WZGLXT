package com.kang.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.GeneralStorageMapper;
import com.kang.pojo.GeneralStorage;
import com.kang.pojo.GgeneralStoragePoJo;
import com.kang.service.GeneralstorageService;
@Service
public class GeneralStorageServiceImpl implements GeneralstorageService{

	@Resource
	private GeneralStorageMapper gsm;
	
	@Override
	public List<GeneralStorage> selectGeneralStorage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gsm.selectGeneralStorage(map);
	}

	@Override
	public int countGeneralStorage() {
		// TODO Auto-generated method stub
		return gsm.countGeneralStorage();
	}

	@Override
	public GeneralStorage selectByGeneralStorage(Integer GeneralStorage) {
		// TODO Auto-generated method stub
		return gsm.selectByGeneralStorage(GeneralStorage);
	}

	@Override
	public int insertone(GeneralStorage gs) {
		// TODO Auto-generated method stub
		return gsm.insertSelective(gs);
	}

	@Override
	public GeneralStorage selectoneid(String warehousenumber) {
		// TODO Auto-generated method stub
		return gsm.selectoneid(warehousenumber);
	}

	@Override
	public List<GgeneralStoragePoJo> selectByWheres(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gsm.selectByWheres(map);
	}

	@Override
	public int selectByWherescount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return gsm.selectByWherescount(map);
	}

	@Override
	public int updateone(GeneralStorage gs) {
		// TODO Auto-generated method stub
		return gsm.insertSelective(gs);
	}

}
