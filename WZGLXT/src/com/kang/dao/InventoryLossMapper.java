package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.InventoryLoss;
import com.kang.pojo.InventoryLossPoJo;

public interface InventoryLossMapper {
    int deleteByPrimaryKey(Integer inventorylossid);

    int insert(InventoryLoss record);

    int insertSelective(InventoryLoss record);

    InventoryLoss selectByPrimaryKey(Integer inventorylossid);

    int updateByPrimaryKeySelective(InventoryLoss record);

    int updateByPrimaryKey(InventoryLoss record);
    
    //��汨��-�򵥲�ѯ
    List<InventoryLoss> selectbaosunone(Map<String, Integer> map);
    
    //��ѯ��汨������ݵ�������
    int countbaosun();
    
    //��汨��-��������id��ѯ
    InventoryLoss selectbaosunById(Integer inventorylossid);
    
    //��ѯ����
    List<InventoryLossPoJo> selectByWheres(Map<String, Object> map);
    int selectByWherescount(Map<String, Object> map);
    
    //���ݵ��Ų�ѯid
    InventoryLoss selectByNumber(String lossnumber);
}