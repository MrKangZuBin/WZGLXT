package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.PurchaseRequisition;
import com.kang.pojo.Purrequisition;

public interface PurchaseRequisitionMapper {
    int deleteByPrimaryKey(Integer purchaserequisitionid);

    Integer insert(Map<String, Object> map);

    Integer insertSelective(Map<String, Object> map);

    PurchaseRequisition selectByPrimaryKey(Integer purchaserequisitionid);
    PurchaseRequisition selectPurchaserequisitionId(String applicationNo);

    int updateByPrimaryKeySelective(PurchaseRequisition record);

    //保存修改状态
    Integer updateByPrimaryKey(Integer purchaserequisitionid);
    //保存提交修改状态
    Integer subByPrimaryKey(Integer purchaserequisitionid);
    //�ɹ��������ݲ�ѯ��ҳ
    List<PurchaseRequisition> selPurchaseRequisition(Map<String, Integer> map);
    //��ѯ�ɹ���������������
    int selectCountRequisition();
    int selectCount(Map<String, Object> map);
    //详情
    List<Purrequisition> selectPur(Map<String, Object> purMap);
    //申请单详情
    List<Purrequisition> selectPurreq(Map<String, Object> purMap);
    //待我操作申请条数
    Integer waitMePlay(Map<String, Object> map);
    //待我操作已申请条数
    Integer played(Integer id);
    Integer MyDJ(Integer id);
    Integer notgMyDJ(Integer id);
}