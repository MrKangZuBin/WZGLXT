package com.kang.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.ReturnRequestMapper;
import com.kang.pojo.DcgPojo;
import com.kang.pojo.RequestPojo;
import com.kang.pojo.ReturnRequest;
import com.kang.service.RequestService;

@Service("RequestService")
public class RequestServiceImpl implements RequestService{
	@Resource
	private ReturnRequestMapper rm;
	@Override
	public List<RequestPojo> selRequest(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return rm.selectRequest(map);
	}

	@Override
	public Integer selCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return rm.selectCount(map);
	}

	@Override
	public List<RequestPojo> selX(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return rm.selectX(map);
	}

	@Override
	public Integer updateStatus(Integer requestID) {
		// TODO Auto-generated method stub
		return rm.updateByPrimaryKey(requestID);
	}

	@Override
	public Integer subStatus(Integer requestID) {
		// TODO Auto-generated method stub
		return rm.subByPrimaryKey(requestID);
	}

	@Override
	public List<DcgPojo> selDcg(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return rm.selectDcg(map);
	}

	@Override
	public Integer selCountDcg(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return rm.selectDcgCount(map);
	}

	@Override
	public Integer selectCountDcg() {
		// TODO Auto-generated method stub
		return rm.selDcgCount();
	}

	@Override
	public Integer selRequestCount() {
		// TODO Auto-generated method stub
		return rm.selectRequestCount();
	}

	@Override
	public Integer waitMePlay(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return rm.waitMePlay(map);
	}

	@Override
	public Integer Played(Integer id) {
		// TODO Auto-generated method stub
		return rm.played(id);
	}

	@Override
	public Integer MyDJ(Integer id) {
		// TODO Auto-generated method stub
		return rm.MyDJ(id);
	}

	@Override
	public Integer notgMyDJ(Integer id) {
		// TODO Auto-generated method stub
		return rm.notgMyDJ(id);
	}

	@Override
	public int insertSelective(ReturnRequest record) {
		// TODO Auto-generated method stub
		return rm.insertSelective(record);
	}

	@Override
	public Integer selectObject(String applicationno) {
		// TODO Auto-generated method stub
		return rm.selectObject(applicationno);
	}
}
