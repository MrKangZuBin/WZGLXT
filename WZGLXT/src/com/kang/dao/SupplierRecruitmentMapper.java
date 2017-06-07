package com.kang.dao;

import com.kang.pojo.SupplierRecruitment;

public interface SupplierRecruitmentMapper {
    int deleteByPrimaryKey(Integer supplierrecruitmentid);

    int insert(SupplierRecruitment record);

    int insertSelective(SupplierRecruitment record);

    SupplierRecruitment selectByPrimaryKey(Integer supplierrecruitmentid);

    int updateByPrimaryKeySelective(SupplierRecruitment record);

    int updateByPrimaryKey(SupplierRecruitment record);
}