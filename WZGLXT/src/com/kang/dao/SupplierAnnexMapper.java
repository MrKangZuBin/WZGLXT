package com.kang.dao;

import java.util.List;

import com.kang.pojo.SupplierAnnex;

public interface SupplierAnnexMapper {
	List<SupplierAnnex> listById(Integer supplierid);
	
    int deleteByPrimaryKey(Integer supplierannexid);

    int insert(SupplierAnnex record);

    int insertSelective(SupplierAnnex record);
    
    SupplierAnnex selectByPrimaryKey(Integer supplierannexid);

    int updateByPrimaryKeySelective(SupplierAnnex record);

    int updateByPrimaryKey(SupplierAnnex record);
}