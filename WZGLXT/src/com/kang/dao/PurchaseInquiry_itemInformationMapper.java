package com.kang.dao;

import com.kang.pojo.PurchaseInquiry_itemInformation;

public interface PurchaseInquiry_itemInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseInquiry_itemInformation record);

    int insertSelective(PurchaseInquiry_itemInformation record);

    PurchaseInquiry_itemInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PurchaseInquiry_itemInformation record);

    int updateByPrimaryKey(PurchaseInquiry_itemInformation record);
}