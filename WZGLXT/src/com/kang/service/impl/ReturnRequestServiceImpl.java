package com.kang.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.ReturnRequestMapper;
import com.kang.pojo.ReturnRequest;
import com.kang.service.ReturnRequestService;

@Service

public class ReturnRequestServiceImpl implements ReturnRequestService{

	@Resource
	private ReturnRequestMapper rrm;
	
	@Override
	public List<ReturnRequest> selectallReturnRequest(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return rrm.selectallReturnRequest(map);
	}

	@Override
	public int selectcountReturnRequest() {
		// TODO Auto-generated method stub
		return rrm.selectcountReturnRequest();
	}

	@Override
	public ReturnRequest selectonebyreturnrequestid(Integer returnrequestid) {
		// TODO Auto-generated method stub
		return rrm.selectByPrimaryKey(returnrequestid);
	}

	@Override
	public ReturnRequest selectById(int id) {
		// TODO Auto-generated method stub
		return rrm.selectByPrimaryKey(id);
	}

}
