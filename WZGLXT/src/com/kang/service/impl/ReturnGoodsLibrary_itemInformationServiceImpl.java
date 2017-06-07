package com.kang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.ReturnGoodsLibrary_itemInformationMapper;
import com.kang.pojo.ReturnGoodsLibrary_itemInformation;
import com.kang.service.ReturnGoodsLibrary_itemInformationService;

@Service

public class ReturnGoodsLibrary_itemInformationServiceImpl implements ReturnGoodsLibrary_itemInformationService{

	@Resource
	private ReturnGoodsLibrary_itemInformationMapper rgl_iif;
	
	@Override
	public List<ReturnGoodsLibrary_itemInformation> selectallReturnGoodsLibrary_itemInformation() {
		// TODO Auto-generated method stub
		return rgl_iif.selectallReturnGoodsLibrary_itemInformation();
	}

	@Override
	public ReturnGoodsLibrary_itemInformation selectbyreturngoodslibraryid(int returngoodslibraryid) {
		// TODO Auto-generated method stub
		return rgl_iif.selectByreturngoodslibraryid(returngoodslibraryid);
	}

	@Override
	public int updatereturngood(ReturnGoodsLibrary_itemInformation rgl_ii) {
		// TODO Auto-generated method stub
		return rgl_iif.updateByPrimaryKeySelective(rgl_ii);
	}

	@Override
	public ReturnGoodsLibrary_itemInformation selectById(Integer id) {
		// TODO Auto-generated method stub
		return rgl_iif.selectByPrimaryKey(id);
	}

}
