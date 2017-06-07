package com.kang.dao;

import com.kang.pojo.PurchaseInquiry_supplier;

public interface PurchaseInquiry_supplierMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseInquiry_supplier record);

    int insertSelective(PurchaseInquiry_supplier record);

    PurchaseInquiry_supplier selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PurchaseInquiry_supplier record);

    int updateByPrimaryKey(PurchaseInquiry_supplier record);
}