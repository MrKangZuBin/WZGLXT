package com.kang.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kang.dao.PurchaseRequisitionMapper;
import com.kang.pojo.PurchaseRequisition;
import com.kang.pojo.Purrequisition;
import com.kang.service.PurchaseRequisitionService;

@Service("PurchaseRequisitionService")
public class PurchaseRequisitionServiceImpl implements PurchaseRequisitionService{

	@Resource
	private PurchaseRequisitionMapper prm;

	@Override
	public List<PurchaseRequisition> selectPurchaseRequisition(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return prm.selPurchaseRequisition(map);
	}

	@Override
	public int selectCountPurchaseRequisition() {
		// TODO Auto-generated method stub
		return prm.selectCountRequisition();
	}

	@Override
	public PurchaseRequisition selectonePurchaseRequisition(int purchaserequisitionid) {
		// TODO Auto-generated method stub
		return prm.selectByPrimaryKey(purchaserequisitionid);
	}

	@Override
	public List<Purrequisition> selectPur(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return prm.selectPur(map);
	}

	@Override
	public Integer selectConut(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return prm.selectCount(map);
	}

	@Override
	public List<Purrequisition> selectPurreq(Map<String, Object> purMap) {
		// TODO Auto-generated method stub
		return prm.selectPurreq(purMap);
	}

	@Override
	public Integer updateStatus(Integer purchaserequisitionid) {
		// TODO Auto-generated method stub
		return prm.updateByPrimaryKey(purchaserequisitionid);
	}

	@Override
	public Integer subStatus(Integer purchaserequisitionid) {
		// TODO Auto-generated method stub
		return prm.subByPrimaryKey(purchaserequisitionid);
	}

	@Override
	public Integer waitMePlay(Map<String, Object> purMap) {
		// TODO Auto-generated method stub
		return prm.waitMePlay(purMap);
	}

	@Override
	public Integer insert(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return prm.insert(map);
	}

	@Override
	public Integer Played(Integer id) {
		// TODO Auto-generated method stub
		return prm.played(id);
	}

	@Override
	public Integer MyDJ(Integer id) {
		// TODO Auto-generated method stub
		return prm.MyDJ(id);
	}

	@Override
	public Integer notgMyDJ(Integer id) {
		// TODO Auto-generated method stub
		return prm.notgMyDJ(id);
	}

	@Override
	public Integer insertSelective(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return prm.insertSelective(map);
	}

	@Override
	public PurchaseRequisition selectPurchaserequisitionId(String applicationNo) {
		// TODO Auto-generated method stub
		return prm.selectPurchaserequisitionId(applicationNo);
	}

}
