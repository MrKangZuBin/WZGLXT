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
    
    //库存报损-简单查询
    List<InventoryLoss> selectbaosunone(Map<String, Integer> map);
    
    //查询库存报损的数据的总条数
    int countbaosun();
    
    //库存报损-根据主键id查询
    InventoryLoss selectbaosunById(Integer inventorylossid);
    
    //查询功能
    List<InventoryLossPoJo> selectByWheres(Map<String, Object> map);
    int selectByWherescount(Map<String, Object> map);
    
    //根据单号查询id
    InventoryLoss selectByNumber(String lossnumber);
}