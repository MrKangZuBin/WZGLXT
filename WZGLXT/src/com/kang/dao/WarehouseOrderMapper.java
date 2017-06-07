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
    
    //采购入库表数据查询分页
    List<WarehouseOrder> selectWarehouseOrder(Map<String, Integer> map);
    //查询入库表数据总条数
    int selectcountWarehouseOrder();
    
    //采购入库按条件查询
    List<WarehouseOrder> selectByWhere();
    
    
    //根据单号查询id
    WarehouseOrder selectoneid(String warehousenumber);
    
    //查询功能
    List<WarehousePoJo> selectByWheres(Map<String, Object> map);
    int selectByWherescount(Map<String, Object> map);
    
    //物品采购入库统计表
    List<WareOrderReport> selectwupingcaigoubaobiao(Map<String, Object> map);
    List<WareOrderReport> selectwupingcaigoubaobiaotwo(Map<String, Object> map);
    int selectwupingcaigoubaobiaocount(Map<String, Object> map);
    int selectwupingcaigoubaobiaotwocount(Map<String, Object> map);
    
}