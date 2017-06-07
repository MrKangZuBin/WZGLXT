package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.WareOrderReport;
import com.kang.pojo.WarehouseOrder;
import com.kang.pojo.WarehousePoJo;

public interface WarehouseOrderMapper {
    int deleteByPrimaryKey(Integer purchaseordereid);

    int insert(WarehouseOrder record);

    int insertSelective(WarehouseOrder record);

    WarehouseOrder selectByPrimaryKey(Integer purchaseordereid);

    int updateByPrimaryKeySelective(WarehouseOrder record);

    int updateByPrimaryKey(WarehouseOrder record);
    
    //�ɹ��������ݲ�ѯ��ҳ
    List<WarehouseOrder> selectWarehouseOrder(Map<String, Integer> map);
    //��ѯ��������������
    int selectcountWarehouseOrder();
    
    //�ɹ���ⰴ������ѯ
    List<WarehouseOrder> selectByWhere();
    
    
    //���ݵ��Ų�ѯid
    WarehouseOrder selectoneid(String warehousenumber);
    
    //��ѯ����
    List<WarehousePoJo> selectByWheres(Map<String, Object> map);
    int selectByWherescount(Map<String, Object> map);
    
    //��Ʒ�ɹ����ͳ�Ʊ�
    List<WareOrderReport> selectwupingcaigoubaobiao(Map<String, Object> map);
    List<WareOrderReport> selectwupingcaigoubaobiaotwo(Map<String, Object> map);
    int selectwupingcaigoubaobiaocount(Map<String, Object> map);
    int selectwupingcaigoubaobiaotwocount(Map<String, Object> map);
    
}