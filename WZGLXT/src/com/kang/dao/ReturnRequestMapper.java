package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.DcgPojo;
import com.kang.pojo.RequestPojo;
import com.kang.pojo.ReturnRequest;

public interface ReturnRequestMapper {
    int deleteByPrimaryKey(Integer returnrequestid);

    int insert(ReturnRequest record);

    int insertSelective(ReturnRequest record);

    //����returnrequestid��ѯ����
    ReturnRequest selectByPrimaryKey(Integer returnrequestid);
    Integer selectObject(String applicationno);
    int updateByPrimaryKeySelective(ReturnRequest record);
    //保存修改状态
    int updateByPrimaryKey(Integer returnrequestid);
    //保存提交修改状态
    int subByPrimaryKey(Integer returnrequestid);
    //��ѯ�˻�������ȫ������
    List<ReturnRequest> selectallReturnRequest(Map<String, Integer> map);
   
    //��ѯ�˻�������������
    int selectcountReturnRequest();
    //退货申请--查询
  	List<RequestPojo> selectRequest(Map<String, Object> map);
  	//退货申请--查询详情
  	List<RequestPojo> selectX(Map<String, Object> map);
  	//退货申请--查询的总条数
  	Integer selectCount(Map<String, Object> map);
  	Integer selectRequestCount();
  	//待采购物资查询
  	List<DcgPojo> selectDcg(Map<String, Object> map);
  	//待采购物资查询总条数
  	Integer selectDcgCount(Map<String, Object> map);
  	//待采购物资查询总条数
  	Integer selDcgCount();
  	//待我操作申请条数
    Integer waitMePlay(Map<String, Object> map);
    //待我操作已申请条数
    Integer played(Integer id);
    Integer MyDJ(Integer id);
    Integer notgMyDJ(Integer id);
}