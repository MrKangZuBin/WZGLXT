package com.kang.service;

import java.util.List;

import com.kang.pojo.SupplierAnnex;

public interface SupplierAnnexService {
	List<SupplierAnnex> listById(Integer supplierannexid);
	
    int deleteByPrimaryKey(Integer supplierannexid);

    int insert(SupplierAnnex record);

    int insertSelective(SupplierAnnex record);

    SupplierAnnex selectByPrimaryKey(Integer supplierannexid);

}
