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
    
    //库存盘点-普通查询
    List<Inventory> selectpandianone(Map<String, Integer> map);
    
    //查询库存盘点的数据总条数
    int countpandian();
    
    //库存盘点-编辑查询
    Inventory selectpandian(Integer inventoryid);
    
    //查询功能
    List<InventoryPoJo> selectByWheres(Map<String, Object> map);
    int selectByWherescount(Map<String, Object> map);
    
    //根据单号查询id
    Inventory selectByNumber(String inventorynumber);
    
    //物品盘点统计
    List<PandianReport> selectkucunpandianbaobiao(Map<String, Object> map);
    int selectkucunpandianbaobiaocount(Map<String, Object> map);
}