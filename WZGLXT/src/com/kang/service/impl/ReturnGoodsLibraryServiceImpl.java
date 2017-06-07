package com.kang.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.ReturnGoodsLibraryMapper;
import com.kang.pojo.ReturnGoodsLibrary;
import com.kang.pojo.ReturngoodslibraryPoJo;
import com.kang.service.ReturnGoodsLibraryService;
@Service
public class ReturnGoodsLibraryServiceImpl implements ReturnGoodsLibraryService{

	@Resource
	private ReturnGoodsLibraryMapper rgl;
	
	@Override
	public List<ReturnGoodsLibrary> selectallReturnGoodsLibrary(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return rgl.selectallReturnGoodsLibrary(map);
	}

	@Override
	public int countReturnGoodsLibrary() {
		// TODO Auto-generated method stub
		return rgl.selectcountReturnGoodsLibrary();
	}

	@Override
	public ReturnGoodsLibrary selectbyreturngoodslibraryid(Integer returngoodslibraryid) {
		// TODO Auto-generated method stub
		return rgl.selectByPrimaryKey(returngoodslibraryid);
	}

	@Override
	public List<ReturngoodslibraryPoJo> selectByWheres(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return rgl.selectByWheres(map);
	}

	@Override
	public int selectByWherescount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return rgl.selectByWherescount(map);
	}

	@Override
	public int updateone(ReturnGoodsLibrary rel) {
		// TODO Auto-generated method stub
		return rgl.updateByPrimaryKeySelective(rel);
	}

}
