package com.kang.service;

import java.util.List;
import java.util.Map;

import com.kang.pojo.DcgPojo;
import com.kang.pojo.RequestPojo;
import com.kang.pojo.ReturnRequest;

public interface RequestService {
	int insertSelective(ReturnRequest record);
	Integer selectObject(String applicationno);
	//退货申请--查询
	List<RequestPojo> selRequest(Map<String, Object> map);
	//退货申请--查询
	List<RequestPojo> selX(Map<String, Object> map);
	//退货申请--查询的总条数
	Integer selCount(Map<String, Object> map);
	//退货申请--查询的总条数
	Integer selRequestCount();
	//保存修改状态
	Integer updateStatus(Integer requestID);
	//保存提交修改状态
	Integer subStatus(Integer requestID);
	//待采购物资查询
	List<DcgPojo> selDcg(Map<String, Object> map);
	//查询待采购物资的总条数
	Integer selCountDcg(Map<String, Object> map);
	Integer selectCountDcg();
	//首页显示未操作的
	Integer waitMePlay(Map<String, Object> map);
	//首页显示已操作的
	Integer Played(Integer id);
	//首页显示我的单据
    Integer MyDJ(Integer id);
    Integer notgMyDJ(Integer id);
}
