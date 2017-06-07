package com.kang.dao;

import com.kang.pojo.SupplierRecruitment_itemInformation;

public interface SupplierRecruitment_itemInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SupplierRecruitment_itemInformation record);

    int insertSelective(SupplierRecruitment_itemInformation record);

    SupplierRecruitment_itemInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SupplierRecruitment_itemInformation record);

    int updateByPrimaryKey(SupplierRecruitment_itemInformation record);
}