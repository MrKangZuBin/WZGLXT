package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.PurchaseRequisition;
import com.kang.pojo.Purrequisition;

public interface PurchaseRequisitionService {
		//�ɹ�����ȫ�����ݲ�ѯ��ҳ
		List<PurchaseRequisition> selectPurchaseRequisition(Map<String, Integer> map);
		//��ѯ�����������
		int selectCountPurchaseRequisition();
		//����id��ѯ����
		PurchaseRequisition selectonePurchaseRequisition(int purchaseordereid);
		//查询详情
		List<Purrequisition> selectPur(Map<String, Object> map);
		//总体数按条件
		Integer selectConut(Map<String, Object> map);
		//申请所有数据
		List<Purrequisition> selectPurreq(Map<String, Object> purMap);
		//保存修改状态
	  	Integer updateStatus(Integer purchaserequisitionid);
	  	//保存提交修改状态
	  	Integer subStatus(Integer purchaserequisitionid);
	  	//待我操作申请总条数
	  	Integer waitMePlay(Map<String, Object> purMap);
	  	//待我操作已申请总条数
	  	Integer Played(Integer id);
	  	 //首页显示我的单据
	    Integer MyDJ(Integer id);
	    Integer notgMyDJ(Integer id);
	  	//添加提交
	  	Integer insert(Map<String, Object> map);
	  	Integer insertSelective(Map<String, Object> map);
	  	PurchaseRequisition selectPurchaserequisitionId(String applicationNo);
}
