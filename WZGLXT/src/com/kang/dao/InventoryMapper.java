package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.Inventory;
import com.kang.pojo.InventoryPoJo;
import com.kang.pojo.PandianReport;

public interface InventoryMapper {
    int deleteByPrimaryKey(Integer inventoryid);

    int insert(Inventory record);

    int insertSelective(Inventory record);

    Inventory selectByPrimaryKey(Integer inventoryid);

    int updateByPrimaryKeySelective(Inventory record);

    int updateByPrimaryKey(Inventory record);
    
    //����̵�-��ͨ��ѯ
    List<Inventory> selectpandianone(Map<String, Integer> map);
    
    //��ѯ����̵������������
    int countpandian();
    
    //����̵�-�༭��ѯ
    Inventory selectpandian(Integer inventoryid);
    
    //��ѯ����
    List<InventoryPoJo> selectByWheres(Map<String, Object> map);
    int selectByWherescount(Map<String, Object> map);
    
    //���ݵ��Ų�ѯid
    Inventory selectByNumber(String inventorynumber);
    
    //��Ʒ�̵�ͳ��
    List<PandianReport> selectkucunpandianbaobiao(Map<String, Object> map);
    int selectkucunpandianbaobiaocount(Map<String, Object> map);
}