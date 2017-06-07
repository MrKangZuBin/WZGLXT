package com.kang.dao;

import com.kang.pojo.PurchaseInquiry;

public interface PurchaseInquiryMapper {
    int deleteByPrimaryKey(Integer purchaseinquiryid);

    int insert(PurchaseInquiry record);

    int insertSelective(PurchaseInquiry record);

    PurchaseInquiry selectByPrimaryKey(Integer purchaseinquiryid);

    int updateByPrimaryKeySelective(PurchaseInquiry record);

    int updateByPrimaryKey(PurchaseInquiry record);
}