package com.kang.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.MaterialLibraryIDMapper;
import com.kang.pojo.MaterialLibraryID;
import com.kang.pojo.MaterialLibraryIDPoJo;
import com.kang.service.MaterialLibraryIDService;
@Service
public class MaterialLibraryIDServiceImpl implements MaterialLibraryIDService{

	@Resource
	private MaterialLibraryIDMapper mlm;
	
	@Override
	public List<MaterialLibraryID> selectallMaterialLibraryID(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return mlm.selectAllMaterialLibraryID(map);
	}

	@Override
	public int countMaterialLibraryID() {
		// TODO Auto-generated method stub
		return mlm.countMaterialLibraryID();
	}

	@Override
	public MaterialLibraryID selectByid(Integer materiallibraryid) {
		// TODO Auto-generated method stub
		return mlm.selectByPrimaryKey(materiallibraryid);
	}

	@Override
	public List<MaterialLibraryIDPoJo> selectByWheres(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mlm.selectByWheres(map);
	}

	@Override
	public int selectByWherescount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mlm.selectByWherescount(map);
	}

	@Override
	public int insertont(MaterialLibraryID mlb) {
		// TODO Auto-generated method stub
		return mlm.insertSelective(mlb);
	}

	@Override
	public MaterialLibraryID selectByNumber(String requisitionNumber) {
		// TODO Auto-generated method stub
		return mlm.selectByNumber(requisitionNumber);
	}

	@Override
	public int updateone(MaterialLibraryID mat) {
		// TODO Auto-generated method stub
		return mlm.updateByPrimaryKeySelective(mat);
	}

	@Override
	public Integer waitMePlay(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mlm.waitMePlay(map);
	}

	@Override
	public Integer Played(Integer id) {
		// TODO Auto-generated method stub
		return mlm.played(id);
	}

	@Override
	public Integer MyDJ(Integer id) {
		// TODO Auto-generated method stub
		return mlm.MyDJ(id);
	}

	@Override
	public Integer notgMyDJ(Integer id) {
		// TODO Auto-generated method stub
		return mlm.notgMyDJ(id);
	}

}
