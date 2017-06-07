package com.kang.dao;

import java.util.List;
import java.util.Map;

import com.kang.pojo.Supplier;

public interface SupplierMapper {
    int deleteByPrimaryKey(Integer supplierid);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(Integer supplierid);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);
    
    Integer selrow(Map<String, Object> map);
  
    List<Supplier> findPagingList(Map<String, Object> map);
    //查询供应商代码和名称
    List<Supplier> selectSupplier(); 
    //订单详情的数据
    Supplier selectSup(String supplierName);
}