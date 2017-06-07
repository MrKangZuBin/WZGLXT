package com.kang.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.ReturnRequest_itemInformationMapper;
import com.kang.pojo.ReturnRequest_itemInformation;
import com.kang.service.ReturnRequest_itemInformationService;

@Service
public class ReturnRequest_itemInformationServiceImpl implements ReturnRequest_itemInformationService{

	@Resource
	private ReturnRequest_itemInformationMapper rrtf;
	
	@Override
	public List<ReturnRequest_itemInformation> selectallReturnRequest_itemInformation() {
		// TODO Auto-generated method stub
		return rrtf.selectallReturnRequest_itemInformation();
	}

	@Override
	public int insertSelective(List<ReturnRequest_itemInformation> list) {
		// TODO Auto-generated method stub
		return rrtf.insertSelective(list);
	}

}
